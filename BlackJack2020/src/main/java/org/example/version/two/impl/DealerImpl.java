package org.example.version.two.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.version.two.interfaces.Card;
import org.example.version.two.interfaces.Dealer;
import org.example.version.two.interfaces.Player;

public class DealerImpl implements Dealer {

    private final List<Card> deck;
    private final Voice voice;
    private final ShuffleMachine shuffleMachine;

    public DealerImpl(Voice voice, ShuffleMachine shuffleMachine) {
        this.voice = voice;
        this.shuffleMachine = shuffleMachine;

        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 1; i < 11; i++) {
            cards.add(new CardImpl(i));
        }
        cards.add(new CardImpl(10)); // jack
        cards.add(new CardImpl(10)); // queen
        cards.add(new CardImpl(10)); // king

        deck = cards;
    }

    public List<Card> giveCards(int amountOfCards) {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < amountOfCards; i++) {
            cards.add(giveOneMoreCard());
        }

        return cards;
    }

    public Card giveOneMoreCard() {
        return shuffleMachine.provideRandomCard(deck);
    }

    public List<Card> giveInitialCards() {
        return giveCards(2);
    }

    public int calculateTotalWorth(List<Card> cards) {
        int result = 0;

        for (Card card : cards) {
            result += card.getWorth();
        }

        return result;
    }

    public int dealersCards() {
        List<Card> dealersCards = giveInitialCards();
        int worthOfDealerCards = 0;
        while (worthOfDealerCards < 17) {
            dealersCards.add(giveOneMoreCard());
            worthOfDealerCards = calculateTotalWorth(dealersCards);
        }
        return worthOfDealerCards;
    }

    public boolean isGameWonByPlayer(Player player, List<Card> cards, int worthOfDealerCards) {
        int totalWorthOfPlayerCards = player.calculateTotalWorth(cards);

        if (hasPlayerMoreThanTwentyOne(player, cards)) {
            return false;
        } else if (hasDealerMoreThanTwentyOne(worthOfDealerCards)) {
            return true;
        } else if (hasDealerSameWorthThanPlayer(totalWorthOfPlayerCards, worthOfDealerCards)) {
            return false; // actual black jack rule would be a draw
        } else if (isGameWonByBank(player, cards, worthOfDealerCards)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasPlayerMoreThanTwentyOne(Player player, List<Card> cards) {
        int totalWorthOfPlayerCards = player.calculateTotalWorth(cards);
        if (totalWorthOfPlayerCards > 21) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasDealerMoreThanTwentyOne(int worthOfDealerCards) {
        if (worthOfDealerCards > 21) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasDealerSameWorthThanPlayer(int totalWorthOfPlayerCards, int worthOfDealerCards) {
        if (totalWorthOfPlayerCards == worthOfDealerCards) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameWonByBank(Player player, List<Card> cards, int worthOfDealerCards) {
        int totalWorthOfPlayerCards = player.calculateTotalWorth(cards);

        if ((21 - totalWorthOfPlayerCards) > (21 - worthOfDealerCards)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doWantToContinue() {
        boolean answer = voice.askTrueFalseQuestion("Do you want another card? Please answer with True or False.");
        if (answer) {
            return true;
        } else {
            return false;
        }
    }

}
