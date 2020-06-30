// $ANTLR 3.4 jp/mufg/sql/Sql.g 2020-06-30 04:32:47
 
	package jp.mufg.sql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SqlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMA", "WS", "'Hello'", "'World'"
    };

    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int COMMA=4;
    public static final int WS=5;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public SqlParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public SqlParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SqlParser.tokenNames; }
    public String getGrammarFileName() { return "jp/mufg/sql/Sql.g"; }



    // $ANTLR start "greet"
    // jp/mufg/sql/Sql.g:11:1: greet : 'Hello' COMMA 'World' ;
    public final void greet() throws RecognitionException {
        try {
            // jp/mufg/sql/Sql.g:12:2: ( 'Hello' COMMA 'World' )
            // jp/mufg/sql/Sql.g:12:4: 'Hello' COMMA 'World'
            {
            match(input,6,FOLLOW_6_in_greet26); 

            match(input,COMMA,FOLLOW_COMMA_in_greet28); 

            match(input,7,FOLLOW_7_in_greet30); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "greet"

    // Delegated rules


 

    public static final BitSet FOLLOW_6_in_greet26 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMMA_in_greet28 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_greet30 = new BitSet(new long[]{0x0000000000000002L});

}