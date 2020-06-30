package jp.mufg.antlrutil;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class LexerErrorListener implements ANTLRErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        throw new RuntimeException("lexer error1. offendingSymbol=" + offendingSymbol + " line:" + line + " pos=" + charPositionInLine + " msg=" + msg, e);
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
            ATNConfigSet configs) {
        throw new RuntimeException("lexer error2.");
        
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
            ATNConfigSet configs) {
        throw new RuntimeException("lexer error3.");
        
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet ambigAlts,
            ATNConfigSet configs) {
        throw new RuntimeException("lexer error4.");
        
    }
}