/**
 */
package org.softlang.xtestgen.config;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.softlang.xtestgen.config.ConfigFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "config";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://softlang.wikidot.com/xxtestgen/Config";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "config";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ConfigPackage eINSTANCE = org.softlang.xtestgen.config.impl.ConfigPackageImpl.init();

  /**
   * The meta object id for the '{@link org.softlang.xtestgen.config.impl.GenerationConfigImpl <em>Generation Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.softlang.xtestgen.config.impl.GenerationConfigImpl
   * @see org.softlang.xtestgen.config.impl.ConfigPackageImpl#getGenerationConfig()
   * @generated
   */
  int GENERATION_CONFIG = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATION_CONFIG__TARGET = 0;

  /**
   * The number of structural features of the '<em>Generation Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATION_CONFIG_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.softlang.xtestgen.config.GenerationConfig <em>Generation Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generation Config</em>'.
   * @see org.softlang.xtestgen.config.GenerationConfig
   * @generated
   */
  EClass getGenerationConfig();

  /**
   * Returns the meta object for the reference '{@link org.softlang.xtestgen.config.GenerationConfig#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.softlang.xtestgen.config.GenerationConfig#getTarget()
   * @see #getGenerationConfig()
   * @generated
   */
  EReference getGenerationConfig_Target();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ConfigFactory getConfigFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.softlang.xtestgen.config.impl.GenerationConfigImpl <em>Generation Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.softlang.xtestgen.config.impl.GenerationConfigImpl
     * @see org.softlang.xtestgen.config.impl.ConfigPackageImpl#getGenerationConfig()
     * @generated
     */
    EClass GENERATION_CONFIG = eINSTANCE.getGenerationConfig();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERATION_CONFIG__TARGET = eINSTANCE.getGenerationConfig_Target();

  }

} //ConfigPackage
