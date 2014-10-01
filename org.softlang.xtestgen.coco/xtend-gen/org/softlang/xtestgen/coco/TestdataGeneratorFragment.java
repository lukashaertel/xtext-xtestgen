package org.softlang.xtestgen.coco;

import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EOF;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.softlang.xtestgen.ConfigStandaloneSetup;
import org.softlang.xtestgen.config.GenerationConfig;

@SuppressWarnings("all")
public class TestdataGeneratorFragment extends Xtend2GeneratorFragment implements IStubGenerating, IStubGenerating.XtendOption {
  /**
   * Injected central artifact
   */
  @Inject
  private Grammar grammar;
  
  /**
   * Injected naming tools
   */
  @Inject
  @Extension
  private Naming naming;
  
  /**
   * Property for generating stubs
   */
  private boolean _generateStub = true;
  
  /**
   * Property for generating stubs
   */
  public boolean isGenerateStub() {
    return this._generateStub;
  }
  
  /**
   * Property for generating stubs
   */
  public void setGenerateStub(final boolean generateStub) {
    this._generateStub = generateStub;
  }
  
  private boolean _generateXtendStub = true;
  
  public boolean isGenerateXtendStub() {
    return this._generateXtendStub;
  }
  
  public void setGenerateXtendStub(final boolean generateXtendStub) {
    this._generateXtendStub = generateXtendStub;
  }
  
  /**
   * URI of the configuration
   */
  private String _uri;
  
  /**
   * URI of the configuration
   */
  public String getUri() {
    return this._uri;
  }
  
  /**
   * URI of the configuration
   */
  public void setUri(final String uri) {
    this._uri = uri;
  }
  
  /**
   * Replacement of the alphabet used by a wild card
   */
  private String _sigma = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789<>|,;.:-_+*~^°!\"$%&/{([)]=}?\\`´*+~#\'";
  
  /**
   * Replacement of the alphabet used by a wild card
   */
  public String getSigma() {
    return this._sigma;
  }
  
  /**
   * Replacement of the alphabet used by a wild card
   */
  public void setSigma(final String sigma) {
    this._sigma = sigma;
  }
  
  /**
   * Returns the test generator package
   */
  public String getTestgenPackage() {
    StringConcatenation _builder = new StringConcatenation();
    String _basePackageRuntime = this.naming.basePackageRuntime(this.grammar);
    _builder.append(_basePackageRuntime, "");
    _builder.append(".testdata");
    return _builder.toString();
  }
  
