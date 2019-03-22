package com.sxc.start;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class MyFailureAnalyzer implements FailureAnalyzer{

    @Override
    public FailureAnalysis analyze(Throwable failure) {
    System.out.println("analyze");
        return null;
    }

}
