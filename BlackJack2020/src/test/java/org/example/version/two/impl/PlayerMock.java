package org.example.version.two.impl;

import org.example.version.two.interfaces.Card;
import org.example.version.two.interfaces.Dealer;

import java.util.ArrayList;
import java.util.List;

public class PlayerMock extends PlayerImpl {
    /*@Override
    public int calculateTotalWorth() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new CardImpl(1));
        cards.add(new CardImpl(2));
        cards.add(new CardImpl(3));
        return super.calculateTotalWorth(cards);
    }*/

    @Override
    public int announceBudget() {
        return super.announceBudget();
    }

    @Override
    public int announceBet() {
        return super.announceBet();
    }

    @Override
    public List<Card> playersCards(List<Card> playerCards) {
        List<Card> cardList = playerCards;
        return super.playersCards(cardList);
    }
    public List<Card> buildPlayerDeckOfThreeCards() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new CardImpl(1));
        cards.add(new CardImpl(2));
        cards.add(new CardImpl(3));
        return cards;

    }

    @Override
    public void joinTable(Dealer dealer) {
        super.joinTable(dealer);
    }

    @Override
    public List<Card> askForInitialCards() {
        return super.askForInitialCards();
    }

    @Override
    public Card askForOneMoreCard() {
        return super.askForOneMoreCard();
    }
}
