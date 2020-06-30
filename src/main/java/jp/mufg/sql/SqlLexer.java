// $ANTLR 3.4 jp/mufg/sql/Sql.g 2020-06-30 04:32:47

	package jp.mufg.sql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SqlLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int COMMA=4;
    public static final int WS=5;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public SqlLexer() {} 
    public SqlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SqlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "jp/mufg/sql/Sql.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // jp/mufg/sql/Sql.g:6:6: ( 'Hello' )
            // jp/mufg/sql/Sql.g:6:8: 'Hello'
            {
            match("Hello"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // jp/mufg/sql/Sql.g:7:6: ( 'World' )
            // jp/mufg/sql/Sql.g:7:8: 'World'
            {
            match("World"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // jp/mufg/sql/Sql.g:16:2: ( ',' )
            // jp/mufg/sql/Sql.g:16:4: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // jp/mufg/sql/Sql.g:19:5: ( ( ' ' | '\\t' ) )
            // jp/mufg/sql/Sql.g:
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // jp/mufg/sql/Sql.g:1:8: ( T__6 | T__7 | COMMA | WS )
        int alt1=4;
        switch ( input.LA(1) ) {
        case 'H':
            {
            alt1=1;
            }
            break;
        case 'W':
            {
            alt1=2;
            }
            break;
        case ',':
            {
            alt1=3;
            }
            break;
        case '\t':
        case ' ':
            {
            alt1=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 1, 0, input);

            throw nvae;

        }

        switch (alt1) {
            case 1 :
                // jp/mufg/sql/Sql.g:1:10: T__6
                {
                mT__6(); 


                }
                break;
            case 2 :
                // jp/mufg/sql/Sql.g:1:15: T__7
                {
                mT__7(); 


                }
                break;
            case 3 :
                // jp/mufg/sql/Sql.g:1:20: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 4 :
                // jp/mufg/sql/Sql.g:1:26: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}