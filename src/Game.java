import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players = new ArrayList<>();
    Cards card = new Cards();




    public Game(List<Player> players) {
        this.players = players;
    }

    public void giveCards(){
        for (Player tmpPlayer : players) {
            while(tmpPlayer.getPlayerCards().size() != 2){
                Cards tmpCards = card.randomCard();
                if(tmpCards.getIsUsed() == false){
                    tmpPlayer.addCard(tmpCards);
                    tmpCards.setIsUsed(true);
                }

            }

        }
        //card.showAllDeck();

    }
    public void playARound() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        if(players.get(0) instanceof Croupier)
            ((Croupier) players.get(0)).showFirstCard();

        while(!players.get(1).isEnoughCards()){
            players.get(1).showPlayerCards();

            if(players.get(1).countPlayersCardsValue() > 21) break;

            System.out.println("Do you want to take another card? (y/n)");
            String choice = scanner.nextLine();

            if(choice.equals("y")) players.get(1).addCard(card.randomCard());

            else if (choice.equals("n")) players.get(1).setEnoughCards(true);

            else System.out.println(" You have to choose \"y\" or \"n\" ");

            System.out.println();
        }

        if(players.get(1).countPlayersCardsValue() > 21)
            System.out.println("you lost");
        else {
            for (Player player : players) {
                if (player instanceof Croupier)
                    System.out.println("Croupier");
                else
                    System.out.println("You");

                System.out.println("------");
                player.showPlayerCards();
                System.out.println();
               //Thread.sleep(1000);
            }
        }

    }

}
