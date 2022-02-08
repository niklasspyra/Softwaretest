package org.example.version.two.impl;

import java.util.List;
import java.util.Random;

import org.example.version.two.interfaces.Card;

public class ShuffleMachine {

    public Card provideRandomCard(List<Card> cards) {
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        return cards.get(randomIndex);
    }

}
