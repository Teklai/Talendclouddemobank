package routines;

import org.antlr.runtime.*;
import org.talend.dataquality.parser.util.GrammarEngine;

public class A1_parisstreetindexcreationTstandardizerow_1 extends GrammarEngine {

    @Override
    protected void executeParserRule(TokenStream tokenStream) throws RecognitionException {
        CombinedParser parser = new CombinedParser(tokenStream, matcher.getInterpreter());
        parser.rule();
    }
   
    @Override
    protected Lexer getUserLexer(ANTLRStringStream antlrStringStream) {
        return new CombinedLexer(antlrStringStream);
    }

static class Combined_BasicLexer extends Lexer {
    public static final int EOF=-1;
    public static final int WHITESPACE=4;
    public static final int CHAR_IGNORED=5;
    public static final int CURRENCY=6;
    public static final int ROMAN_NUMERAL=7;
    public static final int DECIMAL=8;
    public static final int FRACTION=9;
    public static final int CHAR_CJK=10;
    public static final int INT=11;
    public static final int CAPWORD=12;
    public static final int WORD=13;
    public static final int ALPHANUM=14;
    public static final int UNDEFINED=15;
    public static final int DIGIT=16;
    public static final int UpperCasedLetter=17;
    public static final int LETTER_ASCII=18;
    public static final int LETTER=19;
    public static final int SYMBOL_ASCII=20;
    public static final int StreetType=21;
    public static final int StreetName=22;
    public static final int Tokens=23;

    // delegates
    // delegators
    public CombinedLexer gCombined;
    public CombinedLexer gParent;

