import java.util.*;

//-------------------------------------------------------------------------
/**
 *  The Unit class represents playable game units with 
 *  attributes like name, points, quality, and defense.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class Unit 
    implements GameElement
{
    //~ Fields ................................................................
    private String name;
    private int points;
    private int quality;
    private int defense;
    private List<Upgrade> upgrades;

    //~ Constructor ...........................................................
    /**
     * Initializes a newly created Unit 
     * object with the provided name and points.
     * 
     * @param name The name of the unit.
     * @param points The point value of the unit.
     */
    public Unit(String name, int points) {
        this.name = name;
        this.points = points;
        this.quality = 2;
        this.defense = 2;
        this.upgrades = new ArrayList<>();
    }
    // ----------------------------------------------------------
    /**
     * Initializes a newly created Unit object.
     */
    public Unit()
    {
        super();
        /*# Do any work to initialize your class here. */
    }

    //~ Methods ...............................................................
    /**
     * Gets the name of the unit.
     *
     * @return The name of the unit as a string.
     */
    public String getName() 
    {
        return name;
    }
    /**
     * Sets the name of the unit.
     * @param name The new name for the unit.
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    /**
     * Gets the point value of the unit.
     *
     * @return The point value of the unit as an integer.

     */
    public int getPoints() 
    {
        int totalPoints = points;
        for (Upgrade upgrade : upgrades) 
        {
            totalPoints += upgrade.getPoints();
        }
        return totalPoints;
    }
    /**
     * Sets the point value of the unit.
     *
     * @param points The new point value for the unit.
     */
    public void setPoints(int points) 
    {
        this.points = points;
    }
    /**
     * Gets the quality of the unit.
     *
     * @return The quality of the unit as an integer.
     */
    public int getQuality() 
    {
        return quality;
    }
    /**
     * Sets the quality of the unit.
     *
     * @param quality The new quality value for the unit.
     */
    public void setQuality(int quality) 
    {
        this.quality = quality;
    }
    /**
     * Gets the defense of the unit.
     *
     * @return The defense of the unit as an integer.
     */
    public int getDefense() 
    {
        return defense;
    }
    /**
     * Sets the defense of the unit.
     *
     * @param defense The new defense value for the unit.
     */
    public void setDefense(int defense) 
    {
        this.defense = defense;
    }
    /**
     * @return List the upgrades.
     */
    public List<Upgrade> getUpgrades() 
    {
        return upgrades;
    }
    /**
     * this methods adds to the upgrades
     * @param upgrade 
     */
    public void addUpgrade(Upgrade upgrade) 
    {
        upgrades.add(upgrade);
    }
    /**
     * this method removes upgrades.
     * @param upgrade the upgrade
     */
    public void removeUpgrade(Upgrade upgrade) 
    {
        upgrades.remove(upgrade);
    }
    /**
     * this is method overiding method.
     */
    @Override
    public String toString() 
    {
        String unitString = name + " (" 
            + getPoints() + ", " + quality + ", " + defense + ")";
        if (!upgrades.isEmpty()) 
        {
            unitString += " upgrades:" + upgrades;
        }
        return unitString;
    }
}