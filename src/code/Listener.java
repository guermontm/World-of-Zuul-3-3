
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Listener class for the rugby project
 * The listener takes an event argument 
 * Depending of the button pressed, the counter can be increased, decreased or set to 0
 * @author (Clément Risso with group 5)
 * @version (V1 19/10/17)
 */
public class Listener implements KeyListener
{

    
    private char keyTyped;
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        keyTyped = e.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keyTyped = e.getKeyChar();

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keyTyped = e.getKeyChar();
    }

    
    
}