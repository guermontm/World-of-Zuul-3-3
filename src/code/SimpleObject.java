package code;


/**
 * This class inherits from item and represents the item type : simple object. 
 * It means that the attributes are initialised with specific values and specific methods. 
 *
 * @author (Group 5)
 * @version (19/11/17)
 */
public class SimpleObject extends Item 
{

    /**
     * Constructor for objects of class TypeOne
     * Some item does not appears until some quest are not achieved or appears randomly. 
     * When isLock is true the object is Lock until an event 
     */
    public SimpleObject(String name,boolean isLock)
    {
        // the name is given at the creation of the item  
        super.itemName=name;
        // the islock is given at the creation of the item 
        super.isLock=isLock;
    }

    /**
     * Method interactItem give for each object a sentence which depend of the name of the object 
     *
     */
    public void interactItem()
    {
        switch(itemName)
        {
            case "key":
            Interface.setDialog("You have found a key !");
            break;
            case "board":
            Interface.setDialog("You can build board");
            break;
            case "computer":
            if (isLock ==false)
            {
                Interface.setDialog("You can access to the computer");
            }
            else
            {
                Interface.setDialog("There is a computer but you cannot interact with it");
            }
            break;
            default :
            Interface.setDialog("You have found : "+itemName);
        }
    }
}
