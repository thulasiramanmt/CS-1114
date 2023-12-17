
//-------------------------------------------------------------------------
/**
 *  The Monster class is a subclass of 
 *  EnhancedUnit, representing 
 *  formidable game units with enhanced attributes
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class Monster extends EnhancedUnit
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................
    
    /**
     * It initializes monsters with moderate quality and defense.
     *  @param name The name of the monster.
     * @param points The point value of the monster.
     */
    public Monster(String name, int points) 
    {
        super(name, points);
        setQuality(4);
        setDefense(4);
    }


    //~ Methods ...............................................................


}
