package org.example.version.two.impl;

import java.util.List;
import java.util.Scanner;

import org.example.version.two.interfaces.Card;
import org.example.version.two.interfaces.Dealer;
import org.example.version.two.interfaces.Player;

public class PlayerImpl implements Player {

    private Dealer dealer;

    public int calculateTotalWorth(List<Card> cards) {
        int result = 0;

        for (Card card : cards) {
            result += card.getWorth();
        }

        return result;
    }
    public int announceBudget(){
        Scanner playerBudget = new Scanner(System.in);
        int budget = playerBudget.nextInt();
        return budget;
    }
    public int announceBet(){
        Scanner playerBet = new Scanner(System.in);
        int bet = playerBet.nextInt();
        return bet;
    }

    public List<Card> playersCards(List<Card> playerCards) {
        Card card;
        while (true) {
            if (calculateTotalWorth(playerCards) >= 21 || !dealer.doWantToContinue()) {
                break;
            } else {
                card = askForOneMoreCard();
                playerCards.add(card);
                calculateTotalWorth(playerCards);
                System.out.println("Your Cards have the worth of " + calculateTotalWorth(playerCards));
            }
        }

        return playerCards;
    }

    public void joinTable(Dealer dealer) {
        this.dealer = dealer;
    }

    public List<Card> askForInitialCards() {
        return dealer.giveCards(2);
    }

    public Card askForOneMoreCard() {
        return dealer.giveOneMoreCard();
    }
}
