package code;


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
    private boolean gameOver;

    /**
     * Constructor for the class Dialogue
     */
    public Dialogue()
    {
        sentences = new Sentences();
        stress = 0;
    }

    /**
     * Method getChoice allows to ask the user for a character to choose
     * between options in a conversation
     *
     * @return choice an int that is the choice of the user
     */
//    public int PlayerChoice()
//    {
//        char character;
//        Scanner reader;
//        choice = 0;
//        reader = new Scanner(System.in);
//        character = reader.next().charAt(0);
//
//        while (character != '1' && character != '2' && character != 'q')
//        {
//            reader = new Scanner(System.in);
//            character = reader.next().charAt(0);
//        }
//
//        switch (character)
//        {
//            case '1':
//                choice = 1;
//                break;
//            case '2':
//                choice = 2;
//                break;
//            case 'q':
//                Interface.setDialog("ok no problem, we are quitting");
//                break;
//            default:
//                break;
//        }
//        return choice;
//    }
  
    public void setChoice(int playerChoice)
    {
        choice = playerChoice;
    }
    
    public int getChoice()
    {
        return choice; 
    }
    
    public int getStressDialogue()
    {
        return stress;
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
            Interface.setDialog(sentences.getListMainAxel(0));
            //add un keylistener sur la dialogue box pour pouvoir faire entrée pour appeler la suite

            //possible answers are printed and then the function getChoice is called to allow the user to chose an answer 
            Interface.setDialog("1: " + sentences.getListMainPlayerToAxel(0));
            Interface.setDialog("2: " + sentences.getListMainPlayerToAxel(1));
            choice = getChoice();

            if ((choice == 1) || (choice == 2))
            {
                Interface.setDialog(sentences.getListMainAxel(1));

                Interface.setDialog("1 :" + sentences.getListMainPlayerToAxel(2));
                Interface.setDialog("2 :" + sentences.getListMainPlayerToAxel(3));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainAxel(2));

                    Interface.setDialog("1 :" + sentences.getListMainPlayerToAxel(4));
                    Interface.setDialog("2 :" + sentences.getListMainPlayerToAxel(5));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainAxel(4));
                      
                        
                    } else if (choice == 2)
                    {
                        Interface.setDialog(sentences.getListMainAxel(5));
                        
                    }

                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainAxel(3));

                    Interface.setDialog("1 :" + sentences.getListMainPlayerToAxel(5));
                    Interface.setDialog("2 :" + sentences.getListMainPlayerToAxel(6));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainAxel(5));
                       
                    } else if (choice == 2)
                    {
                        Interface.setDialog(sentences.getListMainAxel(6));
                       
                    }
                }
            }
            else
            {
              Interface.setDialog("This choice does not exist");
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
        Interface.setDialog(sentences.getListMainMartin(0));
        Interface.setDialog("1 : " + sentences.getListMainPlayerToMartin(0));
        Interface.setDialog("2 : " + sentences.getListMainPlayerToMartin(1));
        choice = getChoice();

        if (choice == 1)
        {
            Interface.setDialog(sentences.getListMainMartin(1));
            Interface.setDialog("1 : " + sentences.getListMainPlayerToMartin(2));
            Interface.setDialog("2 : " + sentences.getListMainPlayerToMartin(3));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainMartin(3));
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainMartin(4));
            }

        } else if (choice == 2)
        {
            Interface.setDialog(sentences.getListMainMartin(2));
            Interface.setDialog("1 : " + sentences.getListMainPlayerToMartin(3));
            Interface.setDialog("2 : " + sentences.getListMainPlayerToMartin(4));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainMartin(4));
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainMartin(5));
            }
        }

        //you end up here in any case
        Interface.setDialog("1 : " + sentences.getListMainPlayerToMartin(5));
        Interface.setDialog("2 : " + sentences.getListMainPlayerToMartin(6));
        choice = getChoice();

        if (choice == 1)
        {
            Interface.setDialog(sentences.getListMainMartin(6));
        } else if (choice == 2)
        {
            Interface.setDialog(sentences.getListMainMartin(7));
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
        Interface.setDialog(sentences.getListMainNolan(0));
        Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(0));
        Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(1));
        choice = getChoice();

        if (choice == 1)
        {
            Interface.setDialog(sentences.getListMainNolan(3));
            Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(4));
            Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(5));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainNolan(4));
                Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(6));
                Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(7));
                choice = getChoice();

                //no need for a if because you end up in the same place, but we still give the choice to the player
                Interface.setDialog(sentences.getListMainNolan(6));
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainNolan(5));
                Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(8));
                Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(9));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainNolan(7));
                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainNolan(6));
                }

            }
        } else if (choice == 2)
        {
            Interface.setDialog(sentences.getListMainNolan(1));

            //add a point to the stress stat
            Interface.setDialog("Nolan knows you are here, you need to speak to him... your stress increases, be careful! ");
            stress++;

            Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(2));
            Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(3));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainNolan(3));
                Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(4));
                Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(5));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainNolan(4));
                    Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(6));
                    Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(7));
                    choice = getChoice();

                    //no need for a if because you end up in the same place, but we still give the choice to the player
                    Interface.setDialog(sentences.getListMainNolan(6));
                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainNolan(5));
                    Interface.setDialog("1 : " + sentences.getListMainPlayerToNolan(8));
                    Interface.setDialog("2 : " + sentences.getListMainPlayerToNolan(9));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainNolan(7));
                    } else if (choice == 2)
                    {
                        Interface.setDialog(sentences.getListMainNolan(6));
                    }
                }
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainNolan(2));
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
        Interface.setDialog(sentences.getListMainPGTD(0));
        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGTD(0));
        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGTD(1));
        choice = getChoice();

        if (choice == 1)
        {
            Interface.setDialog(sentences.getListMainPGTD(1));
            Interface.setDialog("1 : " + sentences.getListPlayerToMainPGTD(4));
            Interface.setDialog("2 : " + sentences.getListPlayerToMainPGTD(5));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainPGTD(6));
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainPGTD(5));
                //add a point to the stress stat
                Interface.setDialog("Maybe you should be more respectful with your teachers... Your stress is increasing be careful!");
                stress++;
            }
        } else if (choice == 2)
        {
            Interface.setDialog(sentences.getListMainPGTD(2));
            //add a point to the stress stat
            Interface.setDialog("Maybe you should be more respectful with your teachers... Your stress is increasing be careful!");
            stress++;

            Interface.setDialog("1 : " + sentences.getListPlayerToMainPGTD(2));
            Interface.setDialog("2 : " + sentences.getListPlayerToMainPGTD(3));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainPGTD(3));
                //leads to game over
                gameOver = true;
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainPGTD(4));
                Interface.setDialog(sentences.getListMainPGTD(1));
                Interface.setDialog("1 : " + sentences.getListPlayerToMainPGTD(4));
                Interface.setDialog("2 : " + sentences.getListPlayerToMainPGTD(5));
                choice = getChoice();
                
                if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainPGTD(6));
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainPGTD(5));
                //add a point to the stress stat
                Interface.setDialog("Maybe you should be more respectful with your teachers... Your stress is increasing be careful!");
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
        Interface.setDialog(sentences.getListMainMrsGeniet(0));
        Interface.setDialog("1 : " + sentences.getListMainPlayerToMrsGeniet(0));
        Interface.setDialog("2 : " + sentences.getListMainPlayerToMrsGeniet(1));
        choice = getChoice();

        if (choice == 1)
        {
            Interface.setDialog(sentences.getListMainMrsGeniet(1));
            Interface.setDialog("You got the key to Mrs Geniet's office! Be careful with it");
        } else if (choice == 2)
        {
            Interface.setDialog(sentences.getListMainMrsGeniet(2));
            //add a point to the stress stat
            Interface.setDialog("Mrs Geniet is not very  happy! Your stress is increasing be careful!");
            stress++;

            Interface.setDialog("1 : " + sentences.getListMainPlayerToMrsGeniet(2));
            Interface.setDialog("2 : " + sentences.getListMainPlayerToMrsGeniet(3));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainMrsGeniet(1)); //same as before because you end up in the same point
                Interface.setDialog("You got the key to Mrs Geniet's office! Be careful with it");
                
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainMrsGeniet(3));
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
        Interface.setDialog(sentences.getListMainGuardian(0));
        Interface.setDialog("1 : " + sentences.getListMainPlayerToGuardian(0));
        Interface.setDialog("2 : " + sentences.getListMainPlayerToGuardian(1));
        choice = getChoice();

        if (choice == 1)
        {
            Interface.setDialog(sentences.getListMainGuardian(1));
            Interface.setDialog("1 : " + sentences.getListMainPlayerToGuardian(2));
            Interface.setDialog("2 : " + sentences.getListMainPlayerToGuardian(3));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainGuardian(2));
                Interface.setDialog("1 : " + sentences.getListMainPlayerToGuardian(4));
                Interface.setDialog("2 : " + sentences.getListMainPlayerToGuardian(5));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainGuardian(4));
                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainGuardian(5));
                }
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainGuardian(3));
                Interface.setDialog("1 : " + sentences.getListMainPlayerToGuardian(4));
                Interface.setDialog("2 : " + sentences.getListMainPlayerToGuardian(5));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainGuardian(4));
                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainGuardian(5));
                }
            }
        } else if (choice == 2)
        {
            Interface.setDialog(sentences.getListMainGuardian(2));
            Interface.setDialog("1 : " + sentences.getListMainPlayerToGuardian(4));
            Interface.setDialog("2 : " + sentences.getListMainPlayerToGuardian(5));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainGuardian(4));
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainGuardian(5));
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
        Interface.setDialog(sentences.getListMainPGEnd(0));

        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(0));
        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(1));
        choice = getChoice();

        if (choice == 1)
        {
            Interface.setDialog(sentences.getListMainPGEnd(1));

            Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(2));
            Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(3));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainPGEnd(3));
                //leads to game over
                Interface.setDialog("OOOPS wrong answer! GAME OVER");
                gameOver = true;
            } else if (choice == 2)
            {
                Interface.setDialog(sentences.getListMainPGEnd(4));

                Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(8));
                Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(9));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(8));
                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(9));
                    //add a point to the stress stat
                    Interface.setDialog("You were a little bold there, bad choice! Your stress is increasing, be careful!");
                    stress++;
                }

                Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(10));
                Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(11));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(11));

                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(13));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(14));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(13));

                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(15));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(16));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(15));
                        } else if (choice == 2)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(16));
                            //add a stress point
                            Interface.setDialog("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        }

                    } else if (choice == 2)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(14));

                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(16));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(17));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(16));
                            //add a stress point
                            Interface.setDialog("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        } else if (choice == 2)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(17));
                        }
                    }

                    //no matter what you chose, you end up at the same point so no need to put that in the if                        
                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(18));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(19));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(18));
                        //add a stress point
                        Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    Interface.setDialog(sentences.getListMainPGEnd(19));
                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(20));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(21));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(20));
                        //add a stress point
                        Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    Interface.setDialog(sentences.getListMainPGEnd(21));
                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(22));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(23));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(22));
                        //add a stress point
                        Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    Interface.setDialog(sentences.getListMainPGEnd(23));
                    //End of the game
                    Interface.setDialog(sentences.getListMainPGEnd(24));

                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(10));
                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(10));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(12));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        //crossing other part of the conversation                        

                        Interface.setDialog(sentences.getListMainPGEnd(11));
                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(13));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(14));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(13));

                            Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(15));
                            Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(16));
                            choice = getChoice();

                            if (choice == 1)
                            {
                                Interface.setDialog(sentences.getListMainPGEnd(15));
                            } else if (choice == 2)
                            {
                                Interface.setDialog(sentences.getListMainPGEnd(16));
                                //add a stress point
                                Interface.setDialog("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                                stress++;
                            }

                        } else if (choice == 2)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(14));

                            Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(16));
                            Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(17));
                            choice = getChoice();

                            if (choice == 1)
                            {
                                Interface.setDialog(sentences.getListMainPGEnd(16));
                                //add a stress point
                                Interface.setDialog("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                                stress++;
                            } else if (choice == 2)
                            {
                                Interface.setDialog(sentences.getListMainPGEnd(17));
                            }
                        }

                        //no matter what you chose, you end up at the same point so no need to put that in the if                        
                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(18));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(19));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(18));
                            //add a stress point
                            Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                            stress++;
                        }
                        //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                        Interface.setDialog(sentences.getListMainPGEnd(19));
                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(20));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(21));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(20));
                            //add a stress point
                            Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                            stress++;
                        }
                        //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                        Interface.setDialog(sentences.getListMainPGEnd(21));
                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(22));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(23));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(22));
                            //add a stress point
                            Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                            stress++;
                        }
                        //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                        Interface.setDialog(sentences.getListMainPGEnd(23));
                        //End of the game
                        Interface.setDialog(sentences.getListMainPGEnd(24));

                    } else if (choice == 2)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(12));
                        //leads to game over
                        gameOver = true;
                    }
                }
            }
        } else if (choice == 2)
        {
            Interface.setDialog(sentences.getListMainPGEnd(2));
            //adding a point to the stress stat
            Interface.setDialog("Your heart is suddendly beating really fast... Your stress increase, be careful!"); //à mettre en italique maybe pour différencier du dialogue
            stress++;

            Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(4));
            Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(5));
            choice = getChoice();

            if (choice == 1)
            {
                Interface.setDialog(sentences.getListMainPGEnd(4)); //crossing with the other part
                Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(8));
                Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(9));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(8));
                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(9));
                    //add a point to the stress stat
                    Interface.setDialog("You were a little bold there, bad choice! Your stress is increasing, be careful!");
                    stress++;
                }

                Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(10));
                Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(11));
                choice = getChoice();

                if (choice == 1)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(11));

                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(13));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(14));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(13));

                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(15));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(16));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(15));
                        } else if (choice == 2)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(16));
                            //add a stress point
                            Interface.setDialog("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        }

                    } else if (choice == 2)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(14));

                        Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(16));
                        Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(17));
                        choice = getChoice();

                        if (choice == 1)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(16));
                            //add a stress point
                            Interface.setDialog("Well, trying to be mean to your coworkers is not a safe move... Your stress is increasing, be careful!");
                            stress++;
                        } else if (choice == 2)
                        {
                            Interface.setDialog(sentences.getListMainPGEnd(17));
                        }
                    }

                    //no matter what you chose, you end up at the same point so no need to put that in the if                        
                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(18));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(19));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(18));
                        //add a stress point
                        Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    Interface.setDialog(sentences.getListMainPGEnd(19));
                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(20));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(21));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(20));
                        //add a stress point
                        Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    Interface.setDialog(sentences.getListMainPGEnd(21));
                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(22));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(23));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(22));
                        //add a stress point
                        Interface.setDialog("That is not the good answer, you do not want to disappoint PG! You are getting stressed!");
                        stress++;
                    }
                    //same, you end up here anyway, the first choice just gives you another sentence and stress issues
                    Interface.setDialog(sentences.getListMainPGEnd(23));
                    //End of the game
                    Interface.setDialog(sentences.getListMainPGEnd(24));

                } else if (choice == 2)
                {
                    Interface.setDialog(sentences.getListMainPGEnd(5));

                    Interface.setDialog("1 : " + sentences.getListPlayerToMainPGEnd(6));
                    Interface.setDialog("2 : " + sentences.getListPlayerToMainPGEnd(7));
                    choice = getChoice();

                    if (choice == 1)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(6));
                        //leads to game over
                        gameOver = true;
                    } else if (choice == 2)
                    {
                        Interface.setDialog(sentences.getListMainPGEnd(7));
                        //leads to game over
                        gameOver = true;
                    }
                }
            }
        }
    }
}
