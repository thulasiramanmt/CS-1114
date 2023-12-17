
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  This subclass is called SkippingHarvester. The method used in this class
 *  is to hopAndPick, and then add a hop. 
 *
 *  @author thulasiramanmt
 *  @version 2023.09.02
 */
public class SkippingHarvester
    extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created SkippingHarvester object.
     */
    public SkippingHarvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }
    
    /**
     * Using the hopeAndPick method and added another hop
     */
    public void hop2AndPick()
    {
        this.hopAndPick();
        this.hop();
    }

    //~ Methods ...............................................................


}
