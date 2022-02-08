package org.example.version.two.impl;

import java.util.List;

import org.example.version.two.interfaces.Card;

public class ShuffleMachineMock extends ShuffleMachine {

    private Card fakeRandomCard;

    public ShuffleMachineMock(Card fakeRandomCard) {
        this.fakeRandomCard = fakeRandomCard;
    }

    @Override
    public Card provideRandomCard(List<Card> cards) {
        return fakeRandomCard;
    }

    public void setFakeRandomCard(Card card) {
        this.fakeRandomCard = card;
    }
}
