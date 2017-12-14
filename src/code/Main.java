package code;


/**
 * Main class, allowing to launch the game, by initializing the interface,
 * then by adding a frame myFrameWelcome to the interface.
 * 
 * @author (Grp5)
 * @version (14/12/2017)
 */
public class Main {

    /**
     * main method which is launching after running the executable
     * Allows to initialize the interface and add the myFraleWelcome to the 
     * interface.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InterfaceBegin guiB = new InterfaceBegin(); 
        guiB.myFrameWelcome.setVisible(true);
    }

}
