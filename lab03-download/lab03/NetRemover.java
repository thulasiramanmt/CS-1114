
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  The NetRemover class represents a Jeroo that is desgined
 *  to navigate the island. If it sees a flower it picks it up
 *  until all the flowers are picked up
 *  and if it sees a net, it will disable the net unttill all
 *  the nets are diabled. 
 *
 *  @author thulasiramanmt
 *  @version 2023.10.09
 */
public class NetRemover
    extends Jeroo
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created NetRemover object.
     */
    public NetRemover()
    {
        super();
        /*# Do any work to initialize your class here. */
    }

    /**
     * Move the NetRemoves,pick flowers.  
     *  
     * It also disables nets that it encounters by tossing a 
     * flower. 
     */
    public void pickFlowersAndDisableNets()
    {
        if (this.seesFlower(RIGHT))
        {
            this.turn(RIGHT);
            while (this.seesFlower(AHEAD))
            {
                this.hop();
                this.pick();
            }
            this.turn(RIGHT);
            this.turn(RIGHT);
            while (!this.seesWater(AHEAD))
            {
                this.hop();
            }
            if (!this.seesNet(RIGHT))
            {
                this.turn(RIGHT);
                this.hop();
            }
            else
            {
                this.turn(RIGHT);
            }
            while (!this.seesNet(AHEAD))
            {
                this.hop();
            }
            while (this.seesNet(AHEAD))
            {
                if (this.hasFlower())
                {
                    this.toss();
                    this.hop();
                }
                else
                {
                    break;
                }
            }
        }
        if (this.seesNet(RIGHT) && (this.hasFlower()))
        {
            this.turn(RIGHT);
            this.toss();
            this.hop();
        }
        while (this.seesNet(AHEAD))
        {
            if (this.hasFlower())
            {
                this.toss();
                this.hop();
            }
            else
            {
                break;
            }
        }
    }
}

//~ Methods ..............................................................
