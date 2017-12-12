package code;

import java.util.*;
/**
 * This class inherits from item and represents the item type : container. 
 * It means that the attributes are initialised with specific values and specific methods. 
 *
 * @author (Group 5)
 * @version (19/11/17)
 */
public class Container extends Item 
{
    static protected ArrayList<SimpleObject> listContent; 
    /**
     * Constructor for objects of class TypeOne
     * Some item does not appears until some quest are not achieved or appears randomly. 
     * When isLock is true the object is Lock until an event 
     * @param name
     * @param isLock
     */
    public Container(String name,boolean isLock)
    {
        // the name is given at the creation of the item  
        super.itemName=name;
        // the islock is given at the creation of the item 
        super.isLock=isLock;

        listContent = new ArrayList();
    }

    /**
     * 
     * @param nameObj 
     */
    public void addObject(SimpleObject nameObj)
    {
        listContent.add(nameObj);   
    }

    /**
     * 
     * @param removeObj 
     */
    public void removeObject(String removeObj)
    {
        for(int i = 0; i < listContent.size(); i++)
        {
            if (removeObj.equals(listContent.get(i).getName()))
            {
                listContent.remove(i);
            }
        }
    }
    
    /**
     * If the item is a container it is possible to search inside. 
     * The interactItem method will return what it contains.  
     */
    public void interactItem()
    {
        if (! listContent.isEmpty())
        {
            System.out.println("\n"+"The "+itemName+" contain these objects : " );
            for(int i = 0; i < listContent.size(); i++)
            {
                if (listContent.get(i).isLock == false)
                {
                    listContent.get(i).interactItem();
                }
            }
        }
        else 
        {
            System.out.println("\n"+"The "+itemName+" does not contain anything" );
        }
    }
    
    /**
     * Method getListContentObject
     *
     * @return an array list which contain all the objects in the container 
     */
    public ArrayList getListContentObject()
    {
        return listContent; 
    }
}
