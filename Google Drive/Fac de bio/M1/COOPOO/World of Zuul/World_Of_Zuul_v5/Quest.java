import java.lang.Object;
/**
 * Contains all the necessary methods for the quests that the player can take 
 *
 * @author (Grp5)
 * @version 23/11/2017
 */
public class Quest
{
    // boolean that is true when a quest is finished and false when it is not
    private boolean questEnded;
    //table of all the quests in the game
    private String questTable[][];
    
    //private Game game;
    //using the item classes
    private NPC pg = new NPC("PG", false); //a creer dans le td4
    private NPC martin = new NPC("Martin", true ); //a creer dans le tp1
    private NPC nolan = new NPC("Nolan", true ); //en creer deux, un dans les toilettes et un dans tp1 qui seront actives a des moments differents
    private NPC nolan2 = new NPC("Nolan2", true );
    private SimpleObject officeDoor = new SimpleObject ("Office Door",true); //peut etre plus intelligent a faire --> faire dans le hashmap
    private Container desk = new Container ("Desk",false); //a creer dans le main de game, dans le bureau d'annie
    private SimpleObject toiletDoor = new SimpleObject ("Toilet Door",true); //nolan est bloqué derrière, quand on prend le pied de biche passe a false et débloque donc une autre discussion avec nolan
    private SimpleObject computer = new SimpleObject("Computer", true); //PC pour coder le projet, débloqué quand intel >7
    private Container closet = new Container ("Closet", true); // le placard dans lequel se trouve la clé du bureau de PG

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
     * return the case of the table that you want
     * @parameter int i number of the column in the table and int j the number of the line
     * i is between 0 and 7
     * j is between  and 2
     */
    public String getQuestTable(int i, int j)
    {
        return questTable[i][j];
    }
    /**
     * return the description of the quest (where to go, what to do), 
     * can be used to be said by a NPC and in the help menu
     * 
     */
    public void getDescription()
    {
        int i;
        for(i = 0; i < questTable.length; i++){
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
    public boolean getQuestEnded(int numberQuest)
    {
        int q = numberQuest;
        if ((questTable[q][2]).equals("not started")|| (questTable[q][2]).equals("currently running")){
            questEnded = false;
            System.out.println("Your quest is not ended yet");
        }
        else{
            questEnded = true;
            System.out.println("Your quest is ended,well done");
        }
        return questEnded; 
    }

    /**
     * Method for the first quest of the game, the goal is to find the COOPOO subject
     * steps : going to see PG in TD4, then going to find the other members of the group
     * the members of the group are scattered in the building and finding them starts other quests
     *
     * @param  y  a sample parameter for a method
     */
    public void questFindingSubject ()
    {
        //ce que dit pg à récupérer dans NPC
        //il dit qu'il faut trouver les autres membres du groupe

        //on met le boolean pg a false il doit disparaitre --> a changer quand on aura fait game
        pg.setLock();
        //the other quests are starting and this one is finished
        questTable[1][2] = "currently running";
        questTable[2][2] = "currently running";
        questTable[3][2] = "currently running";
        questTable[0][2] = "finished";

        //unlock Nolan and Martin in the toilets and in TP1
        nolan.setLock();
        martin.setLock();
    }

    /**
     * Method questGatheringGroup is the method for the second quest of the game 
     * at the end allows nolan to change rooms so the game can continue
     */
    public void questGatheringGroup()
    {
        //end of the quest
        questTable[1][2] = "finished";
        questTable[6][2] = "currently running";
        //dit un truc pour expliquer que c'est bon c'est fini, il faut coder
        //utiliser simple sentences avec martin et nolan et fait apparaitre nolan en tp1
        nolan.setLock(); //nolan goes from the toilets to the tp1
        nolan2.setLock();
    }

    /**
     * Method for the next quest of the game, you can take it with Martin
     */
    public void questDiploma()
    {
        //trouver martin et lui parler discussion avec des choix ou il dit qu'il faut aller chercher son diplome dans le bureau d'annie

        //end of the quest
        questTable[2][2] = "finished";
        questTable[4][2] = "currently running";
        //debloque discussion avec annie
    }

    /**
     * Method for the sequel quest of Diploma
     */
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
        if (getQuestEnded(5) == true)
        {
            questGatheringGroup();
        }
        else { System.out.println("You need to find the other member of the team to be able to code!");}
    }

    /**
     * Method for the quest you can take with Nolan
     */
    public void questToilets()
    {
        //trouver nolan qui est dans les toilettes à l'étage
        //discussion ou il dit qu'il veut sortir
        // fin de la quete, debloquer la discussion pied de biche avec le gardien
        questTable[3][2] = "finished";
        questTable[5][2] = "currently running";
    }

    /**
     * Method for the sequel of the Toilets quest
     */
    public void questToilets2()
    
    {
        // il faut aller dans l'ascenceur pour choper le pied de biche
        //if (game.thePlayer.getStrStat >= 7){
            //discussion spéciale avec le gardien et à la fin
           // game.thePlayer.crowbar = true;
        //}
        //objet porte qui est bloqué et qui sera débloqué quand on aura le pied de biche
        //if ((game.thePlayer.crowbar == true) || (game.thePlayer.getStrStat = 10)){  
        toiletDoor.setLock(); //débloque la salle
        //}
        //nolan apparait sur l'image et il dit allons coder babe
        //fin de la quete
        // si l'autre quete est finie alors on passe aux quetes suivantes
        questTable[5][2] = "finished";
        if (getQuestEnded(4) == true)
        {
            questGatheringGroup();
        }
        else {System.out.println("You need to find the other member of the team to be able to code!");}
    }


    /**
     * Method for the next quest
     */
    public void questCode()
    {
        //coder sur l'ordi en tp1, il faut avoir une intel sup à 7
        //if (game.thePlayer.getIntStat() >=7){
            computer.setLock();
            //message qui dit qu'on a fini de coder
            //fin de la quete, nolan et martin rentrent chez eux
            nolan2.setLock();
            martin.setLock();
            questTable[6][2] = "finished";
            questTable[7][2] = "currently running";
            //unlock the closet with the keys for the office
            closet.setLock();
        //}
    }
    /**
     * Method for the last quest of the game 
     */
    public void questFinish()
    {
        //trouver les clés dans le closet et ouvrir la porte de PG
        //enlever la key du closet quand le player interagit avec
        //game.thePlayer.key = true; //rajouter boolean dans player
        //unlock the door when you have the key --> dans le hashmap
        //if (game.thePlayer.key == true){
            //discussion avec PG pour finir, discussion avec des choix --> plusieurs fins possibles
        //}
        //fin de la quete et du jeu
        questTable[7][2] = "finished";
    }
}
