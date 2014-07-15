/*
* generated by Xtext
*/
package org.softlang.xtestgen.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.softlang.xtestgen.services.ConfigGrammarAccess;

public class ConfigParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ConfigGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.softlang.xtestgen.parser.antlr.internal.InternalConfigParser createParser(XtextTokenStream stream) {
		return new org.softlang.xtestgen.parser.antlr.internal.InternalConfigParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "GenerationConfig";
	}
	
	public ConfigGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ConfigGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}