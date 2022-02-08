package org.example.version.two.impl;

public class VoiceMock extends Voice {

    private int counter;
    private final int TIMES_TO_SAY_YES = 2;

    @Override
    public boolean askTrueFalseQuestion(String question) {
        return counter++ < TIMES_TO_SAY_YES;
    }
}
