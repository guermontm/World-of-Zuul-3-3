/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Adèlounette
 */
public Interface_BeginGame implements Interface {
       //***************************Welcome interface******************************
    private JButton myButtonStart;   
    private JButton myButtonQuit;
    private JLabel myLabel1, myLabel2, myLabel3;
    private JPanel myPanel1, myPanel2, myPanel3, myPanel4;
    private JFrame myFrameWelcome;
    
    //*********************CHOOSE PLAYER*****************************************
    private JLabel playerInterface; 
    private JButton player1Button, player2Button, player3Button; 
    private JLabel messageLabel; 
    private JPanel mainPanel, panelCenterText, panelChoicePlayer; 
    private JFrame myFrameChoosePlayer;
      public void Interface() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // Game game peut etre en parametre du constructeur de l'interface sauf qu'on a besoin de game = new Game (1) dans GestionAction
       //*************************************WELCOME INTERFACE***************************************************************
       myFrameWelcome = new JFrame("Welcome");
       myFrameWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
       myPanel1 = new JPanel();
       myLabel2 = new JLabel ();
       myLabel2.setIcon(new ImageIcon("images/welcome_test.png")); 
       myLabel2.setPreferredSize(new Dimension(809,471));
       myPanel1.add(myLabel2);
       
        myButtonStart = new JButton();
        myButtonStart.setIcon(new ImageIcon("images/play.jpg")); 
        myButtonStart.setPreferredSize(new Dimension(810,100));
        myButtonQuit = new JButton();
        myButtonQuit.setIcon(new ImageIcon("images/quit.jpg")); 
        myButtonQuit.setPreferredSize(new Dimension(810,100));

       myPanel1.setLayout(new BorderLayout());
       myPanel1.add(myLabel2, BorderLayout.NORTH);
       myPanel1.add(myButtonStart, BorderLayout.CENTER);
        
       myPanel1.add(myButtonQuit, BorderLayout.SOUTH);
        
       myButtonStart.addActionListener(new GestionAction(g, this, "start"));
       myButtonQuit.addActionListener(new GestionAction(g, this, "quit"));  
         
        myFrameWelcome.add(myPanel1);
        myFrameWelcome.setVisible(true);
        myFrameWelcome.pack();
    }

    public void Interface_ChoosePlayer() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // Fermeture de l'interface chooseplayer
        myFrameChoosePlayer = myFrameWelcome;
        
        myPanel1.removeAll();
        myFrameChoosePlayer.setVisible(true);
        myFrameChoosePlayer.pack();
        myFrameChoosePlayer.setSize(700,700);
        
        // Initialization of the panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        panelCenterText = new JPanel();
        panelChoicePlayer = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        panelChoicePlayer.setLayout(new GridLayout(0,3));
        
        // Initialization of the labels
        messageLabel = new JLabel(new ImageIcon("images/intro_v5.gif"));
        //Instanciation of the button 
        player1Button = new JButton();
        player1Button.setIcon(new ImageIcon("images/pierre.png")); 
        player1Button.setPreferredSize(new Dimension(225,300));
        player1Button.setBackground(Color.WHITE);
        
        player2Button = new JButton();
        player2Button.setIcon(new ImageIcon("images/elie.png")); 
        player2Button.setPreferredSize(new Dimension(225,300));
        player2Button.setBackground(Color.WHITE);
        
        player3Button = new JButton();
        player3Button.setIcon(new ImageIcon("images/luc.png")); 
        player3Button.setPreferredSize(new Dimension(225,300));
        player3Button.setBackground(Color.WHITE);
        
        panelChoicePlayer.add(player1Button);
        panelChoicePlayer.add(player2Button);
        panelChoicePlayer.add(player3Button);

        mainPanel.add(messageLabel, BorderLayout.CENTER);
        mainPanel.add(panelChoicePlayer, BorderLayout.SOUTH);
                
        player1Button.addActionListener(new GestionAction(g,this, "player1"));
        player2Button.addActionListener(new GestionAction(g,this, "player2")); 
        player3Button.addActionListener(new GestionAction(g,this, "player3")); 
        
        myFrameChoosePlayer.add(mainPanel);
    }
}
