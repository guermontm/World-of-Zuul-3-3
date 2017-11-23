import java.lang.Object;
/**
 * Contains all the necessary methods for the quests that the player can take
 *
 * @author (Grp5)
 * @version (a version number or a date)
 */
public class Quest
{
    // boolean that is true when a quest is finished and false when it is not
    private boolean questEnded;
    //table of all the quests in the game
    private String questTable[][];  
    //private Game game = new Game();
    //using the item classes
    private NPC pg = new NPC("PG", false); //a creer dans le td4
    private NPC martin = new NPC("Martin", true ); //a creer dans le tp1
    private NPC nolan = new NPC("Nolan", true ); //en creer deux, un dans les toilettes et un dans tp1 qui seront actives a des moments differents
    private NPC nolan2 = new NPC("Nolan2", true );
    private SimpleObject officeDoor = new SimpleObject ("Office Door",true); //peut etre plus intelligent a faire
    private Container desk = new Container ("Desk",false); //a creer dans le main de game, dans le bureau d'annie
    private SimpleObject toiletDoor = new SimpleObject ("Toilet Door",true); //nolan est bloqu� derri�re, quand on prend le pied de biche passe a false et d�bloque donc une autre discussion avec nolan
    /**
     * Constructor for objects of class Quest
     */
    public Quest()
    {
        // the quest is ended
        questEnded = true;

        //a multidimensional table to be able to see all the quests
        questTable = new String[8][3];
        //quest 1
        questTable[0][0] = "Finding the subject";
        questTable[0][1] = "Go to see PG to find the subject in the TD4";
        questTable[0][2] = "currently running";
        //second quests
        questTable[1][0] = "Gathering the Group";
        questTable[1][1] = "Find the members of your group within the B2";
        questTable[1][2] = "not started";
        questTable[2][0] = "Martin's Diploma";
        questTable[2][1] = "Find Martin";
        questTable[2][2] = "not started";
        questTable[3][0] = "Locked Up";
        questTable[3][1] = "Find Nolan";
        questTable[3][2] = "not started";
        //third quests
        questTable[4][0] = "Martin's Diploma, the sequel";
        questTable[4][1] = "Ask Annie for the keys to her office. She is currently listening to students for their internship presentation. ";
        questTable[4][2] = "not started";
        questTable[5][0] = "Still Locked Up";
        questTable[5][1] = "Help Nolan to get out of the toilets";
        questTable[5][2] = "not started";
        //4th quest
        questTable[6][0] = "Let's code!";
        questTable[6][1] = "Answer the COO-POO subject with your teammates";
        questTable[6][2] = "not started";
        //last quest
        questTable[7][0] = "Trying to finish the day";
        questTable[7][1] = "Give your answers to PG, you need to find him in his office.";
        questTable[7][2] = "not started";

    }

    /**
     * return the description of the quest (where to go, what to do), 
     * can be used to be said by a NPC
     * 
     * @param  the number of the quest
     * @return a string with the description
     */
    public void getDescription()
    {
        int i;
        int l = questTable.length;
        for(i = 0; i < l; i++){
            if ((questTable[i][2]).equals("finished")|| (questTable[i][2]).equals("currently running")){
                System.out.println("YOUR QUESTS"+"\n"+"title : "+questTable[i][0]+"\n"+"You have to "+questTable[i][1]+"\n"+questTable[i][2]);
            }
        }
    }

    /**
     * Method getQuestEnded return the value of the boolean questEnded
     * takes the number of the quest to return a boolean depending on the status of the quest
     *
     * @return The return value
     */
    public boolean setQuestEnded(int numberQuest)
    {
        int q = numberQuest;
        for (q=0; q<questTable.length; q++){
            if ((questTable[q][2]).equals("not started")|| (questTable[q][2]).equals("currently running")){
                questEnded = false;
                System.out.println("Your quest is not ended yet");
            }
            else{
                questEnded = true;
                System.out.println("Your quest is ended,well done");
            }
        }
        return questEnded; 
    }

