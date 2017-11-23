

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameTest.
 *
 * Most of the methods call other, already made methods.
 * It is hence useless to test them.
 * For untested methods, it's because they are not 
 * complete yet (not sure about the returns/params.
 * Our class diagram has changed.)
 * 
 * @author  (Groupe 5)
 * @version (V1 - 23/11/17)
 */
public class GameTest
{
    private Game game1;
    /**
     * Default constructor for test class GameTest
     */
    public GameTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        game1 = new Game(1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Test if the player is the one define at the beginning 
     *
     */
    @Test
    public void testGetInformationPlayer()
    {
        assertEquals(5, game1.thePlayer.getStrStat());
    }

    /**
     * Test if the player has well changing the current room 
     *
     */
    @Test
    public void testChangeRoom()
    {
        game1.changeRoom();
        assertEquals("Corridor", game1.theRoom.getName()); 
    }
}
