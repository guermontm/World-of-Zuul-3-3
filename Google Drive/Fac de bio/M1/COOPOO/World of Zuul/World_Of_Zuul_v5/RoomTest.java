import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 * We do not test the methods related to the arrayLists. 
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RoomTest
{
    private Room theRoom;
    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
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
        Room theRoom = new Room();
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
     * Test method gor the getName() method in Room.java.
     * Makes sure that the default name is the one used when room is created
     * via default constructor.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Default Room", theRoom.getName());
    }
    
    /**
     * Test method for the getDescription() method in Room.java.
     * Checks that the default description is the one in the 
     * default constructor.
     */
    @Test
    public void testGetDescription()
    {
        assertEquals("You are not supposed to see this. If you see this, something went wrong at some point. Please report.\"", theRoom.getDescription())
    }
}
