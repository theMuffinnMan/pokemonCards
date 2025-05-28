import java.util.HashMap;
import ecs100.*;
/**
 * Managment class for hashmap of card collection
 * 
 * allows user to add cards to hashmap
 * allows user to find cards in hashmap
 * @Fleur
 * @20/5
 */
public class CardCol
{
    // fields
    private HashMap<Integer, Card> collection; // declaring the collection hashmap
    private int currCardId;
    private Card currCard;

    /**
     * Constructor for objects of class Cards
     */
    public CardCol()
    {
        collection = new HashMap<Integer, Card>();
        
        // initail cards in Collection
        Card p1 = new Card(1, "Garchomp", 850, "img/garchomp.png");
        Card p2 = new Card(2, "Umbreon ex", 11000, "img/umbreon ex.png");
        Card p3 = new Card(3, "Typhlosion", 300, "img/typhlosion.png");
        
        //add cards to the collection
        this.collection.put(1, p1);
        this.collection.put(2, p2);
        this.collection.put(3, p3);
        
        this.currCardId = 3; // stores the current book id
        this.currCard = collection.get(currCardId); // sets intial current card
    }
    
    /**
     * sets an id for the current card
     */
    public void setCardId(){
        this.currCardId += 1;
    }
    
    /**
     * allows the user to add a card to the collection
     * @card name
     * @card value
     */
    public void addCard(String name, double value){
        //sets card id
        this.setCardId();
        collection.put(this.currCardId, new Card(this.currCardId, name, value));
        //sets added card to the current card
        this.currCard = collection.get(currCardId);
    }
    
    /**
     * allows the user to add a card to the collection
     * @card name
     * @card value
     * @card image
     */
    public void addCard(String name, double value, String image){
        //sets card id
        this.setCardId();
        collection.put(this.currCardId, new Card(this.currCardId, name, value, image));
        //sets added card to the current card
        this.currCard = collection.get(currCardId);
    }
    
    /**
     * find a card based off the cards name
     * set the current instance card if found
     * @return true or false
     */
    public boolean findCard(String name){
        //search for the card
        for(int cardId: collection.keySet()){
            if(collection.get(cardId).getName().toLowerCase().equals(name.toLowerCase())){
                currCard = collection.get(cardId);
                return true;
            }
        }
        return false;
    }
    
    /**
     * View all cards
     * loops through all cards and prints the names and info in the text box
     * i couldnt figure out how to do this in the gui but i would if i could
     */
    public void viewAll(){
        for(int cardId: collection.keySet()){
            //prints out card info
            UI.println("Name: " + collection.get(cardId).getName());
            UI.println("Value: " + collection.get(cardId).getValue());
            UI.println();
        }
    }
    
    /**
     * Card getter
     */
    public Card getCard(){
        return this.currCard;
    }
}
