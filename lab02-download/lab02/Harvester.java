
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  The class is called Harvester. The methods used in this class is to
 *  hop and pick. 
 *
 *  @author thulasiramanmt
 *  @version 2023.09.02
 */
public class Harvester
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Harvester object.
     */
    public Harvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }
    /**
     * One hop and one pick flower. 
     */
    public void hopAndPick()
    {
        this.hop();
        this.pick();

    }
    /**
     * Using hopAndPick twice
     */
    public void hop2AndPick()
    {
        this.hopAndPick();
        this.hopAndPick();
    }
    /**
     * Using the hopAndPick methos three times
     */
    public void harvestRow()
    {
        this.hop2AndPick();
        this.hop2AndPick();
        this.hop2AndPick();
    }
    //~ Methods ...............................................................


}
