import ecs100.*;
/**
 * Displays images in the GUI
 * writes text in the GUI
 * User interaction in the GUI
 *
 * @Fleur
 * @21/5
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private CardCol cardCol;
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        CardCol cardCol = new CardCol();
        
        UI.addButton("Add Card", this::addCard);
    }
    
    /**
     * adds new card to the collection
     */
    public void addCard(){
        //Adds card to the collection
        //user enters card name
        String name = UI.askString("Name of Pokemon Card: ");
        //user enters card value
        double value = UI.askDouble("Value of Pokemon Card: ");
        //user enters card image
        String image = null;
        
        this.cardCol.addCard(name, value, image);
    }
    
    public void findCard(){
        // allows user to enter the name of a card
        // if card is found card becomes 
    }
}
