
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  This class extends planter, and has methods
 *  that is designed to make the jeroo
 *  plant in a square. 
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.09.25
 *  // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt
 */
public class SquarePlanter
    extends Jeroo
{
    //~ Fields ................................................................
    /**
     * The number of flowers to plant on each side
     */
    private int numFlowers;
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created SquarePlanter object.
     * @param flowersPerSide 
     * The number of flowers to plant on each side.     
     */
    public SquarePlanter(int flowersPerSide)
    {
        super(flowersPerSide * 4);
        numFlowers = flowersPerSide * 4;
        /*# Do any work to initialize your class here. */
    }
    /**
     * Plants flower in a square by making 4 side and planting on each side. 
     */
    public void plantSquare()
    {
        for (int i = 0; i < 4; i++) 
        {
            plantOneSide();
            this.turn(RIGHT);
        }
    }
    /**
     * Plants flowers on one side of the square. 
     */
    public void plantOneSide()
    {
        for (int i = 0; i < numFlowers / 4; i++) 
        {
            this.hop();
            this.plant();
        }
    }

    //~ Methods ...............................................................

}
