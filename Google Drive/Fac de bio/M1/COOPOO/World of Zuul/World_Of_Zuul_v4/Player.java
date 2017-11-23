
/**
 * This is the mother class for players. 
 * Three types of players are available and (3 classes which inherit from this class).
 *
 * @author (Group 5)
 * @version (09/11/17)
 */
abstract class Player
{
    private int strStat; // strength statistic for the player, range between 1 and 10
    private int speStat; // speech statistic for the player, range between 1 and 10
    private int intStat; // intelligence stat for the player, range between 1 and 10
    private int staStat; // stamina stat for the player, range between 1 and 10
    private int stressStat; // stress stat for the player, range between 1 and 10
    private int money; // money of the player (>0)
    private boolean crowbar; // if the player has the crowbar or not. Starts as false

    /**
     * Constructor for objects of class Player
     * A player has some points for the stat and they are not the same for all the player
     */
    public Player()
    {
        crowbar = false;
        money = 4;
    }

    public int getStrStat ()
    {
        return strStat;
    }
    
    public int getSpeStat ()
    {
        return speStat;
    }
    
    public int getIntStat ()
    {
        return intStat;
    }
    
    public int getStaStat ()
    {
        return staStat;
    }
    
    public int getStressStat ()
    {
        return stressStat;
    }
    
    public int getMoney ()
    {
        return money;
    }
    
    public boolean getCrowbar ()
    {
        return crowbar;
    }
    
    public void setStr (int str)
    {
        strStat = str;
    }
    
    public void setSpe (int spe)
    {
        speStat = spe;
    }
    
    public void setInt (int attint)
    {
        intStat = attint;
    }
    
    public void setSta (int sta)
    {
        staStat = sta;
    }
    
    public void setStress (int stress)
    {
        stressStat = stress;
    }
    
    public void setMoney (int money)
    {
       this.money = money;
    }
    
    public void setCrowbar (boolean bool)
    {
       crowbar = bool;
    }
    
    public void addMoney (int cash)
    {
       money = money + cash;
    }
    
    public void substractMoney (int cash)
    {
       money = money - cash;
    }
    
    public void addStat (String whatStat, int value)
    {
         switch(whatStat) {
             case"strStat":
             setStr(getStrStat() + value);
             break;
             
             case"speStat":
             setSpe(getSpeStat() + value);
             break;
             
             case"staStat":
             setSta(getStaStat() + value);
             break;
             
             case"stressStat":
             setStress(getStressStat() + value);
             break;
             
             case"intStat":
             setInt(getIntStat() + value);
             break;
             default: System.out.print("Not possible");
            }
    }

    public void substractStat (String whatStat, int value)
    {
         switch(whatStat) {
             
             case"strStat":
             if (getStrStat() > 0) 
             {
             setStr(getStrStat() - value);
             }
             break;
             
             case"speStat":
            if (getSpeStat() > 0) 
            {
             setSpe(getSpeStat() - value);
            }
             break;
             
             case"staStat":
            if (getStaStat() > 0) 
            {
             setSta(getStaStat() - value);
            }
             break;
             
             case"stressStat":
             if (getStressStat() > 0) 
             {
             setStress(getStressStat() - value);
             }
             break;
             
             case"intStat":
             if (getIntStat() > 0) 
            {
             setInt(getIntStat() - value);
            }
             break;
             default: System.out.print("Not possible");
            }
    }
}
