import java.util.*;

/**
 * The class Sentences, having different list of sentences.
 * These sentences can be used by interacting with a non-player character (NPC).
 * They are used when the player talks with them, and this NPC has not important
 * sentence to say.
 * The sentences are short, and there is not possible to answer.
 * There are around 3-4 sentences that can be spoken by each NPC.
 * These sentences can be of different kinds: recall the quest to be done; to be a joke, ...
 * 
 * The 'sentences' class is composed by a constructor and two methods : randomsentence and randomNumber. 
 *
 *
 * @Nolan Lacroix 
 * @09/11/2017
 */
public class Sentences
{
    //simple sentences list for each no-player character.
    private ArrayList<String> listAxel;
    private ArrayList<String> listMartin;
    private ArrayList<String> listNolan;
    private ArrayList<String> listValentin;
    private ArrayList<String> listGuardian;
    private ArrayList<String> listThomas;
    private ArrayList<String> listMorgane;
    private ArrayList<String> listMarie;
    private ArrayList<String> listMrsGeniet;
    private ArrayList<String> listClement;
    
    //conversation sentence lists for NPC
    private ArrayList<String> listMainMrsGeniet;
    private ArrayList<String> listMainAxel;
    private ArrayList<String> listMainMartin;
    private ArrayList<String> listMainNolan;
    private ArrayList<String> listMainGuardian;
    private ArrayList<String> listMainPG;
    
    
    //Initialisation of simple sentences
    private String sentenceAxel1, sentenceAxel2, sentenceAxel3, sentenceAxel4;
    private String sentenceValentin1, sentenceValentin2, sentenceValentin3;
    private String sentenceNolan1, sentenceNolan2, sentenceNolan3;
    private String sentenceMartin1, sentenceMartin2, sentenceMartin3;
    private String sentenceGuardian1, sentenceGuardian2, sentenceGuardian3;
    private String sentenceThomas1, sentenceThomas2;
    private String sentenceMorgane1, sentenceMorgane2;
    private String sentenceMarie1, sentenceMarie2;
    private String sentenceMrsGeniet1, sentenceMrsGeniet2;
    private String sentenceClement1, sentenceClement2;
    
    //Initialisation of conversation sentences
    private String sentenceMainMrsGeniet1, sentenceMainMrsGeniet2,sentenceMainMrsGeniet3, sentenceMainMrsGeniet4, sentenceMainMrsGeniet5, 
    sentenceMainMrsGeniet6, sentenceMainMrsGeniet7;
    private String sentenceMainAxel1, sentenceMainAxel2, sentenceMainAxel3, sentenceMainAxel4, sentenceMainAxel5, sentenceMainAxel6,
    sentenceMainAxel7, sentenceMainAxel8;
    private String sentenceMainMartin1, sentenceMainMartin2, sentenceMainMartin3, sentenceMainMartin4, sentenceMainMartin5, sentenceMainMartin6,
    sentenceMainMartin7, sentenceMainMartin8;
    private String sentenceMainNolan1, sentenceMainNolan2, sentenceMainNolan3, sentenceMainNolan4, sentenceMainNolan5, sentenceMainNolan6, 
    sentenceMainNolan7, sentenceMainNolan8;
    private String sentenceMainGuardian1, sentenceMainGuardian2, sentenceMainGuardian3, sentenceMainGuardian4, sentenceMainGuardian5, sentenceMainGuardian6,
    sentenceMainGuardian7, sentenceMainGuardian8; 
    private String sentenceMainPG1, sentenceMainPG2, sentenceMainPG3, sentenceMainPG4, sentenceMainPG5, sentenceMainPG6, sentenceMainPG7, sentenceMainPG8;
    
