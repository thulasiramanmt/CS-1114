import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Represents a squad of units with enhanced attributes,
 *  providing the ability to manage 
 *  and manipulate a group of units.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.24
 */
public class Squad
    extends EnhancedUnit   
{
    //~ Fields ................................................................
    private List<Unit> units;
    private List<Upgrade> upgrades;
    private String specialRule;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created Squad object.
     * @param name the name of the squad
     */
    public Squad(String name)
    {
        super(name, 0);
        /*# Do any work to initialize your class here. */
        units = new ArrayList<Unit>();
        this.upgrades = new ArrayList<>();
        specialRule = ""; 
    }

    //~ Methods ...............................................................
    /**
     * Get the list of units in the squad.
     * @return unit
     */
    public List<Unit> getUnits() 
    {
        return units;
    }
    /**
     * Add a unit to the squad.
     * @param unit The unit to be added. 
     */
    public void addUnit(Unit unit) 
    {
        units.add(unit);
    }
    /**
     * Remove a unit from the squad.
     * @param unit The unit to be removes
     */
    public void removeUnit(Unit unit) 
    {
        units.remove(unit);
    }
    /**
     * Calculate and return the total points 
     */
    @Override
    public int getPoints() 
    {
        int totalPoints = 0;
        for (Unit unit : units) 
        {
            totalPoints += unit.getPoints();
        }
        for (Upgrade upgrade : getUpgrades()) 
        {
            totalPoints += upgrade.getPoints();
        }
        return totalPoints;
    }
    /**
     * string representatoin of the squad. 
     */
    @Override
    public String toString() 
    {
        String baseSquadString = super.toString() + " units:" + units;
        if (!upgrades.isEmpty()) 
        {
            baseSquadString += " upgrades:" + upgrades;
        }
        if (specialRule != null && !specialRule.isEmpty())
        {
            baseSquadString += " special rule:[" + specialRule + "]";
        }
        return baseSquadString;
    }
}
