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

/**
 * Interface class
 * Contains all informations about the main interface, allowing to play
 * Has several buttons :
 * -btnHaut, btnBasn btnDroite, BtnGauche allow to move from one room to another
 * -btnRamasser is the interact button. It allows to interact with NPCs and items.
 * -btnHelp allows to have more information about the game and current quests
 * -btnQuit to leave the game
 * -btnPower to activate or disable the player power
 * -btnChoice1, btnChoice2, btnChoice3, btnChoice4 to select a choice.
 * 
 * @author (Grp5)
 * @version (14/12/2017)
 */
public class Interface extends JFrame {

    //****************MAIN INTERFACE************************************
    //Declarations
    private JFrame myMainFrame = new JFrame("World of Zuul");
    private JPanel mainPanel;
    private final Container myContainer = myMainFrame.getContentPane();
    //Label
    private final JLabel myCommand = new JLabel();
    private final JLabel myGame = new JLabel();
    private final JLabel myDialogBox = new JLabel();
    private final JLabel myNumberChoice = new JLabel();
    private final JLabel myJauge = new JLabel(new ImageIcon(this.getClass().getResource("images/fond_crepi_jauge.png")));
    private final JLabel myAction = new JLabel();
    private final JLabel myHelpQuit = new JLabel();

    //****************** LEFT SCREEN *********************
    private JLabel forceLabel;
    private JLabel intelligenceLabel;
    private JLabel eloquenceLabel;
    private JLabel forceStatLabel; //= new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player 
    private JLabel intelligenceStatLabel; // = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player
    private JLabel eloquenceStatLabel; // = new JLabel("0", JLabel.CENTER); //relier cette variable Ã  player    
    private final JPanel myStatsPanel = new JPanel();

    // ************** RIGHT SCREEN **********************
    private final JLabel displayBarreVie = new JLabel(new ImageIcon(this.getClass().getResource("images/Pv_100v.png")), JLabel.CENTER); //health displaying in image format
    private final JLabel displayBarreStress = new JLabel(new ImageIcon(this.getClass().getResource("images/Pv_0_stress.png")), JLabel.CENTER);

    //game button
    private final JButton btnHaut = new JButton(new ImageIcon(this.getClass().getResource("images/hand_up.png")));
    private final JButton btnBas = new JButton(new ImageIcon(this.getClass().getResource("images/hand_down.png")));
    private final JButton btnDroite = new JButton(new ImageIcon(this.getClass().getResource("images/hand_right.png")));
    private final JButton btnGauche = new JButton(new ImageIcon(this.getClass().getResource("images/hand_left.png")));
    private final JButton btnRamasser = new JButton(new ImageIcon(this.getClass().getResource("images/interaction.png")));
    private final JButton btnHelp = new JButton(new ImageIcon(this.getClass().getResource("images/help2.png")));
    private final JButton btnQuit = new JButton(new ImageIcon(this.getClass().getResource("images/quit2.png")));
    private final JButton btnPower = new JButton(new ImageIcon(this.getClass().getResource("images/pouvoirs.png")));
    private final JButton btnChoice1 = new JButton("1");
    private final JButton btnChoice2 = new JButton("2");
    private final JButton btnChoice3 = new JButton("3");
    private final JButton btnChoice4 = new JButton("4");

    //private JOptionPane jopQuit;
    private Player player1;

    //Textfield for the dialog box which display information to the player and allow him to interact with the game
    private static final TextArea dialogBox = new TextArea("Welcome to the World of GPhy! \n \n The goal is simple : finish the COOPOO project before living the University\n You can interact with the people and the objects in different rooms.\n\n If you need more information on your player or on the game, click on help. \n\n Good luck ! ");

    //Game 
    private Game game;

    //actions of the buttons
    private int option;
    private int choiceInteract; 

    public Interface(int choicePlayer, InterfaceBegin wint) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //  Closing the chooseplayer interface
        game = new Game(choicePlayer, this);
        myMainFrame = wint.myFrameChoosePlayer;
        myMainFrame.setVisible(true);
        wint.mainPanel.removeAll();
        myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMainFrame.pack();
        myMainFrame.setSize(885, 600);
        myMainFrame.setVisible(true);