    /**
     * Constructor for objects of class sentences
     * Contains all the phrase lists for each NPC.
     */
    public Sentences()
    {
       listAxel = new ArrayList<String>(); // This list can be called after talking with Axel. He is present into the hall, during all the game.
       listMartin = new ArrayList<String>(); //This list can be called when the quest "let's code" is "currently running". He is present into the TP1 room.
       listNolan = new ArrayList<String>(); //This list can be called when the quest "let's code" is "currently running". He is preent into the TP1 room with Martin.
       listValentin = new ArrayList<String>(); // [useless NPC] Situated into the TP1 room.
       listGuardian = new ArrayList<String>(); //The Guardian is situated into the elevator, and this list is called when the quest with him is finished.
       listThomas = new ArrayList<String>(); // [useless NPC] Situated in the resting room.
       listMorgane = new ArrayList<String>(); // [useless NPC] Situated in the stairs 
       listMarie = new ArrayList<String>(); // [useless NPC] Situated in the amphitheatre
       listClement = new ArrayList<String>(); // [useless NPC] Situated in the classroom
       listMrsGeniet = new ArrayList<String>(); //This list is called when the quest Martin's diploma is not "currently running".
       
       
       //initialization of conversation lists
       listMainMrsGeniet = new ArrayList<String>(); // This list can be called when the quest "Martin's Diploma, the sequel" is "currently running"
       listMainAxel = new ArrayList<String>(); // This list is called when the player begin the game. 
       listMainMartin = new ArrayList<String>(); // This list is called when the quest "Martin's Diploma" is "currently running"
       listMainNolan = new ArrayList<String>(); // This list is called when the quest "Locked up" is starting.
       listMainGuardian = new ArrayList<String>(); // This list is called when the quest "Locked up" is "currently running"
       listMainPG = new ArrayList<String>(); // This list is called when the quest "Trying to finish the day" is "currently running" and the player open the PG's desk.
       
             
       //The simple sentences
       sentenceAxel1="*is tired*"; //joke
       sentenceAxel2="You have to finish the COOPOO test."; //reminder of the quest to be done
       sentenceAxel3="If you get tired, you can buy food here."; //trick
       sentenceAxel4="aah";
       
       sentenceMartin1="Hurry up ! We have to code, what are you waiting for?";
       sentenceMartin2="Thanks for my L3 diploma ;)";
       sentenceMartin3="Je vois pas pourquoi je parlerais anglais dans ton jeu, je suis un PNJ libre";
       
       sentenceNolan1="I have the toilet phobia now..";
       sentenceNolan2="I am hungry";
       sentenceNolan3="Let's go to work, I want to go home";
       
       sentenceValentin1="I am loner, my life is over. The topic of COOPOO stares me, I want to become nobody";
       sentenceValentin2="*leans out the window* I want to finish it, My COOPOO mates are not here";
       
       sentenceGuardian1="I am your father";
       sentenceGuardian2="When you do not have the strength, you must have the ruse, the weapon of intelligence.";
       sentenceGuardian3="It's been 20 years that I keep nights and days this elevator.";
       
       sentenceThomas1="Alright";
       sentenceThomas2="psss psss pssssss *does not speak loudly, it seems not possible to hear him*";
       
       sentenceMorgane1="*Burp*";
       sentenceMorgane2="It's not because you are in a game that you have to speak to everybody, bitc*";
       
       sentenceMarie1="";
       sentenceMarie2="";
       
       sentenceMrsGeniet1="chut";
       sentenceMrsGeniet2="i am listening to the students";
       
       sentenceClement1="";
       sentenceClement2="";
       
       //add the simple sentences to the list
       listAxel.add(sentenceAxel1);
       listAxel.add(sentenceAxel2);
       listAxel.add(sentenceAxel3);
       
       listMartin.add(sentenceMartin1);
       listMartin.add(sentenceMartin2);
       listMartin.add(sentenceMartin3);
       
       listNolan.add(sentenceNolan1);
       listNolan.add(sentenceNolan2);
       listNolan.add(sentenceNolan3);
       
       listValentin.add(sentenceValentin1);
       listValentin.add(sentenceValentin2);
       
       listGuardian.add(sentenceGuardian1);
       listGuardian.add(sentenceGuardian2);
       listGuardian.add(sentenceGuardian3);
       
       listMorgane.add(sentenceMorgane1);
       listMorgane.add(sentenceMorgane2);
       
       listMarie.add(sentenceMarie1);
       listMarie.add(sentenceMarie2);
       
       listMrsGeniet.add(sentenceMrsGeniet1);
       listMrsGeniet.add(sentenceMrsGeniet2);
       
       listClement.add(sentenceClement1);
       listClement.add(sentenceClement2);
       
       
       
       //The conversation sentences
       sentenceMainMrsGeniet1="";
       sentenceMainMrsGeniet2="";
       sentenceMainMrsGeniet3="";
       sentenceMainMrsGeniet4="";
       sentenceMainMrsGeniet5="";
       sentenceMainMrsGeniet6="";
       sentenceMainMrsGeniet7="";
       
       sentenceMainAxel1="";
       sentenceMainAxel2="";
       sentenceMainAxel3="";
       sentenceMainAxel4="";
       sentenceMainAxel5="";
       sentenceMainAxel6="";
       sentenceMainAxel7="";
       sentenceMainAxel8="";
       
       sentenceMainMartin1="";
       sentenceMainMartin2="";
       sentenceMainMartin3="";
       sentenceMainMartin4="";
       sentenceMainMartin5="";
       sentenceMainMartin6="";
       sentenceMainMartin7="";
       sentenceMainMartin8="";
       
       sentenceMainNolan1="";
       sentenceMainNolan2="";
       sentenceMainNolan3="";
       sentenceMainNolan4="";
       sentenceMainNolan5="";
       sentenceMainNolan6="";
       sentenceMainNolan7="";
       sentenceMainNolan8="";
       
       sentenceMainGuardian1="";
       sentenceMainGuardian2="";
       sentenceMainGuardian3="";
       sentenceMainGuardian4="";
       sentenceMainGuardian5="";
       sentenceMainGuardian6="";
       sentenceMainGuardian7="";
       sentenceMainGuardian8="";
       
       sentenceMainPG1="";
       sentenceMainPG2="";
       sentenceMainPG3="";
       sentenceMainPG4="";
       sentenceMainPG5="";
       sentenceMainPG6="";
       sentenceMainPG7="";
       sentenceMainPG8="";
       
       //add the conversation sentences to the list
       listMainMrsGeniet.add(sentenceMainMrsGeniet1);
       listMainMrsGeniet.add(sentenceMainMrsGeniet2);
       listMainMrsGeniet.add(sentenceMainMrsGeniet3);
       listMainMrsGeniet.add(sentenceMainMrsGeniet4);
       listMainMrsGeniet.add(sentenceMainMrsGeniet5);
       listMainMrsGeniet.add(sentenceMainMrsGeniet6);
       listMainMrsGeniet.add(sentenceMainMrsGeniet7);
       
       listMainAxel.add(sentenceMainAxel1);
       listMainAxel.add(sentenceMainAxel2);
       listMainAxel.add(sentenceMainAxel3);
       listMainAxel.add(sentenceMainAxel4);
       listMainAxel.add(sentenceMainAxel5);
       listMainAxel.add(sentenceMainAxel6);
       listMainAxel.add(sentenceMainAxel7);
       listMainAxel.add(sentenceMainAxel8);
       
       listMainMartin.add(sentenceMainMartin1);
       listMainMartin.add(sentenceMainMartin2);
       listMainMartin.add(sentenceMainMartin3);
       listMainMartin.add(sentenceMainMartin4);
       listMainMartin.add(sentenceMainMartin5);
       listMainMartin.add(sentenceMainMartin6);
       listMainMartin.add(sentenceMainMartin7);
       listMainMartin.add(sentenceMainMartin8);

       listMainNolan.add(sentenceMainNolan1);
       listMainNolan.add(sentenceMainNolan2);
       listMainNolan.add(sentenceMainNolan3);
       listMainNolan.add(sentenceMainNolan4);
       listMainNolan.add(sentenceMainNolan5);
       listMainNolan.add(sentenceMainNolan6);
       listMainNolan.add(sentenceMainNolan7);
       listMainNolan.add(sentenceMainNolan8);
       
       listMainGuardian.add(sentenceMainGuardian1);
       listMainGuardian.add(sentenceMainGuardian2);
       listMainGuardian.add(sentenceMainGuardian3);
       listMainGuardian.add(sentenceMainGuardian4);
       listMainGuardian.add(sentenceMainGuardian5);
       listMainGuardian.add(sentenceMainGuardian6);
       listMainGuardian.add(sentenceMainGuardian7);
       listMainGuardian.add(sentenceMainGuardian8);

       listMainPG.add(sentenceMainPG1);
       listMainPG.add(sentenceMainPG2);
       listMainPG.add(sentenceMainPG3);
       listMainPG.add(sentenceMainPG4);
       listMainPG.add(sentenceMainPG5);
       listMainPG.add(sentenceMainPG6);
       listMainPG.add(sentenceMainPG7);
       listMainPG.add(sentenceMainPG8);
       
    }

