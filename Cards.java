import java.util.HashMap;
import ecs100.*;
/**
 * A collection of pokemon cards
 * Can add a card, search for and hide a card's details, and display the details of all cards at once
 * @author Sydney Liu
 * @version 5/20/25
 */
public class Cards
{
    private HashMap<Integer, Card> cards; //Collection of cards
    private double width; //Width of each book
    private double height; //Height of each book
    private double space; //Vertical and horizontal space between each book
    private double cardsInRow; //Number of card images displayed in a row
    /**
     * Constructor for objects of class cards
     */
    public Cards(double cardsInRow, double width, double height, double space)
    {
        this.width = width;
        this.height = height;
        this.space = space;
        this.cardsInRow = cardsInRow;
        
        //Card card1 = ();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }
}
