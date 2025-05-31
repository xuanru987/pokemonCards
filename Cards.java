import ecs100.*;
import java.util.HashMap;
/**
 * A collection of pokemon cards.
 * Can add a card, search for and hide a card's details, and display the details of all cards at once
 * 
 * @author Sydney Liu
 * @version 5/20/25
 */
public class Cards
  {
    /**
     * Instance variables.
     */
    private HashMap<Integer, Card> cards; //Collection of cards
    private double width; //Width of each book
    private double height; //Height of each book
    private double space; //Vertical and horizontal space between each book
    private double cardsInRow; //Number of card images displayed in a row
    private int latestID; //Index of the most recently added book
    private boolean allDisplayed; //If information of all cards are displayed
    
    /**
     * Initialise instance variables and hashmap, and create 3 cards and put them in the collection.
     * 
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
        allDisplayed = false;
        latestID = 3;
        cards = new HashMap<Integer, Card>();
        Card card1 = new Card("pikachu", "pikachu.jpg", 10.00, width, height, space, cardsInRow, 1);
        Card card2 = new Card("charmander", "charmander.jpg", 9.00, width, height, space, cardsInRow, 2);
        Card card3 = new Card("bulbasaur", "bulbasaur.jpg", 10.00, width, height, space, cardsInRow, 3);
        
        cards.put(1, card1);
        cards.put(2, card2);
        cards.put(3, card3);
    }

    /**
     * Add a card to the card collection, given its details.
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
     * Find a card given its name, and display its name, value, and image.
     * 
     * @param name - name of card
     */
    public void findCard(String name){
        boolean cardExists = false; //Whether there is a card with the name parsed in
        for(Card i : cards.values()){
            if (i.getName().equals(name)){
                i.displayInfo();
                cardExists = true;
            }
        }
        if(cardExists == false){
               UI.println("Card not found.");
        }
    }
    
    /**
     * Display info of all cards, including name, value and image.
     */
    public void displayAll(){
        UI.println("How to match up images and info: image order is from left to right, row by row, info is from top to bottom.");
        for(Card i : cards.values()){
                i.displayInfo();
        }
        allDisplayed = true;
    }
    
    /**
     * Hide all images and details of cards.
     */
    public void hideAll(){
        UI.clearGraphics();
        UI.clearText();
        allDisplayed = false;
    }
    
    /**
     * Hide the information of the card a given point is on, if the point is on a card.
     * 
     * @param - x - x-coordinate of point
     * @param - y - y-coordinate of point
     */
    public void hideCard(double x, double y){
        Card cardTHide = cardOnP(x, y);
        if (cardTHide!= null){
            UI.clearGraphics();
            UI.clearText();
            if(allDisplayed == true){
            //Display all information (including images) except that of the given card
            this.displayBut(cardTHide);
        }
        }
    }
    /**
     * Display the images and info of all cards but the given one.
     * 
     * @param - omit - card omitted
     */
    public void displayBut(Card omit){
        for(Card i : cards.values()){
            if (i != omit){
                i.displayInfo();
            }
        }
    }
    
    /**
     * Iterate through the card collection to check if a point is on any of the cards' images.
     * Returns null if none of the cards are on the point
     * 
     * @param - x-  x-coordinate of the point
     * @param - y-  y-coordinate of the point
     * @return cardOnP - the card the point is on
     */
    public Card cardOnP(double x, double y){
        Card cardOnP = null;
        for(Card i : cards.values()){
            if(i.onImg(x, y)){
                cardOnP = i;
            }
        }
        return cardOnP;
    }
}
