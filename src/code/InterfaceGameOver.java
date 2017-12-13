/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Adèle
 */
public class InterfaceGameOver extends JFrame {
    //***************************Welcome interface******************************

    private final JButton myButtonStart;
    private final JButton myButtonQuit;
    private final JLabel myLabel2;
    private final JPanel myPanel1;
    protected JFrame myFrameGameOver;
    private Main main; 


    public InterfaceGameOver() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Game game peut etre en parametre du constructeur de l'interface sauf qu'on a besoin de game = new Game (1) dans GestionAction
        //*************************************WELCOME INTERFACE***************************************************************
        myFrameGameOver = new JFrame("Game Over");
        myFrameGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel1 = new JPanel();
        myLabel2 = new JLabel();
        myLabel2.setIcon(new ImageIcon(this.getClass().getResource("images/game_over.png")));
        myLabel2.setPreferredSize(new Dimension(809, 471));
        myPanel1.add(myLabel2);

        myButtonStart = new JButton();
        myButtonStart.setIcon(new ImageIcon(this.getClass().getResource("images/new_game.png")));
        myButtonStart.setPreferredSize(new Dimension(810, 100));
        myButtonQuit = new JButton();
        myButtonQuit.setIcon(new ImageIcon(this.getClass().getResource("images/quit.jpg")));
        myButtonQuit.setPreferredSize(new Dimension(810, 100));

        myPanel1.setLayout(new BorderLayout());
        myPanel1.add(myLabel2, BorderLayout.NORTH);
        myPanel1.add(myButtonStart, BorderLayout.CENTER);

        myPanel1.add(myButtonQuit, BorderLayout.SOUTH);

        myButtonStart.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                    main = new Main();
                }
            }
        );
        myButtonQuit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int option = JOptionPane.showConfirmDialog(null, "Are you sure to quit ?",
                        "Oh noooooooooooooooo !",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option != JOptionPane.NO_OPTION
                        && option != JOptionPane.CLOSED_OPTION) {
                    System.exit(0);
                }
            }
        }
        );

        myFrameGameOver.add(myPanel1);
        myFrameGameOver.setVisible(true);
        myFrameGameOver.pack();
    }
}