        //Container
        myMainFrame.setContentPane(myContainer);
        myContainer.setPreferredSize(new Dimension(750, 560));
        myContainer.setBackground(Color.GRAY);

        //Game picture added to each label
        myCommand.setIcon(new ImageIcon(this.getClass().getResource("images/fond_crepi_commande.png")));
        myHelpQuit.setIcon(new ImageIcon(this.getClass().getResource("images/fond_crepi_help.png")));
        myNumberChoice.setIcon(new ImageIcon(this.getClass().getResource("images/fond_crepi_number.png")));

        myDialogBox.setIcon(new ImageIcon(this.getClass().getResource("images/fond_crepi_dialogue.png")));
        myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/hall.jpg")));

        //***************************************************************************************************************
        //defining of the layout for the main panel
        myContainer.setLayout(new GridBagLayout());
        //Definition de l'objet servant a positionner les composants
        GridBagConstraints myGbc = new GridBagConstraints();

        //gauge panel
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

        // LEFT SCREEN
        forceLabel = new JLabel(new ImageIcon(this.getClass().getResource("images/force_test.png")), JLabel.CENTER);
        intelligenceLabel = new JLabel(new ImageIcon(this.getClass().getResource("images/cerveau_test.png")), JLabel.CENTER);
        eloquenceLabel = new JLabel(new ImageIcon(this.getClass().getResource("images/discours_test.png")), JLabel.CENTER);
        forceLabel.setPreferredSize(new Dimension(100, 300));
        intelligenceLabel.setPreferredSize(new Dimension(100, 300));
        eloquenceLabel.setPreferredSize(new Dimension(100, 300));

        forceStatLabel = new JLabel(Integer.toString(game.getPlayer().getStrStat()), JLabel.CENTER); //relier cette variable Ã  player      
        intelligenceStatLabel = new JLabel(Integer.toString(game.getPlayer().getIntStat()), JLabel.CENTER); //relier cette variable Ã  player       
        eloquenceStatLabel = new JLabel(Integer.toString(game.getPlayer().getSpeStat()), JLabel.CENTER); //relier cette variable Ã  player   

        myStatsPanel.setLayout(new GridLayout(3, 2));
        myStatsPanel.add(forceLabel);
        myStatsPanel.add(forceStatLabel);
        myStatsPanel.add(intelligenceLabel);
        myStatsPanel.add(intelligenceStatLabel);
        myStatsPanel.add(eloquenceLabel);
        myStatsPanel.add(eloquenceStatLabel);
        myContainer.add(myStatsPanel, myGbc);

        //game panel
        myGbc.gridx = 1;
        myGbc.gridy = 0;
        myGbc.gridheight = 3;
        myGbc.gridwidth = 2;
        myGbc.fill = GridBagConstraints.HORIZONTAL;
        myContainer.add(myGame, myGbc);
        myGame.setPreferredSize(new Dimension(540, 512));

        //Dialog box panel
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

        //Panel NumberChoice
        myGbc.gridx = 0;
        myGbc.gridy = 4;
        myGbc.gridheight = 1;
        myGbc.gridwidth = 4;
        myGbc.fill = GridBagConstraints.HORIZONTAL;
        myContainer.add(myNumberChoice, myGbc);
        myNumberChoice.setPreferredSize(new Dimension(810, 50));

        //**********************************************************************************************************        
        //defining of the layout for the Dialogue Box panel
        myDialogBox.add(dialogBox);
        dialogBox.setSize(540, 123);
        dialogBox.setEditable(false);
        //**********************************************************************************************************        
        //defining of the layout for the gauge panel
        myJauge.setLayout(new GridLayout(1, 2));

        //life gauge
        myJauge.add(displayBarreVie);
        displayBarreVie.setPreferredSize(new Dimension(300, 40));
        affichageEnergie();
        //stress gauge
        myJauge.add(displayBarreStress);
        displayBarreStress.setPreferredSize(new Dimension(300, 40));
        affichageStress();

