import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  A Jeroo that walks every cell in on an island and uses delegation
 *  to instruct a second jeroo to follow its motions and plant a flower
 *  anywhere it finds one.
 *
 *  @author Stephen Edwards
 *  @version 2021.10.03
 */
public class CopyingJeroo
    extends Jeroo
{
    //~ Fields ................................................................
    private Jeroo bob;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created CopyingJeroo object.
     * 
     * @param copier the Jerro to copy. 
     */
    public CopyingJeroo(Jeroo copier)
    {
        super();
        this.bob = copier;
    }


    //~ Methods ...............................................................
    // ----------------------------------------------------------

    /**
     *Overrides the hop method.
     */
    @Override
    public void hop()
    {
        super.hop(); 
        bob.hop();
    }

    /**
     * Overrides the turn method.
     */
    @Override
    public void turn(RelativeDirection dir)
    {
        super.turn(dir); 
        bob.turn(dir); 
    }
    /**
     * Walk a pattern over every grid location on the current island.
     */
    public void walkIsland()
    {
        for (int numRows = 0; numRows <= 6;) 
        {
            this.hopToWater();
            this.facingTurn();
            numRows++;
        }
        this.hopToWater();
    }

    // ----------------------------------------------------------
    /**
     * Hop forward until we reach the water.
     */
    public void hopToWater()
    {
        while (!this.seesWater(AHEAD))
        {
            if(this.seesFlower(HERE))
            {
                bob.plant();
            }
            this.hop();
        }
        if (this.seesFlower(HERE))
        {
            bob.plant();
        }
    }
    /**
     * Turns, then hops and turns again, to deal
     * with corners.
     */
    public void facingTurn()
    {
        if (this.seesWater(AHEAD) && (this.isFacing(EAST)))
        {
            this.turn(RIGHT);
            this.hop();
            this.turn(RIGHT);
        }
        else
        {
            this.turn(LEFT);
            this.hop();
            this.turn(LEFT);
        }
    }
}