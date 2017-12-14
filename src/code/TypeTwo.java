package code;


/**
 * This class inherits from player and represents a player of the second type
 * It means that the attributes are initialised with specific values
 *
 * @author (Group 5)
 * @version (09/11/17)
 */
public class TypeTwo extends Player
{
    boolean furtif; // if the boolean is true, the player does not have the randomEvents when he goes in the different rooms
    
    /**
     * Constructor for objects of class TypeTwo
     * This method gives the specific values of the different attributes
     */
    public TypeTwo()
    {
        setNamePlayer("Elie");
        furtif = true;
        setStr(5);
        setSpe(5);
        setInt(5);
        setSta(1);
        setStress(9);
    }
    
    public boolean getFurtif()
    {
        return furtif;    
    }
}
