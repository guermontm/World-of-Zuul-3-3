import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task extends TimerTask 
{
    TypeOne myPlayerOne = new TypeOne();
    // instance variables - replace the example below with your own
    public void run()
          {
              while(myPlayerOne.getIntStat()>0)
              {
                   System.out.println("Debut execution tache ");
                   String statToModify = "intStat";
                   myPlayerOne.substractStat(statToModify, 1);
                   System.out.println ("You lost 1 point of intelligence so you have " +myPlayerOne.getIntStat()+ " points of intelligence");
                   System.out.println("Fin execution tache ");
                   
                   try
                   {Thread.currentThread().sleep(5000);} // the player looses 1 point every 5 msec
                   catch (InterruptedException ie)
                   {ie.printStackTrace();}
                   TestTimer.mytimer.cancel();
              }
          }
}
