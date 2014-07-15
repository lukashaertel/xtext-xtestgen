package org.softlang.xtestgen.coco

import com.google.inject.Binder
import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IStubGenerating
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.softlang.xtestgen.ConfigRuntimeModule
import org.softlang.xtestgen.config.GenerationConfig

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
	
	GenerationConfig generationConfig
	
	override protected addLocalBindings(Binder binder) {
		binder.install(new ConfigRuntimeModule)
	}
	
	def setUri(String uri) {
		val rs = forcedResourceSet ?: new XtextResourceSet
		val r = rs.getResource(URI.createURI(uri), true) as XtextResource
	
		if (r.contents.empty)
			throw new IllegalArgumentException('''Couldn't load configuration for '«uri»'.''');
	
		if (!r.errors.empty)
			throw new IllegalStateException('''Problem parsing '«uri»':«FOR e : r.errors SEPARATOR ', '»«e»«ENDFOR»''')
	
		val cs = r.contents.filter(GenerationConfig)
	
		if (cs.empty)
			throw new IllegalStateException('''No configuration model in 'uri'.''')
	
		generationConfig = cs.head
	}

	// TODO: See naming utilities used by other fragments (for now this is OK)
	def String getTestgenPackage() '''«grammar.basePackageRuntime».testdata'''

	def String getAbstractTestgenClass() '''Abstract«grammar.name.toSimpleName»TestdataGenerator'''

	def String getAbstractTestgenName() '''«testgenPackage».«abstractTestgenClass»'''

	def String getAbstractTestgenPath() '''«abstractTestgenName.asPath»'''

	def String getTestgenClass() '''«grammar.name.toSimpleName»TestdataGenerator'''

	def String getTestgenName() '''«testgenPackage».«testgenClass»'''

	def String getTestgenPath() '''«testgenName.asPath»'''

	override generate(Xtend2ExecutionContext ctx) {
		if (generationConfig == null)
			throw new IllegalStateException('''Testdata genration is not configured, set the URI.''')

		// Generate the abstract test generator providing the iterations for all test data	 
		ctx.writeFile(Generator.SRC_GEN, '''«abstractTestgenPath».java''',
			'''
				package «testgenPackage»;
				
				public class «abstractTestgenClass» {
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
