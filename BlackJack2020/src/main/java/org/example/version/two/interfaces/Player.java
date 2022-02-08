package org.example.version.two.interfaces;

import java.util.List;

public interface Player {

    int calculateTotalWorth(List<Card> cards);

    void joinTable(Dealer dealer);

    List<Card> askForInitialCards();

    List<Card> playersCards(List<Card> playerCards);

    Card askForOneMoreCard();
}
