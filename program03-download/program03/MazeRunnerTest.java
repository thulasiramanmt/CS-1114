import student.micro.*;
import static org.assertj.core.api.Assertions.*;

import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
// -------------------------------------------------------------------------
/**
 *  The test class for the MazeRunner class
 *  verifies the corectnedd of it's methods, that is deisgined
 *  to naviagate through various maze senarios, 
 *  and disabling nets. 
 *  Summarize what your test objectives are.
 *  // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt
 *
 *  @author thulasiramant
 *  @version 2023.09.19
 */
public class MazeRunnerTest
    extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
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

    }
    /**
     * Test the runner.clearMaze(); method to verify that it 
     * sucessfully clears the maze, and stop when it retunrs to
     * it's starting position in the same facing direction. 
     */
    public void testClearMaze()
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        island.addObject(new Flower(), 1, 1); 
        island.addObject(new Net(), 1, 2);

        runner.clearMaze();

        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(island.countNets()).isEqualTo(0);
    }
    /**
     * Tests the runner.goingMaze() method to verify
     * that the jeroo can handle different sitatuations
     * throughtout the maze. 
     */
    public void testGoingMaze()
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 3);
        island.addObject(new Flower(), 1, 3);
        island.addObject(new Flower(), 2, 3);
        island.addObject(new Net(), 3, 3); 

        runner.goingMaze();

        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(island.countNets()).isEqualTo(0);
    }
    /**
     * Tests the runner.onlyWaterRight() method to verify
     * that the jeroo
     * can follow the right hand rule. 
     */
    public void testWaterRight() 
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 7);

        runner.onlyWaterRight();

        assertThat(runner.getX()).isEqualTo(2);
        assertThat(runner.getY()).isEqualTo(7);
    }
    /**
     * Test the runner.waterRightAndAhead() method to verify
     * that the jerro can handle 
     * a turn to the left or a dead end. 
     */
    public void testWaterRightAndAhead() 
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 6, 7);
        runner.isFacing(EAST);

        runner.waterRightAndAhead();
        assertThat(runner.getX()).isEqualTo(6);
        assertThat(runner.getY()).isEqualTo(7);
    }
    /**
     * Test the runner.noWater() method to verify that
     * the jeroo can handle when it does not see
     * water to the right. 
     */
    public void testNoWater() 
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 5, 3);

        runner.noWater();

        assertThat(runner.getX()).isEqualTo(5);
        assertThat(runner.getY()).isEqualTo(4);
    }
    /**
     * Test the runner.FlowerHere() method to verify that it 
     * corectly picks flowers when it's on a Flower. 
     */
    public void testFlowerHere() 
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 2);
        island.addObject(new Flower(), 1, 2);

        runner.flowerHere();

        assertThat(island.countFlowers()).isEqualTo(0);
    }
    /**
     * Tests the runner.diableNet() method to verify,
     * that it correctly disables nets, when it sees one 
     * ahead. 
     */
    public void testNetAhead() 
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 5, 3);
        island.addObject(new Net(), 6, 3);

        runner.netAhead();
        assertThat(island.countNets()).isEqualTo(0);
    }
    /**
     * Tests the runner.flowerAhead(); method to verify
     * that it correcly picks a flower it sees
     * ahead. 
     */
    public void testFlowerAhead()
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 3, 3);
        island.addObject(new Flower(), 4, 3);

        runner.flowerAhead();
        
        assertThat(island.countFlowers()).isEqualTo(0);
    }
}

    
// ----------------------------------------------------------
/*# Insert your own test methods here */
