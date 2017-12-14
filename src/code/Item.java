package code;

/**
 * The class item manage all the the items in a room. 
 * This items can be a non player character, a container or a object. 
 * The item has a name when it is create. 
 *
 * @author (Grp5)
 * @version (14/12/2017)
 */
abstract public class Item
{
    // The name of the item, defined when the object is created
    protected String itemName;
    // Some item does not appears until some quest are not achieved or appears randomly 
    protected boolean isLock;
    protected boolean hasDisappeared;
    protected boolean interacting;
    
    protected Dialogue dialogue;
    

    /**
     * Constructor for objects of class Item
     * The type of the item. 1 = non player character, 2 = container, 3 = object.
     */
    public Item( )
    {
                
    }

    /**
     * A method for knowing the name of the item 
     * @return  itemName  return the name of the item 
     */
    public String getName()
    {
        return (itemName); 
    }

    /**
     * Method which allow knowing the state of the item. 
     *
     * @return isLock a boolean
     * True = the item is lock and the player cannot interact, 
     * False = the item is unlock and the player can interact. 
     */
    public boolean getLock()
    {
        return (isLock); 
    }
    
        /**
     * getDisappeared Method which allow knowing the state of the item. 
     *
     * @return hasDisappeared a boolean
     * True = the item is lock and the player cannot interact, 
     * False = the item is unlock and the player can interact. 
     */
    public boolean getDisappeared()
    {
        return (hasDisappeared); 
    }

      /**
     * Method which allow changing the state of the item. 
     *
     * @param newState a boolean that is the state you want your attribute to be
     */
    public void setHasDisappeared( boolean newState)
    {
        hasDisappeared = newState;
    }
    

    /**
     * Method which allow changing the boolean state isLock of the item. 
     * @param b a boolean, allows to set isLock.
     */
    public void setLock(boolean b)
    {
      isLock = b;
    }
    
     /**
     * getInteracting method. Get the interacting value, a boolean 
     * @return interacting boolean
     */
    public boolean getInteracting()
    {
        return interacting;
    }
    
    /**
     * setInteracting method. Allows to set the interacting value with a new value b 
     * @param b a boolean.
     */
    public void setInteracting(boolean b)
    {
        interacting = b;
    }
    /**
     * method interact item which is rewritten in each subclass
     */
    abstract public void interactItem();
    {
        
    }
}
