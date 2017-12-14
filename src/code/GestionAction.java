package code;  

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import code.Game;

/**
 * GestionAction class
 *Allows to choose the character on the character selection screen by actionEvents
 * Allows to select the character choose by clicking.
 * @author (Grp5)
 * @version (14/12/2017)
 */
public class GestionAction implements ActionListener {

    private final InterfaceBegin wint;
    private final String background;
    private final JOptionPane optionPane = new JOptionPane();
    private int option;
    private int playerChoice; //choice of the player
    private JOptionPane jopQuit;
    private Interface gui; 

    /**
     * Constructor for objects of class GestionAction
     * @param w the InterfaceBegin Object
     * @param b a String
     */
    public GestionAction(InterfaceBegin w, String b) {
        wint = w;
        background = b;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (null != background) switch (background) {
            case "start":
                wint.Interface_ChoosePlayer();
                break;
            case "quit":
                option = JOptionPane.showConfirmDialog(null, "Are you sure to quit ?",
                        "Oh noooooooooooooooo !",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION
                        && option != JOptionPane.CLOSED_OPTION) {
                    System.exit(0);
                }   break;
            case "player1":{
                //Interface.mainInterface(); // launch main interface
                playerChoice = 1;
                System.out.println("Player Choice");
                gui = new Interface(playerChoice, wint);
                
//                int force = game.getPlayer().getStrStat();
//                wint.setLabelForce(force);
//                int intelligence = game.getPlayer().getIntStat();
//                wint.setLabelIntelligence(intelligence);
//                int eloquence = game.getPlayer().getSpeStat();
//                wint.setLabelEloquence(eloquence);
//                wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
                    break;
                }
            case "player2":{
                //wint.mainInterface(); // launch main interface
                playerChoice = 2;
                System.out.println("Player Choice");
                gui = new Interface(playerChoice, wint);
//                int force = game.getPlayer().getStrStat();
//                wint.setLabelForce(force);
//                int intelligence = game.getPlayer().getIntStat();
//                wint.setLabelIntelligence(intelligence);
//                int eloquence = game.getPlayer().getSpeStat();
//                wint.setLabelEloquence(eloquence);
//                wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
                break;
                }
            case "player3":{
                //wint.mainInterface(); // launch main interface
                playerChoice = 3;
                System.out.println("Player Choice");
                gui = new Interface(playerChoice, wint);
                
//                System.out.println("force" + game.getPlayer().getStrStat());
//                int force = game.getPlayer().getStrStat();
//                wint.setLabelForce(force);
//                int intelligence = game.getPlayer().getIntStat();
//                wint.setLabelIntelligence(intelligence);
//                int eloquence = game.getPlayer().getSpeStat();
//                wint.setLabelEloquence(eloquence);
//                wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
               
              break;
                }
            default:
                break;
        }
        
    }
}
