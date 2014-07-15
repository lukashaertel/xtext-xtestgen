package org.softlang.xtestgen.coco;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.softlang.xtestgen.ConfigRuntimeModule;
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
  
  private GenerationConfig generationConfig;
  
  protected void addLocalBindings(final Binder binder) {
    ConfigRuntimeModule _configRuntimeModule = new ConfigRuntimeModule();
    binder.install(_configRuntimeModule);
  }
  
  public GenerationConfig setUri(final String uri) {
    GenerationConfig _xblockexpression = null;
    {
      ResourceSet _elvis = null;
      ResourceSet _forcedResourceSet = this.getForcedResourceSet();
      if (_forcedResourceSet != null) {
        _elvis = _forcedResourceSet;
      } else {
        XtextResourceSet _xtextResourceSet = new XtextResourceSet();
        _elvis = _xtextResourceSet;
      }
      final ResourceSet rs = _elvis;
      URI _createURI = URI.createURI(uri);
      Resource _resource = rs.getResource(_createURI, true);
      final XtextResource r = ((XtextResource) _resource);
      EList<EObject> _contents = r.getContents();
      boolean _isEmpty = _contents.isEmpty();
      if (_isEmpty) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Couldn\'t load configuration for \'");
        _builder.append(uri, "");
        _builder.append("\'.");
        throw new IllegalArgumentException(_builder.toString());
      }
      EList<Resource.Diagnostic> _errors = r.getErrors();
      boolean _isEmpty_1 = _errors.isEmpty();
      boolean _not = (!_isEmpty_1);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Problem parsing \'");
        _builder_1.append(uri, "");
        _builder_1.append("\':");
        {
          EList<Resource.Diagnostic> _errors_1 = r.getErrors();
          boolean _hasElements = false;
          for(final Resource.Diagnostic e : _errors_1) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder_1.appendImmediate(", ", "");
            }
            _builder_1.append(e, "");
          }
        }
        throw new IllegalStateException(_builder_1.toString());
      }
      EList<EObject> _contents_1 = r.getContents();
      final Iterable<GenerationConfig> cs = Iterables.<GenerationConfig>filter(_contents_1, GenerationConfig.class);
      boolean _isEmpty_2 = IterableExtensions.isEmpty(cs);
      if (_isEmpty_2) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("No configuration model in \'uri\'.");
        throw new IllegalStateException(_builder_2.toString());
      }
      GenerationConfig _head = IterableExtensions.<GenerationConfig>head(cs);
      _xblockexpression = this.generationConfig = _head;
    }
    return _xblockexpression;
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
  
  public void generate(final Xtend2ExecutionContext ctx) {
    boolean _equals = Objects.equal(this.generationConfig, null);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Testdata genration is not configured, set the URI.");
      throw new IllegalStateException(_builder.toString());
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    String _abstractTestgenPath = this.getAbstractTestgenPath();
    _builder_1.append(_abstractTestgenPath, "");
    _builder_1.append(".java");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package ");
    String _testgenPackage = this.getTestgenPackage();
    _builder_2.append(_testgenPackage, "");
    _builder_2.append(";");
    _builder_2.newLineIfNotEmpty();
    _builder_2.newLine();
    _builder_2.append("public class ");
    String _abstractTestgenClass = this.getAbstractTestgenClass();
    _builder_2.append(_abstractTestgenClass, "");
    _builder_2.append(" {");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("}");
    _builder_2.newLine();
    ctx.writeFile(Generator.SRC_GEN, _builder_1.toString(), _builder_2);
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        StringConcatenation _builder_3 = new StringConcatenation();
        String _testgenPath = this.getTestgenPath();
        _builder_3.append(_testgenPath, "");
        _builder_3.append(".xtend");
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("package ");
        String _testgenPackage_1 = this.getTestgenPackage();
        _builder_4.append(_testgenPackage_1, "");
        _builder_4.newLineIfNotEmpty();
        _builder_4.newLine();
        _builder_4.append("class ");
        String _testgenClass = this.getTestgenClass();
        _builder_4.append(_testgenClass, "");
        _builder_4.append(" extends ");
        String _abstractTestgenClass_1 = this.getAbstractTestgenClass();
        _builder_4.append(_abstractTestgenClass_1, "");
        _builder_4.append(" {");
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("}");
        _builder_4.newLine();
        ctx.writeFile(Generator.SRC, _builder_3.toString(), _builder_4);
      } else {
        StringConcatenation _builder_5 = new StringConcatenation();
        String _testgenPath_1 = this.getTestgenPath();
        _builder_5.append(_testgenPath_1, "");
        _builder_5.append(".java");
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("package ");
        String _testgenPackage_2 = this.getTestgenPackage();
        _builder_6.append(_testgenPackage_2, "");
        _builder_6.append(";");
        _builder_6.newLineIfNotEmpty();
        _builder_6.newLine();
        _builder_6.append("public class ");
        String _testgenClass_1 = this.getTestgenClass();
        _builder_6.append(_testgenClass_1, "");
        _builder_6.append(" extends ");
        String _abstractTestgenClass_2 = this.getAbstractTestgenClass();
        _builder_6.append(_abstractTestgenClass_2, "");
        _builder_6.append(" {");
        _builder_6.newLineIfNotEmpty();
        _builder_6.append("}");
        _builder_6.newLine();
        ctx.writeFile(Generator.SRC, _builder_5.toString(), _builder_6);
      }
    } else {
      StringConcatenation _builder_7 = new StringConcatenation();
      String _testgenPath_2 = this.getTestgenPath();
      _builder_7.append(_testgenPath_2, "");
      _builder_7.append(".java");
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("package ");
      String _testgenPackage_3 = this.getTestgenPackage();
      _builder_8.append(_testgenPackage_3, "");
      _builder_8.append(";");
      _builder_8.newLineIfNotEmpty();
      _builder_8.newLine();
      _builder_8.append("public class ");
      String _testgenClass_2 = this.getTestgenClass();
      _builder_8.append(_testgenClass_2, "");
      _builder_8.append(" extends ");
      String _abstractTestgenClass_3 = this.getAbstractTestgenClass();
      _builder_8.append(_abstractTestgenClass_3, "");
      _builder_8.append(" {");
      _builder_8.newLineIfNotEmpty();
      _builder_8.append("}");
      _builder_8.newLine();
      ctx.writeFile(Generator.SRC_GEN, _builder_7.toString(), _builder_8);
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
}
