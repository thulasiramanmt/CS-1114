import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  This test class test the Copying jerro Tests. 
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.09
 */
public class CopyingJerooTest
    extends TestCase
{
    //~ Fields ................................................................

    private Island island;
    private CopyingJeroo jeroo;
    private Jeroo copier;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CopyingJerooTest test object.
     */
    public CopyingJerooTest()
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
        // empty sub for set up which was given as default. 
    }


    // ----------------------------------------------------------
    /**
     * Check hopToWater(), assuming that setUp() places the
     * jeroo at (1, 1) facing east.
     */
    public void testHopToWater()
    {
        island = new DualIsland();
        copier = new Jeroo(1000);
        Flower flower = new Flower();
        jeroo = new CopyingJeroo(copier);
        island.addObject(jeroo, 1, 1);
        island.addObject(copier, 10, 1);
        island.addObject(flower, 8, 1);   
        jeroo.hopToWater();
        
        assertThat(jeroo.getX()).isEqualTo(8);
        assertThat(jeroo.getY()).isEqualTo(1);
        
    }
     /**
     * Check facingTurn(), assuming that setUp() places the
     * jeroo at (1, 1) facing east.
     */
    public void testFacingWEST()
    {
        island = new DualIsland();
        copier = new Jeroo(1000);
        jeroo = new CopyingJeroo(copier);
        island.addObject(jeroo, 1, 2);
        island.addObject(copier, 10, 2);
        
        jeroo.facingTurn();
        
        assertThat(jeroo.getX()).isEqualTo(1);
        assertThat(jeroo.getY()).isEqualTo(1);
        
    }
    /**
     * Check walksIsland(), assuming that setUp() places the
     * jeroo at (1, 1) facing east.
     */
    public void testWalkIsland()
    {
        island = new DualIsland();
        copier = new Jeroo(1000);
        jeroo = new CopyingJeroo(copier);
        island.addObject(jeroo, 1, 1);
        island.addObject(copier, 10, 1);
        
        jeroo.walkIsland();
        
        assertThat(jeroo.getX()).isEqualTo(1);
        assertThat(jeroo.getY()).isEqualTo(8);
        
    }
    /**
     * Check walksIsland(), assuming that setUp() places the
     * jeroo at (1, 1) facing east
     */
    public void testWalkIsland2()
    {
        island = new DualIsland();
        copier = new Jeroo(1000);
        jeroo = new CopyingJeroo(copier);
        island.addObject(jeroo, 1, 1);
        island.addObject(copier, 10, 1);
        
        jeroo.walkIsland();
        
        assertThat(island.hasFlowerAt(3, 3)).isEqualTo(true);
        assertThat(island.hasFlowerAt(4, 4)).isEqualTo(true);
        assertThat(island.hasFlowerAt(5, 5)).isEqualTo(true);
        assertThat(island.hasFlowerAt(6, 6)).isEqualTo(true);
        assertThat(island.hasFlowerAt(6, 7)).isEqualTo(true);
        assertThat(island.hasFlowerAt(7, 7)).isEqualTo(true);
        assertThat(island.hasFlowerAt(5, 7)).isEqualTo(true);
        assertThat(island.hasFlowerAt(3, 7)).isEqualTo(true);
        assertThat(island.hasFlowerAt(4, 7)).isEqualTo(true);
        assertThat(island.hasFlowerAt(11, 7)).isEqualTo(true);
        assertThat(island.hasFlowerAt(11, 6)).isEqualTo(true);
        assertThat(island.hasFlowerAt(11, 5)).isEqualTo(true);
        assertThat(island.hasFlowerAt(11, 4)).isEqualTo(true);
        assertThat(island.hasFlowerAt(11, 3)).isEqualTo(true);
        assertThat(island.hasFlowerAt(11, 2)).isEqualTo(true);
    }
}

