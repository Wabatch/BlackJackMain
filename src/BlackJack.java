import java.util.ArrayList;
import java.util.List;

public class BlackJack {

    public static void main(String[] args){

        List<Player> players = new ArrayList<>();

        Player croupier = new Croupier();
        Player hero = new Player();

        players.add(croupier);
        players.add(hero);

        Game game = new Game(players);
        game.giveCards();
       // hero.showPlayerCards();
        System.out.println();
       // croupier.showPlayerCards();
        try {
            game.playARound();
        } catch (InterruptedException e){
            e.getMessage();
        }

    }

}
