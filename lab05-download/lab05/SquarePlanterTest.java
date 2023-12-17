import student.micro.*;
import static org.assertj.core.api.Assertions.*;

import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;


// -------------------------------------------------------------------------
/**
 *  This test class is a class to test the SquarePlanter class. 
 *  it checks if the mthods are functioning correctly. 
 *  Summarize what your test objectives are.
 *  
 *  // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt
 *
 *  @author thulasiramanmt
 *  @version 2023.09.25
 */
public class SquarePlanterTest
    extends TestCase
{
    //~ Fields ................................................................
    /**
     * The SquarePlanter object to be used for testing. 
     */
    private SquarePlanter jeroo;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SquarePlanterTest test object.
     */
    public SquarePlanterTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    /**
     * Test the plantSquare(); method. 
     * This verifies that the methods plants a square. 
     */
    public void testplantSquare()
    {
        jeroo.plantSquare();
        
        assertThat(jeroo.getX()).isEqualTo(2);
        assertThat(jeroo.getY()).isEqualTo(2);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    /**
     * Tests the plantOneSide(); method. 
     * This verifies if the methods plants one side of the square. 
     */
    public void testplantOneSide()
    {
        jeroo.plantOneSide();
        
        assertThat(jeroo.getX()).isEqualTo(6);
        assertThat(jeroo.getY()).isEqualTo(2);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        Island island = new Lab05Island();
        jeroo = new SquarePlanter(4);
        island.addObject(jeroo, 2, 2);
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