  /**
   * Returns the abstract test generator class
   */
  public String getAbstractTestgenClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _name = this.grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name);
    _builder.append(_simpleName, "");
    _builder.append("TestdataGenerator");
    return _builder.toString();
  }
  
  /**
   * Returns the abstract test generator name
   */
  public String getAbstractTestgenName() {
    StringConcatenation _builder = new StringConcatenation();
    String _testgenPackage = this.getTestgenPackage();
    _builder.append(_testgenPackage, "");
    _builder.append(".");
    String _abstractTestgenClass = this.getAbstractTestgenClass();
    _builder.append(_abstractTestgenClass, "");
    return _builder.toString();
  }
  
  /**
   * Returns the abstract test generator name
   */
  public String getAbstractTestgenPath() {
    StringConcatenation _builder = new StringConcatenation();
    String _abstractTestgenName = this.getAbstractTestgenName();
    String _asPath = this.naming.asPath(_abstractTestgenName);
    _builder.append(_asPath, "");
    return _builder.toString();
  }
  
  /**
   * Returns the test generator class
   */
  public String getTestgenClass() {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this.grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name);
    _builder.append(_simpleName, "");
    _builder.append("TestdataGenerator");
    return _builder.toString();
  }
  
  /**
   * Returns the test generator name
   */
  public String getTestgenName() {
    StringConcatenation _builder = new StringConcatenation();
    String _testgenPackage = this.getTestgenPackage();
    _builder.append(_testgenPackage, "");
    _builder.append(".");
    String _testgenClass = this.getTestgenClass();
    _builder.append(_testgenClass, "");
    return _builder.toString();
  }
  
  /**
   * Returns the test generator path
   */
  public String getTestgenPath() {
    StringConcatenation _builder = new StringConcatenation();
    String _testgenName = this.getTestgenName();
    String _asPath = this.naming.asPath(_testgenName);
    _builder.append(_asPath, "");
    return _builder.toString();
  }
  
  public TestdataGeneratorFragment() {
    ConfigStandaloneSetup _configStandaloneSetup = new ConfigStandaloneSetup();
    _configStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
  
  /**
   * Returns the generation configuration that controls how the grammar is iterated
   */
  public GenerationConfig getGenerationConfig() {
    String _uri = this.getUri();
    boolean _equals = Objects.equal(_uri, null);
    if (_equals) {
      return null;
    }
    Resource _eResource = this.grammar.eResource();
    final ResourceSet rs = _eResource.getResourceSet();
    String _uri_1 = this.getUri();
    URI _createURI = URI.createURI(_uri_1);
    final Resource r = rs.getResource(_createURI, true);
    EList<EObject> _contents = r.getContents();
    Iterable<GenerationConfig> _filter = Iterables.<GenerationConfig>filter(_contents, GenerationConfig.class);
    return IterableExtensions.<GenerationConfig>head(_filter);
  }
  
  /**
   * Returns the local name of a rule call function
   */
  public CharSequence localCall(final Grammar from, final AbstractRule rule) {
    CaseFormat _xifexpression = null;
    if ((rule instanceof TerminalRule)) {
      _xifexpression = CaseFormat.UPPER_UNDERSCORE;
    } else {
      _xifexpression = CaseFormat.UPPER_CAMEL;
    }
    final CaseFormat sourceCase = _xifexpression;
    String _name = rule.getName();
    String _to = sourceCase.to(CaseFormat.UPPER_CAMEL, _name);
    return ("eval" + _to);
  }
  
  /**
   * Returns the qualified name of a rule domain
   */
  public CharSequence localDomain(final Grammar from, final AbstractRule rule) {
    CaseFormat _xifexpression = null;
    if ((rule instanceof TerminalRule)) {
      _xifexpression = CaseFormat.UPPER_UNDERSCORE;
    } else {
      _xifexpression = CaseFormat.UPPER_CAMEL;
    }
    final CaseFormat sourceCase = _xifexpression;
    String _name = rule.getName();
    return sourceCase.to(CaseFormat.UPPER_UNDERSCORE, _name);
  }
  
  /**
   * Returns the qualified name of a rule call domain
   */
  public Optional<CharSequence> qualifyDomain(final Grammar from, final AbstractRule rule) {
    Optional<CharSequence> _xblockexpression = null;
    {
      EList<AbstractRule> _rules = from.getRules();
      boolean _contains = _rules.contains(rule);
      if (_contains) {
        CharSequence _localDomain = this.localDomain(from, rule);
        return Optional.<CharSequence>of(_localDomain);
      }
      EList<Grammar> _usedGrammars = from.getUsedGrammars();
      for (final Grammar u : _usedGrammars) {
        {
          final Optional<CharSequence> p = this.qualifyDomain(u, rule);
          boolean _isPresent = p.isPresent();
          if (_isPresent) {
            String _name = u.getName();
            String _simpleName = this.naming.toSimpleName(_name);
            String _plus = (_simpleName + ".");
            CharSequence _get = p.get();
            String _plus_1 = (_plus + _get);
            return Optional.<CharSequence>of(_plus_1);
          }
        }
      }
      _xblockexpression = Optional.<CharSequence>absent();
    }
    return _xblockexpression;
  }
  
  /**
   * Returns the qualified name of a rule call function
   */
  public Optional<CharSequence> qualifyCall(final Grammar from, final AbstractRule rule) {
    Optional<CharSequence> _xblockexpression = null;
    {
      EList<AbstractRule> _rules = from.getRules();
      boolean _contains = _rules.contains(rule);
      if (_contains) {
        CharSequence _localCall = this.localCall(from, rule);
        return Optional.<CharSequence>of(_localCall);
      }
      EList<Grammar> _usedGrammars = from.getUsedGrammars();
      for (final Grammar u : _usedGrammars) {
        {
          final Optional<CharSequence> p = this.qualifyCall(u, rule);
          boolean _isPresent = p.isPresent();
          if (_isPresent) {
            String _name = u.getName();
            String _simpleName = this.naming.toSimpleName(_name);
            String _plus = (_simpleName + ".");
            CharSequence _get = p.get();
            String _plus_1 = (_plus + _get);
            return Optional.<CharSequence>of(_plus_1);
          }
        }
      }
      _xblockexpression = Optional.<CharSequence>absent();
    }
    return _xblockexpression;
  }
  
  /**
   * Content of a grammar test generation dependent on a grammar
   */
  public CharSequence grammarContent(final Grammar g) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Grammar> _usedGrammars = g.getUsedGrammars();
      for(final Grammar u : _usedGrammars) {
        _builder.append("private static class ");
        String _name = u.getName();
        String _simpleName = this.naming.toSimpleName(_name);
        _builder.append(_simpleName, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _grammarContent = this.grammarContent(u);
        _builder.append(_grammarContent, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      EList<AbstractRule> _rules = g.getRules();
      for(final AbstractRule r : _rules) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Domain of the rule ");
        _builder.append(r, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("protected static long ");
        CharSequence _localDomain = this.localDomain(g, r);
        _builder.append(_localDomain, "");
        _builder.append(" = ");
        AbstractElement _alternatives = r.getAlternatives();
        long _domain = this.domain(g, _alternatives);
        _builder.append(_domain, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Iteration of the rule ");
        _builder.append(r, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("protected static String ");
        CharSequence _localCall = this.localCall(g, r);
        _builder.append(_localCall, "");
        _builder.append("(long k) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("String result;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t");
        AbstractElement _alternatives_1 = r.getAlternatives();
        CharSequence _function = this.function(g, _alternatives_1, "k", "x", "result");
        _builder.append(_function, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public void generate(final Xtend2ExecutionContext ctx) {
    final GenerationConfig config = this.getGenerationConfig();
    boolean _equals = Objects.equal(config, null);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Testdata genration is not configured, set the URI.");
      throw new IllegalStateException(_builder.toString());
    }
    Grammar _target = config.getTarget();
    boolean _notEquals = (!Objects.equal(_target, this.grammar));
    if (_notEquals) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Testdata generation has problems resolving the target grammar");
      throw new IllegalStateException(_builder_1.toString());
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    String _abstractTestgenPath = this.getAbstractTestgenPath();
    _builder_2.append(_abstractTestgenPath, "");
    _builder_2.append(".java");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package ");
    String _testgenPackage = this.getTestgenPackage();
    _builder_3.append(_testgenPackage, "");
    _builder_3.append(";");
    _builder_3.newLineIfNotEmpty();
    _builder_3.newLine();
    _builder_3.append("/**");
    _builder_3.newLine();
    _builder_3.append(" ");
    _builder_3.append("* Testdata generator for grammar ");
    String _name = this.grammar.getName();
    _builder_3.append(_name, " ");
    _builder_3.newLineIfNotEmpty();
    _builder_3.append(" ");
    _builder_3.append("*/");
    _builder_3.newLine();
    _builder_3.append("public class ");
    String _abstractTestgenClass = this.getAbstractTestgenClass();
    _builder_3.append(_abstractTestgenClass, "");
    _builder_3.append(" {");
    _builder_3.newLineIfNotEmpty();
    _builder_3.append("\t");
    CharSequence _grammarContent = this.grammarContent(this.grammar);
    _builder_3.append(_grammarContent, "\t");
    _builder_3.newLineIfNotEmpty();
    _builder_3.append("}");
    _builder_3.newLine();
    ctx.writeFile(Generator.SRC_GEN, _builder_2.toString(), _builder_3);
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        StringConcatenation _builder_4 = new StringConcatenation();
        String _testgenPath = this.getTestgenPath();
        _builder_4.append(_testgenPath, "");
        _builder_4.append(".xtend");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("package ");
        String _testgenPackage_1 = this.getTestgenPackage();
        _builder_5.append(_testgenPackage_1, "");
        _builder_5.newLineIfNotEmpty();
        _builder_5.newLine();
        _builder_5.append("class ");
        String _testgenClass = this.getTestgenClass();
        _builder_5.append(_testgenClass, "");
        _builder_5.append(" extends ");
        String _abstractTestgenClass_1 = this.getAbstractTestgenClass();
        _builder_5.append(_abstractTestgenClass_1, "");
        _builder_5.append(" {");
        _builder_5.newLineIfNotEmpty();
        _builder_5.append("}");
        _builder_5.newLine();
        ctx.writeFile(Generator.SRC, _builder_4.toString(), _builder_5);
      } else {
        StringConcatenation _builder_6 = new StringConcatenation();
        String _testgenPath_1 = this.getTestgenPath();
        _builder_6.append(_testgenPath_1, "");
        _builder_6.append(".java");
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append("package ");
        String _testgenPackage_2 = this.getTestgenPackage();
        _builder_7.append(_testgenPackage_2, "");
        _builder_7.append(";");
        _builder_7.newLineIfNotEmpty();
        _builder_7.newLine();
        _builder_7.append("public class ");
        String _testgenClass_1 = this.getTestgenClass();
        _builder_7.append(_testgenClass_1, "");
        _builder_7.append(" extends ");
        String _abstractTestgenClass_2 = this.getAbstractTestgenClass();
        _builder_7.append(_abstractTestgenClass_2, "");
        _builder_7.append(" {");
        _builder_7.newLineIfNotEmpty();
        _builder_7.append("}");
        _builder_7.newLine();
        ctx.writeFile(Generator.SRC, _builder_6.toString(), _builder_7);
      }
    } else {
      StringConcatenation _builder_8 = new StringConcatenation();
      String _testgenPath_2 = this.getTestgenPath();
      _builder_8.append(_testgenPath_2, "");
      _builder_8.append(".java");
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("package ");
      String _testgenPackage_3 = this.getTestgenPackage();
      _builder_9.append(_testgenPackage_3, "");
      _builder_9.append(";");
      _builder_9.newLineIfNotEmpty();
      _builder_9.newLine();
      _builder_9.append("public class ");
      String _testgenClass_2 = this.getTestgenClass();
      _builder_9.append(_testgenClass_2, "");
      _builder_9.append(" extends ");
      String _abstractTestgenClass_3 = this.getAbstractTestgenClass();
      _builder_9.append(_abstractTestgenClass_3, "");
      _builder_9.append(" {");
      _builder_9.newLineIfNotEmpty();
      _builder_9.append("}");
      _builder_9.newLine();
      ctx.writeFile(Generator.SRC_GEN, _builder_8.toString(), _builder_9);
    }
  }
  
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    return super.getGuiceBindingsRt(grammar);
  }
  
  public String[] getRequiredBundlesRt(final Grammar grammar) {
    return new String[] { "org.softlang.xtestgen.config", "org.softlang.xtestgen.coco" };
  }
  
  protected List<String> getExportedPackagesRtList(final Grammar grammar) {
    String _testgenPackage = this.getTestgenPackage();
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_testgenPackage));
  }
  
  /**
   * Domain function calculates how many elements may outputted by an iteration in total
   */
  protected long _domain(final Grammar g, final AbstractElement e) {
    return 0;
  }
  
  protected long _domain(final Grammar g, final Keyword e) {
    return 1;
  }
  
  protected long _domain(final Grammar g, final Wildcard e) {
    String _sigma = this.getSigma();
    return _sigma.length();
  }
  
  /**
   * Code guidelines:
   *   calculation must depend on x
   *   local variables used must be prefixed with p
   *   calculation must assign res
   */
  protected CharSequence _function(final Grammar g, final AbstractElement e, final CharSequence x, final String p, final String res) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(res, "");
    _builder.append(" = \"\";");
    return _builder;
  }
  
  protected CharSequence _function(final Grammar g, final Keyword e, final CharSequence x, final String p, final String res) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(res, "");
    _builder.append(" = \"");
    String _value = e.getValue();
    String _escapeJava = StringEscapeUtils.escapeJava(_value);
    _builder.append(_escapeJava, "");
    _builder.append("\";");
    return _builder;
  }
  
  protected CharSequence _function(final Grammar g, final Wildcard e, final CharSequence x, final String p, final String res) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(res, "");
    _builder.append(" = Character.toString(\"");
    String _sigma = this.getSigma();
    String _escapeJava = StringEscapeUtils.escapeJava(_sigma);
    _builder.append(_escapeJava, "");
    _builder.append("\".charAt((int)(");
    _builder.append(x, "");
    _builder.append(")));");
    return _builder;
  }
  
  protected CharSequence _function(final Grammar g, final RuleCall e, final CharSequence x, final String p, final String res) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(res, "");
    _builder.append(" = ");
    AbstractRule _rule = e.getRule();
    Optional<CharSequence> _qualifyCall = this.qualifyCall(g, _rule);
    _builder.append(_qualifyCall, "");
    _builder.append("(");
    _builder.append(x, "");
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence _function(final Grammar g, final EOF e, final CharSequence x, final String p, final String res) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(res, "");
    _builder.append(" = \"\";");
    return _builder;
  }
  
  protected CharSequence _function(final Grammar g, final CrossReference e, final CharSequence x, final String p, final String res) {
    AbstractElement _terminal = e.getTerminal();
    return this.function(g, _terminal, x, p, res);
  }
  
  protected CharSequence _function(final Grammar g, final Group e, final CharSequence x, final String p, final String res) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractElement> _elements = e.getElements();
      int _size = _elements.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append("String ");
        _builder.append((p + i), "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        EList<AbstractElement> _elements_1 = e.getElements();
        AbstractElement _get = _elements_1.get((i).intValue());
        CharSequence _function = this.function(g, _get, x, (p + i), (p + i));
        _builder.append(_function, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append(res, "");
    _builder.append(" = ");
    {
      EList<AbstractElement> _elements_2 = e.getElements();
      int _size_1 = _elements_2.size();
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
      boolean _hasElements = false;
      for(final Integer i_1 : _doubleDotLessThan_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(" + ", "");
        }
        _builder.append((p + i_1), "");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _function(final Grammar g, final Alternatives e, final CharSequence x, final String p, final String res) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("long ");
    _builder.append(p, "");
    _builder.append("offset = 0;");
    _builder.newLineIfNotEmpty();
    {
      EList<AbstractElement> _elements = e.getElements();
      int _size = _elements.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("long ");
        _builder.append(p, "\t");
        _builder.append("size = ");
        EList<AbstractElement> _elements_1 = e.getElements();
        AbstractElement _get = _elements_1.get((i).intValue());
        long _domain = this.domain(g, _get);
        _builder.append(_domain, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("long ");
        _builder.append(p, "\t");
        _builder.append("local = ");
        _builder.append(x, "\t");
        _builder.append(" - ");
        _builder.append(p, "\t");
        _builder.append("offset;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if(");
        _builder.append(p, "\t");
        _builder.append("local >= 0 && ");
        _builder.append(p, "\t");
        _builder.append("local < ");
        _builder.append(p, "\t");
        _builder.append("size)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t");
        EList<AbstractElement> _elements_2 = e.getElements();
        AbstractElement _get_1 = _elements_2.get((i).intValue());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(p, "");
        _builder_1.append("local");
        CharSequence _function = this.function(g, _get_1, _builder_1, (p + i), res);
        _builder.append(_function, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(p, "\t");
        _builder.append("offset += ");
        _builder.append(p, "\t");
        _builder.append("size;");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append(res, "");
    _builder.append(" = \"\";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public long domain(final Grammar g, final AbstractElement e) {
    if (e instanceof Keyword) {
      return _domain(g, (Keyword)e);
    } else if (e instanceof Wildcard) {
      return _domain(g, (Wildcard)e);
    } else if (e != null) {
      return _domain(g, e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(g, e).toString());
    }
  }
  
  public CharSequence function(final Grammar g, final AbstractElement e, final CharSequence x, final String p, final String res) {
    if (e instanceof Alternatives) {
      return _function(g, (Alternatives)e, x, p, res);
    } else if (e instanceof Group) {
      return _function(g, (Group)e, x, p, res);
    } else if (e instanceof CrossReference) {
      return _function(g, (CrossReference)e, x, p, res);
    } else if (e instanceof EOF) {
      return _function(g, (EOF)e, x, p, res);
    } else if (e instanceof Keyword) {
      return _function(g, (Keyword)e, x, p, res);
    } else if (e instanceof RuleCall) {
      return _function(g, (RuleCall)e, x, p, res);
    } else if (e instanceof Wildcard) {
      return _function(g, (Wildcard)e, x, p, res);
    } else if (e != null) {
      return _function(g, e, x, p, res);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(g, e, x, p, res).toString());
    }
  }
}
