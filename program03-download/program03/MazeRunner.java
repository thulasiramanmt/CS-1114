
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  The MazeRunner class represents a Jeroo that can navigate 
 *  through a maze, following a set of methods
 *  to clear the maze by picking flowers and disabling nets. 
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *  
 *  // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt
 *
 *  @author thulasiramanmt
 *  @version 2023.09.19
 */
public class MazeRunner
    extends Jeroo
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created MazeRunner object.
     */
    public MazeRunner()
    {
        super(10);
        /*# Do any work to initialize your class here. */
    }
    /**
     *  Clears the maze by navigating throught the maze using 
     *  this.goingMaze() method, and sucessfully stops. 
     *  @Precondition: The MazeRunner starts at positin (1, 1) 
     *  facing EAST. The MazeRunner initually holds 10 flowers. 
     *  
     *  @Postconditions: The MazeRunner return to positoin (1,1)
     *  facing EAST. The island is cleared, containing no flowers,
     *  and nets. 
     *  
     */
    public void clearMaze()
    {  
        int passCount = 0;
        while (passCount < 3) 
        {
            this.goingMaze();
            while (!(this.getX() == 1 && this.getY() == 1)) {
                this.goingMaze();
            }
            passCount++;
        }
    }
    /**
     * Multiple methods combined to navaviagte through the Maze
     * using the right-hand rule. 
     * 
     * @Preconditions: Jerro on 1,1. Standing with 10 flowers. 
     * 
     * @Posconditions: Jerro on 3,3. 
     * Island has no flowers, and Island has no nets. 
     */
    public void goingMaze()
    {
        this.flowerHere();
        this.netAhead();
        this.flowerAhead();
        if (this.seesWater(RIGHT) && (!this.seesWater(AHEAD))) 
        {
            this.onlyWaterRight();
        }
        this.waterRightAndAhead();
        if (!this.seesWater(RIGHT)) 
        {
            this.noWater();
        }
    }
    /**
     * Uses the Right hand rule to see if there is a net. 
     * 
     * @Preconditions: jerro sees Water to the Right or a net to the Right. 
     * 
     * @Postconsitions: jerro see Water to the Right and no net. 
     */
    public void onlyWaterRight()
    {
        if (this.seesNet(AHEAD))
        {
            this.toss();
            this.hop();
        }
        else
        {
            this.hop();
        }
    }
    /**
     * @Preconditions: Jeroo sees Water to the Right and Water Ahead. 
     * 
     * @Postconditions: Jeroo sees Water to the Right and no water Ahead. 
     */
    public void waterRightAndAhead()
    {
        if (this.seesWater(RIGHT) && this.seesWater(AHEAD)) 
        {
            this.turn(LEFT);
        }
    }
    /**
     * @Preconditions: Jeroo does not see water to the right. 
     * 
     * @Postconditions: Jerrp sees Water to the right. 
     */
    public void noWater()
    {
        this.turn(RIGHT);
        if (this.seesNet(AHEAD))
        {
            this.toss();
            this.hop();
        }
        else
        {
            this.hop();
        }
    }
    /** 
     * 
     * @Preconditions: Jeroo sees Net Ahead. 
     * 
     * @Postconditions: Jeroo sees no Net Ahead. 
     */
    public void netAhead()
    {
        if (this.seesNet(AHEAD))
        {
            this.toss(); 
        }
    }
    /**
     * @Preconditions: Jeroo is on a flower. 
     * 
     * @Postconditions: Jeroo is not on a flower. 
     * 
     */
    public void flowerHere()
    {
        if (this.seesFlower(HERE))
        {
            this.pick();
        }
    }
    /**
     * @Preconditions: Jerro sees flower ahead. 
     * 
     * @Postconditins: Jerro doesn't see flower ahead. 
     * 
     */
    public void flowerAhead()
    {
        if (this.seesFlower(AHEAD))
        {
            this.hop();
            this.pick();
        }
    }
}

//~ Methods ...............................................................
