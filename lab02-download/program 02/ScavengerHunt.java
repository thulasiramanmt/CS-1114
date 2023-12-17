
//-------------------------------------------------------------------------
/**
 *  This class is called ScavengerHunt which inherits LongIsland. 
 *  The method is used to create a jeroo which will collect flowers. 
 *
 *  @author thulasiramanmt
 *  @version 2023.09.05
 */
//Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt

public class ScavengerHunt
        extends LongIsland
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created ScavengerHunt object.
     */
    public ScavengerHunt()
    {
        super();
        /*# Do any work to initialize your class here. */
    }
    /**
     * Creating myProgram with new Scavenger.
     */
    public void myProgram()
    {
        Scavenger jeroo = new Scavenger();
        this.addObject(jeroo, 1, 5);
        jeroo.collectFlowers();
    }


    //~ Methods ...............................................................


}
