package org.example.version.two.impl;

import org.example.version.two.interfaces.Card;

public class CardImpl implements Card {

    private final int worth;

    public CardImpl(int worth) {
        this.worth = worth;
    }

    public int getWorth() {
        return worth;
    }

    public String getColor() {
        return null;
    }
}
