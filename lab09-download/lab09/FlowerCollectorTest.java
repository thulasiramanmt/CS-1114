import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;
    

// -------------------------------------------------------------------------
/**
 *  This test class, test the flowerCollector
 *  class. 
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.23
 */
public class FlowerCollectorTest
    extends TestCase
{
    //~ Fields ................................................................
    private FlowerIsland island;
    private FlowerCollector collector;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlowerCollectorTest test object.
     */
    public FlowerCollectorTest()
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
        island = new FlowerIsland(6, 6);
        collector = new FlowerCollector();
    }
    /**
     * Test the collecFlower Method. 
     */
    public void testCollectFlower()
    {
        island.addObject(collector, 1, 1);
        
        collector.collectFlowers();
        
        assertThat(collector.getX()).isEqualTo(4);
        assertThat(collector.getY()).isEqualTo(4);
        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(collector.getBasket()).size().isEqualTo(8);
        
    }
    /**
     * test the testBasket. 
     */
    public void testBasket()
    {
        assertThat(collector.getBasket()).size().isEqualTo(0);
    }
    /**
     * testing the pic method
     */
    public void testPick()
    {
        island.addObject(collector, 1, 1);
        
        collector.pick();
        
        assertThat(collector.getFlowers()).isEqualTo(0);
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
