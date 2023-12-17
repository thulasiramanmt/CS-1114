
//-------------------------------------------------------------------------
/**
 *  The `Upgrade` class represents game upgrades with a name and point cost.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.24
 */
public class Upgrade 
    implements GameElement
{
    //~ Fields ................................................................
    private String name;
    private int points;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created Upgrade object.
     * @param name The name (and description) of the upgrade.
     * @param points The point value of the upgrade.
     * 
     */
    public Upgrade(String name, int points) 
    {
        this.name = name;
        this.points = points;
    }


    //~ Methods ...............................................................

    /**
     * Gets the name of the upgrade.
     *
     * @return The name of the upgrade as a string.
     */
    public String getName() 
    {
        return name;
    }
    /**
     * Sets the name of the upgrade.
     *
     * @param name The new name for the upgrade.
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    /**
     * Gets the point cost of the upgrade.
     *
     * @return The point cost of the upgrade as an integer.
     */
    public int getPoints() 
    {
        return points;
    }
    /**
     * Sets the point cost of the upgrade.
     *
     * @param points The new point cost for the upgrade.
     */
    public void setPoints(int points) 
    {
        this.points = points;
    }
    /**
     * 
     */
    @Override
    public String toString() 
    {
        return name + " (" + points + ")";
    }
}