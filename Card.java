
/**
 * Object class for Cards and GUI.

 *   @Fleur
     19/5
 */
public class Card {
  // fields
  private String name;
  private double value;
  private String image;
  private int id;
  static final String DEFUALT_IMAGE = "img/DEFUALT_IMAGE.png"; // a defualt image value
  
  private static final double WIDTH = 500;
  private static final double HEIGHT = 700;
    

  /**
   * Constructor for objects of class Card with image.
   */
  public Card(int key, String nm, double vl, String img) {
    // initialise instance variables
    this.id = key;
    this.name = nm;
    this.value = vl;
    // set image
    if (img == null) {
      // set image to defualt if no image is entered
      this.image = DEFUALT_IMAGE;
    } else {
      // sets image to custom image
      this.image = img;
    }
  }
    
  /**
   * Concstucter for objects of class Card without image.
   */
  public Card(int key, String nm, double vl) {
    this(key, nm, vl, DEFUALT_IMAGE);
  }
    
  /**
   * name getter.
   */
  public String getName() {
    return this.name;
  }
    
  /**
   * value getter.
   */
  public double getValue() {
    return this.value;
  }
    
  /**
   * Image getter.
   */
  public String getImg() {
    return this.image;
  }
}
