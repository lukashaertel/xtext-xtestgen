/**
 */
package org.softlang.xtestgen.config;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.Grammar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generation Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.softlang.xtestgen.config.GenerationConfig#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.softlang.xtestgen.config.ConfigPackage#getGenerationConfig()
 * @model
 * @generated
 */
public interface GenerationConfig extends EObject
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Grammar)
   * @see org.softlang.xtestgen.config.ConfigPackage#getGenerationConfig_Target()
   * @model
   * @generated
   */
  Grammar getTarget();

  /**
   * Sets the value of the '{@link org.softlang.xtestgen.config.GenerationConfig#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Grammar value);

} // GenerationConfig
