import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players = new ArrayList<>();
    Cards card = new Cards();

    private int yourBet;

    public Game(List<Player> players) {
        this.players = players;
    }

    //rozdaje karty graczom
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
        // card.showAllDeck();

    }
    public int playARound(int yourBet) throws InterruptedException {

        this.yourBet = yourBet;

        //pokazuje pierwsza karte krupiera
        ((Croupier) players.get(0)).showFirstCard();

        //pozwala dobierac karty az ich wartosc przekroczy 21 lub sam sprawdzisz
        while(!players.get(1).isEnoughCards()){
            players.get(1).showPlayerCards();

            if(players.get(1).countPlayersCardsValue() > 21) break;

            takeCards();

            System.out.println();
        }

        //wyswietla karty po dobraniu
        cardsDispaly();
        players.get(1).setEnoughCards(false);

        if(players.get(1).countPlayersCardsValue() < 22)
            return whoWins();
        else
            System.out.println("You lost");

        return 0;

    }

    public void takeCards(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to take another card? (y/n)");
        String choice = scanner.nextLine();

        if(choice.equals("y"))
            players.get(1).addCard(card.randomCard());

        else if (choice.equals("n"))
            players.get(1).setEnoughCards(true);

        else
            System.out.println(" You have to choose \"y\" or \"n\" ");
    }
    //wyswietla karty po dobraniu
    public void cardsDispaly() throws InterruptedException{

        for (Player player : players) {
            if (player instanceof Croupier)
                System.out.println("Croupier");
            else
                System.out.println("You");

            System.out.println("------");
            player.showPlayerCards();
            System.out.println();
            Thread.sleep(1000);
        }

    }

    //sprawdza kto wygral
    public int  whoWins(){
        if(players.get(0).countPlayersCardsValue() > players.get(1).countPlayersCardsValue()){
            System.out.println("You lost");
            yourBet = 0;
        } else if(players.get(0).countPlayersCardsValue() < players.get(1).countPlayersCardsValue()) {
            System.out.println("You won!");
            yourBet *= 2;
        } else
            System.out.println("It's a draw");

        return yourBet;
    }

}
