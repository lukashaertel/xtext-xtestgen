package org.softlang.xtestgen.coco

import com.google.common.base.CaseFormat
import com.google.common.base.Optional
import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IStubGenerating
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.softlang.xtestgen.ConfigStandaloneSetup
import org.softlang.xtestgen.config.GenerationConfig
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.Wildcard
import static org.apache.commons.lang3.StringEscapeUtils.*
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.EOF
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.Group
import java.util.List
import org.eclipse.xtext.Alternatives

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
	 * URI of the configuration
	 */
	@Property String uri

	/**
	 * Replacement of the alphabet used by a wild card
	 */
	@Property String sigma = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789<>|,;.:-_+*~^°!\"$%&/{([)]=}?\\`´*+~#'"

	// TODO: See naming utilities used by other fragments (for now this is OK)
	/**
	 * Returns the test generator package
	 */
	def String getTestgenPackage() '''«grammar.basePackageRuntime».testdata'''

	/**
	 * Returns the abstract test generator class
	 */
	def String getAbstractTestgenClass() '''Abstract«grammar.name.toSimpleName»TestdataGenerator'''

	/**
	 * Returns the abstract test generator name
	 */
	def String getAbstractTestgenName() '''«testgenPackage».«abstractTestgenClass»'''

	/**
	 * Returns the abstract test generator name
	 */
	def String getAbstractTestgenPath() '''«abstractTestgenName.asPath»'''

	/**
	 * Returns the test generator class
	 */
	def String getTestgenClass() '''«grammar.name.toSimpleName»TestdataGenerator'''

	/**
	 * Returns the test generator name
	 */
	def String getTestgenName() '''«testgenPackage».«testgenClass»'''

	/**
	 * Returns the test generator path
	 */
	def String getTestgenPath() '''«testgenName.asPath»'''

	new() {

		// Set up the standalone setup to enable reading configuration models
		new ConfigStandaloneSetup().createInjectorAndDoEMFRegistration
	}

	/**
	 * Returns the generation configuration that controls how the grammar is iterated
	 */
	def GenerationConfig getGenerationConfig() {

		// If unspecified, no configuration exists
		if (uri == null)
			return null

		// Load configuration with same resource set as the grammar, so
		// that the references are resolved to the same objects
		val rs = grammar.eResource.resourceSet

		// Demand load the resource
		val r = rs.getResource(URI.createURI(uri), true)

		// Filter all direct contents that are generation configs
		return r.contents.filter(GenerationConfig).head
	}

	/**
	 * Returns the local name of a rule call function
	 */
	def CharSequence localCall(Grammar from, AbstractRule rule) {

		// Decide the source casing for name conversion
		val sourceCase = if (rule instanceof TerminalRule)
				CaseFormat.UPPER_UNDERSCORE
			else
				CaseFormat.UPPER_CAMEL

		// Return the call name
		return "eval" + sourceCase.to(CaseFormat.UPPER_CAMEL, rule.name)
	}

	/**
	 * Returns the qualified name of a rule domain
	 */
	def CharSequence localDomain(Grammar from, AbstractRule rule) {

		// Decide the source casing for name conversion
		val sourceCase = if (rule instanceof TerminalRule)
				CaseFormat.UPPER_UNDERSCORE
			else
				CaseFormat.UPPER_CAMEL

		return sourceCase.to(CaseFormat.UPPER_UNDERSCORE, rule.name)
	}

	/**
	 * Returns the qualified name of a rule call domain
	 */
	def Optional<CharSequence> qualifyDomain(Grammar from, AbstractRule rule) {

		// If the grammar contains the rule, return present
		if (from.rules.contains(rule))
			return Optional.of(localDomain(from, rule))

		// Else, check if the used grammars contain the rule
		for (u : from.usedGrammars) {
			val p = qualifyDomain(u, rule)
			if (p.present)
				return Optional.of(u.name.toSimpleName + "." + p.get)
		}

		// If none contained, return absent
		Optional.absent
	}

	/**
	 * Returns the qualified name of a rule call function
	 */
	def Optional<CharSequence> qualifyCall(Grammar from, AbstractRule rule) {

		// If the grammar contains the rule, return present
		if (from.rules.contains(rule))
			return Optional.of(localCall(from, rule))

		// Else, check if the used grammars contain the rule
		for (u : from.usedGrammars) {
			val p = qualifyCall(u, rule)
			if (p.present)
				return Optional.of(u.name.toSimpleName + "." + p.get)
		}

		// If none contained, return absent
		Optional.absent
	}

	/**
	 * Content of a grammar test generation dependent on a grammar
	 */
	def CharSequence grammarContent(Grammar g) '''
		«
		/*
		 * For all imported grammars, usually one, make a nested definition
		 */
		FOR u : g.usedGrammars»
			private static class «u.name.toSimpleName» {
				«grammarContent(u)»
			}
		«ENDFOR»
		«
		/*
		 * For all rules, return the iteration of it's definition
		 */
		FOR r : g.rules»
			/**
			 * Domain of the rule «r»
			 */
			protected static long «localDomain(g, r)» = «domain(g, r.alternatives)»;
			
			/**
			 * Iteration of the rule «r»
			 */
			protected static String «localCall(g, r)»(long k) {
				String result;
				{
					«function(g, r.alternatives, 'k', 'x', 'result')»
				}
				
				return result;
			}
		«ENDFOR»
	'''

	override generate(Xtend2ExecutionContext ctx) {

		// Get the generation configuration, it is required to control the iteration
		val config = generationConfig

		// If no configuration is specified, throw an error
		if (config == null)
			throw new IllegalStateException('''Testdata genration is not configured, set the URI.''')

		// Check if correct pointer
		if (config.target != grammar)
			throw new IllegalStateException('''Testdata generation has problems resolving the target grammar''')

		// Generate the abstract test generator providing the iterations for all test data	 
		ctx.writeFile(Generator.SRC_GEN, '''«abstractTestgenPath».java''',
			'''
				package «testgenPackage»;
				
				/**
				 * Testdata generator for grammar «grammar.name»
				 */
				public class «abstractTestgenClass» {
					«grammarContent(grammar)»
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

	/**
	 * Domain function calculates how many elements may outputted by an iteration in total
	 */
	def dispatch long domain(Grammar g, AbstractElement e) {
		return 0

	//throw new UnsupportedOperationException
	}

	def dispatch long domain(Grammar g, Keyword e) {

		// Only one keyword as result
		return 1
	}

	def dispatch long domain(Grammar g, Wildcard e) {

		// The size of the alphabet may be output
		return sigma.length
	}

	/**
	 * Code guidelines:
	 *   calculation must depend on x
	 *   local variables used must be prefixed with p
	 *   calculation must assign res
	 */
	def dispatch CharSequence function(Grammar g, AbstractElement e, CharSequence x, String p, String res) {
		return '''«res» = "";'''

	//throw new UnsupportedOperationException
	}

	def dispatch CharSequence function(Grammar g, Keyword e, CharSequence x, String p, String res) {

		// Keyword mapping is independent of the position
		'''«res» = "«escapeJava(e.value)»";'''
	}

	def dispatch CharSequence function(Grammar g, Wildcard e, CharSequence x, String p, String res) {

		// Get sigma at the position
		'''«res» = Character.toString("«escapeJava(sigma)»".charAt((int)(«x»)));'''
	}

	def dispatch CharSequence function(Grammar g, RuleCall e, CharSequence x, String p, String res) {

		// Return a call from the current grammar level
		'''«res» = «qualifyCall(g, e.rule)»(«x»);'''
	}

	def dispatch CharSequence function(Grammar g, EOF e, CharSequence x, String p, String res) {

		// TODO: Special behavior
		return '''«res» = "";'''
	}

	def dispatch CharSequence function(Grammar g, CrossReference e, CharSequence x, String p, String res) {

		// Delegate to the actual terminal
		function(g, e.terminal, x, p, res)
	}

	def dispatch CharSequence function(Grammar g, Group e, CharSequence x, String p, String res) {
		'''
			«FOR i : 0 ..< e.elements.size»
				String «p + i»;
				{
					«function(g, e.elements.get(i), x, p + i, p + i)»
				}
			«ENDFOR»
			«res» = «FOR i : 0 ..< e.elements.size SEPARATOR ' + '»«p + i»«ENDFOR»;
		'''
	}

	def dispatch CharSequence function(Grammar g, Alternatives e, CharSequence x, String p, String res) {
		'''
			long «p»offset = 0;
			«FOR i : 0 ..< e.elements.size»
				{
					long «p»size = «domain(g, e.elements.get(i))»;
					long «p»local = «x» - «p»offset;
					
					if(«p»local >= 0 && «p»local < «p»size)
					{
						«function(g, e.elements.get(i), '''«p»local''', p + i, res)»
					}
					
					«p»offset += «p»size;
				}
			«ENDFOR»
			«res» = "";
		'''
	}
}
