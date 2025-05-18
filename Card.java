
/**
 * Object class for Cards and GUI
 *
 * @Fleur
 * 19/5
 */
public class Card
{
    // fields
    private String name;
    private int value;
    private String image;
    static final String DEFUALT_IMAGE = "image name here"; // a defualt image value
    

    /**
     * Constructor for objects of class Card
     */
    public Card(String nm, int vl, String img)
    {
        // initialise instance variables
        this.name = nm;
        this.value = vl;
        // set image to defualt if no image is entered
        if(img == null){
            this.image = DEFUALT_IMAGE;
        }
        else{
            this.image = img;
        }
    }
}