    /**
     * Method for the first quest of the game, the goal is to find the COOPOO subject
     * steps : going to see PG in TD4, then going to find the other members of the group
     * the members of the group are scattered in the building and finding them starts other quests
     *
     */
    public void questFindingSubject ()
    {
        //ce que dit pg à récupérer dans NPC
        //il dit qu'il faut trouver les autres membres du groupe

        //on met le boolean pg a false il doit disparaitre --> a changer quand on aura fait game
        pg.setLock();
        //on commence les autres quetes
        questTable[1][2] = "currently running";
        questTable[2][2] = "currently running";
        questTable[3][2] = "currently running";
        questTable[1][2] = "currently running";
        questTable[0][2] = "finished";

        //unlock nolan et martin dans les toilettes et en tp1
        nolan.setLock();
        martin.setLock();
    }

    public void questGatheringGroup()
    {
        //fin de la quete
        questTable[1][2] = "finished";
        questTable[6][2] = "currently running";
        //dit un truc pour expliquer que c'est bon c'est fini, il faut coder
        //utiliser simple sentences avec martin et nolan et fait apparaitre nolan en tp1
        nolan.setLock(); //nolan goes from the toilets to the tp1
        nolan2.setLock();
    }

    public void questDiploma()
    {
        //trouver martin et lui parler discussion avec des choix ou il dit qu'il faut aller chercher son diplome dans le bureau d'annie

        //fin de la quete
        questTable[2][2] = "finished";
        questTable[4][2] = "currently running";
        //debloque discussion avec annie
    }

    public void questDiploma2()
    {
        //on va dans le bureau d'annie mais ferme donc faut aller la trouver en amphi --> papier sur la porte?

        //prendre la phrase d'annie dans la liste (celle qui demande de lui ramener ses cles)
        //annie a donné ses clés donc on débloque sa porte
        officeDoor.setLock(); //office door is opened --> maybe blocking the exit instead?
        //interagir avec le bureau et prendre le diplome
        desk.interactItem(); //return the diploma
        //le fait de récupérer le diplome débloque une nouvelle discussion avec martin qui dit merci et hop
        //fin de la quete
        questTable[4][2] = "finished";
        if (questTable[5][2].equals("finished"))
        {
            questGatheringGroup();
        }
        else { System.out.println("You need to find the other member of the team to be able to code!");}
    }

    public void questToilets()
    {
        //trouver nolan qui est dans les toilettes à l'étage
        //discussion ou il dit qu'il veut sortir
        // fin de la quete, debloquer la discussion pied de biche avec le gardien
        questTable[3][2] = "finished";
        questTable[5][2] = "currently running";
    }

    public void questToilets2()
    {
        // il faut aller dans l'ascenceur pour choper le pied de biche
        // if (game.thePlayer.getStrStat >= 7){
            // game.thePlayer.crowbar = true;
        // }
        // //objet porte qui est bloqu� et qui sera d�bloqu� quand on aura le pied de biche
        // if ((game.thePlayer.crowbar == true) || (game.thePlayer.getStrStat = 10)){  
            // toiletDoor.setLock(); //d�bloque la salle
        // }
        //nolan apparait sur l'image et il dit allons coder babe
        //fin de la quete
        // si l'autre quete est finie alors on passe aux quetes suivantes
        questTable[5][2] = "finished";
        if (questTable[4][2].equals("finished"))
        {
            questGatheringGroup();
        }
        else {System.out.println("You need to find the other member of the team to be able to code!");}
    }

    public void questCode()
    {
        //coder sur l'ordi en tp1
        //if (game.thePlayer.getIntStat() >=7){
            
        //}
        //fin de la quete
        questTable[6][2] = "finished";
        questTable[7][2] = "currently running";
    }

    public void questFinish()
    {
        //fin de la quete
        questTable[7][2] = "finished";
    }
}
