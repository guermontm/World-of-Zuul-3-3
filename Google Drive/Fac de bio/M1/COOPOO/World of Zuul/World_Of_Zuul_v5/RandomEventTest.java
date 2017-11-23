import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RandomEventTest.
 *
 * @author  Group 5
 * @version 10/11/2017
 */
public class RandomEventTest
{
    private RandomEvent event;
    /**
     * Default constructor for test class RandomEventTest
     */
    public RandomEventTest()
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
        RandomEvent event = new RandomEvent();
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
    
    @Test
    public void testHiddenCandy()
    {
        event.hiddenCandy();
        assertEquals(false, event.player.getStaStat() >10);
    }
    
    @Test
    public void testAllanJoke()
    {
        event.allanJoke();
        assertEquals(false, event.player.getStressStat() != 0);
    }
    @Test
    public void testPillowAttack()
    {
        event.pillowAttack();
        assertEquals(false, event.player.getStaStat() <0);
    }
    @Test
    public void testAdaHelp()
    {
        event.adaHelp();
        assertEquals(false, event.player.getIntStat() >10);
        assertEquals(false, event.player.getStressStat() >10);
    }
    @Test
    public void testPenguinHug()
    {
        event.penguinHug();
        assertEquals(false, event.player.getStaStat() <0);
        assertEquals(false, event.player.getStressStat() <0);
    }
    @Test
    public void testTeacherMeeting()
    {
        event.teacherMeeting();
        assertEquals(false, event.player.getStressStat() >10);
    }
    @Test
    public void testConversation()
    {
        event.conversation();
        assertEquals(false, event.player.getStaStat() <0);
        assertEquals(false, event.player.getSpeStat() >10);
    }
}
