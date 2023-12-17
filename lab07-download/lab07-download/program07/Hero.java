
//-------------------------------------------------------------------------
/**
 *  The `Hero` class is a subclass of EnhancedUnit, 
 *  representing powerful game units with enhanced attributes.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class Hero extends EnhancedUnit
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * The Hero class is a subclass of 
     * EnhancedUnit, representing 
     * powerful game units with enhanced attributes.
     * 
     * @param name The name of the hero.
     * @param points The point value of the hero.
     */
    public Hero(String name, int points) 
    {
        super(name, points); 
        setQuality(5);
        setDefense(5);
    }


    //~ Methods ...............................................................


}
