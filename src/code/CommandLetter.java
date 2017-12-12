package code;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class take a character and check if this character is one the accept command.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommandLetter
{
    // 
    private char commandChar;
    // source of command input
    private Scanner reader;  
    // a constant array that holds all valid command words
    private static final char[] validCommands = {'n','N','s','S','e','E','w','W','h','H','q','Q'};
    private boolean isValid = false;

    /**
     * Constructor for objects of class CommandLetter
     */
    public CommandLetter()
    {
        reader = new Scanner(System.in);
        reader.useDelimiter("");        
    }

    /**
     * Method readCommand allows checking if the character enter is a command or not 
     *
     * @return a char that can be the command letter or an error message ("!") 
     */
    public char readCommand()
    {
        char commandChar = reader.next().charAt(0);


        for(int i = 0; i < validCommands.length; i++) 
        {
            if(validCommands[i] == commandChar)
            {
                isValid = true;
            }
        }
        if (isValid==true)
        {
            return(commandChar); 
        }
        else
        {
            return('!');
        }
    }

    public boolean getValid()
    {
        return isValid;
    }
}
