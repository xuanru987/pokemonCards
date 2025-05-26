
/**
 * A pokemon card that has a name, monetary value and image(on GUI)
 * Has methods to retrieve its name, value and image
 * Can check whether a point is on its image
 * Sydney Liu
 * 19/5/25
 */
import ecs100.*;
public class Card
{
    // instance variables - replace the example below with your own
    private String name; //Card name
    private String img;//File name of image
    private double value; //Monetary value of card
    
    private double top; //Y-coordinate of top edge
    private double left; //X-coordinate of left edge
    private double width; //Width of card image
    private double height; //Height of image
    
    private static final String DEFAULT_IMAGE = "card.jpg";
    /**
     * Initialise instance variables: top, left, name, img, value, width, height
     */
    public Card(String name, String img, double value, double width, double height, double space, double cardsInRow, int id)
    {
        // initialise instance variables
        this.name = name;
        if("".equals(img)){
            this.img = DEFAULT_IMAGE; //Use default image if user entered nothing
        }
        else{
            this.img = img; //If user entered a file name, set image of card to that
        }
        this.value = value;
        this.width = width;
        this.height = height;
        //Calculate left edge of card given its width, the space between each card, its index, and the number of cards in a row
        if (id%cardsInRow != 0){
            this.left = (width + space) * (id % cardsInRow - 1);
        }
        else{
            this.left = (width + space) * (cardsInRow - 1);
        }
        //Calculate top edge of card given the space between cards and number of cards in a row, and the height and index of this card
        this.top = (height + space) * (Math.ceil(id/cardsInRow) - 1);
    }

    /**
     * Return name of card
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Return monetaery value of card
     */
    public double getVal(){
        return this.value;
    }
    /**
     * Display name, value and image of card
     */ 
    public void displayInfo(){
        UI.drawImage(img, left, top, width, height);
        UI.println();
        UI.println("Name: " + name + " Value: " + value);
    }
    /**
     * Check if a set of coordinates is on the image of this card
     * @param - x- x-coordinate
     * @param - y- y-coordinate
     * @return - onCard - whether the point is on the card
     */
    public boolean onImg(double x, double y){
        boolean onCard = false;
        if (x >= left && x <= left + width && y >= top && y <= top + height){
            onCard = true;
        }
        return onCard;
    }
}
