package code;

/**
 * This class inherits from item and represents the item type : simple object.
 * It means that the attributes are initialised with specific values and
 * specific methods.
 *
 * @author (Group 5)
 * @version (19/11/17)
 */
public class SimpleObject extends Item {

    /**
     * Constructor for objects of class TypeOne Some item does not appears until
     * some quest are not achieved or appears randomly. When isLock is true the
     * object is Lock until an event
     */
    public SimpleObject(String name, boolean isLock) {
        // the name is given at the creation of the item  
        super.itemName = name;
        // the islock is given at the creation of the item 
        super.isLock = isLock;
    }

    /**
     * Method interactItem give for each object a sentence which depend of the
     * name of the object
     *
     */
    public void interactItem() {
        switch (itemName) {
            case "key":
                Interface.setDialog("You have found a key !");
                break;
            case "board":
                Interface.setDialog("You can see a beautiful board that you your classmates use during the lessons.");
                Interface.setDialog("Unfortunately, there is no pen in sight, you cannot write on it...");
                break;
            case "computer":
                if (isLock == false) {
                    Interface.setDialog("You can access to the computer");
                } else {
                    Interface.setDialog("There is a computer but you cannot interact with it");
                }
                break;
            case "coca":
                Interface.setDialog("You should be careful, there is a lot of sugar in that drink...");
                break;
            case"icetea":
                Interface.setDialog("Well, it is not red bull, but it will help you get through the day anyway");
                break;
            case "kinderbueno":
                Interface.setDialog("That is one of the best chocolate bar of all time!");
                break;
            case "croissant":
                Interface.setDialog("patisserie à la Francaise, as they say in England");
            default:
        }
    }
}