    public Combined_BasicLexer() {;} 
    public Combined_BasicLexer(CharStream input, CombinedLexer gCombined) {
        this(input, new RecognizerSharedState(), gCombined);
    }
    public Combined_BasicLexer(CharStream input, RecognizerSharedState state, CombinedLexer gCombined) {
        super(input,state);

        this.gCombined = gCombined;
        gParent = gCombined;
    }
    public String getGrammarFileName() { return "BasicLexer.g"; }

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // BasicLexer.g:5:3: ( '0' .. '9' )
            // BasicLexer.g:6:3: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "UpperCasedLetter"
    public final void mUpperCasedLetter() throws RecognitionException {
        try {
            // BasicLexer.g:11:3: ( 'A' .. 'Z' )
            // BasicLexer.g:12:3: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UpperCasedLetter"

    // $ANTLR start "LETTER_ASCII"
    public final void mLETTER_ASCII() throws RecognitionException {
        try {
            // BasicLexer.g:17:3: ( 'a' .. 'z' | 'A' .. 'Z' )
            // BasicLexer.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER_ASCII"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // BasicLexer.g:24:3: ( LETTER_ASCII | '\\u00a0' .. '\\u00ff' )
            // BasicLexer.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "SYMBOL_ASCII"
    public final void mSYMBOL_ASCII() throws RecognitionException {
        try {
            // BasicLexer.g:31:3: ( '#' .. '&' | '*' | '+' | '-' | '/' | '<' .. '>' | '@' | '\\u005b' .. '\\u0060' | '\\u007b' .. '\\u007e' )
            // BasicLexer.g:
            {
            if ( (input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/'||(input.LA(1)>='<' && input.LA(1)<='>')||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<='`')||(input.LA(1)>='{' && input.LA(1)<='~') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SYMBOL_ASCII"

    // $ANTLR start "CHAR_CJK"
    public final void mCHAR_CJK() throws RecognitionException {
        try {
            int _type = CHAR_CJK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:39:3: ( ( '\\u4e00' .. '\\u9faf' )+ )
            // BasicLexer.g:40:3: ( '\\u4e00' .. '\\u9faf' )+
            {
            // BasicLexer.g:40:3: ( '\\u4e00' .. '\\u9faf' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u4E00' && LA1_0<='\u9FAF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // BasicLexer.g:40:4: '\\u4e00' .. '\\u9faf'
            	    {
            	    matchRange('\u4E00','\u9FAF'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR_CJK"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:44:3: ( DIGIT ( DIGIT )* )
            // BasicLexer.g:45:3: DIGIT ( DIGIT )*
            {
            mDIGIT(); 
            // BasicLexer.g:45:9: ( DIGIT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // BasicLexer.g:45:9: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "ALPHANUM"
    public final void mALPHANUM() throws RecognitionException {
        try {
            int _type = ALPHANUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:49:3: ( ( LETTER )+ DIGIT ( DIGIT | LETTER )* | ( DIGIT )+ LETTER ( DIGIT | LETTER )* )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='A' && LA7_0<='Z')||(LA7_0>='a' && LA7_0<='z')||(LA7_0>='\u00A0' && LA7_0<='\u00FF')) ) {
                alt7=1;
            }
            else if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // BasicLexer.g:50:3: ( LETTER )+ DIGIT ( DIGIT | LETTER )*
                    {
                    // BasicLexer.g:50:3: ( LETTER )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00A0' && LA3_0<='\u00FF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // BasicLexer.g:50:3: LETTER
                    	    {
                    	    mLETTER(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    mDIGIT(); 
                    // BasicLexer.g:50:17: ( DIGIT | LETTER )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00A0' && LA4_0<='\u00FF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // BasicLexer.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // BasicLexer.g:51:5: ( DIGIT )+ LETTER ( DIGIT | LETTER )*
                    {
                    // BasicLexer.g:51:5: ( DIGIT )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // BasicLexer.g:51:5: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    mLETTER(); 
                    // BasicLexer.g:51:19: ( DIGIT | LETTER )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00A0' && LA6_0<='\u00FF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // BasicLexer.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALPHANUM"

    // $ANTLR start "CAPWORD"
    public final void mCAPWORD() throws RecognitionException {
        try {
            int _type = CAPWORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:55:3: ( UpperCasedLetter ( UpperCasedLetter )* )
            // BasicLexer.g:56:3: UpperCasedLetter ( UpperCasedLetter )*
            {
            mUpperCasedLetter(); 
            // BasicLexer.g:56:20: ( UpperCasedLetter )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='A' && LA8_0<='Z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // BasicLexer.g:56:20: UpperCasedLetter
            	    {
            	    mUpperCasedLetter(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CAPWORD"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:60:3: ( ( LETTER )+ ( ( '-' | '.' ) ( LETTER )+ )* ( '.' )? )
            // BasicLexer.g:61:3: ( LETTER )+ ( ( '-' | '.' ) ( LETTER )+ )* ( '.' )?
            {
            // BasicLexer.g:61:3: ( LETTER )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='A' && LA9_0<='Z')||(LA9_0>='a' && LA9_0<='z')||(LA9_0>='\u00A0' && LA9_0<='\u00FF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // BasicLexer.g:61:3: LETTER
            	    {
            	    mLETTER(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // BasicLexer.g:61:11: ( ( '-' | '.' ) ( LETTER )+ )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='.') ) {
                    int LA11_1 = input.LA(2);

                    if ( ((LA11_1>='A' && LA11_1<='Z')||(LA11_1>='a' && LA11_1<='z')||(LA11_1>='\u00A0' && LA11_1<='\u00FF')) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0=='-') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // BasicLexer.g:61:12: ( '-' | '.' ) ( LETTER )+
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    // BasicLexer.g:61:22: ( LETTER )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( ((LA10_0>='A' && LA10_0<='Z')||(LA10_0>='a' && LA10_0<='z')||(LA10_0>='\u00A0' && LA10_0<='\u00FF')) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // BasicLexer.g:61:22: LETTER
            	    	    {
            	    	    mLETTER(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // BasicLexer.g:61:32: ( '.' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='.') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // BasicLexer.g:61:32: '.'
                    {
                    match('.'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WORD"

    // $ANTLR start "DECIMAL"
    public final void mDECIMAL() throws RecognitionException {
        try {
            int _type = DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:65:3: ( ( DIGIT )* '.' ( DIGIT )+ )
            // BasicLexer.g:66:3: ( DIGIT )* '.' ( DIGIT )+
            {
            // BasicLexer.g:66:3: ( DIGIT )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // BasicLexer.g:66:3: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match('.'); 
            // BasicLexer.g:66:14: ( DIGIT )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // BasicLexer.g:66:14: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "FRACTION"
    public final void mFRACTION() throws RecognitionException {
        try {
            int _type = FRACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:70:3: ( ( DIGIT )+ '/' ( DIGIT )+ | '\\u2153' .. '\\u215f' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                alt17=1;
            }
            else if ( ((LA17_0>='\u2153' && LA17_0<='\u215F')) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // BasicLexer.g:71:3: ( DIGIT )+ '/' ( DIGIT )+
                    {
                    // BasicLexer.g:71:3: ( DIGIT )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // BasicLexer.g:71:3: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    match('/'); 
                    // BasicLexer.g:71:14: ( DIGIT )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // BasicLexer.g:71:14: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // BasicLexer.g:72:5: '\\u2153' .. '\\u215f'
                    {
                    matchRange('\u2153','\u215F'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FRACTION"

    // $ANTLR start "CURRENCY"
    public final void mCURRENCY() throws RecognitionException {
        try {
            int _type = CURRENCY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:76:3: ( '\\u0024' | '\\u00a2' .. '\\u00a5' | '\\u20a0' .. '\\u20cf' )
            // BasicLexer.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A5')||(input.LA(1)>='\u20A0' && input.LA(1)<='\u20CF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CURRENCY"

    // $ANTLR start "ROMAN_NUMERAL"
    public final void mROMAN_NUMERAL() throws RecognitionException {
        try {
            int _type = ROMAN_NUMERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:83:3: ( '\\u2160' .. '\\u2182' )
            // BasicLexer.g:84:3: '\\u2160' .. '\\u2182'
            {
            matchRange('\u2160','\u2182'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROMAN_NUMERAL"

    // $ANTLR start "CHAR_IGNORED"
    public final void mCHAR_IGNORED() throws RecognitionException {
        try {
            int _type = CHAR_IGNORED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:88:3: ( '.' | ',' | ':' | ';' | '!' | '?' | '\"' | '\\'' | '(' | ')' )
            // BasicLexer.g:
            {
            if ( (input.LA(1)>='!' && input.LA(1)<='\"')||(input.LA(1)>='\'' && input.LA(1)<=')')||input.LA(1)==','||input.LA(1)=='.'||(input.LA(1)>=':' && input.LA(1)<=';')||input.LA(1)=='?' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR_IGNORED"

    // $ANTLR start "UNDEFINED"
    public final void mUNDEFINED() throws RecognitionException {
        try {
            int _type = UNDEFINED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BasicLexer.g:102:3: ( SYMBOL_ASCII ( SYMBOL_ASCII | CHAR_IGNORED )* )
            // BasicLexer.g:103:3: SYMBOL_ASCII ( SYMBOL_ASCII | CHAR_IGNORED )*
            {
            mSYMBOL_ASCII(); 
            // BasicLexer.g:103:16: ( SYMBOL_ASCII | CHAR_IGNORED )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='!' && LA18_0<='/')||(LA18_0>=':' && LA18_0<='@')||(LA18_0>='[' && LA18_0<='`')||(LA18_0>='{' && LA18_0<='~')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // BasicLexer.g:
            	    {
            	    if ( (input.LA(1)>='!' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='@')||(input.LA(1)>='[' && input.LA(1)<='`')||(input.LA(1)>='{' && input.LA(1)<='~') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDEFINED"

    public void mTokens() throws RecognitionException {
        // BasicLexer.g:1:8: ( CHAR_CJK | INT | ALPHANUM | CAPWORD | WORD | DECIMAL | FRACTION | CURRENCY | ROMAN_NUMERAL | CHAR_IGNORED | UNDEFINED )
        int alt19=11;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // BasicLexer.g:1:10: CHAR_CJK
                {
                mCHAR_CJK(); 

                }
                break;
            case 2 :
                // BasicLexer.g:1:19: INT
                {
                mINT(); 

                }
                break;
            case 3 :
                // BasicLexer.g:1:23: ALPHANUM
                {
                mALPHANUM(); 

                }
                break;
            case 4 :
                // BasicLexer.g:1:32: CAPWORD
                {
                mCAPWORD(); 

                }
                break;
            case 5 :
                // BasicLexer.g:1:40: WORD
                {
                mWORD(); 

                }
                break;
            case 6 :
                // BasicLexer.g:1:45: DECIMAL
                {
                mDECIMAL(); 

                }
                break;
            case 7 :
                // BasicLexer.g:1:53: FRACTION
                {
                mFRACTION(); 

                }
                break;
            case 8 :
                // BasicLexer.g:1:62: CURRENCY
                {
                mCURRENCY(); 

                }
                break;
            case 9 :
                // BasicLexer.g:1:71: ROMAN_NUMERAL
                {
                mROMAN_NUMERAL(); 

                }
                break;
            case 10 :
                // BasicLexer.g:1:85: CHAR_IGNORED
                {
                mCHAR_IGNORED(); 

                }
                break;
            case 11 :
                // BasicLexer.g:1:98: UNDEFINED
                {
                mUNDEFINED(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\2\uffff\1\15\1\21\1\23\1\12\1\uffff\1\23\1\13\5\uffff\1\15\3\uffff"+
        "\1\21\1\uffff";
    static final String DFA19_eofS =
        "\24\uffff";
    static final String DFA19_minS =
        "\1\41\1\uffff\1\56\1\55\2\60\1\uffff\1\60\1\41\5\uffff\1\56\3\uffff"+
        "\1\55\1\uffff";
    static final String DFA19_maxS =
        "\1\u9faf\1\uffff\3\u00ff\1\71\1\uffff\1\u00ff\1\176\5\uffff\1\u00ff"+
        "\3\uffff\1\u00ff\1\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\4\uffff\1\7\2\uffff\1\11\1\12\1\10\1\13\1\2\1\uffff"+
        "\1\3\1\6\1\4\1\uffff\1\5";
    static final String DFA19_specialS =
        "\24\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\12\1\14\1\10\2\14\3\12\2\14\1\12\1\14\1\5\1\14\12\2\2\12"+
            "\3\14\1\12\1\14\32\3\6\14\32\7\4\14\41\uffff\2\7\4\4\132\7\u1fa0"+
            "\uffff\60\13\u0083\uffff\15\6\43\11\u2c7d\uffff\u51b0\1",
            "",
            "\1\20\1\6\12\16\7\uffff\32\17\6\uffff\32\17\45\uffff\140\17",
            "\2\23\1\uffff\12\17\7\uffff\32\22\6\uffff\32\7\45\uffff\140"+
            "\7",
            "\12\17\7\uffff\32\7\6\uffff\32\7\45\uffff\140\7",
            "\12\20",
            "",
            "\12\17\7\uffff\32\7\6\uffff\32\7\45\uffff\140\7",
            "\17\14\12\uffff\7\14\32\uffff\6\14\32\uffff\4\14",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\6\12\16\7\uffff\32\17\6\uffff\32\17\45\uffff\140\17",
            "",
            "",
            "",
            "\2\23\1\uffff\12\17\7\uffff\32\22\6\uffff\32\7\45\uffff\140"+
            "\7",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( CHAR_CJK | INT | ALPHANUM | CAPWORD | WORD | DECIMAL | FRACTION | CURRENCY | ROMAN_NUMERAL | CHAR_IGNORED | UNDEFINED );";
        }
    }
 

}

static class CombinedLexer extends Lexer {
    public static final int EOF=-1;
    public static final int WHITESPACE=4;
    public static final int CHAR_IGNORED=5;
    public static final int CURRENCY=6;
    public static final int ROMAN_NUMERAL=7;
    public static final int DECIMAL=8;
    public static final int FRACTION=9;
    public static final int CHAR_CJK=10;
    public static final int INT=11;
    public static final int CAPWORD=12;
    public static final int WORD=13;
    public static final int ALPHANUM=14;
    public static final int UNDEFINED=15;
    public static final int DIGIT=16;
    public static final int UpperCasedLetter=17;
    public static final int LETTER_ASCII=18;
    public static final int LETTER=19;
    public static final int SYMBOL_ASCII=20;
    public static final int StreetType=21;
    public static final int StreetName=22;
    public static final int Tokens=23;

    /** Override this method to change where error messages go */
    public void emitErrorMessage(String msg) {
        org.talend.dataquality.parser.util.RecognitionError.set(false, msg);
        // System.err.println(msg);
    }


    // delegates
    public Combined_BasicLexer gBasicLexer;
    // delegators

    public CombinedLexer() {;} 
    public CombinedLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CombinedLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        gBasicLexer = new Combined_BasicLexer(input, state, this);
    }
    public String getGrammarFileName() { return "/Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g"; }

    // $ANTLR start "StreetType"
    public final void mStreetType() throws RecognitionException {
        try {
            int _type = StreetType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:52:12: ( '(' ( LETTER | '-' | '\\'' | ' ' )+ )
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:52:16: '(' ( LETTER | '-' | '\\'' | ' ' )+
            {
            match('('); 
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:52:21: ( LETTER | '-' | '\\'' | ' ' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==' '||LA1_0=='\''||LA1_0=='-'||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')||(LA1_0>='\u00A0' && LA1_0<='\u00FF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:
            	    {
            	    if ( input.LA(1)==' '||input.LA(1)=='\''||input.LA(1)=='-'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StreetType"

    // $ANTLR start "StreetName"
    public final void mStreetName() throws RecognitionException {
        try {
            int _type = StreetName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:53:12: ( ( LETTER | '-' | '\\'' | ' ' )+ )
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:53:15: ( LETTER | '-' | '\\'' | ' ' )+
            {
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:53:15: ( LETTER | '-' | '\\'' | ' ' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' '||LA2_0=='\''||LA2_0=='-'||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')||(LA2_0>='\u00A0' && LA2_0<='\u00FF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:
            	    {
            	    if ( input.LA(1)==' '||input.LA(1)=='\''||input.LA(1)=='-'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00A0' && input.LA(1)<='\u00FF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StreetName"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:56:3: ( ' ' | '\\n' | '\\r' | '\\t' | '\\f' )
            int alt3=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt3=1;
                }
                break;
            case '\n':
                {
                alt3=2;
                }
                break;
            case '\r':
                {
                alt3=3;
                }
                break;
            case '\t':
                {
                alt3=4;
                }
                break;
            case '\f':
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:57:3: ' '
                    {
                    match(' '); 

                          _channel = HIDDEN;
                         

                    }
                    break;
                case 2 :
                    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:61:5: '\\n'
                    {
                    match('\n'); 

                             _channel = HIDDEN;
                            

                    }
                    break;
                case 3 :
                    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:65:5: '\\r'
                    {
                    match('\r'); 

                             _channel = HIDDEN;
                            

                    }
                    break;
                case 4 :
                    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:69:5: '\\t'
                    {
                    match('\t'); 

                             _channel = HIDDEN;
                            

                    }
                    break;
                case 5 :
                    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:73:5: '\\f'
                    {
                    match('\f'); 

                             _channel = HIDDEN;
                            

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:1:8: ( StreetType | StreetName | WHITESPACE | BasicLexer. Tokens )
        int alt4=4;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:1:10: StreetType
                {
                mStreetType(); 

                }
                break;
            case 2 :
                // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:1:21: StreetName
                {
                mStreetName(); 

                }
                break;
            case 3 :
                // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:1:32: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 4 :
                // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:1:43: BasicLexer. Tokens
                {
                gBasicLexer.mTokens(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\1\5\1\uffff\1\13\3\uffff\3\13\2\uffff\4\13";
    static final String DFA4_eofS =
        "\20\uffff";
    static final String DFA4_minS =
        "\1\11\1\40\1\uffff\1\55\3\uffff\2\55\1\41\2\uffff\1\55\1\101\1\41"+
        "\1\55";
    static final String DFA4_maxS =
        "\1\u9faf\1\u00ff\1\uffff\1\u00ff\3\uffff\2\u00ff\1\176\2\uffff\2"+
        "\u00ff\1\176\1\u00ff";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\1\uffff\1\3\1\4\1\2\3\uffff\1\1\1\2\4\uffff";
    static final String DFA4_specialS =
        "\20\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\4\1\uffff\2\4\22\uffff\1\2\6\5\1\6\1\1\4\5\1\11\23\5\32\3"+
            "\6\5\32\10\4\5\41\uffff\2\10\4\7\132\10\u1fa0\uffff\60\5\u0083"+
            "\uffff\60\5\u2c7d\uffff\u51b0\5",
            "\1\12\6\uffff\1\12\5\uffff\1\12\23\uffff\32\12\6\uffff\32\12"+
            "\45\uffff\140\12",
            "",
            "\1\15\1\5\1\uffff\12\5\7\uffff\32\14\6\uffff\32\10\45\uffff"+
            "\140\10",
            "",
            "",
            "",
            "\1\15\1\5\1\uffff\12\5\7\uffff\32\10\6\uffff\32\10\45\uffff"+
            "\140\10",
            "\1\15\1\5\1\uffff\12\5\7\uffff\32\10\6\uffff\32\10\45\uffff"+
            "\140\10",
            "\6\5\1\16\5\5\1\16\2\5\12\uffff\7\5\32\uffff\6\5\32\uffff\4"+
            "\5",
            "",
            "",
            "\1\15\1\5\1\uffff\12\5\7\uffff\32\14\6\uffff\32\10\45\uffff"+
            "\140\10",
            "\32\17\6\uffff\32\17\45\uffff\140\17",
            "\6\5\1\16\5\5\1\16\2\5\12\uffff\7\5\32\uffff\6\5\32\uffff\4"+
            "\5",
            "\1\15\1\5\22\uffff\32\17\6\uffff\32\17\45\uffff\140\17"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( StreetType | StreetName | WHITESPACE | BasicLexer. Tokens );";
        }
    }
 

}

static class Combined_BasicParser extends Parser {
    public static final int EOF=-1;
    public static final int WHITESPACE=4;
    public static final int CHAR_IGNORED=5;
    public static final int CURRENCY=6;
    public static final int ROMAN_NUMERAL=7;
    public static final int DECIMAL=8;
    public static final int FRACTION=9;
    public static final int CHAR_CJK=10;
    public static final int INT=11;
    public static final int CAPWORD=12;
    public static final int WORD=13;
    public static final int ALPHANUM=14;
    public static final int UNDEFINED=15;
    public static final int DIGIT=16;
    public static final int UpperCasedLetter=17;
    public static final int LETTER_ASCII=18;
    public static final int LETTER=19;
    public static final int SYMBOL_ASCII=20;
    public static final int StreetType=21;
    public static final int StreetName=22;

    // delegates
    // delegators
    public CombinedParser gCombined;
    public CombinedParser gParent;


        public Combined_BasicParser(TokenStream input, CombinedParser gCombined) {
            this(input, new RecognizerSharedState(), gCombined);
        }
        public Combined_BasicParser(TokenStream input, RecognizerSharedState state, CombinedParser gCombined) {
            super(input, state);
            this.gCombined = gCombined;
             
            gParent = gCombined;
        }
        

    public String[] getTokenNames() { return CombinedParser.tokenNames; }
    public String getGrammarFileName() { return "BasicParser.g"; }


    org.talend.dataquality.parser.util.Interpreter interp;

    public void setInterpreter(org.talend.dataquality.parser.util.Interpreter interp) {
    	this.interp = interp;
    }



    // $ANTLR start "separator"
    // BasicParser.g:11:1: separator : ( WHITESPACE | CHAR_IGNORED );
    public final void separator() throws RecognitionException {
        try {
            // BasicParser.g:12:3: ( WHITESPACE | CHAR_IGNORED )
            // BasicParser.g:
            {
            if ( (input.LA(1)>=WHITESPACE && input.LA(1)<=CHAR_IGNORED) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "separator"


    // $ANTLR start "extended"
    // BasicParser.g:19:1: extended : ( currency | roman_numeral | decimal | fraction | cjk );
    public final void extended() throws RecognitionException {
        try {
            // BasicParser.g:20:3: ( currency | roman_numeral | decimal | fraction | cjk )
            int alt1=5;
            switch ( input.LA(1) ) {
            case CURRENCY:
                {
                alt1=1;
                }
                break;
            case ROMAN_NUMERAL:
                {
                alt1=2;
                }
                break;
            case DECIMAL:
                {
                alt1=3;
                }
                break;
            case FRACTION:
                {
                alt1=4;
                }
                break;
            case CHAR_CJK:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // BasicParser.g:21:3: currency
                    {
                    pushFollow(FOLLOW_currency_in_extended45);
                    currency();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // BasicParser.g:22:5: roman_numeral
                    {
                    pushFollow(FOLLOW_roman_numeral_in_extended51);
                    roman_numeral();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // BasicParser.g:23:5: decimal
                    {
                    pushFollow(FOLLOW_decimal_in_extended57);
                    decimal();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // BasicParser.g:24:5: fraction
                    {
                    pushFollow(FOLLOW_fraction_in_extended63);
                    fraction();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // BasicParser.g:25:5: cjk
                    {
                    pushFollow(FOLLOW_cjk_in_extended69);
                    cjk();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "extended"

    public static class currency_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "currency"
    // BasicParser.g:28:1: currency : CURRENCY ;
    public final Combined_BasicParser.currency_return currency() throws RecognitionException {
        Combined_BasicParser.currency_return retval = new Combined_BasicParser.currency_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:29:3: ( CURRENCY )
            // BasicParser.g:30:3: CURRENCY
            {
            match(input,CURRENCY,FOLLOW_CURRENCY_in_currency84); 

                        interp.store("CURRENCY", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "currency"

    public static class roman_numeral_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "roman_numeral"
    // BasicParser.g:36:1: roman_numeral : ROMAN_NUMERAL ;
    public final Combined_BasicParser.roman_numeral_return roman_numeral() throws RecognitionException {
        Combined_BasicParser.roman_numeral_return retval = new Combined_BasicParser.roman_numeral_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:37:3: ( ROMAN_NUMERAL )
            // BasicParser.g:38:3: ROMAN_NUMERAL
            {
            match(input,ROMAN_NUMERAL,FOLLOW_ROMAN_NUMERAL_in_roman_numeral113); 

                             interp.store("ROMAIN_NUMERAL", input.toString(retval.start,input.LT(-1)));
                            

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "roman_numeral"

    public static class decimal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "decimal"
    // BasicParser.g:44:1: decimal : DECIMAL ;
    public final Combined_BasicParser.decimal_return decimal() throws RecognitionException {
        Combined_BasicParser.decimal_return retval = new Combined_BasicParser.decimal_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:45:3: ( DECIMAL )
            // BasicParser.g:46:3: DECIMAL
            {
            match(input,DECIMAL,FOLLOW_DECIMAL_in_decimal147); 

                       interp.store("DECIMAL", input.toString(retval.start,input.LT(-1)));
                      

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decimal"

    public static class fraction_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "fraction"
    // BasicParser.g:52:1: fraction : FRACTION ;
    public final Combined_BasicParser.fraction_return fraction() throws RecognitionException {
        Combined_BasicParser.fraction_return retval = new Combined_BasicParser.fraction_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:53:3: ( FRACTION )
            // BasicParser.g:54:3: FRACTION
            {
            match(input,FRACTION,FOLLOW_FRACTION_in_fraction175); 

                        interp.store("FRACTION", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fraction"

    public static class cjk_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "cjk"
    // BasicParser.g:60:1: cjk : CHAR_CJK ;
    public final Combined_BasicParser.cjk_return cjk() throws RecognitionException {
        Combined_BasicParser.cjk_return retval = new Combined_BasicParser.cjk_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:61:3: ( CHAR_CJK )
            // BasicParser.g:62:3: CHAR_CJK
            {
            match(input,CHAR_CJK,FOLLOW_CHAR_CJK_in_cjk204); 

                        interp.store("CJK", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cjk"


    // $ANTLR start "basic"
    // BasicParser.g:70:1: basic : ( integer | capword | word | alphanum | undefined );
    public final void basic() throws RecognitionException {
        try {
            // BasicParser.g:71:3: ( integer | capword | word | alphanum | undefined )
            int alt2=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt2=1;
                }
                break;
            case CAPWORD:
                {
                alt2=2;
                }
                break;
            case WORD:
                {
                alt2=3;
                }
                break;
            case ALPHANUM:
                {
                alt2=4;
                }
                break;
            case UNDEFINED:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // BasicParser.g:72:3: integer
                    {
                    pushFollow(FOLLOW_integer_in_basic235);
                    integer();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // BasicParser.g:73:5: capword
                    {
                    pushFollow(FOLLOW_capword_in_basic241);
                    capword();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // BasicParser.g:74:5: word
                    {
                    pushFollow(FOLLOW_word_in_basic247);
                    word();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // BasicParser.g:75:5: alphanum
                    {
                    pushFollow(FOLLOW_alphanum_in_basic253);
                    alphanum();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // BasicParser.g:76:5: undefined
                    {
                    pushFollow(FOLLOW_undefined_in_basic259);
                    undefined();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "basic"

    public static class integer_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "integer"
    // BasicParser.g:79:1: integer : INT ;
    public final Combined_BasicParser.integer_return integer() throws RecognitionException {
        Combined_BasicParser.integer_return retval = new Combined_BasicParser.integer_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:80:3: ( INT )
            // BasicParser.g:81:3: INT
            {
            match(input,INT,FOLLOW_INT_in_integer274); 

                   interp.store("INT", input.toString(retval.start,input.LT(-1)));
                  

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integer"

    public static class capword_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "capword"
    // BasicParser.g:87:1: capword : CAPWORD ;
    public final Combined_BasicParser.capword_return capword() throws RecognitionException {
        Combined_BasicParser.capword_return retval = new Combined_BasicParser.capword_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:88:3: ( CAPWORD )
            // BasicParser.g:89:3: CAPWORD
            {
            match(input,CAPWORD,FOLLOW_CAPWORD_in_capword298); 

                       interp.store("CAPWORD", input.toString(retval.start,input.LT(-1)));
                      

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "capword"

    public static class word_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "word"
    // BasicParser.g:95:1: word : WORD ;
    public final Combined_BasicParser.word_return word() throws RecognitionException {
        Combined_BasicParser.word_return retval = new Combined_BasicParser.word_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:96:3: ( WORD )
            // BasicParser.g:97:3: WORD
            {
            match(input,WORD,FOLLOW_WORD_in_word326); 

                    interp.store("WORD", input.toString(retval.start,input.LT(-1)));
                   

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "word"

    public static class alphanum_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "alphanum"
    // BasicParser.g:103:1: alphanum : ALPHANUM ;
    public final Combined_BasicParser.alphanum_return alphanum() throws RecognitionException {
        Combined_BasicParser.alphanum_return retval = new Combined_BasicParser.alphanum_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:104:3: ( ALPHANUM )
            // BasicParser.g:105:3: ALPHANUM
            {
            match(input,ALPHANUM,FOLLOW_ALPHANUM_in_alphanum351); 

                        interp.store("ALPHANUM", input.toString(retval.start,input.LT(-1)));
                       

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "alphanum"

    public static class undefined_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "undefined"
    // BasicParser.g:111:1: undefined : UNDEFINED ;
    public final Combined_BasicParser.undefined_return undefined() throws RecognitionException {
        Combined_BasicParser.undefined_return retval = new Combined_BasicParser.undefined_return();
        retval.start = input.LT(1);

        try {
            // BasicParser.g:112:3: ( UNDEFINED )
            // BasicParser.g:113:3: UNDEFINED
            {
            match(input,UNDEFINED,FOLLOW_UNDEFINED_in_undefined380); 

                         interp.store("UNDEFINED", input.toString(retval.start,input.LT(-1)));
                        

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "undefined"

    // Delegated rules


 

    public static final BitSet FOLLOW_set_in_separator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_currency_in_extended45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_roman_numeral_in_extended51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimal_in_extended57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fraction_in_extended63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cjk_in_extended69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENCY_in_currency84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROMAN_NUMERAL_in_roman_numeral113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_in_decimal147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FRACTION_in_fraction175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_CJK_in_cjk204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_in_basic235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_capword_in_basic241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_basic247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alphanum_in_basic253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_undefined_in_basic259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integer274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPWORD_in_capword298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_word326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHANUM_in_alphanum351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDEFINED_in_undefined380 = new BitSet(new long[]{0x0000000000000002L});

}

static class CombinedParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WHITESPACE", "CHAR_IGNORED", "CURRENCY", "ROMAN_NUMERAL", "DECIMAL", "FRACTION", "CHAR_CJK", "INT", "CAPWORD", "WORD", "ALPHANUM", "UNDEFINED", "DIGIT", "UpperCasedLetter", "LETTER_ASCII", "LETTER", "SYMBOL_ASCII", "StreetType", "StreetName"
    };
    public static final int EOF=-1;
    public static final int WHITESPACE=4;
    public static final int CHAR_IGNORED=5;
    public static final int CURRENCY=6;
    public static final int ROMAN_NUMERAL=7;
    public static final int DECIMAL=8;
    public static final int FRACTION=9;
    public static final int CHAR_CJK=10;
    public static final int INT=11;
    public static final int CAPWORD=12;
    public static final int WORD=13;
    public static final int ALPHANUM=14;
    public static final int UNDEFINED=15;
    public static final int DIGIT=16;
    public static final int UpperCasedLetter=17;
    public static final int LETTER_ASCII=18;
    public static final int LETTER=19;
    public static final int SYMBOL_ASCII=20;
    public static final int StreetType=21;
    public static final int StreetName=22;

    // delegates
    public Combined_BasicParser gBasicParser;
    // delegators


        public CombinedParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CombinedParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gBasicParser = new Combined_BasicParser(input, state, this);         
        }
        

    public String[] getTokenNames() { return CombinedParser.tokenNames; }
    public String getGrammarFileName() { return "/Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g"; }


    org.talend.dataquality.parser.util.Interpreter interp;

    public CombinedParser(TokenStream tokenStream,
            org.talend.dataquality.parser.util.Interpreter interp) {
        this(tokenStream);
        this.interp = interp;
        gBasicParser.setInterpreter(interp);
    }

    /** Override this method to change where error messages go */
    public void emitErrorMessage(String msg) {
        org.talend.dataquality.parser.util.RecognitionError.set(false, msg);
        // System.err.println(msg);
    }



    // $ANTLR start "rule"
    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:38:1: rule : ( WHITESPACE | CHAR_IGNORED )* ( ( user | extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )* ;
    public final void rule() throws RecognitionException {
        try {
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:39:3: ( ( WHITESPACE | CHAR_IGNORED )* ( ( user | extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )* )
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:40:3: ( WHITESPACE | CHAR_IGNORED )* ( ( user | extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )*
            {
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:40:3: ( WHITESPACE | CHAR_IGNORED )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=WHITESPACE && LA1_0<=CHAR_IGNORED)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:
            	    {
            	    if ( (input.LA(1)>=WHITESPACE && input.LA(1)<=CHAR_IGNORED) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:41:3: ( ( user | extended | basic ) ( WHITESPACE | CHAR_IGNORED )* )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=CURRENCY && LA4_0<=UNDEFINED)||(LA4_0>=StreetType && LA4_0<=StreetName)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:42:5: ( user | extended | basic ) ( WHITESPACE | CHAR_IGNORED )*
            	    {
            	    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:42:5: ( user | extended | basic )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case StreetType:
            	    case StreetName:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case CURRENCY:
            	    case ROMAN_NUMERAL:
            	    case DECIMAL:
            	    case FRACTION:
            	    case CHAR_CJK:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case INT:
            	    case CAPWORD:
            	    case WORD:
            	    case ALPHANUM:
            	    case UNDEFINED:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:42:6: user
            	            {
            	            pushFollow(FOLLOW_user_in_rule74);
            	            user();

            	            state._fsp--;


            	            }
            	            break;
            	        case 2 :
            	            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:42:13: extended
            	            {
            	            pushFollow(FOLLOW_extended_in_rule78);
            	            extended();

            	            state._fsp--;


            	            }
            	            break;
            	        case 3 :
            	            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:42:24: basic
            	            {
            	            pushFollow(FOLLOW_basic_in_rule82);
            	            basic();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:43:5: ( WHITESPACE | CHAR_IGNORED )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( ((LA3_0>=WHITESPACE && LA3_0<=CHAR_IGNORED)) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:
            	    	    {
            	    	    if ( (input.LA(1)>=WHITESPACE && input.LA(1)<=CHAR_IGNORED) ) {
            	    	        input.consume();
            	    	        state.errorRecovery=false;
            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


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
    // $ANTLR end "rule"

    public static class user_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "user"
    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:47:1: user : ( StreetType | StreetName );
    public final CombinedParser.user_return user() throws RecognitionException {
        CombinedParser.user_return retval = new CombinedParser.user_return();
        retval.start = input.LT(1);

        try {
            // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:48:3: ( StreetType | StreetName )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==StreetType) ) {
                alt5=1;
            }
            else if ( (LA5_0==StreetName) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:48:5: StreetType
                    {
                    match(input,StreetType,FOLLOW_StreetType_in_user119); 
                     interp.store("StreetType", input.toString(retval.start,input.LT(-1))); 

                    }
                    break;
                case 2 :
                    // /Talend/Talend_All_trunk/runtime/TDQEE_runtime/TDQEEDEMOJAVA/tStandardizeRow_1_RULEFILES/grammar/Combined.g:49:5: StreetName
                    {
                    match(input,StreetName,FOLLOW_StreetName_in_user132); 
                     interp.store("StreetName", input.toString(retval.start,input.LT(-1))); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "user"

    // Delegated rules
    public Combined_BasicParser.fraction_return fraction() throws RecognitionException { return gBasicParser.fraction(); }
    public void separator() throws RecognitionException { gBasicParser.separator(); }
    public Combined_BasicParser.currency_return currency() throws RecognitionException { return gBasicParser.currency(); }
    public void basic() throws RecognitionException { gBasicParser.basic(); }
    public Combined_BasicParser.integer_return integer() throws RecognitionException { return gBasicParser.integer(); }
    public Combined_BasicParser.word_return word() throws RecognitionException { return gBasicParser.word(); }
    public Combined_BasicParser.undefined_return undefined() throws RecognitionException { return gBasicParser.undefined(); }
    public void extended() throws RecognitionException { gBasicParser.extended(); }
    public Combined_BasicParser.capword_return capword() throws RecognitionException { return gBasicParser.capword(); }
    public Combined_BasicParser.roman_numeral_return roman_numeral() throws RecognitionException { return gBasicParser.roman_numeral(); }
    public Combined_BasicParser.cjk_return cjk() throws RecognitionException { return gBasicParser.cjk(); }
    public Combined_BasicParser.alphanum_return alphanum() throws RecognitionException { return gBasicParser.alphanum(); }
    public Combined_BasicParser.decimal_return decimal() throws RecognitionException { return gBasicParser.decimal(); }


 

    public static final BitSet FOLLOW_set_in_rule54 = new BitSet(new long[]{0x000000000060FFF2L});
    public static final BitSet FOLLOW_user_in_rule74 = new BitSet(new long[]{0x000000000060FFF2L});
    public static final BitSet FOLLOW_extended_in_rule78 = new BitSet(new long[]{0x000000000060FFF2L});
    public static final BitSet FOLLOW_basic_in_rule82 = new BitSet(new long[]{0x000000000060FFF2L});
    public static final BitSet FOLLOW_set_in_rule91 = new BitSet(new long[]{0x000000000060FFF2L});
    public static final BitSet FOLLOW_StreetType_in_user119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StreetName_in_user132 = new BitSet(new long[]{0x0000000000000002L});

}
}