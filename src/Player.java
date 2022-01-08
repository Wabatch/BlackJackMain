import java.util.ArrayList;
import java.util.List;

public class Player {
    protected int cash;
    private String name;
    protected List<Cards> playerCards = new ArrayList<>();
    private boolean enoughCards = false;

    public Player() {
    }

    public boolean isEnoughCards() {
        return enoughCards;
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
