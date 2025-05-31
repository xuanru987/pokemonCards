import ecs100.*;
/**
 * A GUI allowing users to interact with a collection of cards
 * Has buttons for each of the following functions: 
 * Add a card, find a card's details, display the details of all cards, and hiding all details 
 * User clicks a button to perform the corresponding action
 * User can also click on a card's image to hide the card's details
 * 
 * @author Sydney Liu
 * @version 24/5/2025
 */
  public class CardsGUI{
    //Instance variables
    private double width; //Width of each book
    private double height; //Height of each book
    private static final double GUIWidth = 400; //Width of area of GUI used
    private double cardsInRow; //Number of cards in a row
    private double space; //Space between each card
    private Cards cards; //Collection of cards
    /**
     * Initialise instance variables, and add buttons and mouse listener
     */
    public CardsGUI(){
        width = 50; 
        height = 70;
        space = 20;
        cardsInRow = Math.floor(GUIWidth/(width + space));
        cards = new Cards(cardsInRow, width, height, space);
        UI.addButton("Add", this :: addCard);
        UI.addButton("Find", this :: findCard);
        UI.addButton("View all", cards :: displayAll);
        UI.addButton("Hide", cards:: hideAll);
        UI.addButton("Quit", UI :: quit);
        UI.setMouseListener(this :: doMouse);
    }
    
    /**
     * Ask user for the name, value and file name of the image of the card they want to add, and add the card to the collection
     */
    public void addCard(){
        String inptName = this.forceValidStr("Enter card name:", 50);
        double inptValue = this.forceValidDbl("Enter value of card (just the number):", 5500000);
        String inptImg = this.forceJpg("Choose an image:");
        cards.addCard(inptName, inptImg, inptValue); 
    }
    
    /**
     * Ask user for the name of the card they want to find, and display that card's details - name, value, image
     */
    public void findCard(){
        String inptName = this.forceValidStr("Enter card name:", 50);
        cards.findCard(inptName);
    }
    
    /**
     * Respond to mouse actions
     * If the GUI is clicked, call a function that checks whether the point clicked is on an image
     * If the point is on a card's image, hide the cards details - name, value, image
     */
    public void doMouse(String action, double x, double y){
        if (action.equals("clicked")){
            cards.hideCard(x, y);
        }
    }
    /**
     * Force user to enter a valid string
     * Valid string requirement 1: containing characters other than whitespaces
     * Requirement 2: number of characters is less than or equal to maxLen
     * 
     * @param String message - input prompt
     * @param int maxLen = maximum length allowed for the final input
     * @return inputStr - final string input
     */
    public String forceValidStr(String message, int maxLen){
        String inputStr = "";
        do{
            inputStr = UI.askString(message).strip();
            if(inputStr == "" || inputStr.length() > maxLen){
                UI.println("Please enter a non-blank name no more than " + maxLen + " characters.");
            }
        }while(inputStr.equals("") || inputStr.length() > maxLen);
        return inputStr;
    }
    /**
     * Force user to enter a positive double no greater than a certain limit
     * 
     * @param String message - input prompt
     * @param double maxNum - maximum number allowed
     * @return finalDbl - final double input
     */
    public double forceValidDbl(String message, double maxNum){
        double inputDbl = 0;
        do{
            inputDbl = UI.askDouble(message);
            if(inputDbl <= 0 || inputDbl > maxNum){
                UI.println("Please enter a positive number no greater than " + maxNum);
            }
        }while (inputDbl <= 0 || inputDbl > maxNum);
        inputDbl = (inputDbl * 100 - (inputDbl * 100) % 1)/100; //Rounds the input double to 2dp
        return inputDbl;
    }
    
    /**
     * Force user to choose a jpg file from filechooser
     * 
     * @param String message - input prompt
     * @return finalImg - final image chosen
     */
    public String forceJpg(String message){
        String finalImg = "";
        do{
            finalImg = UIFileChooser.open(message + " (must be jpg)");
        }while(finalImg == null || finalImg.contains("jpg") == false);
        return finalImg;
    }
    /**
     * Main method
     * Create GUI
     */
    public static void main(String[] args){
        CardsGUI GUI = new CardsGUI();
    }
}
