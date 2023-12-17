import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  The NetIsland class represents an island where the NetRemover
 *  Jeroo can perform a specific program. 
 *
 *  @author thulasiramanmt
 *  @version 2023.10.09
 */
public class NetIsland
    extends NetIslandBase
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created NetIsland object.
     */
    public NetIsland()
    {
        super();
    }
    /**
     * This creates a new NetRemover. Which starts at 3,1.
     */
    public void myProgram()
    {
        NetRemover ted = new NetRemover();
        this.addObject(ted, 3, 1);
        ted.pickFlowersAndDisableNets();
    }
}
