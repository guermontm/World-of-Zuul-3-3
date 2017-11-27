
/**
 * This class inherits from player and represents a player of the third type
 * It means that the attributes are initialised with specific values
 *
 * @author (Group 5)
 * @version (09/11/17)
 */
public class TypeThree extends Player
{
    boolean lucky; // if the bool is true, the player is lucky and find more coins
    
    /**
     * Constructor for objects of class TypeThree
     * This method gives the specific values of the different attributes 
     */
    public TypeThree()
    {
        lucky = true;
        setStr(4);
        setSpe(4);
        setInt(4);
        setSta(4);
        setStress(4);
    }
    
    public boolean getLucky () 
    {
        return lucky;   
    }
}
