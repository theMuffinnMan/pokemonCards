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

    /**
     * Constructor for objects of class Cards
     */
    public CardCol()
    {
        collection = new HashMap<Integer, Card>();
        
        // initail cards in Collection
        Card p1 = new Card(1, "Garchomp", 850, null);
        Card p2 = new Card(2, "Umberon", 11000, null);
        Card p3 = new Card(3, "Typhlosion", 300, null);
        
        this.currCardId = 3; // stores the current book id
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
    }
}
