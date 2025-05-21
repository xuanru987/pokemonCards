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
    /**
     * Instance variables
     */
    private HashMap<Integer, Card> cards; //Collection of cards
    private double width; //Width of each book
    private double height; //Height of each book
    private double space; //Vertical and horizontal space between each book
    private double cardsInRow; //Number of card images displayed in a row
    private int latestID; //Index of the most recently added book
    
    /**
     * Initialise instance variables, and create 3 cards and put them in the collection
     * @param cardsInRow - number of cards in a row in GUI
     * @param width - width of each card image in GUI
     * @param height - height of each card image in GUI
     * @param space - space between each card image in GUI
     */
    public Cards(double cardsInRow, double width, double height, double space)
    {
        this.width = width;
        this.height = height;
        this.space = space;
        this.cardsInRow = cardsInRow;
        latestID = 3;
        
        Card card1 = new Card("pikachu", "pikachu.webp", 10.00, width, height, space, cardsInRow, 1);
        Card card2 = new Card("charmander", "charmander.webp", 9.00, width, height, space, cardsInRow, 2);
        Card card3 = new Card("bulbasaur", "bulbasaur.jpg", 10.00, width, height, space, cardsInRow, 3);
        
        cards.put(1, card1);
        cards.put(2, card2);
        cards.put(3, card3);
    }

    /**
     * Add a card to the card collection
     * 
     * @param  name - name of card
     * @param img - file name of card image
     * @param value - monetary value of card
     */
    public void addCard(String name, String img, double value)
    {
        latestID += 1;
        Card newCard = new Card(name, img, value, width, height, space, cardsInRow, latestID);
        cards.put(latestID, newCard);
    }
    
    /**
     * Find a card given its name
     * 
     * @param name - name of card
     * @return card - the card found
     */
    //Possibility of returning null is not good when working with others
    public Card findCard(String name){
        Card cardFound = null;
        for(Card i : cards.values()){
            if (i.getName().equals(name)){
                cardFound = i;
            }
        }
        return cardFound;
    }
}
