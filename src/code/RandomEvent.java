package code;

import java.util.*;
/**
 * a lot of randomEvent that appears randomly in the corridors. The methods of this class always return a list with the statistic that could be changed during the event.
 * The statistics of the player will be changed in the game class by calling the addStat method from the player class. 
 * One of the method of the class is called in the game class when the player enter a room where it might happen.
 *
 * @author Group 5
 * @version 09/11
 */
public class RandomEvent
{
    Player player;

    /**
    * Constructor for RandomEvent with a Player parameter
    * @param thePlayer the player transmitted to the Constructor.
    */
    public RandomEvent(Player thePlayer)
    {
        player = thePlayer;
    }

    /** 
     *  This method modifies the energy of the player and adds 2 points.
     *  it uses methods from the player class
     */
    public void hiddenCandy()
    {
        if (player.getStaStat() <= 8)  
        {
            player.addStat("staStat", 2);
            System.out.println("you find a hidden candy from halloween, you gain 2 energy points");
        }
        else if (player.getStaStat() <= 9) 
        {
            player.addStat("staStat", 1);
            System.out.println("you find a hidden candy from halloween, you gain 2 energy points");
        }
        else if (player.getStaStat() >= 10) System.out.println("You already have full energy!");
    }

    /**
     *  This method modifies the stress which is set to 0.
     */
    public void allanJoke()
    {
        player.setStress(0);
        System.out.println("Allan tells you a joke so funny that you are not stressed anymore!");
    }

    /** 
     *  This method modifies the energy, it subtracts 1 point.
     */
    public void pillowAttack()
    {
        if (player.getStaStat() >= 1) 
        {
            player.addStat("staStat", -1);
            System.out.println("You did not sleep enough during the night, your pillow comes back to haunt you. You lose one energy point");
        }
        else System.out.println("GAME OVER"); 
    }

    /** 
     *  This method modifies the intelligence and stress, it adds 1 point for each.
     *
     */
    public void adaHelp()
    {
        if (player.getIntStat() <= 9) 
        {
            player.addStat("intStat", 1);
            System.out.println("You are helping a little L3 student, your intelligence increases");
        }
        else System.out.println("You are as clever as Einstein, no need to gain more!");
        if (player.getStrStat() <= 9) 
        {
            player.addStat("stressStat", 1);
            System.out.println("You are talking about ada, of course you are getting stressed...");
        }
        else System.out.println("GAME OVER");
    }

    /** 
     *  This method modifies the energy (+1) and the stress (-1)
     *
     */
    public void penguinHug()
    {
        if (player.getStaStat() <=9) 
        {
            player.addStat("staStat", 1);
            System.out.println("The penguin gives you a hug, your energy increase!");
        }
        else System.out.println("Well done, you reached the maximum of Energy points!");
        if (player.getStrStat() >= 1)
        {
            player.addStat("stressStat", -1);
            System.out.println("The penguin gives you a hug, you feel better, your stress decrease!");
        }
    }

    /** 
     *  This one modifies the stress (+1)
     */
    public void teacherMeeting()
    {
        if (player.getStrStat() <=9) {
            player.addStat("stressStat", 1);
            System.out.println("You gain one stress point because of this meeting!");
        }
        else System.out.println("GAME OVER");
    }

    /** 
     *  This method modifies the energy (-1) and speech ability (+1)
     */
    public void conversation()
    {
        if (player.getStaStat() >= 1) {
            player.addStat("staStat", -1);
            System.out.println("You lose one energy point!");
        }
        else System.out.println("GAME OVER");
        if (player.getSpeStat() <= 9 ){
            player.addStat("speStat", 1);
            System.out.println("You have one more Speech point! Keep practicing!");
        }
        else System.out.println("You can already talk like Steve Jobs, you do not gain any points");
    }
}

