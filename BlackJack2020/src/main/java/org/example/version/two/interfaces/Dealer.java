package org.example.version.two.interfaces;

import java.util.List;

import org.example.version.two.impl.Voice;

public interface Dealer {

    List<Card> giveCards(int amountOfCards);

    Card giveOneMoreCard();

    boolean isGameWonByPlayer(Player player, List<Card> cards, int worthOfDealersCards);

    boolean hasPlayerMoreThanTwentyOne(Player player, List<Card> cards);

    boolean hasDealerMoreThanTwentyOne(int worthOfDealerCards);

    boolean hasDealerSameWorthThanPlayer(int totalWorthOfPlayerCards, int worthOfDealerCards);

    boolean isGameWonByBank(Player player, List<Card> cards, int worthOfDealerCards);
    
    boolean doWantToContinue();

    int dealersCards();
}
