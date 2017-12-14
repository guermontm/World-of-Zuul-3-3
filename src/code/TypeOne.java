package code;
/**
 * This class inherits from player and represents a player of the first type
 * It means that the attributes are initialised with specific values
 *
 * @author (Group 5)
 * @version (09/11/17)
 */
public class TypeOne extends Player 
{
    /**
     * Constructor for objects of class TypeOne
     * This method gives the specific values of the different attributes 
     */
    public TypeOne()
    {
        setNamePlayer("Pierrot");
        setStr(6);
        setSpe(6);
        setInt(6);
        setSta(6);
        setStress(6);
    }
}
