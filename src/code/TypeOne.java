package code;


import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * This class inherits from player and represents a player of the first type
 * It means that the attributes are initialised with specific values
 *
 * @author (Group 5)
 * @version (09/11/17)
 */
public class TypeOne extends Player 
{
    GregorianCalendar myCalendar;
    Date myDate;

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

    public void recupHour ()
    {
        myCalendar = new GregorianCalendar();
        int myHour  = myCalendar.get(java.util.Calendar.HOUR_OF_DAY);
        int myMinute  = myCalendar.get(java.util.Calendar.MINUTE);
        System.out.println("Il est: "+ myHour + "H et" + myMinute + "min");
    }

    
}