package org.softlang.xtestgen.coco

import com.google.common.base.Optional
import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Group
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IStubGenerating
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

class TestdataGeneratorFragment extends Xtend2GeneratorFragment implements IStubGenerating, IStubGenerating.XtendOption {

	/**
	 * Injected central artifact
	 */
	@Inject Grammar grammar

	/**
	 * Injected naming tools
	 */
	@Inject extension Naming naming

	/**
	 * Property for generating stubs
	 */
	@Property boolean generateStub = true

	@Property boolean generateXtendStub = true

	/**
	 * Cf. forced resource set of the language configuration
	 */
	@Property ResourceSet forcedResourceSet

	// TODO: See naming utilities used by other fragments (for now this is OK)
	def String getTestgenPackage() '''«grammar.basePackageRuntime».testdata'''

	def String getAbstractTestgenClass() '''Abstract«grammar.name.toSimpleName»TestdataGenerator'''

	def String getAbstractTestgenName() '''«testgenPackage».«abstractTestgenClass»'''

	def String getAbstractTestgenPath() '''«abstractTestgenName.asPath»'''

	def String getTestgenClass() '''«grammar.name.toSimpleName»TestdataGenerator'''

	def String getTestgenName() '''«testgenPackage».«testgenClass»'''

	def String getTestgenPath() '''«testgenName.asPath»'''

	def CharSequence grammarContent(Grammar g) '''
		«FOR u : g.usedGrammars»
			private static class «u.name.toSimpleName» {
				«grammarContent(u)»
			}
		«ENDFOR»
		«FOR r : g.rules»
			protected String get«r.name.toFirstUpper»(long k) {
				return «elementDependentOf(r.alternatives, 'k')»;
			}
		«ENDFOR»
	'''

	/** TODO: Bessere Struktur finden, nested statics scheinen aber eine gute lösung für den Grammar inheritance Tree(?) zu sein*/
	def dispatch CharSequence elementDependentOf(AbstractElement element, String v) {
		return ''''''
	}

	def dispatch CharSequence elementDependentOf(Keyword element, String v) '''"«element.value»"'''

	def dispatch CharSequence elementDependentOf(Group element, String v) '''«FOR e : element.elements SEPARATOR '+'»«elementDependentOf(
		e, 'distributeInGroup(' + v + ', ' + element.elements.indexOf(e) + ' ,' + element.elements.size + ")")»«ENDFOR»'''

	def Optional<CharSequence> qualify(Grammar from, AbstractRule rule) {
		if (from.rules.contains(rule))
			return Optional.of("get" + rule.name.toFirstUpper)

		for (u : from.usedGrammars) {
			val p = qualify(u, rule)
			if (p.present)
				return Optional.of(u.name.toSimpleName + "." + p.get)
		}

		Optional.absent
	}

	override generate(Xtend2ExecutionContext ctx) {

		//		if (generationConfig == null)
		//			throw new IllegalStateException('''Testdata genration is not configured, set the URI.''')
		// Generate the abstract test generator providing the iterations for all test data	 
		ctx.writeFile(Generator.SRC_GEN, '''«abstractTestgenPath».java''',
			'''
				package «testgenPackage»;
				
				import static org.softlang.xtestgen.coco.Counting.*;
				
				/**
				 * Testdata generator for grammar «grammar.name»
				 */
				public class «abstractTestgenClass» {
					«grammarContent(grammar)»
					
					/**
					 «FOR f : grammar.eAllContents.filter(RuleCall).toIterable»
					 	* «qualify(grammar, f.rule)»
					 «ENDFOR»
					 */
				}
			''')

		// Check if stub is wanted
		if (generateStub) {

			// Check if stub should be generated in XTend
			if (generateXtendStub)
				ctx.writeFile(Generator.SRC, '''«testgenPath».xtend''',
					// Generate the stub in XTend and in the user directory
					'''
						package «testgenPackage»
						
						class «testgenClass» extends «abstractTestgenClass» {
						}
					''')
			else
				ctx.writeFile(Generator.SRC, '''«testgenPath».java''',
					// Generate the stub in Java and in the user directory
					'''
						package «testgenPackage»;
						
						public class «testgenClass» extends «abstractTestgenClass» {
						}
					''')
		} else {
			ctx.writeFile(Generator.SRC_GEN, '''«testgenPath».java''',
				// Generate the stub in Java and in the generated directory
				'''
					package «testgenPackage»;
					
					public class «testgenClass» extends «abstractTestgenClass» {
					}
				''')
		}

	}

	override getGuiceBindingsRt(Grammar grammar) {
		super.getGuiceBindingsRt(grammar)
	}

	override getRequiredBundlesRt(Grammar grammar) {
		#[
			'org.softlang.xtestgen.config',
			'org.softlang.xtestgen.coco'
		]
	}

	override protected getExportedPackagesRtList(Grammar grammar) {
		#[
			testgenPackage
		]
	}

}
