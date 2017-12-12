package Interface_Game;

/**
 * This class represents the design of OUR GAME
 * 
 * @author grp 5  
 * @version 2017-12-11
 */

public interface Interface {

 
    
    //public Interface() {}
    
    //**************************************************CHOOSE PLAYER INTERFACE********************************************
    //public void Interface_ChoosePlayer() {  }

    //public void mainInterface() {  }
    
    //public void setLabelForce (int i){}
    
    //public void setLabelIntelligence (int i) {}
    
    //public void setLabelEloquence (int i){}
    
    //public void setDialog (String s) {  }
                
      //  *******************************************GESTION ACTION*************************************************************
        
      //  **********************
        
        // btnHelp.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){
                    // changeSalle(g.getPlayer().getCurrentRoom().getImageRoom());
                    // majInventaire ();
                    // dialogBox.setText(g.printWelcome());
                // }
            // });         

    
        // btnDroite.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){

                    // g.processCommand(new Command("go","east"));

                // }
            // });

        // btnGauche.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){

                    // g.processCommand(new Command("go","west")); 
                // }
            // });

    
        // btnHaut.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){

                    // g.processCommand(new Command("go","north")); 
                // }
            // });


        // btnBas.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){

                    // g.processCommand(new Command("go","south")); 
                // }
            // });

        // btnLoupe.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){

                    // g.processCommand(new Command("look", null)); 
                // }
            // });

        // btnRamasser.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){

                    // g.processCommand(new Command("pickup", null)); 
                // }
            // });

        // btnBoire.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){

                    // g.processCommand(new Command("usePotion", null)); 
                // }
            // });

        // btnRePlay.addActionListener (new ActionListener()
            // {
                // public void actionPerformed (ActionEvent e){
                    // //Boite du message d'information
                    // jopQuit = new JOptionPane();
                    // JOptionPane.showMessageDialog(null, "Thanks, see you later !", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // System.exit(0);
                // }
            // });

    //}

   // public void run(){    }


    // //When we have modifications of the life of the player this function allow to display these modifications 
    // public void affichageVie(int Pv, int Pvmax){
        // int i = (int)( 10.0 * (float)Pv / (float)Pvmax);

        // switch (i){
            // case 10 :
            // ImageIcon icon10 = new ImageIcon("images/Pv_100v.png");
            // displayBarreVie.setIcon(icon10);
            // break;
            // case 9 :
            // ImageIcon icon9 = new ImageIcon("images/Pv_90v.png");
            // displayBarreVie.setIcon(icon9);
            // break;
            // case 8 :
            // ImageIcon icon8 = new ImageIcon("images/Pv_80v.png");
            // displayBarreVie.setIcon(icon8);
            // break;
            // case 7 :
            // ImageIcon icon7 = new ImageIcon("images/Pv_70v.png");
            // displayBarreVie.setIcon(icon7);
            // break;
            // case 6 :
            // ImageIcon icon6 = new ImageIcon("images/Pv_60v.png");
            // displayBarreVie.setIcon(icon6);
            // break;
            // case 5 :
            // ImageIcon icon5 = new ImageIcon("images/Pv_50v.png");
            // displayBarreVie.setIcon(icon5);
            // break;
            // case 4 :
            // ImageIcon icon4 = new ImageIcon("images/Pv_40v.png");
            // displayBarreVie.setIcon(icon4);
            // break;
            // case 3 :
            // ImageIcon icon3 = new ImageIcon("images/Pv_30v.png");
            // displayBarreVie.setIcon(icon3);
            // break;
            // case 2 :
            // ImageIcon icon2 = new ImageIcon("images/Pv_20v.png");
            // displayBarreVie.setIcon(icon2);
            // break;
            // case 1 :
            // ImageIcon icon1 = new ImageIcon("images/Pv_10v.png");
            // displayBarreVie.setIcon(icon1);
            // break;
            // case 0 :
            // if (Pv == 0){ 
                // ImageIcon icon0 = new ImageIcon("images/Pv_0v.png");
                // displayBarreVie.setIcon(icon0);
                // break;
            // }
            // else {
                // icon1 = new ImageIcon("images/Pv_10v.png");
                // displayBarreVie.setIcon(icon1);
                // break;
            // }
            // default :
            // break;
        // }
    // }

    // public void changeSalle (String s){
        // myGame.setIcon(new ImageIcon (s));
    // }

    // public void changeInventaireArc (String s){
        // myInventaireArc.setIcon(new ImageIcon (s));
    // }

    // public void changeInventairePotion (String s){
        // myInventairePotion.setIcon(new ImageIcon (s));
    // }

    // public void changeInventaireEpee (String s){
        // myInventaireEpee.setIcon(new ImageIcon (s));
    // }

    // public void changeInventairePrincesse (String s){
        // myInventairePrincesse.setIcon(new ImageIcon (s));
    // }

    // public void changeInventaireBaguette (String s){
        // myInventaireBaguette.setIcon(new ImageIcon (s));
    // }

    // //audrey
    // public void changeImageWin (String s){
        // myGame.setIcon(new ImageIcon (s));
    // }

    // //audrey
    // public void changeImageLoose(String s){
        // myGame.setIcon(new ImageIcon (s));
    // }

    // public void majInventaire (){
        // if (g.getPlayer().possedeBow()==false){
            // changeInventaireArc("images/arc_inventaire2.png");
        // }
        // else {
            // changeInventaireArc("images/arc_ok.jpg");
        // }

        // if (g.getPlayer().possedeSword()==false){
            // changeInventaireEpee("images/epee_inventaire2.png");
        // }
        // else {
            // changeInventaireEpee("images/eppe_ok.jpg");
        // }

        // if (g.getPlayer().possedeWand()==false){
            // changeInventaireBaguette("images/baguette_inventaire2.png");
        // }
        // else {
            // changeInventaireBaguette("images/baguette_ok.jpg");
        // }

        // if (g.getPlayer().possedePotion()==false){
            // changeInventairePotion("images/potion_inventaire2.png");
        // }
        // else {
            // changeInventairePotion("images/potion_ok.jpg");
        // }

        // if (g.getPlayer().getWithPrincess()==false){
            // changeInventairePrincesse("images/princesse_inventaire2.png");
        // }
        // else {
            // changeInventairePrincesse("images/princesse_ok.jpg");
        // }   
    // }

    // //audrey
    // public void youWin() {
        // myGame.setIcon(new ImageIcon ("images/salles/victoire.png"));
    // }


    // //audrey
    // public void youLoose() {
        // myGame.setIcon(new ImageIcon ("images/salles/tete-de-mort.gif"));
    // }

    // /**
     // * Allow to modify the message of the dialog box
     // */
    // public static void setDialogBox(String text){

        // dialogBox.setText(text);
    // }

    // /**
     // * Allow to use the message of the textarea dialogBox in goRoom
     // */
    // public static String getDialogBox(){
        // return dialogBox.getText();
    // }


}
      
