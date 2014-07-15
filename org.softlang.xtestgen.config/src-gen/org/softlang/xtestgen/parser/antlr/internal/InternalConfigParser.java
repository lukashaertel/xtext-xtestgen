package org.softlang.xtestgen.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.softlang.xtestgen.services.ConfigGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'generator'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalConfigParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConfigParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConfigParser.tokenNames; }
    public String getGrammarFileName() { return "../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g"; }



     	private ConfigGrammarAccess grammarAccess;
     	
        public InternalConfigParser(TokenStream input, ConfigGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "GenerationConfig";	
       	}
       	
       	@Override
       	protected ConfigGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleGenerationConfig"
    // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:67:1: entryRuleGenerationConfig returns [EObject current=null] : iv_ruleGenerationConfig= ruleGenerationConfig EOF ;
    public final EObject entryRuleGenerationConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerationConfig = null;


        try {
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:68:2: (iv_ruleGenerationConfig= ruleGenerationConfig EOF )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:69:2: iv_ruleGenerationConfig= ruleGenerationConfig EOF
            {
             newCompositeNode(grammarAccess.getGenerationConfigRule()); 
            pushFollow(FOLLOW_ruleGenerationConfig_in_entryRuleGenerationConfig75);
            iv_ruleGenerationConfig=ruleGenerationConfig();

            state._fsp--;

             current =iv_ruleGenerationConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGenerationConfig85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerationConfig"


    // $ANTLR start "ruleGenerationConfig"
    // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:76:1: ruleGenerationConfig returns [EObject current=null] : (otherlv_0= 'generator' ( ( ruleQID ) ) ) ;
    public final EObject ruleGenerationConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:79:28: ( (otherlv_0= 'generator' ( ( ruleQID ) ) ) )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:80:1: (otherlv_0= 'generator' ( ( ruleQID ) ) )
            {
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:80:1: (otherlv_0= 'generator' ( ( ruleQID ) ) )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:80:3: otherlv_0= 'generator' ( ( ruleQID ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleGenerationConfig122); 

                	newLeafNode(otherlv_0, grammarAccess.getGenerationConfigAccess().getGeneratorKeyword_0());
                
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:84:1: ( ( ruleQID ) )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:85:1: ( ruleQID )
            {
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:85:1: ( ruleQID )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:86:3: ruleQID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getGenerationConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getGenerationConfigAccess().getTargetGrammarCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleGenerationConfig145);
            ruleQID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerationConfig"


    // $ANTLR start "entryRuleQID"
    // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:107:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:108:2: (iv_ruleQID= ruleQID EOF )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:109:2: iv_ruleQID= ruleQID EOF
            {
             newCompositeNode(grammarAccess.getQIDRule()); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID182);
            iv_ruleQID=ruleQID();

            state._fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID193); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:116:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:119:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:120:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:120:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:120:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID233); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:127:1: (kw= '.' this_ID_2= RULE_ID )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.softlang.xtestgen.config/src-gen/org/softlang/xtestgen/parser/antlr/internal/InternalConfig.g:128:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleQID252); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID267); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQID"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleGenerationConfig_in_entryRuleGenerationConfig75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGenerationConfig85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGenerationConfig122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleGenerationConfig145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID233 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQID252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID267 = new BitSet(new long[]{0x0000000000001002L});

}