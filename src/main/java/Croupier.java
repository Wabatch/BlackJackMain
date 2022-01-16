public class Croupier extends Player{

    public Croupier() {
        super();
    }


    public void showFirstCard(){
        System.out.println(playerCards.get(0).getCardName());
        System.out.println(playerCards.get(0).getCardValue());
    }


}
