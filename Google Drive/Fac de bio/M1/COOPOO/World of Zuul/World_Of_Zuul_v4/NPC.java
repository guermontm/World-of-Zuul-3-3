import java.awt.*;
import java.util.*;
/**
 * This class inherits from item and represents the item type : non player character. 
 * It means that the attributes are initialised with specific values and specific methods. 
 *
 * @author (Group 5)
 * @version (19/11/17)
 */
public class NPC extends Item 
{
    private Sentences sentences;
    /**
     * Constructor for objects of subclass NPC
     * Some item does not appears until some quest are not achieved or appears randomly. 
     * When isLock is true the object is Lock until an event 
     */
    public NPC(String name,boolean isLock)
    {
        // the name is given at the creation of the item  
        itemName=name;
        // the islock is given at the creation of the item 
        isLock=isLock;

        sentences = new Sentences();
    }

    /**
     * Method interactItem allow to listen what the non player character have to say 
     *
     */
    public void interactItem()
    {
        if (isLock == true)
        {
            switch (itemName)
            {
                case ("Axel"):
                System.out.println(sentences.randomSentence(sentences.getListAxel()));
                break;
                case ("Martin"):
                System.out.println(sentences.randomSentence(sentences.getListMartin()));
                break;
                case ("Nolan"):
                System.out.println(sentences.randomSentence(sentences.getListNolan()));
                break;
                case ("Valentin"):
                System.out.println(sentences.randomSentence(sentences.getListValentin()));
                break;
                case ("Guardian"):
                System.out.println(sentences.randomSentence(sentences.getListGuardian()));
                break;
                case ("Thomas"):
                System.out.println(sentences.randomSentence(sentences.getListThomas()));
                break;
                case ("Morgane"):
                System.out.println(sentences.randomSentence(sentences.getListMorgane()));
                break;
                case ("Marie"):
                System.out.println(sentences.randomSentence(sentences.getListMarie()));
                break;
                default:    
                System.out.println("You can talk to no one");
            }
        }
        else
        {
            System.out.println("Hello");
        }
    }
}
