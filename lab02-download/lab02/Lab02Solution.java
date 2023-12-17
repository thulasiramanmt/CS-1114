import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  The class is Lab02Solutions. Which is a constructor for various harvester
 *  objects, harvestRow object, SkippingHarvester object and Planting
 *  Harvester. 
 *
 *  @author thulasiramanmt
 *  @version 2023.09.02
 */
public class Lab02Solution
    extends PlantationIsland
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Lab02Solution object.
     */
    public Lab02Solution()
    {    
        super();
    }
    /**
     * My program().
     */
    public void myProgram()
    {
        // Creating Harvester Object
        Harvester bob = new Harvester();
        this.addObject(bob, 2, 3);
        bob.harvestRow();
        // Creating SkippingHarvester Object
        SkippingHarvester ted = new SkippingHarvester();
        this.addObject(ted, 2, 5);
        ted.harvestRow();
        //Creating PlantingHarvester Object
        PlantingHarvester cara = new PlantingHarvester();
        this.addObject(cara, 2, 7);
        cara.harvestRow();
    }



    //~ Methods ...............................................................


}
