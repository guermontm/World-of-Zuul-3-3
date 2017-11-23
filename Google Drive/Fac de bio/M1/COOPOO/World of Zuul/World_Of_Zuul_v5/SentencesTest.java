import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


/**
 * The test class SentencesTest of the Sentences class.
 * Some test are done : 
 * 
 * * testGetNull(), testing the getters. To test if the lists are null (level1)
 * * testGetEmpty(), testing the getters. To test if the lists contain a void string. (level2)
 * * testGetGreat(), testing the getters. To test if the random lists are well written. (level3)
 * * testRandomSentence(), testing the randomSentence class. To test if one of the random sentences is well sent back, by passing an arrayList.
 * * testRandomNumber(), testing the randomNumber class
 *  
 *  
 *
 * @Groupe 5
 * @23/11/2017
 */
public class SentencesTest
{
    private Sentences sent;
    /**
     * Default constructor for test class SentencesTest
     */
    public SentencesTest()
    {
    }

    /**
     * Sets up the test fixture.
     * 
     * Sentences class is called before every test case method.
     */
    @Before
    public void setUp()
    {
        sent= new Sentences();
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
     * Test for the getters
     * Test if all the lists are null (size=0)
     * False if a list is null
     * True if a list has a size higher than 0.
     * 
     */
    @Test
    public void testGetNull()
    {
        //test random lists
        assertEquals(false, sent.getListAxel().size()==0);
        assertEquals(false, sent.getListMartin().size()==0);
        assertEquals(false, sent.getListNolan().size()==0);
        assertEquals(false, sent.getListValentin().size()==0);
        assertEquals(false, sent.getListGuardian().size()==0);
        assertEquals(false, sent.getListThomas().size()==0);
        assertEquals(false, sent.getListMorgane().size()==0);
        assertEquals(false, sent.getListMarie().size()==0);
        assertEquals(false, sent.getListClement().size()==0);
        assertEquals(false, sent.getListMrsGeniet().size()==0);
        
        //test conversation lists
        assertEquals(false, sent.getListMainMrsGeniet().size()==0);
        assertEquals(false, sent.getListMainAxel().size()==0);
        assertEquals(false, sent.getListMainMartin().size()==0);
        assertEquals(false, sent.getListMainNolan().size()==0);
        assertEquals(false, sent.getListMainGuardian().size()==0);
        assertEquals(false, sent.getListMainPG().size()==0);
    }

    
    /**
     * test the getters of all lists
     * Test if a list contains a empty string : ""
     * False if at least one string of a list is empty
     * True if all strings have at least one character.
     */
    @Test
    public void testGetEmpty()
    {
       int i=0;
       //test random lists
        for(i=0; i<sent.getListAxel().size();i++)
        {
            assertEquals(false, sent.getListAxel().get(i) == "");
        }  
        
        for(i=0; i<sent.getListMartin().size();i++)
        {
            assertEquals(false, sent.getListMartin().get(i) == "");
        }    
        
        for(i=0; i<sent.getListNolan().size();i++)
        {
            assertEquals(false, sent.getListNolan().get(i) == "");
        }    
        
        for(i=0; i<sent.getListGuardian().size();i++)
        {
            assertEquals(false, sent.getListGuardian().get(i) == "");
        }    
        
        for(i=0; i<sent.getListValentin().size();i++)
        {
            assertEquals(false, sent.getListValentin().get(i) == "");
        }    
        
        for(i=0; i<sent.getListThomas().size();i++)
        {
            assertEquals(false, sent.getListThomas().get(i) == "");
        }    
        
        for(i=0; i<sent.getListMorgane().size();i++)
        {
            assertEquals(false, sent.getListMorgane().get(i) == "");
        }    
        
        for(i=0; i<sent.getListMarie().size();i++)
        {
            assertEquals(false, sent.getListMarie().get(i) == "");
        }    
        
        for(i=0; i<sent.getListClement().size();i++)
        {
            assertEquals(false, sent.getListClement().get(i) == "");
        }    
        
        for(i=0; i<sent.getListMrsGeniet().size();i++)
        {
            assertEquals(false, sent.getListMrsGeniet().get(i) == "");
        }    
        
        
        //test conversation lists
        for(i=0; i<sent.getListMainMrsGeniet().size();i++)
        {
            assertEquals(false, sent.getListMainMrsGeniet().get(i) == "");
        }   
        
        for(i=0; i<sent.getListMainAxel().size();i++)
        {
            assertEquals(false, sent.getListMainAxel().get(i) == "");
        }   
        
        for(i=0; i<sent.getListMainNolan().size();i++)
        {
            assertEquals(false, sent.getListMainNolan().get(i) == "");
        }   
        
        for(i=0; i<sent.getListMainMartin().size();i++)
        {
            assertEquals(false, sent.getListMainMartin().get(i) == "");
        }  
        
        for(i=0; i<sent.getListMainGuardian().size();i++)
        {
            assertEquals(false, sent.getListMainGuardian().get(i) == "");
        }
        
        for(i=0; i<sent.getListMainPG().size();i++)
        {
            assertEquals(false, sent.getListMainPG().get(i) == "");
        }
        
    }
    
    
    
    
    /**
     * test the getters of all random lists
     * The sentences have to be well written.
     * False if  at least one sentence is not well written
     * True if all the sentences are well written.
     * 
     */
    @Test
    public void testGetGreat()
    {
        ArrayList<String> listTest;
        listTest = new ArrayList<String>();
        
        listTest.add("*is tired*");
        listTest.add("You have to finish the COOPOO test.");
        listTest.add("If you get tired, you can buy food here.");
        assertEquals(listTest,sent.getListAxel());
        listTest.clear();
        
        listTest.add("Hurry up ! We have to code, what are you waiting for?");
        listTest.add("Thanks for my L3 diploma ;)");
        listTest.add("Je vois pas pourquoi je parlerais anglais dans ton jeu, je suis un PNJ libre");
        assertEquals(listTest,sent.getListMartin());
        listTest.clear();
        
        listTest.add("I have the toilet phobia now..");
        listTest.add("I am hungry");
        listTest.add("Let's go to work, I want to go home");
        assertEquals(listTest,sent.getListNolan());
        listTest.clear();
        
        listTest.add("I am loner, my life is over. The topic of COOPOO stares me, I want to become nobody");
        listTest.add("*leans out the window* I want to finish it, My COOPOO mates are not here");
        assertEquals(listTest,sent.getListValentin());
        listTest.clear();
        
        listTest.add("I am your father");
        listTest.add("When you do not have the strength, you must have the ruse, the weapon of intelligence.");
        listTest.add("It's been 20 years that I keep nights and days this elevator.");
        assertEquals(listTest,sent.getListGuardian());
        listTest.clear();
        
        listTest.add("Alright");
        listTest.add("psss psss pssssss *does not speak loudly, it seems not possible to hear him*");
        assertEquals(listTest,sent.getListThomas());
        listTest.clear();
        
        listTest.add("*Burp*");
        listTest.add("It's not because you are in a game that you have to talk to everybody !");
        assertEquals(listTest,sent.getListMorgane());
        listTest.clear();
        
        listTest.add("It seems to me that Nolan wanted to go to the toilet");
        listTest.add("I am working the COOPOO");
        assertEquals(listTest,sent.getListMarie());
        listTest.clear();
        
        listTest.add("chut");
        listTest.add("I am listening to the students");
        assertEquals(listTest,sent.getListMrsGeniet());
        listTest.clear();
        
        listTest.add("Hey, how are you?");
        listTest.add("I feel great today !");
        assertEquals(listTest,sent.getListClement());
        listTest.clear();
    }

    
    /**
     * Test the randomSentence method
     * Test if the randomSentence sent back randomly at least one of the three sentences of the listAxel arrayList.
     * "listTest" an arrayList having the strings of listAxel
     * s1 the string which is sent back by randomSentence method.  
     * 
     * True if s1 corresponds to one of the three cases.
     * False if s1 doesn't correspond to one of the three cases. 
     * 
     */
    @Test
     public void testRandomSentence()
     {
        ArrayList<String> listTest;
        listTest = new ArrayList<String>();
        listTest = sent.getListAxel();
        String s1; 
        s1 = sent.randomSentence(listTest);
        switch (s1) {
            case "is tired":
            assertEquals(listTest.get(0),s1);
            break;
            case "You have to finish the COOPOO test.":
            assertEquals(listTest.get(1),s1);
            break;
            case "If you get tired, you can buy food here.":
            assertEquals(listTest.get(2),s1);
            break;
            default:
            System.out.println("impossible");
        }
    }
    
    
    
    /**
     * test the randomNumber class.
     * This last class gives a random number between 0 and a number (=size)
     * Here, the number chosen is 1. So, the random number must be equal to 0.
     * The test is done 10 times, to be sure that the random method works.
     * i the integer for the loop.
     * 
     * False if the number is not 0
     * True if the number is 0.
     */
    @Test
    public void testRandomNumber()
    {
        int i=0;
        for(i=0;i<=10;i++)
        {
            assertEquals(0, sent.randomNumber(1));
        }        
    }
}




