/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends JFrame  {
    //***************************Welcome interface******************************

    private JButton myButtonStart;
    private JButton myButtonQuit;
    private JLabel myLabel1, myLabel2, myLabel3;
    private JPanel myPanel1, myPanel2, myPanel3, myPanel4;
    protected JFrame myFrameWelcome;

    //*********************CHOOSE PLAYER*****************************************
    private JLabel playerInterface;
    private JButton player1Button, player2Button, player3Button;
    private JLabel messageLabel;
    private JPanel mainPanel, panelCenterText, panelChoicePlayer;
    private JFrame myFrameChoosePlayer;

    //****************MAIN INTERFACE************************************
    //Declarations
    private JFrame myMainFrame = new JFrame("World of Zuul");

    private Container myContainer = myMainFrame.getContentPane();
    //Label
    private JLabel myCommand = new JLabel();
    private JLabel myGame = new JLabel();
    private JLabel myDialogBox = new JLabel();
    private JLabel myJauge = new JLabel(new ImageIcon("images/fond_crepi_jauge.png"));
    private JLabel myAction = new JLabel();
    private JLabel myHelpQuit = new JLabel();

    //****************** ECRAN DE GAUCHE voir ligne 240*********************
    private JLabel forceLabel;
    private JLabel intelligenceLabel;
    private JLabel eloquenceLabel;
    private JLabel forceStatLabel; //= new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player 
    private JLabel intelligenceStatLabel; // = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player
    private JLabel eloquenceStatLabel; // = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player    
    private JPanel myStatsPanel = new JPanel();

    // ************** ECRAN DE DROITE voir ligne 290-300**********************
    private JLabel displayBarreVie = new JLabel(new ImageIcon("images/Pv_100v.png"), JLabel.CENTER); //health displaying in image format
    private JLabel displayBarreStress = new JLabel(new ImageIcon("images/Pv_0_stress.png"), JLabel.CENTER);

    //Button game
    private JButton btnHaut = new JButton(new ImageIcon("images/hand_up.png"));
    private JButton btnBas = new JButton(new ImageIcon("images/hand_down.png"));
    private JButton btnDroite = new JButton(new ImageIcon("images/hand_right.png"));
    private JButton btnGauche = new JButton(new ImageIcon("images/hand_left.png"));
    private JButton btnRamasser = new JButton(new ImageIcon("images/interaction.png"));
    private JButton btnHelp = new JButton(new ImageIcon("images/help2.png"));
    private JButton btnQuit = new JButton(new ImageIcon("images/quit2.png"));
    private JButton btnPower = new JButton(new ImageIcon("images/pouvoirs.png"));

    //private JOptionPane jopQuit;
    private Player player1;

    //Textfield for the dialog box which display information to the player and allow him to interact with the game
    private static TextArea dialogBox = new TextArea("Welcome to the World of GPhy! \n \n The goal is simple : finish the COOPOO project before living the University\n You can interact with the people and the object in different rooms.\n\n If you need more information on your player or on the game, click on help. \n\n Good luck !");

    //Game 
    private Game g;

    public Interface() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Game game peut etre en parametre du constructeur de l'interface sauf qu'on a besoin de game = new Game (1) dans GestionAction
        //*************************************WELCOME INTERFACE***************************************************************
        myFrameWelcome = new JFrame("Welcome");
        myFrameWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel1 = new JPanel();
        myLabel2 = new JLabel();
        myLabel2.setIcon(new ImageIcon("images/welcome_test.png"));
        myLabel2.setPreferredSize(new Dimension(809, 471));
        myPanel1.add(myLabel2);

        myButtonStart = new JButton();
        myButtonStart.setIcon(new ImageIcon("images/play.jpg"));
        myButtonStart.setPreferredSize(new Dimension(810, 100));
        myButtonQuit = new JButton();
        myButtonQuit.setIcon(new ImageIcon("images/quit.jpg"));
        myButtonQuit.setPreferredSize(new Dimension(810, 100));

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
        myFrameChoosePlayer.setSize(700, 700);

        // Initialization of the panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        panelCenterText = new JPanel();
        panelChoicePlayer = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        panelChoicePlayer.setLayout(new GridLayout(0, 3));

        // Initialization of the labels
        messageLabel = new JLabel(new ImageIcon("images/intro_v5.gif"));
        //Instanciation of the button 
        player1Button = new JButton();
        player1Button.setIcon(new ImageIcon("images/pierre.png"));
        player1Button.setPreferredSize(new Dimension(225, 300));
        player1Button.setBackground(Color.WHITE);

        player2Button = new JButton();
        player2Button.setIcon(new ImageIcon("images/elie.png"));
        player2Button.setPreferredSize(new Dimension(225, 300));
        player2Button.setBackground(Color.WHITE);

        player3Button = new JButton();
        player3Button.setIcon(new ImageIcon("images/luc.png"));
        player3Button.setPreferredSize(new Dimension(225, 300));
        player3Button.setBackground(Color.WHITE);

        panelChoicePlayer.add(player1Button);
        panelChoicePlayer.add(player2Button);
        panelChoicePlayer.add(player3Button);

        mainPanel.add(messageLabel, BorderLayout.CENTER);
        mainPanel.add(panelChoicePlayer, BorderLayout.SOUTH);

        player1Button.addActionListener(new GestionAction(g, this, "player1"));
        player2Button.addActionListener(new GestionAction(g, this, "player2"));
        player3Button.addActionListener(new GestionAction(g, this, "player3"));

        myFrameChoosePlayer.add(mainPanel);
    }

    public void mainInterface()  {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Fermeture de l'interface chooseplayer
        myMainFrame = myFrameChoosePlayer;
        mainPanel.removeAll();
        myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMainFrame.pack();
        myMainFrame.setSize(885, 570);
        myMainFrame.setVisible(true);

        //Container
        myMainFrame.setContentPane(myContainer);
        myContainer.setPreferredSize(new Dimension(750, 500));
        myContainer.setBackground(Color.GRAY);

        //Image du jeu
        myCommand.setIcon(new ImageIcon("images/fond_crepi_commande.png"));
        myHelpQuit.setIcon(new ImageIcon("images/fond_crepi_help.png"));

        myDialogBox.setIcon(new ImageIcon("images/fond_crepi_dialogue.png"));
        myGame.setIcon(new ImageIcon("images/salle_cours.jpg"));

        //***************************************************************************************************************
        //On definit le layout pour le panel principal
        myContainer.setLayout(new GridBagLayout());
        //Definition de l'objet servant a positionner les composants
        GridBagConstraints myGbc = new GridBagConstraints();

        //Panel jauge
        myGbc.gridx = 3;
        myGbc.gridy = 0;
        myGbc.gridheight = 3;
        myGbc.gridwidth = 1;
        myGbc.fill = GridBagConstraints.VERTICAL;
        myContainer.add(myJauge, myGbc);
        myJauge.setPreferredSize(new Dimension(130, 384));

        //Panel function : help + exit
        myGbc.gridx = 0;
        myGbc.gridy = 3;
        myGbc.gridheight = 1;
        myGbc.gridwidth = 1;
        myGbc.fill = GridBagConstraints.VERTICAL;
        myContainer.add(myHelpQuit, myGbc);
        //myHelpQuit.setPreferredSize(new Dimension(200,128));

        //Panel Statistiques
        myGbc.gridx = 0;
        myGbc.gridy = 0;
        myGbc.gridheight = 3;
        myGbc.gridwidth = 1;
        myGbc.fill = GridBagConstraints.VERTICAL;

        // ECRAN DE GAUCHE
        forceLabel = new JLabel(new ImageIcon("images/force_test.png"), JLabel.CENTER);
        intelligenceLabel = new JLabel(new ImageIcon("images/cerveau_test.png"), JLabel.CENTER);
        eloquenceLabel = new JLabel(new ImageIcon("images/discours_test.png"), JLabel.CENTER);
        forceLabel.setPreferredSize(new Dimension(100, 300));
        intelligenceLabel.setPreferredSize(new Dimension(100, 300));
        eloquenceLabel.setPreferredSize(new Dimension(100, 300));

        forceStatLabel = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player      
        intelligenceStatLabel = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player       
        eloquenceStatLabel = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player   

        myStatsPanel.setLayout(new GridLayout(3, 2));
        myStatsPanel.add(forceLabel);
        myStatsPanel.add(forceStatLabel);
        myStatsPanel.add(intelligenceLabel);
        myStatsPanel.add(intelligenceStatLabel);
        myStatsPanel.add(eloquenceLabel);
        myStatsPanel.add(eloquenceStatLabel);
        myContainer.add(myStatsPanel, myGbc);

        //Panel Jeu
        myGbc.gridx = 1;
        myGbc.gridy = 0;
        myGbc.gridheight = 3;
        myGbc.gridwidth = 2;
        myGbc.fill = GridBagConstraints.HORIZONTAL;
        myContainer.add(myGame, myGbc);
        myGame.setPreferredSize(new Dimension(540, 512));

        //Panel Boite Dialog
        myGbc.gridx = 1;
        myGbc.gridy = 3;
        myGbc.gridheight = 1;
        myGbc.gridwidth = 2;
        myGbc.fill = GridBagConstraints.HORIZONTAL;
        myContainer.add(myDialogBox, myGbc);
        myDialogBox.setPreferredSize(new Dimension(540, 128));

        //Panel Command
        myGbc.gridx = 3;
        myGbc.gridy = 3;
        myGbc.gridheight = 1;
        myGbc.gridwidth = 1;
        myGbc.fill = GridBagConstraints.VERTICAL;
        myContainer.add(myCommand, myGbc);
        myCommand.setPreferredSize(new Dimension(150, 128));

        //**********************************************************************************************************        
        //On definit le layout pour le panel Dialogue Box
        myDialogBox.add(dialogBox);
        dialogBox.setSize(540, 123);

        //**********************************************************************************************************        
        //On definit le layout pour le panel Jauge
        myJauge.setLayout(new GridLayout(1, 2));

        //Jauge de vie
        myJauge.add(displayBarreVie);
        displayBarreVie.setPreferredSize(new Dimension(300, 40));

        //Jauge de stress
        myJauge.add(displayBarreStress);
        displayBarreStress.setPreferredSize(new Dimension(300, 40));

        //**********************************************************************************************************        
        //On definit le layout pour le panel Command
        myCommand.setLayout(new GridBagLayout());
        //Definition de l'objet servant a positionner les composants
        GridBagConstraints myGbcCommand = new GridBagConstraints();

        //Bouton haut
        myGbcCommand.gridx = 1;
        myGbcCommand.gridy = 0;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnHaut, myGbcCommand);
        btnHaut.setPreferredSize(new Dimension(41, 41));

        //Bouton bas
        myGbcCommand.gridx = 1;
        myGbcCommand.gridy = 3;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnBas, myGbcCommand);
        btnBas.setPreferredSize(new Dimension(41, 41));

        //Bouton gauche
        myGbcCommand.gridx = 0;
        myGbcCommand.gridy = 1;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnGauche, myGbcCommand);
        btnGauche.setPreferredSize(new Dimension(41, 41));

        //Bouton droite
        myGbcCommand.gridx = 2;
        myGbcCommand.gridy = 1;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnDroite, myGbcCommand);
        btnDroite.setPreferredSize(new Dimension(41, 41));

        //Bouton interaction
        myGbcCommand.gridx = 1;
        myGbcCommand.gridy = 1;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnRamasser, myGbcCommand);
        btnRamasser.setPreferredSize(new Dimension(41, 41));

        //********************************************************************************************************
        //On definit le layout pour le panel Help and Quit 
        myHelpQuit.setLayout(new GridBagLayout());
        //Definition de l'objet servant Ã  positionner les composants
        GridBagConstraints myGbcPlay = new GridBagConstraints();

        //Bouton Pouvoir spécial
        myGbcPlay.gridx = 0;
        myGbcPlay.gridy = 1;
        myGbcPlay.gridheight = 1;
        myGbcPlay.gridwidth = 1;
        myGbcPlay.fill = GridBagConstraints.VERTICAL;
        myHelpQuit.add(btnPower, myGbcPlay);
        btnPower.setPreferredSize(new Dimension(59, 59));

        //Bouton Help
        myGbcPlay.gridx = 1;
        myGbcPlay.gridy = 1;
        myGbcPlay.gridheight = 1;
        myGbcPlay.gridwidth = 1;
        myGbcPlay.fill = GridBagConstraints.VERTICAL;
        myHelpQuit.add(btnHelp, myGbcPlay);
        btnHelp.setPreferredSize(new Dimension(59, 59));

        //Bouton QUIT
        myGbcPlay.gridx = 2;
        myGbcPlay.gridy = 1;
        myGbcPlay.gridheight = 1;
        myGbcPlay.gridwidth = 1;
        myGbcPlay.fill = GridBagConstraints.VERTICAL;
        myHelpQuit.add(btnQuit, myGbcPlay);
        btnQuit.setPreferredSize(new Dimension(59, 59));

        // ADD ACTION LISTENER
        btnDroite.addActionListener(new GestionAction(g, this, "droite"));
        btnGauche.addActionListener(new GestionAction(g, this, "gauche"));
        btnHaut.addActionListener(new GestionAction(g, this, "haut"));
        btnBas.addActionListener(new GestionAction(g, this, "bas"));

        btnQuit.addActionListener(new GestionAction(g, this, "quit"));
        btnHelp.addActionListener(new GestionAction(g, this, "play"));
        btnRamasser.addActionListener(new GestionAction(g, this, "ramasser"));
    }

    public void setLabelForce(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        forceStatLabel.setText(Integer.toString(i));
    }

    public void setLabelIntelligence(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        intelligenceStatLabel.setText(Integer.toString(i));
    }

    public void setLabelEloquence(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        eloquenceStatLabel.setText(Integer.toString(i));
    }

    public void setDialog(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        dialogBox.setText(s);
    }

    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        myFrameWelcome.setVisible(true);
    }

}
