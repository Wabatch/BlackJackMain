import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args){

        List<Player> players = new ArrayList<>();

        Player croupier = new Croupier();
        Player hero = new Player(10000);

        players.add(croupier);
        players.add(hero);

        while (players.get(1).getCash() > 0) {

            Scanner scanner = new Scanner(System.in);
            int bet;

            System.out.println("Your cash: $" + players.get(1).getCash());
            System.out.println("How much do you want to bet? ");

            bet = scanner.nextInt();

            if(players.get(1).bet(bet) !=0) {

                Game game = new Game(players);
                game.giveCards();

                System.out.println();

                try {
                    players.get(1).addCash(game.playARound(bet));
                } catch (InterruptedException e) {
                    e.getMessage();
                }


            }
            for (Player player : players) {
                player.playerCards.clear();
            }

        }
    }

}