        //**********************************************************************************************************        
        //defining the layout for the Command panel
        myCommand.setLayout(new GridBagLayout());
        //Definition of the object used to position the components
        GridBagConstraints myGbcCommand = new GridBagConstraints();

        //Up button
        myGbcCommand.gridx = 1;
        myGbcCommand.gridy = 0;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnHaut, myGbcCommand);
        btnHaut.setPreferredSize(new Dimension(41, 41));

        //down button
        myGbcCommand.gridx = 1;
        myGbcCommand.gridy = 3;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnBas, myGbcCommand);
        btnBas.setPreferredSize(new Dimension(41, 41));

        //Left button
        myGbcCommand.gridx = 0;
        myGbcCommand.gridy = 1;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnGauche, myGbcCommand);
        btnGauche.setPreferredSize(new Dimension(41, 41));

        //Right button
        myGbcCommand.gridx = 2;
        myGbcCommand.gridy = 1;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnDroite, myGbcCommand);
        btnDroite.setPreferredSize(new Dimension(41, 41));

        //interaction button (also named btnRamasser)
        myGbcCommand.gridx = 1;
        myGbcCommand.gridy = 1;
        myGbcCommand.gridheight = 1;
        myGbcCommand.gridwidth = 1;
        myGbcCommand.fill = GridBagConstraints.VERTICAL;
        myCommand.add(btnRamasser, myGbcCommand);
        btnRamasser.setPreferredSize(new Dimension(41, 41));

        //********************************************************************************************************
        //defining the layout for the Help and Quit panel
        myHelpQuit.setLayout(new GridBagLayout());
        //Definition of the object used to position the components
        GridBagConstraints myGbcPlay = new GridBagConstraints();

        //Special power button
        myGbcPlay.gridx = 0;
        myGbcPlay.gridy = 1;
        myGbcPlay.gridheight = 1;
        myGbcPlay.gridwidth = 1;
        myGbcPlay.fill = GridBagConstraints.VERTICAL;
        myHelpQuit.add(btnPower, myGbcPlay);
        btnPower.setPreferredSize(new Dimension(59, 59));
        btnPower.setEnabled(false); 

        //help button
        myGbcPlay.gridx = 1;
        myGbcPlay.gridy = 1;
        myGbcPlay.gridheight = 1;
        myGbcPlay.gridwidth = 1;
        myGbcPlay.fill = GridBagConstraints.VERTICAL;
        myHelpQuit.add(btnHelp, myGbcPlay);
        btnHelp.setPreferredSize(new Dimension(59, 59));

        //quit button
        myGbcPlay.gridx = 2;
        myGbcPlay.gridy = 1;
        myGbcPlay.gridheight = 1;
        myGbcPlay.gridwidth = 1;
        myGbcPlay.fill = GridBagConstraints.VERTICAL;
        myHelpQuit.add(btnQuit, myGbcPlay);
        btnQuit.setPreferredSize(new Dimension(59, 59));

        //defining the layout for the NumberChoice panel
        myNumberChoice.setLayout(new GridLayout(1, 4));
        myNumberChoice.add(btnChoice1);
        myNumberChoice.add(btnChoice2);
        myNumberChoice.add(btnChoice3);
        myNumberChoice.add(btnChoice4);

        // ADD ACTION LISTENER
        //################  COMMAND #######################
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

                option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit ?",
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

                game.printHelp(game.currentQuest);
            }

        }
        );

        setDialog("You play with " + game.getPlayer().getNamePlayer() + " ! \n You can see the points at the left or right of the screen");

        //################  Numbers for the choices #######################
        btnChoice1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choiceInteract=0; 
                game.afterInteract(choiceInteract);
            }
        });
        btnChoice2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choiceInteract=1; 
                game.afterInteract(choiceInteract);
                game.getDialogue().setChoice(choiceInteract); //to chose between two answers
    
            }
        });
        btnChoice3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choiceInteract=2;
                game.afterInteract(choiceInteract);
            }
        });
        btnChoice4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choiceInteract=3;
                game.afterInteract(choiceInteract);
            }
        });

        //all the methods needed to launch the game
        game.createRooms();
        game.addItems();
        Interface.setDialog(game.getInstructions().get(0));
        Interface.setDialog("Press the interact button to be able to talk to him! (the open hand on your right)");
    }

    /**
     * setLabelForce method : displays the strenth stat value in front of the 
     * forceStatLabel
     *
     */
    public void setLabelForce() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        forceStatLabel.setText(Integer.toString(game.getPlayer().getStrStat()));
    }

    /**
     * setLabelIntelligence method : displays the intelligence stat value in
     * front of the intelligenceStatLabel
     *
     */
    public void setLabelIntelligence() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        intelligenceStatLabel.setText(Integer.toString(game.getPlayer().getIntStat()));
    }

    /**
     * setLabelEloquence method : displays the eloquence stat value in
     * front of the eloquenceStatLabel
     *
     */
    public void setLabelEloquence() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        eloquenceStatLabel.setText(Integer.toString(game.getPlayer().getSpeStat()));
    }

    /**
     * setDialog method : displays a String in a dialogBox
     * @param s String the sentence to display in the dialogBox
     */
    public static void setDialog(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //dialogBox.setLineWrap(true); 
        dialogBox.append(s + "\n");
        //dialogBox.setText(s);
    }

    /**
     * run method : allows to set visible the main frame.
     */
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        myMainFrame.setVisible(true);
    }

    /**
     * affichageEnergie method : displays picture for the energy stat according
     * to the energy rate that the player has.
     */
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

    /**
     * affichageStress method : displays picture for the stress stat according
     * to the stress rate that the player has.
     */
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

    /**
     * affichageSalles method : displays picture depending on where the player is
     * and depending on the non-player character with whom the player interacts
     *
     */
    public void affichageSalles() {
        switch (game.currentRoom.getName()) {
            case ("B2 entrance"):
                if (game.getItem("Axel").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/hall_withaxel.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/hall.jpg")));
                }
                break;
            case ("Amphitheatre"):
                if (game.getItem("Marie").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/theatre_withmarie.jpg")));
                } else if (game.getItem("Mrs Geniet").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/theatre_withannie.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/theatre.jpg")));
                }
                break;
            case ("WC"):
                if (game.getItem("Nolan").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/wc_withnolan.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/wc.jpg")));
                }
                break;
            case ("TD4"):
                if (game.getItem("PGTD").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/td4_withpg.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/td4.jpg")));
                }
                break;
            case ("TD1"):
                if (game.getItem("Thomas").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/td1_withthomas.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/td1.jpg")));
                }
                break;
            case ("TP1"):
                if (game.getItem("Valentin").getInteracting()) {
                  myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/tp1_withvalentin.jpg")));
                } else if (game.getItem("Martin").getInteracting()) {                    
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/tp1_withmartin.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/tp1.jpg")));
                }
                break;
            case ("Resting room"):
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/restingroom.jpg")));                
                break;
            case ("Corridor down1"):
                if (game.isAllanThere())
                {
                   myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor4_withallan.jpg")));
                   game.setAllanThere(false);
                }
                else if (game.isLucThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor4_withl3.jpg")));
                    game.setLucThere(false);
                }
                 else if (game.isPillowThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor4_withpillow.jpg")));
                    game.setPillowThere(false);
                }
                else if(game.isPenguinThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor4_withpenguin.jpg")));
                    game.setPenguinThere(false);
                }
                else{
                myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor4.jpg")));
                }
                break;
            case ("Corridor down2"):
                if (game.isAllanThere())
                {
                   myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor3_withallan.jpg")));
                   game.setAllanThere(false);
                }
                else if (game.isLucThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor3_withl3.jpg")));
                    game.setLucThere(false);
                }
                else if (game.isPillowThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor3_withpillow.jpg")));
                    game.setPillowThere(false);
                }
                else if(game.isPenguinThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor3_withpenguin.jpg")));
                    game.setPenguinThere(false);
                }
                
                else{
                myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor3.jpg")));
                }
                break;
            case ("Corridor upstairs1"):
                if (game.isAllanThere())
                {
                   myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor1_withallan.jpg")));
                   game.setAllanThere(false);
                }
                else if (game.isLucThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor1_withl3.jpg")));
                    game.setLucThere(false);
                }
                else if (game.getItem("M2").getInteracting())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor1_withm2.jpg")));
                    
                }
                 else if (game.isPillowThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor1_withpillow.jpg")));
                    game.setPillowThere(false);
                }
                else if(game.isPenguinThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor1_withpenguin.jpg")));
                    game.setPenguinThere(false);
                }
                else{
                myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor1.jpg")));
                }
                break;
            case ("Corridor upstairs2"):
                if (game.isAllanThere())
                {
                   myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor2_withallan.jpg"))); 
                   game.setAllanThere(false);
                }
                else if (game.isLucThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor2_withl3.jpg")));
                    game.setLucThere(false);
                }
                 else if (game.isPillowThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor2_withpillow.jpg")));
                    game.setPillowThere(false);
                }
                else if(game.isPenguinThere())
                {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor2_withpenguin.jpg")));
                    game.setPenguinThere(false);
                }
                else{
                myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/corridor2.jpg")));
                }
                break;
            case ("Lift down"):
                if (game.getItem("Guardian").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/lift_withguardian.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/lift.jpg")));
                }
                break;
            case ("Lift up"):
                if (game.getItem("Guardian").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/lift_withguardian.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/lift.jpg")));
                }
                break;
            case ("Mrs. Geniet's Office"):
                myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/genietoffice.jpg")));
                break;
            case ("Staircase down"):
                if (game.getItem("Morgane").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/stairs_withmomo.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/stairs.jpg")));
                }
                break;
            case ("Staircase up"):
                myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/stairs.jpg")));
                break;
            case ("Classroom"):
                if (game.getItem("Clément").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/classroom_withclem.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/classroom.jpg")));
                }
                break;
            case ("Mr. Girard's Office"):
                if (game.getItem("PGEnd").getInteracting()) {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/pgoffice_withpg.jpg")));
                } else {
                    myGame.setIcon(new ImageIcon(this.getClass().getResource("images/salles/pgoffice.jpg")));
                }
                break;
            default:
                break;

        }
    }

    /**
     * refresh method : refreshes stat labels of the player : energy, strength, 
     * eloquence, intelligence, stress
     * refreshes the room.
     *
     */
    public void refresh() {
        affichageSalles();
        affichageStress();
        affichageEnergie();
        setLabelForce();
        setLabelEloquence();
        setLabelIntelligence();
        setButtons();
        game.gameOver();

    }

    /**
     * getName method : allows to return a Game object named game
     *@return a Game object named game
     */
    public Game getGame() {
        return game;
    }

    /**
     * getChoiceInteract method : allows to return a choiceInteract integer
     * @return choiceInteract integer
     */
    public int getChoiceInteract() {
        return choiceInteract;
    }
    
    /**
     * setButtons method : allows to return a Game object named game
     * set disable a button if there is no exit. 
     * set enable a button if there is an exit 
     */
    public void setButtons()
    {
        if (game.currentRoom.getExit("north") == null)
        {
            btnHaut.setEnabled(false);
        }
        else{
            btnHaut.setEnabled(true);
        }
         if (game.currentRoom.getExit("east") == null)
        {
            btnDroite.setEnabled(false);
        }
        else{
            btnDroite.setEnabled(true);
        }
          if (game.currentRoom.getExit("south") == null)
        {
            btnBas.setEnabled(false);
        }
        else{
            btnBas.setEnabled(true);
        }
           if (game.currentRoom.getExit("west") == null)
        {
            btnGauche.setEnabled(false);
        }
        else{
            btnGauche.setEnabled(true);
        }
            
    }
}
