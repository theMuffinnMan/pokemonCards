import ecs100.UI;
import ecs100.UIFileChooser;
/**
 * Displays images in the GUI.
 * writes text in the GUI
 * User interaction in the GUI (add card, find card)

 *  @Fleur
    21/5
 */

public class Gui {
  // feilds
  private CardCol cardCol;
  private Card card;
  
  // img start pos
  private double imgX = 30;
  private double imgY = 30;
  
  // img size
  private static final double WIDTH = 250;
  private static final double HEIGHT = 350;
  
  // text pos
  private static final int NM_POS = 400;
  private static final int VL_POS = 430;
  
  //max value user can enter
  //value taken from most expensive pokemon card sold (5.75mil) rounded up
  private static final double MAX_VALUE = 6000000;
  
  private int value;
    
  /**
   * Constructor for objects of class GUI.
  */
  public Gui() {
    // initialise instance variables
    cardCol = new CardCol();
      
    //GUI buttons
    UI.addButton("Add Card", this::addCard);
    UI.addButton("Find Card", this::findCard);
    UI.addButton("View All", this::viewAll);
    UI.addButton("Hide", this::hideAll);
    UI.addButton("Quit", UI::quit);
    //other UI
    UI.setFontSize(17);
    UI.setMouseListener(this::doMouse);

      
  }
  
  /**
   * adds new card to the collection.
   */
  public void addCard() {
    //clears text
    this.hideAll();
    //Adds card to the collection
    //user enters card name
    String name = UI.askString("Name of Pokemon Card: ");
    //user enters card value
    //check boundaries for card value
    do {
      value = UI.askInt("Value of Pokemon Card: ");
      if ((value > 0) && (value <= MAX_VALUE)) {
        // do nothing
      } else if (value > MAX_VALUE) {
        UI.println("Must be less than 6000000");
      } else if (value < 1) {
        UI.println("Must be greater than 0");
      } else {
        UI.println("Must be a number!");
      }
    } while (0 >= value || value > MAX_VALUE);
    //user enters card image
    String imgFileName = UIFileChooser.open("Choose Image File: ");
    
    //adds card to collection
    this.cardCol.addCard(name, value, imgFileName);
    
    UI.println("Card Added!");
    
    //display the card
    this.displayCard();
  }

  /**
   * searches for card based on card name.
   */
  public void findCard() {
    //clears text
    this.hideAll();
    // allows user to enter the name of a card
    String cardName = UI.askString("Name of card: ");
    // search for card
    if (this.cardCol.findCard(cardName.toLowerCase().trim())) {
      // tell the user the card is found
      UI.println("Card Found!");
      
      //display the card in the gui
      this.card = cardCol.getCard();
      this.displayCard();
    } else {
      UI.println("That Card doesn't exist!");
    }
  }
  /**
   * Shows all cards name and value.
   */
  
  public void viewAll() {
    //prints all card information in the text box
    //clears text
    this.hideAll();
    // doing this through cardcol because i cant figure out how to do it through the gui im sorry
    cardCol.viewAll();
  }
  
  /**
   * hides all card information in GUI and text box.
   */
  public void hideAll() {
    //clears text pane
    UI.clearText();
    //clears the graphics pane
    UI.clearGraphics();
  }
  
  /**
   * Displays the card image in the gui.
   * prints card info in the gui with the image
   */
  public void displayCard() {
    //displays the card
    UI.drawImage(cardCol.getCard().getImg(), this.imgX, this.imgY, this.WIDTH, this.HEIGHT);
    
    //displays the information
    UI.drawString("Name: " + cardCol.getCard().getName(), this.imgX, this.NM_POS);
    UI.drawString("Value: $" + cardCol.getCard().getValue(), this.imgX, this.VL_POS);
  }
  
  /**
   * doMouse.
   * mouse interaction with pokemon cards
   */
  public void doMouse(String action, double mouseX, double mouseY) {
    //checks if mouse clicked on card
    if (action.equals("clicked") && mouseX > this.imgX && mouseX < this.imgX + this.WIDTH
        && mouseY > this.imgY && mouseY < this.imgY + this.HEIGHT) {
      //hides current card info
      UI.clearGraphics();
    }
  }
}
