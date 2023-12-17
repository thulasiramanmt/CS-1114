
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  The Scavenger represents a Jeroo that is designed to move
 *  arround the island,collecting flowers based on a 
 *  set of predefined methods.
 *  
 *  This class extends the Jeroo class and provdies methods
 *  collecting flowers in a specific order. 
 *
 *  @author thulasiramanmt
 *  @version 2023.09.11
 */
//Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt
public class Scavenger
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Scavenger object.
     */
    public Scavenger()
    {
        super();
        /*# Do any work to initialize your class here. */
    }
    /**
     * This methos is used to call other methods to collect 
     * all the flowers. 
     */
    public void collectFlowers()
    {   
        this.hop();
        this.turn(LEFT);
        this.hop();
        this.turn(RIGHT);
        this.hop();
        this.hop();
    }
}

    
    
    


    //~ Methods ..........................................................
