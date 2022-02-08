package org.example.version.two.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.version.two.interfaces.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DealerImplTest {
    private DealerImpl classToBeTested;
    private Voice voice = new Voice();
    private ShuffleMachine shuffleMachine = new ShuffleMachine();

    @BeforeEach
    void setUp() {
        classToBeTested = new DealerImpl(voice, shuffleMachine);
    }

    @Test
    void shouldReturnFiveCards_When_AmountOfCardsIsFive() {
        int amountOfCards = 5;
        List<Card> cardList = classToBeTested.giveCards(amountOfCards);
        assertEquals(cardList.size(), amountOfCards);
    }

    @Test
    void shouldReturnOneMoreCard() {
        ArrayList<Card> cards = new ArrayList<Card>();
        boolean OneMore = cards.add(classToBeTested.giveOneMoreCard());
        assertTrue(OneMore);
    }

    @Test
    void gameIsLostByPlayerWhenPlayerHasMoreThanTwentyOne() {
        PlayerMock playerMock = new PlayerMock();
        List<Card> playersCard = buildDealerDeckOfThreeCardsOverTwentyOne();
        assertTrue(classToBeTested.hasPlayerMoreThanTwentyOne(playerMock, playersCard));
    }

    @Test
    void gameIsLostByPlayerWhenPlayerHasMoreThanTwentyOneFalse() {
        PlayerMock playerMock = new PlayerMock();
        List<Card> playersCard = playerMock.buildPlayerDeckOfThreeCards();
        assertFalse(classToBeTested.hasPlayerMoreThanTwentyOne(playerMock, playersCard));
    }

    @Test
    void gameIsWonByPlayerWhenPlayerCardsUnderTwentyOneButDealerCardsOverTwentyOne() {
        List<Card> dealersCards = buildDealerDeckOfThreeCardsOverTwentyOne();
        int worthOfDealersCards = classToBeTested.calculateTotalWorth(dealersCards);
        assertTrue(classToBeTested.hasDealerMoreThanTwentyOne(worthOfDealersCards));
    }

    @Test
    void gameIsWonByPlayerWhenPlayerCardsUnderTwentyOneButDealerCardsOverTwentyOneFalse() {
        List<Card> dealersCards = buildDealerDeckOfThreeCardsUnderTwentyOne();
        int worthOfDealersCards = classToBeTested.calculateTotalWorth(dealersCards);
        assertFalse(classToBeTested.hasDealerMoreThanTwentyOne(worthOfDealersCards));
    }

    @Test
    void sameWorthOfCardsBetweenPlayerAndDealer() {
        PlayerMock playerMock = new PlayerMock();
        List<Card> playersCard = playerMock.buildPlayerDeckOfThreeCards();
        List<Card> dealersCards = playerMock.buildPlayerDeckOfThreeCards();
        int worthOfPlayersCards = playerMock.calculateTotalWorth(playersCard);
        int worthOfDealersCards = classToBeTested.calculateTotalWorth(dealersCards);
        assertTrue(classToBeTested.hasDealerSameWorthThanPlayer(worthOfPlayersCards, worthOfDealersCards));
    }

    @Test
    void gameIsLostByDealerWhenDealerCardsUnderTwentyOneAndUnderPlayersCards() {
        PlayerMock playerMock = new PlayerMock();
        List<Card> playersCard = playerMock.buildPlayerDeckOfThreeCards();
        List<Card> dealersCards = buildDealerDeckOfThreeCardsUnderTwentyOne();
        int worthOfDealersCards = classToBeTested.calculateTotalWorth(dealersCards);
        assertFalse(classToBeTested.isGameWonByBank(playerMock, playersCard, worthOfDealersCards));
    }

    @Test
    void gameIsLostByDealerWhenDealerCardsUnderTwentyOneAndUnderPlayersCardsTrue() {
        PlayerMock playerMock = new PlayerMock();
        List<Card> playersCard = playerMock.buildPlayerDeckOfThreeCards();
        List<Card> dealersCards = playerMock.buildPlayerDeckOfThreeCards();
        int worthOfDealersCards = classToBeTested.calculateTotalWorth(dealersCards);
        assertFalse(classToBeTested.isGameWonByBank(playerMock, playersCard, worthOfDealersCards));
    }

    @Test
    void playerWantsToContinue() {
        VoiceMockTrue voiceMock = new VoiceMockTrue();
        boolean answer = voiceMock.askTrueFalseQuestion("Do you want another card? Please answer with True or False.");
        assertTrue(answer);
    }

    @Test
    void playerDoesNotWantToContinue() {
        VoiceMockFalse voiceMock = new VoiceMockFalse();
        boolean answer = voiceMock.askTrueFalseQuestion("Do you want another card? Please answer with True or False.");
        assertFalse(answer);
    }


    private List<Card> buildDealerDeckOfThreeCardsOverTwentyOne() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new CardImpl(10));
        cards.add(new CardImpl(10));
        cards.add(new CardImpl(3));
        return cards;
    }

    private List<Card> buildDealerDeckOfThreeCardsUnderTwentyOne() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new CardImpl(1));
        cards.add(new CardImpl(1));
        cards.add(new CardImpl(3));
        return cards;
    }
}

