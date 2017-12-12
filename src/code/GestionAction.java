package code;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import code.Game;

/**
 * Write a description of class GestionMouse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestionAction implements ActionListener {

    private Interface wint;
    private String background;
    private JOptionPane optionPane = new JOptionPane();
    private int option;
    private int force;

    private JOptionPane jopQuit;
    private Game game;

    /**
     * Constructor for objects of class GestionMouse
     */
    public GestionAction(Game g, Interface w, String b) {
        wint = w;
        background = b;
        game = g;
    }

    public void actionPerformed(ActionEvent ae) {
        if (background == "start") {
            wint.Interface_ChoosePlayer();
        } else if (background == "quit") {
            option = optionPane.showConfirmDialog(null, "Are you sure to quit ?",
                    "Oh noooooooooooooooo !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION
                    && option != JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            } else {
                wint.Interface_ChoosePlayer();
            }
        } else if (background == "player1") {
            game.choosePlayer(1);
            wint.mainInterface(); // lance l'interface main
            int force = game.getPlayer().getStrStat();
            wint.setLabelForce(force);
            int intelligence = game.getPlayer().getIntStat();
            wint.setLabelIntelligence(intelligence);
            int eloquence = game.getPlayer().getSpeStat();
            wint.setLabelEloquence(eloquence);
            wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
        } else if (background == "player2") {
            wint.mainInterface(); // lance l'interface main
            int force = game.getPlayer().getStrStat();
            wint.setLabelForce(force);
            int intelligence = game.getPlayer().getIntStat();
            wint.setLabelIntelligence(intelligence);
            int eloquence = game.getPlayer().getSpeStat();
            wint.setLabelEloquence(eloquence);
            wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
        } else if (background == "player3") {
            wint.mainInterface(); // lance l'interface main
            int force = game.getPlayer().getStrStat();
            wint.setLabelForce(force);
            int intelligence = game.getPlayer().getIntStat();
            wint.setLabelIntelligence(intelligence);
            int eloquence = game.getPlayer().getSpeStat();
            wint.setLabelEloquence(eloquence);
            wint.setDialog("Good choice ! You play with " + game.getPlayer().getNamePlayer() + "! You can see the points at the left or right of the screen");
        }
        game.play();
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
