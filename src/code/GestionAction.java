package code;  

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import code.Game;

/**
 * Write a description of class GestionMouse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestionAction implements ActionListener {

    private final Interface wint;
    private final String background;
    private final JOptionPane optionPane = new JOptionPane();
    private int option;
    private int playerChoice;
    private JOptionPane jopQuit;
    private final Game game;

    /**
     * Constructor for objects of class GestionMouse
     * @param g
     * @param w
     * @param b
     */
    public GestionAction(Game g, Interface w, String b) {
        wint = w;
        background = b;
        game = g;
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
                wint.mainInterface(); // lance l'interface main
                playerChoice = 1;
                System.out.println("Player Choice");
                game.play(playerChoice);
                int force = game.getPlayer().getStrStat();
                wint.setLabelForce(force);
                int intelligence = game.getPlayer().getIntStat();
                wint.setLabelIntelligence(intelligence);
                int eloquence = game.getPlayer().getSpeStat();
                wint.setLabelEloquence(eloquence);
                wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
                    break;
                }
            case "player2":{
                wint.mainInterface(); // lance l'interface main
                playerChoice = 2;
                System.out.println("Player Choice");
                game.play(playerChoice);
                int force = game.getPlayer().getStrStat();
                wint.setLabelForce(force);
                int intelligence = game.getPlayer().getIntStat();
                wint.setLabelIntelligence(intelligence);
                int eloquence = game.getPlayer().getSpeStat();
                wint.setLabelEloquence(eloquence);
                wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
                break;
                }
            case "player3":{
                wint.mainInterface(); // lance l'interface main
                playerChoice = 3;
                System.out.println("Player Choice");
                game.play(playerChoice);
                System.out.println("force" + game.getPlayer().getStrStat());
                int force = game.getPlayer().getStrStat();
                wint.setLabelForce(force);
                int intelligence = game.getPlayer().getIntStat();
                wint.setLabelIntelligence(intelligence);
                int eloquence = game.getPlayer().getSpeStat();
                wint.setLabelEloquence(eloquence);
                wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
                
                break;
                }
            default:
                break;
        }
        
    }

    // public void actionPerformed2 (ActionEvent e)
    // {
    // changeSalle(game.getPlayer().getCurrentRoom().getImageRoom());
    // wint.majInventaire ();
    // wint.dialogBox.setText(game.printWelcome());
    // }
    // public void actionPerformed3 (ActionEvent e)
    // {
    // game.processCommand(new Command("go","east"));
    // }
    // public void actionPerformed4 (ActionEvent e)
    // {
    // game.processCommand(new Command("go","west")); 
    // }
    // public void actionPerformed5 (ActionEvent e)
    // {
    // game.processCommand(new Command("go","north")); 
    // }
    // public void actionPerformed6 (ActionEvent e)
    // {
    // game.processCommand(new Command("go","south")); 
    // }
    // public void actionPerformed7 (ActionEvent e)
    // {
    // game.processCommand(new Command("look", null)); 
    // }
    // public void actionPerformed8 (ActionEvent e)
    // {
    // game.processCommand(new Command("pickup", null)); 
    // }
    // public void actionPerformed9 (ActionEvent e)
    // {
    // game.processCommand(new Command("usePotion", null)); 
    // }
    // public void actionPerformed10 (ActionEvent e)
    // {
    // //Boï¿½te du message d'information
    // jopQuit = new JOptionPane();
    // JOptionPane.showMessageDialog(null, "Thanks, see you later !", "Information", JOptionPane.INFORMATION_MESSAGE);
    // System.exit(0);
    // }
}