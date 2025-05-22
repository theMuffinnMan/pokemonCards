import ecs100.*;
/**
 * Displays images in the GUI
 * writes text in the GUI
 * User interaction in the GUI (add card, find card)
 *
 * @Fleur
 * @21/5
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private CardCol cardCol;
    private Card card;
    
    // img values
    private double x = 100;
    private double y = 100;
    
    private final double WIDTH = 500;
    private final double HEIGHT = 700;
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        cardCol = new CardCol();
        this.displayCard();
        
        UI.addButton("Add Card", this::addCard);
        UI.addButton("Find Card", this::findCard);
        UI.addButton("Quit", UI::quit);
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
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        this.cardCol.addCard(name, value, imgFileName);
    }
    
    public void findCard(){
        // allows user to enter the name of a card
        String cardName = UI.askString("Name of card: ");
        // search for card
        if(this.cardCol.findCard(cardName.toLowerCase().trim())){
            UI.println("Card Found!");
            
            this.card = cardCol.getCard();
            this.displayCard();
        }
        // if card is found card becomes 
    }
    
    public void displayCard(){
        //displays the card
        UI.drawImage(card.getImg(), this.x, this.y, this.WIDTH, this.HEIGHT);
    }
}
