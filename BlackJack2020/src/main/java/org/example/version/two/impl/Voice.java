package org.example.version.two.impl;

import java.util.Scanner;

public class Voice {

    public boolean askTrueFalseQuestion(String question) {
        Scanner playerInput = new Scanner(System.in);
        System.out.println(question);
        String answerPlayer = playerInput.nextLine();

        return answerPlayer.equals("True");
    }

}
