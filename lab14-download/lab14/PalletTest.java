import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  This test class tests the Pallet class
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.12.04
 */
public class PalletTest
    extends TestCase
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PalletTest test object.
     */
    public PalletTest()
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
        /*# Pick your own values instead of those used below */
    }


    // ----------------------------------------------------------
    /**
     * Test the basic accessors on a brand new Pallet.
     */
    public void testPalletConstructor()
    {
        /*# Put your own assertions in here. */
        int bricksInPlane = 5;
        int height = 3;
        
        Pallet pallet = new Pallet(bricksInPlane, height);
        
        assertThat(bricksInPlane).isEqualTo(5);
        assertThat(height).isEqualTo(3);
        
    }
    /**
     * tests the getWeight()
     */
    public void testGetWeight()
    {
        //tests with positive number bricks
        Pallet pallet1 = new Pallet(5, 3);
        assertThat(pallet1.getWeight()).isEqualTo(64.1, within(0.01));
        
        //tests with 0 number bricks
        Pallet pallet2 = new Pallet(0, 0);
        assertThat(pallet2.getWeight()).isEqualTo(6.5, within(0.01));
        
        // Test with a large number of bricks
        Pallet pallet3 = new Pallet(100, 100);
        assertThat(pallet3.getWeight()).isEqualTo(38406.5, within(0.01));
        
    }
    /**
     * tests the getHeight()
     */
    public void testGetHeight()
    {
        // Test with positive number of bricks in plane and stack
        Pallet pallet1 = new Pallet(4, 2);
        assertThat(pallet1.getHeight()).isEqualTo(31.0, within(0.01));
        
        // Test with zero bricks in plane and stack
        Pallet pallet2 = new Pallet(0, 0);
        assertThat(pallet2.getHeight()).isEqualTo(15.0, within(0.01));
        
        // Test with a large number of bricks
        Pallet pallet3 = new Pallet(50, 50);
        assertThat(pallet3.getHeight()).isEqualTo(415.0, within(0.01));
        
    }

}
