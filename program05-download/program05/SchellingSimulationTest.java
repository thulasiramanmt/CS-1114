import student.micro.*;
import static org.assertj.core.api.Assertions.*;

import student.media.*;
import java.awt.Color;
// -------------------------------------------------------------------------
/**
 *  This class test the SchellingSimulation Class. 
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.03
 */
public class SchellingSimulationTest
    extends TestCase
{
    //~ Fields ................................................................
    private SchellingSimulation picture;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SchellingSimulationTest test object.
     */
    public SchellingSimulationTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
        picture = new SchellingSimulation(3, 3);
        Pixel b = picture.getPixel(0, 0);
        Pixel p = picture.getPixel(1, 0);
        b.setColor(Color.ORANGE);
        p.setColor(Color.BLUE);
        
    }
    /**
     * Test method for checking the satisfaction threshold retrieval.
     */
    public void testGetSatisfactionThreshold()
    {
        picture.getSatisfactionThreshold();
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for setting the satisfaction threshold.
     */
    public void testSetSatisfactionThreshold()
    {
        picture.setSatisfactionThreshold(0.2);    
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for checking the retrieval of the redline value.
     */
    public void testGetRedLine()
    {
        picture.getRedLine();
        
        assertThat(picture.getRedLine()).isEqualTo(4);

    }
    /**
     * Test method for setting the redline value.
     */
    public void testSetRedLine()
    {
        picture.setRedLine(5);
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for populating the image.
     */
    public void testPopulate()
    {
        picture.populate(0, 0);
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for checking if two pixels have the same color.
     */
    public void testAreSameColor() 
    {
        Pixel b = picture.getPixel(0, 0);
        Pixel p = picture.getPixel(1, 0);
        b.setColor(Color.ORANGE);
        p.setColor(Color.BLUE);
        
        picture.areSameColor(p, b);
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for checking if a pixel represents an empty location.
     */
    public void testIsEmpty() 
    {
        Pixel b = picture.getPixel(0, 0);
        
        picture.isEmpty(b);
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for checking if an 
     * agent is satisfied at a pixel location.
     */
    public void testIsSatisfied() 
    {
        Pixel b = picture.getPixel(0, 0);
        
        picture.isEmpty(b);
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for attempting to 
     * relocate an agent to a new pixel location.
     */
    public void testMaybeRelocate() 
    {
        Pixel b = picture.getPixel(0, 0);

        picture.maybeRelocate(b);
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    /**
     * Test method for cycling through agent relocation.
     */
    public void testcycleAgents() 
    {
        Pixel b = picture.getPixel(0, 0);

        picture.maybeRelocate(b);
        
        assertThat(picture.getPixel(0, 0).getBlue()).isEqualTo(Color.ORANGE);
    }
    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
