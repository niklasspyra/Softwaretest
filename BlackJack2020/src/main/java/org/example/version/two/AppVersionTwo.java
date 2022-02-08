package org.example.version.two;

import java.util.List;

import org.example.version.two.impl.DealerImpl;
import org.example.version.two.impl.PlayerImpl;
import org.example.version.two.impl.ShuffleMachine;
import org.example.version.two.impl.Voice;
import org.example.version.two.interfaces.Card;
import org.example.version.two.interfaces.Dealer;
import org.example.version.two.interfaces.Player;

public class AppVersionTwo {

    public static void main(String[] args) {
        Dealer dealer = new DealerImpl(new Voice(), new ShuffleMachine());
        Player player = new PlayerImpl();
        player.joinTable(dealer);

        List<Card> playerCards = player.askForInitialCards();
        player.calculateTotalWorth(playerCards);
        System.out.println("Your Cards have the worth of " + player.calculateTotalWorth(playerCards));
        player.playersCards(playerCards);
        int worthOfDealersCards = dealer.dealersCards();
        System.out.println("The worth of Dealers cards are " + worthOfDealersCards);
        boolean isGameWonByPlayer = dealer.isGameWonByPlayer(player, playerCards, worthOfDealersCards);

        printFinalResult(isGameWonByPlayer);
    }

    private static void printFinalResult(boolean isGameWonByPlayer) {
        if (isGameWonByPlayer) {
            System.out.println("Player won!");
        } else {
            System.out.println("Bank won.");
        }
    }
}
