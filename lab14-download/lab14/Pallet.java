// -------------------------------------------------------------------------
/**
 *  A pallet is a stack of bricks on a wooden base.
 *  This class is a part of an application for a company producing bricks.
 *  Bricks are delivered in pallets (stacks of bricks).  This class
 *  is supposed to provide methods telling its height and weight.
 *
 *  There are (at least) four errors in this project. Find them. Fix them.
 *
 * @author Mridula Thulasiraman (thulasiramanmt)
 * @version 2023-12-04
 */
public class Pallet
{
    //~ Instance/static variables .............................................

    private Brick aBrick;
    private int   bricksInPlane;
    private int   height;
    
    // constants:
    private static final double BASEWEIGHT = 6.5;  // in kg
    private static final double BASEHEIGHT = 15;   // in cm


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a pallet with a given number of bricks.
     * @param bricksInPlane  is the number of bricks in each level on the
     *                       base
     * @param height         is the number of bricks stacked on top of each
     *                       other
     */
    public Pallet(int bricksInPlane, int height)
    {
        aBrick = new Brick(8, 20, 12);
        this.bricksInPlane = bricksInPlane;
        this.height        = height;
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get the weight of this pallet.
     * @return the weight of the pallet (in kg)
     */
    public double getWeight()
    {
        int numberOfBricks = bricksInPlane * height;
        return aBrick.getWeight() * numberOfBricks + BASEWEIGHT;
    }


    // ----------------------------------------------------------
    /**
     * Get the height of this pallet.
     * return the height of this stack (in cm)
     * @return BaseHeight the heighggt of the 
     * pallet (in kg)
     */
    public double getHeight()
    {
        if (bricksInPlane == 0)
        {
            return BASEHEIGHT;
        }
        return (aBrick.getHeight() * height) + BASEHEIGHT;
    }
}
