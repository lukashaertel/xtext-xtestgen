/*
* generated by Xtext
*/
package org.softlang.xtestgen;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ConfigStandaloneSetup extends ConfigStandaloneSetupGenerated{

	public static void doSetup() {
		new ConfigStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
