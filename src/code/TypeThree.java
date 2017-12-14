package code;


/**
 * This class inherits from player and represents a player of the third type
 * It means that the attributes are initialised with specific values.
 * This player is named Elie and owns a special power : "lucky". This power can be activated or disabled.
 * If "lucky" is on, the player is more likely to find coins.
 *
 * @author (Group 5)
 * @version (09/11/17)
 */
public class TypeThree extends Player
{
    boolean lucky; // if the boolean is true, the player is lucky and find more coinss
    
    /**
     * Constructor for objects of class TypeThree
     * This method gives the specific values of the different attributes 
     * The player has also a lucky boolean.
     */
    public TypeThree()
    {
        setNamePlayer("Luc");
        lucky = true;
        setStr(4);
        setSpe(4);
        setInt(4);
        setSta(4);
        setStress(4);
    }
    
    /**
     * Method getLucky allowing to return the boolean lucky
     *
     * @return the boolean lucky
     */
    public boolean getLucky () 
    {
        return lucky;   
    }
}
