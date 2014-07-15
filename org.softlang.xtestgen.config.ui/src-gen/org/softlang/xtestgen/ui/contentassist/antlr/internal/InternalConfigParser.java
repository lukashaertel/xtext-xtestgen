package org.softlang.xtestgen.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.softlang.xtestgen.services.ConfigGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigParser extends AbstractInternalContentAssistParser {
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
    public String getGrammarFileName() { return "../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g"; }


     
     	private ConfigGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ConfigGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleGenerationConfig"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:60:1: entryRuleGenerationConfig : ruleGenerationConfig EOF ;
    public final void entryRuleGenerationConfig() throws RecognitionException {
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:61:1: ( ruleGenerationConfig EOF )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:62:1: ruleGenerationConfig EOF
            {
             before(grammarAccess.getGenerationConfigRule()); 
            pushFollow(FOLLOW_ruleGenerationConfig_in_entryRuleGenerationConfig61);
            ruleGenerationConfig();

            state._fsp--;

             after(grammarAccess.getGenerationConfigRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGenerationConfig68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGenerationConfig"


    // $ANTLR start "ruleGenerationConfig"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:69:1: ruleGenerationConfig : ( ( rule__GenerationConfig__Group__0 ) ) ;
    public final void ruleGenerationConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:73:2: ( ( ( rule__GenerationConfig__Group__0 ) ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:74:1: ( ( rule__GenerationConfig__Group__0 ) )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:74:1: ( ( rule__GenerationConfig__Group__0 ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:75:1: ( rule__GenerationConfig__Group__0 )
            {
             before(grammarAccess.getGenerationConfigAccess().getGroup()); 
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:76:1: ( rule__GenerationConfig__Group__0 )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:76:2: rule__GenerationConfig__Group__0
            {
            pushFollow(FOLLOW_rule__GenerationConfig__Group__0_in_ruleGenerationConfig94);
            rule__GenerationConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGenerationConfigAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenerationConfig"


    // $ANTLR start "entryRuleQID"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:88:1: entryRuleQID : ruleQID EOF ;
    public final void entryRuleQID() throws RecognitionException {
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:89:1: ( ruleQID EOF )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:90:1: ruleQID EOF
            {
             before(grammarAccess.getQIDRule()); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID121);
            ruleQID();

            state._fsp--;

             after(grammarAccess.getQIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:97:1: ruleQID : ( ( rule__QID__Group__0 ) ) ;
    public final void ruleQID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:101:2: ( ( ( rule__QID__Group__0 ) ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:102:1: ( ( rule__QID__Group__0 ) )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:102:1: ( ( rule__QID__Group__0 ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:103:1: ( rule__QID__Group__0 )
            {
             before(grammarAccess.getQIDAccess().getGroup()); 
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:104:1: ( rule__QID__Group__0 )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:104:2: rule__QID__Group__0
            {
            pushFollow(FOLLOW_rule__QID__Group__0_in_ruleQID154);
            rule__QID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQID"


    // $ANTLR start "rule__GenerationConfig__Group__0"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:118:1: rule__GenerationConfig__Group__0 : rule__GenerationConfig__Group__0__Impl rule__GenerationConfig__Group__1 ;
    public final void rule__GenerationConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:122:1: ( rule__GenerationConfig__Group__0__Impl rule__GenerationConfig__Group__1 )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:123:2: rule__GenerationConfig__Group__0__Impl rule__GenerationConfig__Group__1
            {
            pushFollow(FOLLOW_rule__GenerationConfig__Group__0__Impl_in_rule__GenerationConfig__Group__0188);
            rule__GenerationConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GenerationConfig__Group__1_in_rule__GenerationConfig__Group__0191);
            rule__GenerationConfig__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerationConfig__Group__0"


    // $ANTLR start "rule__GenerationConfig__Group__0__Impl"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:130:1: rule__GenerationConfig__Group__0__Impl : ( 'generator' ) ;
    public final void rule__GenerationConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:134:1: ( ( 'generator' ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:135:1: ( 'generator' )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:135:1: ( 'generator' )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:136:1: 'generator'
            {
             before(grammarAccess.getGenerationConfigAccess().getGeneratorKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__GenerationConfig__Group__0__Impl219); 
             after(grammarAccess.getGenerationConfigAccess().getGeneratorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerationConfig__Group__0__Impl"


    // $ANTLR start "rule__GenerationConfig__Group__1"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:149:1: rule__GenerationConfig__Group__1 : rule__GenerationConfig__Group__1__Impl ;
    public final void rule__GenerationConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:153:1: ( rule__GenerationConfig__Group__1__Impl )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:154:2: rule__GenerationConfig__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__GenerationConfig__Group__1__Impl_in_rule__GenerationConfig__Group__1250);
            rule__GenerationConfig__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerationConfig__Group__1"


    // $ANTLR start "rule__GenerationConfig__Group__1__Impl"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:160:1: rule__GenerationConfig__Group__1__Impl : ( ( rule__GenerationConfig__TargetAssignment_1 ) ) ;
    public final void rule__GenerationConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:164:1: ( ( ( rule__GenerationConfig__TargetAssignment_1 ) ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:165:1: ( ( rule__GenerationConfig__TargetAssignment_1 ) )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:165:1: ( ( rule__GenerationConfig__TargetAssignment_1 ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:166:1: ( rule__GenerationConfig__TargetAssignment_1 )
            {
             before(grammarAccess.getGenerationConfigAccess().getTargetAssignment_1()); 
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:167:1: ( rule__GenerationConfig__TargetAssignment_1 )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:167:2: rule__GenerationConfig__TargetAssignment_1
            {
            pushFollow(FOLLOW_rule__GenerationConfig__TargetAssignment_1_in_rule__GenerationConfig__Group__1__Impl277);
            rule__GenerationConfig__TargetAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGenerationConfigAccess().getTargetAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerationConfig__Group__1__Impl"


    // $ANTLR start "rule__QID__Group__0"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:181:1: rule__QID__Group__0 : rule__QID__Group__0__Impl rule__QID__Group__1 ;
    public final void rule__QID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:185:1: ( rule__QID__Group__0__Impl rule__QID__Group__1 )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:186:2: rule__QID__Group__0__Impl rule__QID__Group__1
            {
            pushFollow(FOLLOW_rule__QID__Group__0__Impl_in_rule__QID__Group__0311);
            rule__QID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QID__Group__1_in_rule__QID__Group__0314);
            rule__QID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__0"


    // $ANTLR start "rule__QID__Group__0__Impl"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:193:1: rule__QID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:197:1: ( ( RULE_ID ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:198:1: ( RULE_ID )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:198:1: ( RULE_ID )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:199:1: RULE_ID
            {
             before(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QID__Group__0__Impl341); 
             after(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__0__Impl"


    // $ANTLR start "rule__QID__Group__1"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:210:1: rule__QID__Group__1 : rule__QID__Group__1__Impl ;
    public final void rule__QID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:214:1: ( rule__QID__Group__1__Impl )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:215:2: rule__QID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QID__Group__1__Impl_in_rule__QID__Group__1370);
            rule__QID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__1"


    // $ANTLR start "rule__QID__Group__1__Impl"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:221:1: rule__QID__Group__1__Impl : ( ( rule__QID__Group_1__0 )* ) ;
    public final void rule__QID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:225:1: ( ( ( rule__QID__Group_1__0 )* ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:226:1: ( ( rule__QID__Group_1__0 )* )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:226:1: ( ( rule__QID__Group_1__0 )* )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:227:1: ( rule__QID__Group_1__0 )*
            {
             before(grammarAccess.getQIDAccess().getGroup_1()); 
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:228:1: ( rule__QID__Group_1__0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:228:2: rule__QID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QID__Group_1__0_in_rule__QID__Group__1__Impl397);
            	    rule__QID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getQIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__1__Impl"


    // $ANTLR start "rule__QID__Group_1__0"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:242:1: rule__QID__Group_1__0 : rule__QID__Group_1__0__Impl rule__QID__Group_1__1 ;
    public final void rule__QID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:246:1: ( rule__QID__Group_1__0__Impl rule__QID__Group_1__1 )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:247:2: rule__QID__Group_1__0__Impl rule__QID__Group_1__1
            {
            pushFollow(FOLLOW_rule__QID__Group_1__0__Impl_in_rule__QID__Group_1__0432);
            rule__QID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QID__Group_1__1_in_rule__QID__Group_1__0435);
            rule__QID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__0"


    // $ANTLR start "rule__QID__Group_1__0__Impl"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:254:1: rule__QID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:258:1: ( ( '.' ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:259:1: ( '.' )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:259:1: ( '.' )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:260:1: '.'
            {
             before(grammarAccess.getQIDAccess().getFullStopKeyword_1_0()); 
            match(input,12,FOLLOW_12_in_rule__QID__Group_1__0__Impl463); 
             after(grammarAccess.getQIDAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__0__Impl"


    // $ANTLR start "rule__QID__Group_1__1"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:273:1: rule__QID__Group_1__1 : rule__QID__Group_1__1__Impl ;
    public final void rule__QID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:277:1: ( rule__QID__Group_1__1__Impl )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:278:2: rule__QID__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QID__Group_1__1__Impl_in_rule__QID__Group_1__1494);
            rule__QID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__1"


    // $ANTLR start "rule__QID__Group_1__1__Impl"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:284:1: rule__QID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:288:1: ( ( RULE_ID ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:289:1: ( RULE_ID )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:289:1: ( RULE_ID )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:290:1: RULE_ID
            {
             before(grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QID__Group_1__1__Impl521); 
             after(grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__1__Impl"


    // $ANTLR start "rule__GenerationConfig__TargetAssignment_1"
    // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:306:1: rule__GenerationConfig__TargetAssignment_1 : ( ( ruleQID ) ) ;
    public final void rule__GenerationConfig__TargetAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:310:1: ( ( ( ruleQID ) ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:311:1: ( ( ruleQID ) )
            {
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:311:1: ( ( ruleQID ) )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:312:1: ( ruleQID )
            {
             before(grammarAccess.getGenerationConfigAccess().getTargetGrammarCrossReference_1_0()); 
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:313:1: ( ruleQID )
            // ../org.softlang.xtestgen.config.ui/src-gen/org/softlang/xtestgen/ui/contentassist/antlr/internal/InternalConfig.g:314:1: ruleQID
            {
             before(grammarAccess.getGenerationConfigAccess().getTargetGrammarQIDParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQID_in_rule__GenerationConfig__TargetAssignment_1563);
            ruleQID();

            state._fsp--;

             after(grammarAccess.getGenerationConfigAccess().getTargetGrammarQIDParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getGenerationConfigAccess().getTargetGrammarCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerationConfig__TargetAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleGenerationConfig_in_entryRuleGenerationConfig61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGenerationConfig68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GenerationConfig__Group__0_in_ruleGenerationConfig94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group__0_in_ruleQID154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GenerationConfig__Group__0__Impl_in_rule__GenerationConfig__Group__0188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__GenerationConfig__Group__1_in_rule__GenerationConfig__Group__0191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__GenerationConfig__Group__0__Impl219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GenerationConfig__Group__1__Impl_in_rule__GenerationConfig__Group__1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GenerationConfig__TargetAssignment_1_in_rule__GenerationConfig__Group__1__Impl277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group__0__Impl_in_rule__QID__Group__0311 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QID__Group__1_in_rule__QID__Group__0314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QID__Group__0__Impl341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group__1__Impl_in_rule__QID__Group__1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group_1__0_in_rule__QID__Group__1__Impl397 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__QID__Group_1__0__Impl_in_rule__QID__Group_1__0432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QID__Group_1__1_in_rule__QID__Group_1__0435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QID__Group_1__0__Impl463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group_1__1__Impl_in_rule__QID__Group_1__1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QID__Group_1__1__Impl521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_rule__GenerationConfig__TargetAssignment_1563 = new BitSet(new long[]{0x0000000000000002L});

}