package org.example.version.two.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.example.version.two.interfaces.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerImplTest {

    private PlayerImpl classToBeTested;

    @BeforeEach
    void setUp() {
        classToBeTested = new PlayerImpl();
    }

    @Test
    void calculateTotalWorth() {
        List<Card> cards = buildDeckOfThreeCards();

        int result = classToBeTested.calculateTotalWorth(cards);

        assertEquals(6, result);
    }

    @Test
    void playersCards_doTakeOneAdditionalCard() {
        DealerMock dealerMock = new DealerMock(null, null);
        dealerMock.amountOfYesAnswers(1);
        classToBeTested.joinTable(dealerMock);
        List<Card> cards = buildDeckOfThreeCards();

        List<Card> result = classToBeTested.playersCards(cards);

        assertEquals(4, result.size());
    }

    @Test
    void askForInitialCards() {
    }

    @Test
    void askForOneMoreCard() {
        DealerMock dealerMock = new DealerMock(null, null);
        dealerMock.amountOfYesAnswers(1);
        classToBeTested.joinTable(dealerMock);

        Card card = classToBeTested.askForOneMoreCard();

        assertEquals(1, card.getWorth());
    }

    private List<Card> buildDeckOfThreeCards() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new CardImpl(1));
        cards.add(new CardImpl(2));
        cards.add(new CardImpl(3));
        return cards;
    }
}
