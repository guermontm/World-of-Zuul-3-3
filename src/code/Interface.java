package code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Interface extends JFrame {
//    //***************************Welcome interface******************************
//
//    private final JButton myButtonStart;
//    private final JButton myButtonQuit;
//    //private final JLabel myLabel1;
//    private JLabel myLabel2, myLabel3;
//    private JPanel myPanel1, myPanel2, myPanel3, myPanel4;
//    protected JFrame myFrameWelcome;
//
//    //*********************CHOOSE PLAYER*****************************************
//    private JLabel playerInterface;
//    private JButton player1Button, player2Button, player3Button;
//    private JLabel messageLabel;
//    private JPanel mainPanel, panelCenterText, panelChoicePlayer;
//    private JFrame myFrameChoosePlayer;

    //****************MAIN INTERFACE************************************
    //Declarations
    private JFrame myMainFrame = new JFrame("World of Zuul");
    private JPanel mainPanel;
    private final Container myContainer = myMainFrame.getContentPane();
    //Label
    private final JLabel myCommand = new JLabel();
    private final JLabel myGame = new JLabel();
    private final JLabel myDialogBox = new JLabel();
    private final JLabel myJauge = new JLabel(new ImageIcon(this.getClass().getResource("images/fond_crepi_jauge.png")));
    private final JLabel myAction = new JLabel();
    private final JLabel myHelpQuit = new JLabel();

    //****************** ECRAN DE GAUCHE voir ligne 240*********************
    private JLabel forceLabel;
    private JLabel intelligenceLabel;
    private JLabel eloquenceLabel;
    private JLabel forceStatLabel; //= new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player 
    private JLabel intelligenceStatLabel; // = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player
    private JLabel eloquenceStatLabel; // = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player    
    private final JPanel myStatsPanel = new JPanel();

    // ************** ECRAN DE DROITE voir ligne 290-300**********************
    private final JLabel displayBarreVie = new JLabel(new ImageIcon(this.getClass().getResource("images/Pv_100v.png")), JLabel.CENTER); //health displaying in image format
    private final JLabel displayBarreStress = new JLabel(new ImageIcon(this.getClass().getResource("images/Pv_0_stress.png")), JLabel.CENTER);

    //Button game
    private final JButton btnHaut = new JButton(new ImageIcon(this.getClass().getResource("images/hand_up.png")));
    private final JButton btnBas = new JButton(new ImageIcon(this.getClass().getResource("images/hand_down.png")));
    private final JButton btnDroite = new JButton(new ImageIcon(this.getClass().getResource("images/hand_right.png")));
    private final JButton btnGauche = new JButton(new ImageIcon(this.getClass().getResource("images/hand_left.png")));
    private final JButton btnRamasser = new JButton(new ImageIcon(this.getClass().getResource("images/interaction.png")));
    private final JButton btnHelp = new JButton(new ImageIcon(this.getClass().getResource("images/help2.png")));
    private final JButton btnQuit = new JButton(new ImageIcon(this.getClass().getResource("images/quit2.png")));
    private final JButton btnPower = new JButton(new ImageIcon(this.getClass().getResource("images/pouvoirs.png")));

    //private JOptionPane jopQuit;
    private Player player1;

    //Textfield for the dialog box which display information to the player and allow him to interact with the game
    private static final TextArea dialogBox = new TextArea("Welcome to the World of GPhy! \n \n The goal is simple : finish the COOPOO project before living the University\n You can interact with the people and the object in different rooms.\n\n If you need more information on your player or on the game, click on help. \n\n Good luck !");

    //Game 
    private Game game;

    //actions of the buttons
    private int option;

    public Interface(int choicePlayer, InterfaceBegin wint) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Fermeture de l'interface chooseplayer
        game = new Game(choicePlayer);
        myMainFrame = wint.myFrameChoosePlayer;
        myMainFrame.setVisible(true);
        wint.mainPanel.removeAll();
        myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMainFrame.pack();
        myMainFrame.setSize(885, 570);
        myMainFrame.setVisible(true);

        //Container
        myMainFrame.setContentPane(myContainer);
        myContainer.setPreferredSize(new Dimension(750, 500));
        myContainer.setBackground(Color.GRAY);

        //Image du jeu
        myCommand.setIcon(new ImageIcon(this.getClass().getResource("images/fond_crepi_commande.png")));
        myHelpQuit.setIcon(new ImageIcon(this.getClass().getResource("images/fond_crepi_help.png")));

        myDialogBox.setIcon(new ImageIcon(this.getClass().getResource("images/fond_crepi_dialogue.png")));
        myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/salle_cours.jpg")));

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
        forceLabel = new JLabel(new ImageIcon(this.getClass().getResource("images/force_test.png")), JLabel.CENTER);
        intelligenceLabel = new JLabel(new ImageIcon(this.getClass().getResource("images/cerveau_test.png")), JLabel.CENTER);
        eloquenceLabel = new JLabel(new ImageIcon(this.getClass().getResource("images/discours_test.png")), JLabel.CENTER);
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
        //################  COMMANDE #######################
        btnDroite.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                game.changeRoom("east");
            }

        }
        );
        btnGauche.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                game.changeRoom("west");
            }

        }
        );
        btnHaut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                game.changeRoom("north");
            }

        }
        );
        btnBas.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                game.changeRoom("south");
            }

        }
        );

        btnRamasser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                game.interact();
            }

        }
        );
        //################  Help and quit #######################
        btnQuit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                option = JOptionPane.showConfirmDialog(null, "Are you sure to quit ?",
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

        btnHelp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                game.printHelp();
            }

        }
        );
        int force = game.getPlayer().getStrStat();
        setLabelForce(force);//<--- à appeler dès qu'il y a un changement de force
        int intelligence = game.getPlayer().getIntStat();
        setLabelIntelligence(intelligence);//<--- à appeler dès qu'il y a un changement d'intelligence
        int eloquence = game.getPlayer().getSpeStat();
        setLabelEloquence(eloquence);//<--- à appeler dès qu'il y a un changement d'eloquence
        setDialog("You play with " + game.getPlayer().getNamePlayer() + " ! \n You can see the points at the left or right of the screen");
        game.createRooms();
        game.getPlayer().setStress(5);//<-- test pour vérifier les affichages
        game.getPlayer().setSta(5);//<-- test pour vérifier les affichages
        game.getPlayer().setStr(9);//<-- test pour vérifier les affichages
    
        affichageEnergie(); //<--- à appeler dès qu'il y a un changement d'énergie
        affichageStress(); //<--- à appeler dès qu'il y a un changement de stress 
    
