
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Group 5
 */
public class Dialogue
{

    Sentences sentences;
    int choice;
    private Game game;

    /**
     * Constructor for the class Dialogue
     */
    public Dialogue()
    {
        sentences = new Sentences();
    }

    /**
     * Method playerChoice allows to ask the user for a character to choose
     * between options in a conversation
     *
     * @return choice an int that is the choice of the user
     */
    public int playerChoice()
    {
        char character;
        Scanner reader;
        reader = new Scanner(System.in);
        character = reader.next().charAt(0);

        while ((character != '1') && (character != '2'))
        {
            if ((character == '1') || (character == '2'))
            {
                choice = 1;
            } else if (character == '2')
            {
                choice = 2;
            } else
            {
                System.out.println("that is not a valid choice");
            }
        }
        return choice;
    }

    /**
     * Method dialogueAxel is used to call the conversation between Axel and the
     * player
     * each time you have two choices that leads you to different ends of the conversation
     */
    public void dialogueAxel()
    {
        {
            System.out.println(sentences.getListMainAxel(0));
            //add un keylistener sur la dialogue box pour pouvoir faire entrée pour appeler la suite

            //the player has 2 choices 
            choice = playerChoice();
            System.out.println("1: " + sentences.getListMainPlayerToAxel(0));
            System.out.println("2: " + sentences.getListMainPlayerToAxel(1));

            if ((choice == 1) || (choice == 2))
            {
                System.out.println(sentences.getListMainAxel(1));
                choice = playerChoice();

                System.out.println("1 :" + sentences.getListMainPlayerToAxel(2));
                System.out.println("2 :" + sentences.getListMainPlayerToAxel(3));
                if (choice == 1)
                {
                    System.out.println(sentences.getListMainAxel(2));
                    choice = playerChoice();

                    System.out.println("1 :" + sentences.getListMainPlayerToAxel(4));
                    System.out.println("2 :" + sentences.getListMainPlayerToAxel(5));
                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainAxel(4));
                    } else if (choice == 2)
                    {
                        System.out.println(sentences.getListMainAxel(5));
                    }

                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainAxel(3));
                    choice = playerChoice();

                    System.out.println("1 :" + sentences.getListMainPlayerToAxel(5));
                    System.out.println("2 :" + sentences.getListMainPlayerToAxel(6));
                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainAxel(5));
                    } else if (choice == 2)
                    {
                        System.out.println(sentences.getListMainAxel(6));
                    }
                }
            }
        }
    }

    /**
     *
     */
    public void dialogueMartin()
    {
        System.out.println(sentences.getListMainMartin(0));
    }

    /**
     *
     */
    public void dialoguePGFin()
    {
        System.out.println(sentences.getListMainPGEnd(0));
        choice = playerChoice();

        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(0));
        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(1));

        if (choice == 1)
        {
            System.out.println(sentences.getListMainPGEnd(1));

            choice = playerChoice();
            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(2));
            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(3));
            if (choice == 1)
            {
                System.out.println(sentences.getListMainPGEnd(3));
                //leads to game over
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainPGEnd(4));

                choice = playerChoice();
                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(8));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(9));

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainPGEnd(8));
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainPGEnd(9));
                    //add a point to the stress stat
                    System.out.println("You were a little bold there, bad choice! Your stress is increasing, be careful!");
                    game.thePlayer.addStat("stressStat", 1);
                }

                choice = playerChoice();
                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(10));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(11));
                if (choice == 1)
                {
                    System.out.println(sentences.getListMainPGEnd(11));
                    
                    choice = playerChoice();
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(13));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(14));
                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(13));
                            
                            choice = playerChoice();
                            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(15));
                            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(16));
                                if (choice == 1)
                                {
                                    System.out.println(sentences.getListMainPGEnd(15));
                                }
                                else if (choice == 2)
                                {
                                    System.out.println(sentences.getListMainPGEnd(16));
                                    //add a stress point
                                    System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                                    game.thePlayer.addStat("stressStat", 1);
                                }
                            
                        }
                        else if (choice == 2)
                        {
                            System.out.println(sentences.getListMainPGEnd(14));
                            
                            choice = playerChoice();
                            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(16));
                            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(17));
                                if (choice == 1)
                                {
                                    System.out.println(sentences.getListMainPGEnd(16));
                                    //add a stress point
                                    System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                                    game.thePlayer.addStat("stressStat", 1);
                                }
                                else if (choice == 2)
                                {
                                  System.out.println(sentences.getListMainPGEnd(17));  
                                }
                        }
                
                //no matter what you chose, you end up at the same point so no need to put that in the if        
                choice = playerChoice();
                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(18));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(19));
                
                    if(choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(18));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        game.thePlayer.addStat("stressStat", 1);
                    }
                //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                System.out.println(sentences.getListMainPGEnd(19));
                    
                choice = playerChoice();
                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(20));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(21));
                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(20));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        game.thePlayer.addStat("stressStat", 1);
                    }
                //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                System.out.println(sentences.getListMainPGEnd(21));
                
                choice = playerChoice();
                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(22));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(23));
                    if(choice == 1)
                    {
                       System.out.println(sentences.getListMainPGEnd(22));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        game.thePlayer.addStat("stressStat", 1); 
                    }
                //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                System.out.println(sentences.getListMainPGEnd(23));
                //End of the game
                System.out.println(sentences.getListMainPGEnd(24));
            
                
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainPGEnd(10));

                    choice = playerChoice();
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(10)); 
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(12));
                        if (choice == 1)
                        {
                            //besoin de le raccorder plus haut, à réfléchir
                        }
                        else if (choice == 2)
                        {
                            System.out.println(sentences.getListMainPGEnd(12));
                            //leads to game over
                        }
                }
            }
        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainPGEnd(2));
            //adding a point to the stress stat
            System.out.println("Your heart is suddendly beating really fast... Your stress increase, be careful!"); //à mettre en italique maybe pour différencier du dialogue
            game.thePlayer.addStat("stressStat", 1);

            choice = playerChoice();
            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(4));
            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(5));
            if (choice == 1)
            {
                System.out.println(sentences.getListMainPGEnd(4)); //help ça retourne de l'autre coté
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainPGEnd(5));

                choice = playerChoice();
                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(6));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(7));

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainPGEnd(6));
                    //leads to game over
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainPGEnd(7));
                    //leads to game over
                }
            }
        }
    }
}
