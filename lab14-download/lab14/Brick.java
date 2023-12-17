// -------------------------------------------------------------------------
/**
 *  Models a simple brick.
 *  This class is a part of an application for a company producing bricks.
 *  Bricks are delivered in palettes (stacks of bricks).
 * 
 *  There are (at least) four errors in this project. Find them. Fix them.
 *
 * @author Mridula Thulasiraman (thulasiramanmt)
 * @version 2023-12-04
 */
public class Brick
{
    //~ Instance/static variables .............................................

    // instance variables:
    private int height;
    private int width;
    private int depth;

    // Constant: weight per cubic cm in grams
    private static final int WEIGHT_PER_CM3 = 2;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a Brick. Parameters are edge lengths.
     * @param height in centimeters
     * @param width  in centimeters
     * @param depth  in centimeters
     */
    public Brick(int height, int width, int depth)
    {
        this.height = height;
        this.width  = width;
        this.depth  = depth;
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get this brick's surface area.
     * @return the surface area in square centimeters
     */
    public double getSurfaceArea()
    {
        double side1 = width * height;
        double side2 = width * depth;
        double side3 = depth * height;
        double total = (side1 + side2 + side3) * 2;

        return total;
    }


    // ----------------------------------------------------------
    /**
     * Get this brick's weight.
     * @return the weight in kg.
     */
    public double getWeight()
    {
        return (getVolume() * WEIGHT_PER_CM3) / 1000;
    }


    // ----------------------------------------------------------
    /**
     * Get this brick's volume.
     * @return the volume in qubic centimeters
     */
    public double getVolume()
    {
        return width * height * depth;
    }

    /**
     * Get this brick's height
     * @return height  the hieght in 
     * qubic centimeters
     */
    public double getHeight()
    {
        return height;
    }
}
