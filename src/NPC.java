
/**
 * This class inherits from item and represents the item type : non player
 * character. It means that the attributes are initialised with specific values
 * and specific methods.
 *
 * @author (Group 5)
 * @version (19/11/17)
 */
public class NPC extends Item
{

    private Sentences sentences;

    /**
     * Constructor for objects of subclass NPC Some item does not appears until
     * some quest are not achieved or appears randomly. When isLock is true the
     * object is Lock until an event
     *
     * @param name is the name of the NPC
     * @param isLock is a boolean saying if you can interact with the NPC (false
     * when you can)
     */
    public NPC(String name, boolean isLock, boolean hasDisappeared)
    {
        // the name is given at the creation of the item  
        super.itemName = name;
        // the islock is given at the creation of the item 
        super.isLock = isLock;
        super.hasDisappeared = hasDisappeared;
        
        super.dialogue = new Dialogue();

        sentences = new Sentences();
    }
    

    /**
     * Method interactItem allow to listen to what the non player character have
     * to say
     *
     */
    public void interactItem()
    {
        if (isLock == true)
        {
            switch (itemName)
            {
                case ("Axel"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListAxel()));
                    break;
                case ("Martin"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListMartin()));
                    break;
                case ("Nolan"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListNolan()));
                    break;
                case ("Valentin"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListValentin()));
                    break;
                case ("Guardian"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListGuardian()));
                    break;
                case ("Thomas"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListThomas()));
                    break;
                case ("Morgane"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListMorgane()));
                    break;
                case ("Marie"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListMarie()));
                    break;
                case ("Mrs Geniet"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListMrsGeniet()));
                case ("M2"):
                    System.out.println("\n"+sentences.randomSentence(sentences.getListM2()));
                default:
                    System.out.println("There is no one to talk to in this room");
            }
        } else if (!isLock) //for the NPCs that have conversations linked to quests
            
        { 

            switch (itemName)
            {
                case ("PGTD"):
                    dialogue.dialoguePGTD();
                    break;
                case ("Axel"):
                    dialogue.dialogueAxel();
                    break;
                case ("MrsGeniet"):
                    dialogue.dialogueGeniet();
                    break;
                case ("Guardian"):
                    dialogue.dialogueGuardian();
                    break;
                case ("Martin"):
                    dialogue.dialogueMartin();
                    break;
                case ("Nolan"):
                    dialogue.dialogueNolan();
                    break;
                case ("PGEnd"):
                    dialogue.dialoguePGEnd();
                    break;
            }

        }
    }
}
