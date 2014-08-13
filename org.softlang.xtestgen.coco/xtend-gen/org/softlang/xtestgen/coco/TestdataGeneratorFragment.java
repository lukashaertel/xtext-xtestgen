package org.softlang.xtestgen.coco;

import com.google.common.base.Optional;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
   * Cf. forced resource set of the language configuration
   */
  private ResourceSet _forcedResourceSet;
  
  /**
   * Cf. forced resource set of the language configuration
   */
  public ResourceSet getForcedResourceSet() {
    return this._forcedResourceSet;
  }
  
  /**
   * Cf. forced resource set of the language configuration
   */
  public void setForcedResourceSet(final ResourceSet forcedResourceSet) {
    this._forcedResourceSet = forcedResourceSet;
  }
  
  public String getTestgenPackage() {
    StringConcatenation _builder = new StringConcatenation();
    String _basePackageRuntime = this.naming.basePackageRuntime(this.grammar);
    _builder.append(_basePackageRuntime, "");
    _builder.append(".testdata");
    return _builder.toString();
  }
  
  public String getAbstractTestgenClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _name = this.grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name);
    _builder.append(_simpleName, "");
    _builder.append("TestdataGenerator");
    return _builder.toString();
  }
  
  public String getAbstractTestgenName() {
    StringConcatenation _builder = new StringConcatenation();
    String _testgenPackage = this.getTestgenPackage();
    _builder.append(_testgenPackage, "");
    _builder.append(".");
    String _abstractTestgenClass = this.getAbstractTestgenClass();
    _builder.append(_abstractTestgenClass, "");
    return _builder.toString();
  }
  
  public String getAbstractTestgenPath() {
    StringConcatenation _builder = new StringConcatenation();
    String _abstractTestgenName = this.getAbstractTestgenName();
    String _asPath = this.naming.asPath(_abstractTestgenName);
    _builder.append(_asPath, "");
    return _builder.toString();
  }
  
  public String getTestgenClass() {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this.grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name);
    _builder.append(_simpleName, "");
    _builder.append("TestdataGenerator");
    return _builder.toString();
  }
  
  public String getTestgenName() {
    StringConcatenation _builder = new StringConcatenation();
    String _testgenPackage = this.getTestgenPackage();
    _builder.append(_testgenPackage, "");
    _builder.append(".");
    String _testgenClass = this.getTestgenClass();
    _builder.append(_testgenClass, "");
    return _builder.toString();
  }
  
  public String getTestgenPath() {
    StringConcatenation _builder = new StringConcatenation();
    String _testgenName = this.getTestgenName();
    String _asPath = this.naming.asPath(_testgenName);
    _builder.append(_asPath, "");
    return _builder.toString();
  }
  
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
        _builder.append("protected String get");
        String _name_1 = r.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_1);
        _builder.append(_firstUpper, "");
        _builder.append("(long k) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return ");
        AbstractElement _alternatives = r.getAlternatives();
        CharSequence _elementDependentOf = this.elementDependentOf(_alternatives, "k");
        _builder.append(_elementDependentOf, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * TODO: Bessere Struktur finden, nested statics scheinen aber eine gute lösung für den Grammar inheritance Tree(?) zu sein
   */
  protected CharSequence _elementDependentOf(final AbstractElement element, final String v) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _elementDependentOf(final Keyword element, final String v) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _value = element.getValue();
    _builder.append(_value, "");
    _builder.append("\"");
    return _builder;
  }
  
  protected CharSequence _elementDependentOf(final Group element, final String v) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractElement> _elements = element.getElements();
      boolean _hasElements = false;
      for(final AbstractElement e : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("+", "");
        }
        EList<AbstractElement> _elements_1 = element.getElements();
        int _indexOf = _elements_1.indexOf(e);
        String _plus = ((("distributeInGroup(" + v) + ", ") + Integer.valueOf(_indexOf));
        String _plus_1 = (_plus + " ,");
        EList<AbstractElement> _elements_2 = element.getElements();
        int _size = _elements_2.size();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size));
        String _plus_3 = (_plus_2 + ")");
        CharSequence _elementDependentOf = this.elementDependentOf(e, _plus_3);
        _builder.append(_elementDependentOf, "");
      }
    }
    return _builder;
  }
  
  public Optional<CharSequence> qualify(final Grammar from, final AbstractRule rule) {
    Optional<CharSequence> _xblockexpression = null;
    {
      EList<AbstractRule> _rules = from.getRules();
      boolean _contains = _rules.contains(rule);
      if (_contains) {
        String _name = rule.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        String _plus = ("get" + _firstUpper);
        return Optional.<CharSequence>of(_plus);
      }
      EList<Grammar> _usedGrammars = from.getUsedGrammars();
      for (final Grammar u : _usedGrammars) {
        {
          final Optional<CharSequence> p = this.qualify(u, rule);
          boolean _isPresent = p.isPresent();
          if (_isPresent) {
            String _name_1 = u.getName();
            String _simpleName = this.naming.toSimpleName(_name_1);
            String _plus_1 = (_simpleName + ".");
            CharSequence _get = p.get();
            String _plus_2 = (_plus_1 + _get);
            return Optional.<CharSequence>of(_plus_2);
          }
        }
      }
      _xblockexpression = Optional.<CharSequence>absent();
    }
    return _xblockexpression;
  }
  
  public void generate(final Xtend2ExecutionContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    String _abstractTestgenPath = this.getAbstractTestgenPath();
    _builder.append(_abstractTestgenPath, "");
    _builder.append(".java");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package ");
    String _testgenPackage = this.getTestgenPackage();
    _builder_1.append(_testgenPackage, "");
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("import static org.softlang.xtestgen.coco.Counting.*;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* Testdata generator for grammar ");
    String _name = this.grammar.getName();
    _builder_1.append(_name, " ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("public class ");
    String _abstractTestgenClass = this.getAbstractTestgenClass();
    _builder_1.append(_abstractTestgenClass, "");
    _builder_1.append(" {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    CharSequence _grammarContent = this.grammarContent(this.grammar);
    _builder_1.append(_grammarContent, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/**");
    _builder_1.newLine();
    {
      TreeIterator<EObject> _eAllContents = this.grammar.eAllContents();
      Iterator<RuleCall> _filter = Iterators.<RuleCall>filter(_eAllContents, RuleCall.class);
      Iterable<RuleCall> _iterable = IteratorExtensions.<RuleCall>toIterable(_filter);
      for(final RuleCall f : _iterable) {
        _builder_1.append("\t ");
        _builder_1.append("* ");
        AbstractRule _rule = f.getRule();
        Optional<CharSequence> _qualify = this.qualify(this.grammar, _rule);
        _builder_1.append(_qualify, "\t ");
        _builder_1.newLineIfNotEmpty();
      }
    }
    _builder_1.append("\t ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    ctx.writeFile(Generator.SRC_GEN, _builder.toString(), _builder_1);
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        StringConcatenation _builder_2 = new StringConcatenation();
        String _testgenPath = this.getTestgenPath();
        _builder_2.append(_testgenPath, "");
        _builder_2.append(".xtend");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("package ");
        String _testgenPackage_1 = this.getTestgenPackage();
        _builder_3.append(_testgenPackage_1, "");
        _builder_3.newLineIfNotEmpty();
        _builder_3.newLine();
        _builder_3.append("class ");
        String _testgenClass = this.getTestgenClass();
        _builder_3.append(_testgenClass, "");
        _builder_3.append(" extends ");
        String _abstractTestgenClass_1 = this.getAbstractTestgenClass();
        _builder_3.append(_abstractTestgenClass_1, "");
        _builder_3.append(" {");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("}");
        _builder_3.newLine();
        ctx.writeFile(Generator.SRC, _builder_2.toString(), _builder_3);
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        String _testgenPath_1 = this.getTestgenPath();
        _builder_4.append(_testgenPath_1, "");
        _builder_4.append(".java");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("package ");
        String _testgenPackage_2 = this.getTestgenPackage();
        _builder_5.append(_testgenPackage_2, "");
        _builder_5.append(";");
        _builder_5.newLineIfNotEmpty();
        _builder_5.newLine();
        _builder_5.append("public class ");
        String _testgenClass_1 = this.getTestgenClass();
        _builder_5.append(_testgenClass_1, "");
        _builder_5.append(" extends ");
        String _abstractTestgenClass_2 = this.getAbstractTestgenClass();
        _builder_5.append(_abstractTestgenClass_2, "");
        _builder_5.append(" {");
        _builder_5.newLineIfNotEmpty();
        _builder_5.append("}");
        _builder_5.newLine();
        ctx.writeFile(Generator.SRC, _builder_4.toString(), _builder_5);
      }
    } else {
      StringConcatenation _builder_6 = new StringConcatenation();
      String _testgenPath_2 = this.getTestgenPath();
      _builder_6.append(_testgenPath_2, "");
      _builder_6.append(".java");
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("package ");
      String _testgenPackage_3 = this.getTestgenPackage();
      _builder_7.append(_testgenPackage_3, "");
      _builder_7.append(";");
      _builder_7.newLineIfNotEmpty();
      _builder_7.newLine();
      _builder_7.append("public class ");
      String _testgenClass_2 = this.getTestgenClass();
      _builder_7.append(_testgenClass_2, "");
      _builder_7.append(" extends ");
      String _abstractTestgenClass_3 = this.getAbstractTestgenClass();
      _builder_7.append(_abstractTestgenClass_3, "");
      _builder_7.append(" {");
      _builder_7.newLineIfNotEmpty();
      _builder_7.append("}");
      _builder_7.newLine();
      ctx.writeFile(Generator.SRC_GEN, _builder_6.toString(), _builder_7);
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
  
  public CharSequence elementDependentOf(final AbstractElement element, final String v) {
    if (element instanceof Group) {
      return _elementDependentOf((Group)element, v);
    } else if (element instanceof Keyword) {
      return _elementDependentOf((Keyword)element, v);
    } else if (element != null) {
      return _elementDependentOf(element, v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, v).toString());
    }
  }
}
