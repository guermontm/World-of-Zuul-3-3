package code;

/**
 * This class inherits from item and represents the item type : simple object. 
 * It means that the attributes are initialised with specific values and specific methods. 
 *
 * @author (Group 5)
 * @version (19/11/17)
 */
public class SimpleObject extends Item {

    /**
     * Constructor for simple objects
     * Some item does not appears until some quest are not achieved or appears randomly. 
     * When isLock is true the object is Lock until an event 
     */
    public SimpleObject(String name, boolean isLock) {
        // the name is given at the creation of the item  
        super.itemName = name;
        // the islock is given at the creation of the item 
        super.isLock = isLock;
    }

    /**
     * Method interactItem give for each object a sentence which depend of the name of the object.
     * The sentences is displayed on the interface.
     * In the case of the computer, the sentences will be different depending on the isLock attribute.
     */
    public void interactItem() {
        switch (itemName) {
            case "board":
                Interface.setDialog("You can see a beautiful board that you your classmates use during the lessons.");
                Interface.setDialog("Unfortunately, there is no pen in sight, you cannot write on it...");
                break;
            case "computer":
                if (isLock == false) {
                    Interface.setDialog("You can access to the computer");
                    Interface.setDialog("You are coding for your project it is gonna take a little moment...");
                    Interface.setDialog("");
                    Interface.setDialog("Here you go! Martin Nolan and you are really proud of what you have done, maybe you should go talk to Martin again!");
                    hasDisappeared = true;
                } else {
                    Interface.setDialog("There is a computer but you cannot interact with it");
                }
                break;
            case "key":
                Interface.setDialog("There is a key under the tissue! That is good thing that you looked, it might open a door you need to be opened...");
                hasDisappeared = true; //to use to unlock the office
                break;
            case "coca":
                Interface.setDialog("You should be careful, there is a lot of sugar in that drink...");
                break;
            case "icetea":
                Interface.setDialog("Well, it is not red bull, but it will help you get through the day anyway");
                break;
            case "kinderbueno":
                Interface.setDialog("That is one of the best chocolate bar of all time!");
                break;
            case "croissant":
                Interface.setDialog("patisserie à la Francaise, as they say in England");
            case "tissue":
                Interface.setDialog("There is an old tissue here, it is really dirty, you don't want to touch that!");
                break;
            default:
        }
    }
}
