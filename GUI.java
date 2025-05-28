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
    private double x = 30;
    private double y = 30;
    
    // img size
    private final double WIDTH = 250;
    private final double HEIGHT = 350;
    
    // text pos
    private final int NM_POS = 400;
    private final int VL_POS = 430;
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        cardCol = new CardCol();
        UI.setFontSize(17);
        
        //GUI buttons
        UI.addButton("Add Card", this::addCard);
        UI.addButton("Find Card", this::findCard);
        UI.addButton("View All", this::viewAll);
        UI.addButton("Hide", this::hideAll);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * adds new card to the collection
     */
    public void addCard(){
        //clears text
        this.hideAll();
        //Adds card to the collection
        //user enters card name
        String name = UI.askString("Name of Pokemon Card: ");
        //user enters card value
        double value = UI.askDouble("Value of Pokemon Card: ");
        //user enters card image
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        //adds card to collection
        this.cardCol.addCard(name, value, imgFileName);
        
        UI.println("Card Added!");
        
        //display the card
        this.displayCard();
    }
    
    /**
     * searches for card based on card name
     */
    public void findCard(){
        //clears text
        this.hideAll();
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
        //prints all card information in the text box
        //clears text
        this.hideAll();
        // doing this through cardcol because i cant figure out how to do it through the gui im sorry
        cardCol.viewAll();
    }
    
    /**
     * hides all card information in GUI and text box
     */
    public void hideAll(){
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
        UI.drawString("Name: " + cardCol.getCard().getName(),this.x, this.NM_POS);
        UI.drawString("Value: " + cardCol.getCard().getValue(), this.x, this.VL_POS);
    }
}
