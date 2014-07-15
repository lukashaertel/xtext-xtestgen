/**
 */
package org.softlang.xtestgen.config;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.softlang.xtestgen.config.ConfigPackage
 * @generated
 */
public interface ConfigFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ConfigFactory eINSTANCE = org.softlang.xtestgen.config.impl.ConfigFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Generation Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Generation Config</em>'.
   * @generated
   */
  GenerationConfig createGenerationConfig();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ConfigPackage getConfigPackage();

} //ConfigFactory
