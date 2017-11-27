import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Write a description of class testfortimer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TestTimer
{
    GregorianCalendar myCalendar;
    static Timer mytimer = new Timer();
    Date myDate;

    public void recupHour ()
    {
        myCalendar = new GregorianCalendar();
        int myHour  = myCalendar.get(java.util.Calendar.HOUR_OF_DAY);
        int myMinute  = myCalendar.get(java.util.Calendar.MINUTE);
        System.out.println("Il est: "+ myHour + "H et" + myMinute + "min");
    }
    
    public void main() // la tache est d'enlever 1 point au player 
    {
        TimerTask theTask = new Task();
        mytimer.schedule(theTask,new Date()); // the task has to be executed now

    }
}
