package code;


/**
 * This is the mother class for players. 
 * Three types of players are available and (3 classes which inherit from this class).
 *
 * @author (Group 5)
 * @version (09/11/17)
 */
abstract class Player
{
    private String name;
    private int strStat; // strength statistic for the player, range between 1 and 10
    private int speStat; // speech statistic for the player, range between 1 and 10
    private int intStat; // intelligence stat for the player, range between 1 and 10
    private int staStat; // stamina stat for the player, range between 1 and 10
    private int stressStat; // stress stat for the player, range between 1 and 10
    private int money; // money of the player (>0)
    private boolean crowbar; // if the player has the crowbar or not. Starts at false
    private boolean keyAnnie; //a key for the office of Mrs Geniet, starts at false.

    /**
     * Constructor for objects of class Player
     * A player has some points for the stat and they are not the same for all the player
     */
    public Player()
    {
        crowbar = false;
        keyAnnie = false;
        money = 4;
    }

    /**
     * getNamePlayer Method, allowing to return the name of the player
     * @return the String name, being the name of the player
     */
    public String getNamePlayer ()
    {
      return name;   
    }
    
    /**
     * setNamePlayer Method, allowing to set the name of the player with a new name
     * @param the String newName, being the new name of the player
     */
    public void setNamePlayer (String newName)
    {
        name = newName;
    }
    
    /**
     * getStrStat Method, allowing to return the strength value of the player
     * @return the integer strStat, being the strength of the player
     */
    public int getStrStat ()
    {
        return strStat;
    }
    
    /**
     * getSpeStat Method, allowing to return the speech value of the player
     * @return the integer speStat, being the speech of the player
     */
    public int getSpeStat ()
    {
        return speStat;
    }
    
    /**
     * getIntStat Method, allowing to return the intelligence value of the player
     * @return the integer intStat, being the intelligence of the player
     */
    public int getIntStat ()
    {
        return intStat;
    }
    
    /**
     * getStaStat Method, allowing to return the stamina value of the player
     * @return the integer staStat, being the stamina value of the player
     */
    public int getStaStat ()
    {
        return staStat;
    }
    
    /**
     * getStressStat Method, allowing to return the stress value of the player
     * @return the integer stressStat, being the stress of the player
     */
    public int getStressStat ()
    {
        return stressStat;
    }
    
    /**
     * getMoney Method, allowing to return the money value of the player
     * @return the integer money, being the money value of the player
     */
    public int getMoney ()
    {
        return money;
    }
    
    /**
     * getCrowbar Method, allowing to return the boolean value of the player.
     * If true, the player is owning a crowbar.
     * @return the boolean crowbar
     */
    public boolean getCrowbar ()
    {
        return crowbar;
    }
    
    /**
     * getKeyAnnie Method, allowing to return the boolean value of the player.
     * If true, the player is owning the key of the Annie's office.
     * @return the boolean keyAnnie
     */
    public boolean getKeyAnnie()
    {
        return keyAnnie;
    }
    

    
    /**
     * setStr Method, allowing to set the strength of the player with a new value
     * @param str integer, being the new value for the player stat.
     */
    public void setStr (int str)
    {
        strStat = str;
    }
    
    /**
     * setSpe Method, allowing to set the speech of the player with a new value
     * @param spe integer, being the new value for the player stat.
     */
    public void setSpe (int spe)
    {
        speStat = spe;
    }
    
    /**
     * setInt Method, allowing to set the intelligence of the player with a new value
     * @param attint integer, being the new value for the player stat.
     */
    public void setInt (int attint)
    {
        intStat = attint;
    }
    
    /**
     * setSta Method, allowing to set the stamina of the player with a new value
     * @param sta integer, being the new value for the player stat.
     */
    public void setSta (int sta)
    {
        staStat = sta;
    }
    
    /**
     * setStress Method, allowing to set the stress of the player with a new value
     * @param stress integer, being the new value for the player stat.
     */
    public void setStress (int stress)
    {
        stressStat = stress;
    }
    
    /**
     * setMoney Method, allowing to set money of the player with a new value
     * @param money integer, being the new value for the player stat.
     */
    public void setMoney (int money)
    {
       this.money = money;
    }
    
    /**
     * setCrowbar Method, allowing to set the boolean crowbar of the player with a new value
     * @param bool integer, being the new value for the player stat.
     */
    public void setCrowbar (boolean bool)
    {
       crowbar = bool;
    }
    
    /**
     * setKeyAnnie Method, allowing to set the boolean keyAnnie of the player with a new value
     * @param bool integer, being the new value for the player stat.
     */
    public void setKeyAnnie(boolean bool)
    {
        keyAnnie = bool;
    }
    
    
    /**
     * addMoney Method, allowing to add a cash value to the current money of the player.
     * @param cash integer, being the value added to the current money.
     */
    public void addMoney (int cash)
    {
       money = money + cash;
    }
    
    /**
     * substractMoney Method, allowing to substract a cash value to the current money of the player.
     * @param cash integer, being the value removed to the current money.
     */
    public void substractMoney (int cash)
    {
       money = money - cash;
    }
    
    /**
     * addStat Method, allowing to add a value for a current whatStat stat.
     * @param whatStat String, being the stat to increase ; value integer, being
     * the value to add to the stat.
     */
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

    /**
     * substractStat Method, allowing to substract a value for a current 
     * whatStat stat.
     * @param whatStat String, being the stat to decrease ; value integer, being
     * the value to substract to the stat.
     */
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
