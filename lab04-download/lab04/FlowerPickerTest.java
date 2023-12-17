import student.micro.*;
import static org.assertj.core.api.Assertions.*;

import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  This test class test the methods
 *  that picks the flower in the island.
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.09.18
 *  
 *  // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt
 */
public class FlowerPickerTest
    extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new FlowerPickerTest test object.
     */
    public FlowerPickerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    // ----------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * Test the pickLine() method on flower patch A's northwest corner.
     */
    public void testPickLine()
    {
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 2);
        // 2. Call the method(s) you are testing
        picker.pickLine();
        // 3. Make assertions capturing your expected outcomes
        // The jeroo should end at (6, 2), so check the x coordinate
        assertThat(picker.getX()).isEqualTo(6);
        assertThat(picker.getY()).isEqualTo(2);
        assertThat(picker.isFacing(EAST)).isTrue();
        //the number of flower the jerro picked
        assertThat(picker.getFlowers()).isEqualTo(5);
        //the number of flower that is left in the island
        assertThat(island.countFlowers()).isEqualTo(37);

    }
    /**
     * tests the method picker.pickLine(); on Flower bed D. 
     */
    public void testPickLineD()
    {
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 8, 2);
        // 2. Call the method(s) you are testing
        picker.pickLine();
        // 3. Make assertions capturing your expected outcomes
        // The jeroo should end at (6, 2), so check the x coordinate
        assertThat(picker.getX()).isEqualTo(9);
        assertThat(picker.getY()).isEqualTo(2);
        assertThat(picker.isFacing(EAST)).isTrue();
        //the number of flower the jerro picked
        assertThat(picker.getFlowers()).isEqualTo(1);
        //the number of flower that is left in the island
        assertThat(island.countFlowers()).isEqualTo(41);

    }
    /**
     * tests the method picker.pickLine(); 
     * in flower bed E, by first turing Right
     * and running the method. 
     */
    public void testPickLineE()
    {
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 10, 8);
        // 2. Call the method(s) you are testing
        picker.turn(RIGHT);
        picker.pickLine();
        // 3. Make assertions capturing your expected outcomes
        // The jeroo should end at (6, 2), so check the x coordinate
        assertThat(picker.getX()).isEqualTo(10);
        assertThat(picker.getY()).isEqualTo(10);
        assertThat(picker.isFacing(SOUTH)).isTrue();
        //the number of flower the jerro picked
        assertThat(picker.getFlowers()).isEqualTo(3);
        //the number of flower that is left in the island
        assertThat(island.countFlowers()).isEqualTo(39);
    }
    /**
     * tests the method picker.turnAroundRight() in flower bed A.
     */
    public void testturnAroundRight()
    {
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 6, 2);
        // 2. Call the method(s) you are testing
        picker.turnAroundRight();
        // 3. Make assertions capturing your expected outcomes
        // The jeroo should end at (6, 2), so check the x coordinate
        assertThat(picker.getX()).isEqualTo(6);
        assertThat(picker.getY()).isEqualTo(3);
        assertThat(picker.isFacing(WEST)).isTrue();
    }
    /**
     * tests the method picker.pick2Lines(); on flower bed A. 
     */
    public void testpick2LinesA()
    {
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 2);
        // 2. Call the method(s) you are testing
        picker.pick2Lines();
        // 3. Make assertions capturing your expected outcomes
        // The jeroo should end at (6, 2), so check the x coordinate
        assertThat(picker.getX()).isEqualTo(2);
        assertThat(picker.getY()).isEqualTo(3);
        assertThat(picker.isFacing(WEST)).isTrue();
        //the number of flower the jerro picked
        assertThat(picker.getFlowers()).isEqualTo(10);
        //the number of flower that is left in the island
        assertThat(island.countFlowers()).isEqualTo(32);
    }
    /**
     * tests a flase case of method picker.pick2Lines(); 
     */
    public void testpick2LinesA1()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 3);
        // 2. Call the method(s) you are testing
        picker.pick2Lines();
        // 3. Make assertions capturing your expected outcomes
        // The jeroo should end at (6, 2), so check the x coordinate
        assertThat(picker.getX()).isEqualTo(6);
        assertThat(picker.getY()).isEqualTo(4);
        assertThat(picker.isFacing(WEST)).isTrue();
        //the number of flower the jerro picked
        assertThat(picker.getFlowers()).isEqualTo(5);
        //the number of flower that is left in the island
        assertThat(island.countFlowers()).isEqualTo(37);
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
