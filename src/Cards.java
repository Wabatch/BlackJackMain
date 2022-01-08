import javax.lang.model.type.DeclaredType;
import java.util.*;

public class Cards {

    private String cardName;            //nazwa karty

    private int cardValue;              //wartosc karty
    private int cardIndex;              //indeks karty
    private boolean isUsed;             //czy karta zostala rozdana
    public List<Cards> listOfCards;     //cała talia

    public Cards(){     //pusty konstruktor do calej talii kart
        listOfCards = setAllDeck();
    }

    //konstruktor do tworzenia obiektow
    public Cards(String cardName, int cardValue, int cardIndex){
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.cardIndex = cardIndex;
        isUsed = false;
    }

    //gettery
    public String getCardName() { return cardName; }
    public int getCardValue() { return cardValue; }
    public int getCardIndex() { return  cardIndex; }
    public boolean getIsUsed() { return isUsed; }
    public List<Cards> getListOfCards() { return listOfCards; }

    // setter do booleana
    public void setIsUsed(boolean used) { isUsed = used; }
    private void setCardValue(int value){
        this.cardValue = value;
    }

    // zwraca nazwe karty przypisanej do podanego indeksu
    public String getCardNameByIndex(int index) {
        if(index < 1 || index > 52) {
            return null;
        }
        for (Cards card : listOfCards) {
            if(index == card.cardIndex)
                return card.getCardName();
        }
        return null;
    }
    // zwraca wartosc karty przypisanej do podanego indeksu
    public int getCardValueByIndex(int index) {
        if(index < 1 || index > 52) {
            return 0;
        }
        for (Cards card : listOfCards) {
            if(index == card.cardIndex)
                return card.getCardValue();
        }
        return 0;
    }


    //zwraca obiekt karty zawierajacej podany index
    public Cards getCardObjectByIndex(int index){
        for (Cards card : listOfCards) {
            if(card.getCardIndex() == index)
                return card;
        }
        return null;
    }

    //hashmapy wykorzystywane do utrzowenia obiektow w petli
    Map<Integer, String> cardColors = new HashMap<>();
    Map<Integer, String> cardNumber = new HashMap<>();

    private void setCardColors(){
        cardColors.put(1, "Spades");
        cardColors.put(2, "Diamonds");
        cardColors.put(3, "Hearts");
        cardColors.put(4, "Clubs");
    }

    private void setCardNumber(){
        cardNumber.put(1, "Ace");
        cardNumber.put(2, "Two");
        cardNumber.put(3, "Three");
        cardNumber.put(4, "Four");
        cardNumber.put(5, "Five");
        cardNumber.put(6, "Six");
        cardNumber.put(7, "Seven");
        cardNumber.put(8, "Eight");
        cardNumber.put(9, "Nine");
        cardNumber.put(10, "Ten");
        cardNumber.put(11, "Jack");
        cardNumber.put(12, "Queen");
        cardNumber.put(13, "King");
    }
    // tworzy obiekty Cards - tworzy cala takie kart
    private List<Cards> setAllDeck(){
        List<Cards> deck = new ArrayList<>();
        setCardColors();
        setCardNumber();
        int index = 0;
        for(int i = 1; i < 14; i++){
            for(int j = 1; j < 5; j++){
                index++;
                if(i == 1)
                    deck.add(new Cards(cardNumber.get(i) + " of " + cardColors.get(j), 11, index));
                else if(i < 11)
                    deck.add(new Cards(cardNumber.get(i) + " of " + cardColors.get(j), i, index));
                else
                    deck.add(new Cards(cardNumber.get(i) + " of " + cardColors.get(j), 10, index));
            }
        }


        return deck;
    }

    // pokazuje całą talie razem z wartosciami i indeksami
    public void showAllDeck(){
        for (Cards card : listOfCards) {
            System.out.println(card.getCardName() + " -- Wartosc karty: " + card.getCardValue() + " -- Indeks karty: " + card.getCardIndex() + " -- Czy jest w czyims posiadaniu? " + card.getIsUsed());
        }

    }

    public Cards randomCard(){
        Random random = new Random();
        int tmp = random.nextInt(52) + 1;
        Cards card = getCardObjectByIndex(tmp);
        return card;
    }


}
