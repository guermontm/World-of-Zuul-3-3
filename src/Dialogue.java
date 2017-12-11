
import java.util.Scanner;

/*
 *The Dialogue class is the class where we store all the complex conversation between the player and the NPCs.
*each conversation is a method and can be called in the main class.
 */
/**
 *
 * @author Group 5
 */
public class Dialogue
{

    Sentences sentences;
    private int choice;
    private int stress;
    private boolean key = false;
    private boolean gameOver;

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
        choice = 0;
        reader = new Scanner(System.in);
        character = reader.next().charAt(0);

        while (character != '1' && character != '2' && character != 'q')
        {
            reader = new Scanner(System.in);
            character = reader.next().charAt(0);
        }

        switch (character)
        {
            case '1':
                choice = 1;
                break;
            case '2':
                choice = 2;
                break;
            case 'q':
                System.out.println("ok no problem, we are quitting");
                break;
            default:
                break;
        }
        return choice;
    }
    
    public int getStressDialogue()
    {
        return stress;
    }
    
    public boolean getKeyBool()
    {
        return key;
    }
    
    public boolean getGameOver()
    {
        return gameOver;
    }

    /**
     * Method dialogueAxel is used to call the conversation between Axel and the
     * player each time you have two choices that leads you to different ends of
     * the conversation
     */
    public void dialogueAxel()
    {
        {
            System.out.println(sentences.getListMainAxel(0));
            //add un keylistener sur la dialogue box pour pouvoir faire entrée pour appeler la suite

            //possible answers are printed and then the function playerChoice is called to allow the user to chose an answer 
            System.out.println("1: " + sentences.getListMainPlayerToAxel(0));
            System.out.println("2: " + sentences.getListMainPlayerToAxel(1));
            choice = playerChoice();

            if ((choice == 1) || (choice == 2))
            {
                System.out.println(sentences.getListMainAxel(1));

                System.out.println("1 :" + sentences.getListMainPlayerToAxel(2));
                System.out.println("2 :" + sentences.getListMainPlayerToAxel(3));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainAxel(2));

                    System.out.println("1 :" + sentences.getListMainPlayerToAxel(4));
                    System.out.println("2 :" + sentences.getListMainPlayerToAxel(5));
                    choice = playerChoice();

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

                    System.out.println("1 :" + sentences.getListMainPlayerToAxel(5));
                    System.out.println("2 :" + sentences.getListMainPlayerToAxel(6));
                    choice = playerChoice();

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
     * Method dialogueMartin is used to call the conversation between Martin and
     * the player each time you have two choices that leads you to different
     * ends of the conversation
     */
    public void dialogueMartin()
    {
        stress = 0;
        System.out.println(sentences.getListMainMartin(0));
        System.out.println("1 : " + sentences.getListMainPlayerToMartin(0));
        System.out.println("2 : " + sentences.getListMainPlayerToMartin(1));
        choice = playerChoice();

        if (choice == 1)
        {
            System.out.println(sentences.getListMainMartin(1));
            System.out.println("1 : " + sentences.getListMainPlayerToMartin(2));
            System.out.println("2 : " + sentences.getListMainPlayerToMartin(3));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainMartin(3));
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainMartin(4));
            }

        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainMartin(2));
            System.out.println("1 : " + sentences.getListMainPlayerToMartin(3));
            System.out.println("2 : " + sentences.getListMainPlayerToMartin(4));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainMartin(4));
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainMartin(5));
            }
        }

        //you end up here in any case
        System.out.println("1 : " + sentences.getListMainPlayerToMartin(5));
        System.out.println("2 : " + sentences.getListMainPlayerToMartin(6));
        choice = playerChoice();

        if (choice == 1)
        {
            System.out.println(sentences.getListMainMartin(6));
        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainMartin(7));
        }
    }

    /**
     * Method dialogueNolan is used to call the conversation between Nolan and
     * the player each time you have two choices that leads you to different
     * ends of the conversation
     */
    public void dialogueNolan()
    {
        stress = 0;
        System.out.println(sentences.getListMainNolan(0));
        System.out.println("1 : " + sentences.getListMainPlayerToNolan(0));
        System.out.println("2 : " + sentences.getListMainPlayerToNolan(1));
        choice = playerChoice();

        if (choice == 1)
        {
            System.out.println(sentences.getListMainNolan(3));
            System.out.println("1 : " + sentences.getListMainPlayerToNolan(4));
            System.out.println("2 : " + sentences.getListMainPlayerToNolan(5));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainNolan(4));
                System.out.println("1 : " + sentences.getListMainPlayerToNolan(6));
                System.out.println("2 : " + sentences.getListMainPlayerToNolan(7));
                choice = playerChoice();

                //no need for a if because you end up in the same place, but we still give the choice to the player
                System.out.println(sentences.getListMainNolan(6));
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainNolan(5));
                System.out.println("1 : " + sentences.getListMainPlayerToNolan(8));
                System.out.println("2 : " + sentences.getListMainPlayerToNolan(9));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainNolan(7));
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainNolan(6));
                }

            }
        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainNolan(1));

            //add a point to the stress stat
            System.out.println("Nolan knows you are here, you need to speak to him... your stress increases, be careful! ");
            stress++;

            System.out.println("1 : " + sentences.getListMainPlayerToNolan(2));
            System.out.println("2 : " + sentences.getListMainPlayerToNolan(3));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainNolan(3));
                System.out.println("1 : " + sentences.getListMainPlayerToNolan(4));
                System.out.println("2 : " + sentences.getListMainPlayerToNolan(5));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainNolan(4));
                    System.out.println("1 : " + sentences.getListMainPlayerToNolan(6));
                    System.out.println("2 : " + sentences.getListMainPlayerToNolan(7));
                    choice = playerChoice();

                    //no need for a if because you end up in the same place, but we still give the choice to the player
                    System.out.println(sentences.getListMainNolan(6));
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainNolan(5));
                    System.out.println("1 : " + sentences.getListMainPlayerToNolan(8));
                    System.out.println("2 : " + sentences.getListMainPlayerToNolan(9));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainNolan(7));
                    } else if (choice == 2)
                    {
                        System.out.println(sentences.getListMainNolan(6));
                    }
                }
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainNolan(2));
            }
        }
    }

    /**
     * Method dialoguePGTD is used to call the conversation between PG and the
     * player each time you have two choices that leads you to different ends of
     * the conversation
     */
    public void dialoguePGTD()
    {
        stress = 0;
        gameOver =false;
        System.out.println(sentences.getListMainPGTD(0));
        System.out.println("1 : " + sentences.getListPlayerToMainPGTD(0));
        System.out.println("2 : " + sentences.getListPlayerToMainPGTD(1));
        choice = playerChoice();

        if (choice == 1)
        {
            System.out.println(sentences.getListMainPGTD(1));
            System.out.println("1 : " + sentences.getListPlayerToMainPGTD(4));
            System.out.println("2 : " + sentences.getListPlayerToMainPGTD(5));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainPGTD(6));
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainPGTD(5));
                //add a point to the stress stat
                System.out.println("Maybe you should be more respectful with your teachers... Your stress is increasing be careful!");
                stress++;
            }
        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainPGTD(2));
            //add a point to the stress stat
            System.out.println("Maybe you should be more respectful with your teachers... Your stress is increasing be careful!");
            stress++;

            System.out.println("1 : " + sentences.getListPlayerToMainPGTD(2));
            System.out.println("2 : " + sentences.getListPlayerToMainPGTD(3));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainPGTD(3));
                //leads to game over
                gameOver = true;
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainPGTD(4));
                System.out.println(sentences.getListMainPGTD(1));
                System.out.println("1 : " + sentences.getListPlayerToMainPGTD(4));
                System.out.println("2 : " + sentences.getListPlayerToMainPGTD(5));
                choice = playerChoice();
                
                if (choice == 1)
            {
                System.out.println(sentences.getListMainPGTD(6));
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainPGTD(5));
                //add a point to the stress stat
                System.out.println("Maybe you should be more respectful with your teachers... Your stress is increasing be careful!");
                stress++;
            }      
            }
        }
    }

    /**
     * Method dialogueGeniet is used to call the conversation between Mrs Geniet
     * and the player each time you have two choices that leads you to different
     * ends of the conversation
     */
    public void dialogueGeniet()
    {
        stress = 0;
        gameOver = false;
        System.out.println(sentences.getListMainMrsGeniet(0));
        System.out.println("1 : " + sentences.getListMainPlayerToMrsGeniet(0));
        System.out.println("2 : " + sentences.getListMainPlayerToMrsGeniet(1));
        choice = playerChoice();

        if (choice == 1)
        {
            System.out.println(sentences.getListMainMrsGeniet(1));
            key = true; //adds the key to the inventory
            System.out.println("You got the key to Mrs Geniet's office! Be careful with it");
        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainMrsGeniet(2));
            //add a point to the stress stat
            System.out.println("Mrs Geniet is not very  happy! Your stress is increasing be careful!");
            stress++;

            System.out.println("1 : " + sentences.getListMainPlayerToMrsGeniet(2));
            System.out.println("2 : " + sentences.getListMainPlayerToMrsGeniet(3));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainMrsGeniet(1)); //same as before because you end up in the same point
                key = true; //adds the key to the inventory
                System.out.println("You got the key to Mrs Geniet's office! Be careful with it");
                
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainMrsGeniet(3));
                //leads to game over
                gameOver = true;
            }

        }
    }

    /**
     * Method dialogueGuardian is used to call the conversation between the
     * guardian and the player each time you have two choices that leads you to
     * different ends of the conversation
     */
    public void dialogueGuardian()
    {
        stress = 0;
        System.out.println(sentences.getListMainGuardian(0));
        System.out.println("1 : " + sentences.getListMainPlayerToGuardian(0));
        System.out.println("2 : " + sentences.getListMainPlayerToGuardian(1));
        choice = playerChoice();

        if (choice == 1)
        {
            System.out.println(sentences.getListMainGuardian(1));
            System.out.println("1 : " + sentences.getListMainPlayerToGuardian(2));
            System.out.println("2 : " + sentences.getListMainPlayerToGuardian(3));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainGuardian(2));
                System.out.println("1 : " + sentences.getListMainPlayerToGuardian(4));
                System.out.println("2 : " + sentences.getListMainPlayerToGuardian(5));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainGuardian(4));
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainGuardian(5));
                }
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainGuardian(3));
                System.out.println("1 : " + sentences.getListMainPlayerToGuardian(4));
                System.out.println("2 : " + sentences.getListMainPlayerToGuardian(5));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainGuardian(4));
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainGuardian(5));
                }
            }
        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainGuardian(2));
            System.out.println("1 : " + sentences.getListMainPlayerToGuardian(4));
            System.out.println("2 : " + sentences.getListMainPlayerToGuardian(5));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainGuardian(4));
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainGuardian(5));
            }
        }

    }

    /**
     * Method dialoguePGEnd is used to call the conversation between PG and the
     * player each time you have two choices that leads you to different ends of
     * the conversation
     */
    public void dialoguePGEnd()
    {
        stress = 0;
        gameOver = false;
        System.out.println(sentences.getListMainPGEnd(0));

        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(0));
        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(1));
        choice = playerChoice();

        if (choice == 1)
        {
            System.out.println(sentences.getListMainPGEnd(1));

            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(2));
            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(3));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainPGEnd(3));
                //leads to game over
                System.out.println("OOOPS wrong answer! GAME OVER");
                gameOver = true;
            } else if (choice == 2)
            {
                System.out.println(sentences.getListMainPGEnd(4));

                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(8));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(9));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainPGEnd(8));
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainPGEnd(9));
                    //add a point to the stress stat
                    System.out.println("You were a little bold there, bad choice! Your stress is increasing, be careful!");
                    stress++;
                }

                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(10));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(11));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainPGEnd(11));

                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(13));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(14));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(13));

                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(15));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(16));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(15));
                        } else if (choice == 2)
                        {
                            System.out.println(sentences.getListMainPGEnd(16));
                            //add a stress point
                            System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        }

                    } else if (choice == 2)
                    {
                        System.out.println(sentences.getListMainPGEnd(14));

                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(16));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(17));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(16));
                            //add a stress point
                            System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        } else if (choice == 2)
                        {
                            System.out.println(sentences.getListMainPGEnd(17));
                        }
                    }

                    //no matter what you chose, you end up at the same point so no need to put that in the if                        
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(18));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(19));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(18));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    System.out.println(sentences.getListMainPGEnd(19));
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(20));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(21));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(20));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    System.out.println(sentences.getListMainPGEnd(21));
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(22));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(23));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(22));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    System.out.println(sentences.getListMainPGEnd(23));
                    //End of the game
                    System.out.println(sentences.getListMainPGEnd(24));

                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainPGEnd(10));
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(10));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(12));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        //crossing other part of the conversation                        

                        System.out.println(sentences.getListMainPGEnd(11));
                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(13));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(14));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(13));

                            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(15));
                            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(16));
                            choice = playerChoice();

                            if (choice == 1)
                            {
                                System.out.println(sentences.getListMainPGEnd(15));
                            } else if (choice == 2)
                            {
                                System.out.println(sentences.getListMainPGEnd(16));
                                //add a stress point
                                System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                                stress++;
                            }

                        } else if (choice == 2)
                        {
                            System.out.println(sentences.getListMainPGEnd(14));

                            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(16));
                            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(17));
                            choice = playerChoice();

                            if (choice == 1)
                            {
                                System.out.println(sentences.getListMainPGEnd(16));
                                //add a stress point
                                System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                                stress++;
                            } else if (choice == 2)
                            {
                                System.out.println(sentences.getListMainPGEnd(17));
                            }
                        }

                        //no matter what you chose, you end up at the same point so no need to put that in the if                        
                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(18));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(19));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(18));
                            //add a stress point
                            System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                            stress++;
                        }
                        //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                        System.out.println(sentences.getListMainPGEnd(19));
                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(20));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(21));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(20));
                            //add a stress point
                            System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                            stress++;
                        }
                        //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                        System.out.println(sentences.getListMainPGEnd(21));
                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(22));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(23));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(22));
                            //add a stress point
                            System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                            stress++;
                        }
                        //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                        System.out.println(sentences.getListMainPGEnd(23));
                        //End of the game
                        System.out.println(sentences.getListMainPGEnd(24));

                    } else if (choice == 2)
                    {
                        System.out.println(sentences.getListMainPGEnd(12));
                        //leads to game over
                        gameOver = true;
                    }
                }
            }
        } else if (choice == 2)
        {
            System.out.println(sentences.getListMainPGEnd(2));
            //adding a point to the stress stat
            System.out.println("Your heart is suddendly beating really fast... Your stress increase, be careful!"); //à mettre en italique maybe pour différencier du dialogue
            stress++;

            System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(4));
            System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(5));
            choice = playerChoice();

            if (choice == 1)
            {
                System.out.println(sentences.getListMainPGEnd(4)); //crossing with the other part
                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(8));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(9));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainPGEnd(8));
                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainPGEnd(9));
                    //add a point to the stress stat
                    System.out.println("You were a little bold there, bad choice! Your stress is increasing, be careful!");
                    stress++;
                }

                System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(10));
                System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(11));
                choice = playerChoice();

                if (choice == 1)
                {
                    System.out.println(sentences.getListMainPGEnd(11));

                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(13));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(14));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(13));

                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(15));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(16));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(15));
                        } else if (choice == 2)
                        {
                            System.out.println(sentences.getListMainPGEnd(16));
                            //add a stress point
                            System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        }

                    } else if (choice == 2)
                    {
                        System.out.println(sentences.getListMainPGEnd(14));

                        System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(16));
                        System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(17));
                        choice = playerChoice();

                        if (choice == 1)
                        {
                            System.out.println(sentences.getListMainPGEnd(16));
                            //add a stress point
                            System.out.println("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        } else if (choice == 2)
                        {
                            System.out.println(sentences.getListMainPGEnd(17));
                        }
                    }

                    //no matter what you chose, you end up at the same point so no need to put that in the if                        
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(18));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(19));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(18));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    System.out.println(sentences.getListMainPGEnd(19));
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(20));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(21));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(20));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    System.out.println(sentences.getListMainPGEnd(21));
                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(22));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(23));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(22));
                        //add a stress point
                        System.out.println("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    System.out.println(sentences.getListMainPGEnd(23));
                    //End of the game
                    System.out.println(sentences.getListMainPGEnd(24));

                } else if (choice == 2)
                {
                    System.out.println(sentences.getListMainPGEnd(5));

                    System.out.println("1 : " + sentences.getListPlayerToMainPGEnd(6));
                    System.out.println("2 : " + sentences.getListPlayerToMainPGEnd(7));
                    choice = playerChoice();

                    if (choice == 1)
                    {
                        System.out.println(sentences.getListMainPGEnd(6));
                        //leads to game over
                        gameOver = true;
                    } else if (choice == 2)
                    {
                        System.out.println(sentences.getListMainPGEnd(7));
                        //leads to game over
                        gameOver = true;
                    }
                }
            }
        }
    }
}
