package code;


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
    private boolean interacting;

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
        super.interacting = false;
    }
    

    /**
     * Method interactItem allow to listen to what the non player character have
     * to say
     *
     */
    public void interactItem()
    {
        if (isLock)
        {
            switch (itemName)
            {
                case ("Axel"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListAxel()));
                    break;
                case ("Martin"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListMartin()));
                    break;
                case ("Nolan"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListNolan()));
                    break;
                case ("Valentin"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListValentin()));
                    break;
                case ("Guardian"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListGuardian()));
                    break;
                case ("Thomas"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListThomas()));
                    break;
                case ("Morgane"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListMorgane()));
                    break;
                case ("Marie"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListMarie()));
                    break;
                case ("Mrs Geniet"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListMrsGeniet()));
                case ("M2"):
                    Interface.setDialog("\n"+sentences.randomSentence(sentences.getListM2()));
                default:
                    Interface.setDialog("There is no one to talk to in this room");
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
        interacting = false;
    }
}
