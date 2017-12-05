import java.util.*;
/*
 * Class Quest 
 */

/**
 *
 * @author Group 5
 * @version 01/12/2017
 */
public class QuestV2 {

    private ArrayList<String> currentQuests;
    //table of all the quests in the game
    private String questTable[][];

    public QuestV2() {
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
     * Method getQuestTable
     *
     * @return a string corresponding to the wanted space in the table
     * @param i number of the column in the table, i is between 0 and 7
     * @param j number of the line in the table, j is between and 2
     */
    public String getQuestTable(int i, int j) {
        return questTable[i][j];
    }

    /**
     * return the description of the quest (where to go, what to do), can be
     * used to be said by a NPC and in the help menu
     *
     */
    public void getDescription() {
        int i;
        for (i = 0; i < questTable.length; i++) {
            if ((questTable[i][2]).equals("finished") || (questTable[i][2]).equals("currently running")) {
                System.out.println("YOUR QUESTS" + "\n" + "title : " + questTable[i][0] + "\n" + "You have to " + questTable[i][1] + "\n" + questTable[i][2]);
            }
        }
    }

    /**
     * Method endQuest allows you to change the status of a quest to finished
     *
     * @param numberQuest an int that is the number of the quest you want to
     * change the status
     */
    public void endQuest(int numberQuest) {
        questTable[numberQuest][2] = "finished";
    }

    /**
     * Method startQuest allows you to change the status of a quest to currently
     * running
     *
     * @param numberQuest an int that is the number of the quest you want to
     * change the status
     */
    public void startQuest(int numberQuest) {
        questTable[numberQuest][2] = "currently running";
    }

    /**
     * Method getStatus allows you to know the status of the quest
     *
     * @param numberQuest an int that is the number of the quest you want to
     * know the status
     * @retrun status a string corresponding to the status of the quest, can be
     * "not started", "finished" or "currently running"
     */
    public String getStatus(int numberQuest) {
        return getQuestTable(numberQuest, 2);
    }

    /**
     * Method getCurrentQuest
     *
     * @return currentQuests an ArrayList that takes all the current quests
     */
    public ArrayList getCurrentQuest() {
        int i;
        currentQuests = new ArrayList<String>();      
        
        for (i = 0; i < questTable.length; i++) {
            if (questTable[i][2].equals("currently running")) {
                currentQuests.add(questTable[i][0]);
                System.out.println(currentQuests);
            }
        }
        return currentQuests;
    }
}
