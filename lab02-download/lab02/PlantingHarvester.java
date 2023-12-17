
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  This class is called PlantingHarvester. The method in this class is for 
 *  plant. 
 *
 *  @author thulasiramanmt
 *  @version 2023.09.02
 */
public class PlantingHarvester
    extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created PlantingHarvester object.
     */
    public PlantingHarvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }
    /**
     * Using supper to call the parent then usingn the hopAndPick method
        and the adding a hop and plant
     */
    public void hop2AndPick()
    { 
        super.hopAndPick();
        this.hop();
        this.plant();
    }

    //~ Methods ...............................................................


}