    /**
     * randomSentence method
     * Choose a random phrase from the list provided as a parameter, and return it
     * @param list, an arrayList, being a NPC's list of sentences.
     * @return a String, chosen randomly by the method called "randomNumber"
     */
    public String randomSentence(ArrayList list)
    {
        ArrayList<String> lista=list;
        String sentence="";
        int sizeArray = list.size();
        //System.out.println(sizeArray);
        int i = randomNumber(sizeArray);
        sentence=lista.get(i);
        return sentence;
        
    }
    
     /**
     * randomNumber method
     * Choose a number between 0 and the size of the list and return it. (As a list can consist of only 4 sentences maximum).
     * @return an integer, being the random number chosen.
     */
    public int randomNumber(int size)
    {
        int randomNumber=(int)(Math.random()*size);
        //randomNumber = -1; // For the test, a negatif number has been chosen, to fail the test. [value to change]
        return randomNumber;
        
    }
    
    
    
    
    /**
     * Method getListAxel allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListAxel()
    {
        return listAxel; 
    }
    
    /**
     * Method getListMartin allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMartin()
    {
        return listMartin; 
    }
    
    /**
     * Method getListNolan allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListNolan()
    {
        return listNolan; 
    }
    
    /**
     * Method getListValentin allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListValentin()
    {
        return listValentin; 
    }
    
    /**
     * Method getListGuardian allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListGuardian()
    {
        return listGuardian; 
    }
    
    /**
     * Method getListThomas allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListThomas()
    {
        return listThomas; 
    }
    
    /**
     * Method getListMorgane allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMorgane()
    {
        return listMorgane; 
    }
    
    /**
     * Method getListMarie allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMarie()
    {
        return listMarie; 
    }
    
    /**
     * Method getListClement allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListClement()
    {
        return listClement; 
    }
    
    /**
     * Method getListMrsGeniet allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMrsGeniet()
    {
        return listMrsGeniet; 
    }
    
    
    
    /**
     * Method getListMainAxel allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMainAxel()
    {
        return listMainAxel; 
    }
    
    /**
     * Method getListMainMrsGeniet allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMainMrsGeniet()
    {
        return listMainMrsGeniet; 
    }
    
    /**
     * Method getListMainNolan allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMainNolan()
    {
        return listMainNolan; 
    }
    
    /**
     * Method getListMainMartin allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMainMartin()
    {
        return listMainMartin; 
    }
    
    /**
     * Method getListMainGuardian allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMainGuardian()
    {
        return listMainGuardian; 
    }
    
    /**
     * Method getListMainPG allow to have an access to the list
     *
     * @return The sentences of the list 
     */
    public ArrayList getListMainPG()
    {
        return listMainPG; 
    }
    
    /**
     * appel une liste pour test
     */
    public void appelList()
    {
        String finalSentence=randomSentence(listAxel);
        System.out.println(finalSentence);
    }
}   