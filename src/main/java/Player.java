import java.util.ArrayList;
import java.util.List;

public class Player {
    protected int cash;
    private String name;
    protected List<Cards> playerCards = new ArrayList<>();
    private boolean enoughCards = false;

    public Player() {
    }

    public Player(int cash){
        this.cash = cash;
    }

    public boolean isEnoughCards() {
        return enoughCards;
    }

    // sprawdza czy mozesz obstawic odpowiednia kwote
    public int bet(int yourBet){
        if(yourBet > cash) {
            System.out.println("You don't have enough cash to bet $" + yourBet);
            System.out.println("You have only $" + cash);
            return 0;
        } else {
            cash -= yourBet;
            return yourBet;
        }
    }

    public void addCash(int prize){
        this.cash += prize;
    }

    public void setEnoughCards(boolean b){
        enoughCards = b;
    }

    public int getCash() {
        return cash;
    }

    public String getName() {
        return name;
    }

    public List<Cards> getPlayerCards() {
        return playerCards;
    }

    public void addCard(Cards card){
        playerCards.add(card);
    }

    public void showPlayerCards(){
        for (Cards card : playerCards) {
            System.out.println(card.getCardName());
        }
        System.out.println(countPlayersCardsValue());
    }


    //liczy wartosc kart
    public int countPlayersCardsValue(){
        int amountOfAces = 0;
        int valueOfCards = 0;

        for (Cards card : playerCards) {
            if(card.getCardIndex() > 0 && card.getCardIndex() < 5)
                amountOfAces++;
        }

        valueOfCards = playerCards.stream()
                .map(cards -> cards.getCardValue())
                .reduce((card1, card2) -> card1 + card2)
                .get();


        if(valueOfCards > 21 && amountOfAces > 0){
            while(valueOfCards > 21){
                if(amountOfAces > 0){
                    valueOfCards -= 10;
                    amountOfAces--;
                } else
                    break;
            }
        }

        return valueOfCards;
    }

}
