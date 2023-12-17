import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;

//-------------------------------------------------------------------------
/**
 *  This clas ipmlements the "left" command
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.27
 */
public class LeftCommand implements Command
{
    //~ Fields ................................................................
    private Jeroo jeroo;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created LeftCommand object.
     * @param jeroo the Jeroo
     */
    public LeftCommand(Jeroo jeroo)
    {
        this.jeroo = jeroo;
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    
    
    /**
     * turn left when 
     * the "left" is called.
     */
    public void execute()
    {
        jeroo.turn(LEFT);
    }

}
