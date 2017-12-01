
/**
 * This class inherits from item and represents the item type : non player
 * character. It means that the attributes are initialised with specific values
 * and specific methods.
 *
 * @author (Group 5)
 * @version (19/11/17)
 */
public class NPC extends Item {

    private Sentences sentences;

    bool spokenToPgTd = false;

    /**
     * Constructor for objects of subclass NPC Some item does not appears until
     * some quest are not achieved or appears randomly. When isLock is true the
     * object is Lock until an event
     * @param name is the name of the NPC
     * @param isLock is a boolean saying if you can interact with the NPC (false when you can)
     */
    public NPC(String name, boolean isLock) {
        // the name is given at the creation of the item  
        super.itemName = name;
        // the islock is given at the creation of the item 
        super.isLock = isLock;

        sentences = new Sentences();

    }

    /**
     * Method interactItem allow to listen what the non player character have to
     * say
     *
     */
    public void interactItem() {
        if (isLock == true) {
            switch (itemName) {
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
            switch (itemName) 
            {
                case ("Mrs Geniet"):
                    //conversation
                    break;
                case ("Martin"):
                    //conversation
                    break;
                case ("Nolan"):
                    //conversation (une seule, juste pour le nolan des toilettes)
                    break;
                case ("Guardian"):
                    //conversation
                    break;
                case ("PGTD"):
                    //conversation
                    tdPgConversation();
                    spokenToPgTd = true;
                    break;

                case ("Axel"): //a retoucher avec le schéma de la conversation
                    System.out.println(sentences.getListMainAxel(0));
                    System.out.println(sentences.getListMainPlayerToAxel(0));
                    System.out.println(sentences.getListMainAxel(1));
                    System.out.println(sentences.getListMainPlayerToAxel(1));
                    System.out.println(sentences.getListMainAxel(2));
                    System.out.println(sentences.getListMainPlayerToAxel(2));
                    System.out.println(sentences.getListMainAxel(3));
                    System.out.println(sentences.getListMainPlayerToAxel(3));
                    System.out.println(sentences.getListMainAxel(4));
                    System.out.println(sentences.getListMainPlayerToAxel(4));
                    System.out.println(sentences.getListMainAxel(5));
                    System.out.println(sentences.getListMainPlayerToAxel(6));
                    break;
                case ("PGEnd"):
                    //conversation
                    break;
            }
        }
    }

    public void tdPgConversation()
    {
        System.out.println(getListMainPGTD(0));
        System.out.println(listMainPlayerToPGTD(0));
        System.out.println(getListMainPGTD(1));
        System.out.println(listMainPlayerToPGTD(1));
        System.out.println(getListMainPGTD(2));
        System.out.println(listMainPlayerToPGTD(2));
        System.out.println(getListMainPGTD(3));
        System.out.println(listMainPlayerToPGTD(3));
        System.out.println(getListMainPGTD(4));
        System.out.println(listMainPlayerToPGTD(4));
    }
}
