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
    // feilds
    private CardCol cardCol;
    private Card card;
    
    // img start pos
    private double x = 100;
    private double y = 100;
    
    // img size
    private final double WIDTH = 200;
    private final double HEIGHT = 280;
    
    //text pos
    
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        cardCol = new CardCol();
        
        //GUI buttons
        UI.addButton("Add Card", this::addCard);
        UI.addButton("Find Card", this::findCard);
        UI.addButton("View All", this::viewAll);
        UI.addButton("Hide", this::hideInfo);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * adds new card to the collection
     */
    public void addCard(){
        //clears text
        UI.clearText();
        //Adds card to the collection
        //user enters card name
        String name = UI.askString("Name of Pokemon Card: ");
        //user enters card value
        double value = UI.askDouble("Value of Pokemon Card: ");
        //user enters card image
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        this.cardCol.addCard(name, value, imgFileName);
        
        UI.println("Card Added!");
    }
    
    /**
     * searches for card based on card name
     */
    public void findCard(){
        //clears text
        UI.clearText();
        // allows user to enter the name of a card
        String cardName = UI.askString("Name of card: ");
        // search for card
            if(this.cardCol.findCard(cardName.toLowerCase().trim())){
            // tell the user the card is found
            UI.println("Card Found!");
            
            //display the card in the gui
            this.card = cardCol.getCard();
            this.displayCard();
        }else{
            UI.println("That Card doesn't exist!");
        }
    }
    /**
     * Shows all cards name and value
     */
    public void viewAll(){
        //
    }
    
    /**
     * hides all card information in GUI and text box
     */
    public void hideInfo(){
        //clears text pane
        UI.clearText();
        //clears the graphics pane
        UI.clearGraphics();
    }
    
    /**
     * Displays the card image in the gui
     * prints card info in the gui with the image
     */
    public void displayCard(){
        //displays the card
        UI.drawImage(cardCol.getCard().getImg(), this.x, this.y, this.WIDTH, this.HEIGHT);
        
        //displays the information
        UI.drawString("Name: " + cardCol.getCard().getName(),this.x, 400);
        UI.drawString("Value: " + cardCol.getCard().getValue(), this.x, 420);
    }
}