//game.play();
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

    public static void setDialog(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //dialogBox.setLineWrap(true); 
        dialogBox.append(s + "\n");
        //dialogBox.setText(s);
    }

    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        myMainFrame.setVisible(true);
    }

    public void affichageEnergie() {
        int i = game.getPlayer().getStaStat();

        switch (i) {
            case 10:
                ImageIcon icon10 = new ImageIcon(this.getClass().getResource("images/Pv_100v.png"));
                displayBarreVie.setIcon(icon10);
                break;
            case 9:
                ImageIcon icon9 = new ImageIcon(this.getClass().getResource("images/Pv_90v.png"));
                displayBarreVie.setIcon(icon9);
                break;
            case 8:
                ImageIcon icon8 = new ImageIcon(this.getClass().getResource("images/Pv_80v.png"));
                displayBarreVie.setIcon(icon8);
                break;
            case 7:
                ImageIcon icon7 = new ImageIcon(this.getClass().getResource("images/Pv_70v.png"));
                displayBarreVie.setIcon(icon7);
                break;
            case 6:
                ImageIcon icon6 = new ImageIcon(this.getClass().getResource("images/Pv_60v.png"));
                displayBarreVie.setIcon(icon6);
                break;
            case 5:
                ImageIcon icon5 = new ImageIcon(this.getClass().getResource("images/Pv_50v.png"));
                displayBarreVie.setIcon(icon5);
                break;
            case 4:
                ImageIcon icon4 = new ImageIcon(this.getClass().getResource("images/Pv_40v.png"));
                displayBarreVie.setIcon(icon4);
                break;
            case 3:
                ImageIcon icon3 = new ImageIcon(this.getClass().getResource("images/Pv_30v.png"));
                displayBarreVie.setIcon(icon3);
                break;
            case 2:
                ImageIcon icon2 = new ImageIcon(this.getClass().getResource("images/Pv_20v.png"));
                displayBarreVie.setIcon(icon2);
                break;
            case 1:
                ImageIcon icon1 = new ImageIcon(this.getClass().getResource("images/Pv_10v.png"));
                displayBarreVie.setIcon(icon1);
                break;
            case 0:

                ImageIcon icon0 = new ImageIcon(this.getClass().getResource("images/Pv_0v.png"));
                displayBarreVie.setIcon(icon0);
                break;

            default:
                break;
        }
    }
    
        public void affichageStress() {
        int i = game.getPlayer().getStressStat();

        switch (i) {
            case 10:
                ImageIcon icon10 = new ImageIcon(this.getClass().getResource("images/Pv_100_stress.png"));
                displayBarreStress.setIcon(icon10);
                break;
            case 9:
                ImageIcon icon9 = new ImageIcon(this.getClass().getResource("images/Pv_90_stress.png"));
                displayBarreStress.setIcon(icon9);
                break;
            case 8:
                ImageIcon icon8 = new ImageIcon(this.getClass().getResource("images/Pv_80_stress.png"));
                displayBarreStress.setIcon(icon8);
                break;
            case 7:
                ImageIcon icon7 = new ImageIcon(this.getClass().getResource("images/Pv_70_stress.png"));
                displayBarreStress.setIcon(icon7);
                break;
            case 6:
                ImageIcon icon6 = new ImageIcon(this.getClass().getResource("images/Pv_60_stress.png"));
                displayBarreStress.setIcon(icon6);
                break;
            case 5:
                ImageIcon icon5 = new ImageIcon(this.getClass().getResource("images/Pv_50_stress.png"));
                displayBarreStress.setIcon(icon5);
                break;
            case 4:
                ImageIcon icon4 = new ImageIcon(this.getClass().getResource("images/Pv_40_stress.png"));
                displayBarreStress.setIcon(icon4);
                break;
            case 3:
                ImageIcon icon3 = new ImageIcon(this.getClass().getResource("images/Pv_30_stress.png"));
                displayBarreStress.setIcon(icon3);
                break;
            case 2:
                ImageIcon icon2 = new ImageIcon(this.getClass().getResource("images/Pv_20_stress.png"));
                displayBarreStress.setIcon(icon2);
                break;
            case 1:
                ImageIcon icon1 = new ImageIcon(this.getClass().getResource("images/Pv_10_stress.png"));
                displayBarreStress.setIcon(icon1);
                break;
            case 0:

                ImageIcon icon0 = new ImageIcon(this.getClass().getResource("images/Pv_0_stress.png"));
                displayBarreStress.setIcon(icon0);
                break;

            default:
                break;
        }
    }
}
