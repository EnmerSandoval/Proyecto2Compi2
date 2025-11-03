package com.enmer.compi2.errors;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class IDEErrorListener extends BaseErrorListener {
    private final ErrorReporter reporter;
    private final String fileName;
    private final String fase;

    public IDEErrorListener(ErrorReporter reporter, String fileName, String fase) {
        this.reporter = reporter;
        this.fileName = fileName;
        this.fase = fase;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        reporter.add(new CompileError(
                fase,
                msg,
                line,
                charPositionInLine,
                fileName
        ));
    }
}
