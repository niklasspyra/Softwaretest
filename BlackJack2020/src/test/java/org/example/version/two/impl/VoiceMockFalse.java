package org.example.version.two.impl;

public class VoiceMockFalse extends Voice {

    @Override
    public boolean askTrueFalseQuestion(String question) {
        return false;
    }
}
