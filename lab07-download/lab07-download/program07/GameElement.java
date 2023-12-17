
//-------------------------------------------------------------------------
/**
 *  The GameElement interface represents 
 *  objects in a game with a name and point cost.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 *  
 *  // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (pid)
 */
public interface GameElement
{
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get this GameElement's name.
     *
     * @return This object's name as a string.
     */
    public String getName();

    // ----------------------------------------------------------
    /**
     * Get this GameElement's cost in points.
     *
     * @return The number of points for this object.
     */
    public int getPoints();
}