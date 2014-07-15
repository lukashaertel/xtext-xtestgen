/*
* generated by Xtext
*/
package org.softlang.xtestgen.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.softlang.xtestgen.services.ConfigGrammarAccess;

public class ConfigParser extends AbstractContentAssistParser {
	
	@Inject
	private ConfigGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.softlang.xtestgen.ui.contentassist.antlr.internal.InternalConfigParser createParser() {
		org.softlang.xtestgen.ui.contentassist.antlr.internal.InternalConfigParser result = new org.softlang.xtestgen.ui.contentassist.antlr.internal.InternalConfigParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getGenerationConfigAccess().getGroup(), "rule__GenerationConfig__Group__0");
					put(grammarAccess.getQIDAccess().getGroup(), "rule__QID__Group__0");
					put(grammarAccess.getQIDAccess().getGroup_1(), "rule__QID__Group_1__0");
					put(grammarAccess.getGenerationConfigAccess().getTargetAssignment_1(), "rule__GenerationConfig__TargetAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.softlang.xtestgen.ui.contentassist.antlr.internal.InternalConfigParser typedParser = (org.softlang.xtestgen.ui.contentassist.antlr.internal.InternalConfigParser) parser;
			typedParser.entryRuleGenerationConfig();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ConfigGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ConfigGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}