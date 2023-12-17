
//-------------------------------------------------------------------------
/**
 *  The EnhancedUnit class represents 
 *  game units with additional special rules 
 *  or abilities, extending the base Unit class.
 *
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.24
 */
public class EnhancedUnit 
    extends Unit {
    private String specialRule;
    
    //~ Fields ................................................................



    //~ Constructor ...........................................................
    /**
     * Initializes a newly created EnhancedUnit 
     * object with the provided name 
     * and points, and sets the specialRule to null.
     *
     * @param name The name of the enhanced unit.
     * @param points The point value of the enhanced unit.
     */
    public EnhancedUnit(String name, int points) 
    {
        super(name, points); 
        specialRule = null; 
    }
    // ----------------------------------------------------------
    /**
     * Initializes a newly created EnhancedUnit object.
     */
    public EnhancedUnit()
    {
        super();    
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    /**
     * Gets the special rule of the enhanced unit.
     * 
     * @return specialRule
     * 
     */
    public String getSpecialRule() 
    {
        return specialRule;
    }
    /**
     * Sets the special rule
     * 
     * @param specialRule The rule to set.
     */
    public void setSpecialRule(String specialRule) 
    {
        this.specialRule = specialRule;
    }
    /**
     * toString method
     */
    @Override
    public String toString() 
    {
        String baseUnitString = super.toString();
        if (getSpecialRule() != null) 
        {
            return baseUnitString + " special rule:[" + getSpecialRule() + "]";
        }
        return baseUnitString;
    }
}
