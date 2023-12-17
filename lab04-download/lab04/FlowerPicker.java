    
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  This calss is called FlowerPicked.
 *  The methods used is FlowerPicker(), pickLine(), turnAroundRight() and 
 *  pick2Lines(). 
 *  
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
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
public class FlowerPicker
    extends Jeroo
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created FlowerPicker object.
     */
    public FlowerPicker()
    {
        super();
    }
    /**
     * Picks one straight line of flowers, stopping when there are no
     * more flowers left.
     * @precondition The jeroo is standing on the first flower in the
     *               line, and is facing in the same direction as the
     *               line of flowers.
     * @postcondition The jeroo has picked the continuous line of
     *                flowers starting from where it was standing, it
     *                ends standing in the spot where the last flower
     *                was, still facing the same direction as before.
     */
    public void pickLine()
    {
        if (this.seesFlower(HERE))
        {
            this.pick();
        }
        while (this.seesFlower(AHEAD))
        {
            this.hop();
            this.pick();
        }
    }
    /**
     * Turns the jeroo completely around, while also moving one
     * square to the right of the starting position.
     * @precondition  The jeroo is not blocked one square to the
     *                right of its starting position.
     * @postcondition The jeroo is facing the opposite direction, and
     *                it ends standing in the spot that was one square
     *                immediately to the right relative to its
     *                position before the method was called.
     */
    public void turnAroundRight()
    {
        this.turn(RIGHT);
        this.hop();
        this.turn(RIGHT);
    }
    /**
     * Picks two straight line of flowers that are adjacent to each
     * other.  This involves picking the first line, and then turning
     * around to the right to pick the second line.
     * @precondition The jeroo is standing on the first flower in the
     *               first line, and is facing in the same direction
     *               as the line of flowers.  The second line of
     *               flowers is to the right of the first line,
     *               relative to the jeroo's position.
     * @postcondition The jeroo has picked the continuous line of
     *                flowers starting from where it was standing,
     *                turned around, and picked the second line of
     *                flowers.  It ends standing in the spot where the
     *                last flower in the second line was, facing the
     *                opposite direction from before.
     */
    public void pick2Lines()
    {
        this.pickLine();
        this.turnAroundRight();
        this.pickLine();
    }

    //~ Methods ...............................................................
}
