package org.example.version.two.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.version.two.interfaces.Card;

public class DealerMock extends DealerImpl {

    private int amountOfYesAnswers;
    private int counter;

    public DealerMock(Voice voice, ShuffleMachine shuffleMachine) {
        super(voice, shuffleMachine);
    }

    @Override
    public List<Card> giveCards(int amountOfCards) {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < amountOfCards; i++) {
            cards.add(new CardImpl(1));
        }

        return cards;
    }

    @Override
    public Card giveOneMoreCard() {
        return new CardImpl(1);
    }

    @Override
    public boolean doWantToContinue() {
        return counter++ < amountOfYesAnswers;
    }

    public void amountOfYesAnswers(int yesAnswers) {
        this.amountOfYesAnswers = yesAnswers;
    }
}
