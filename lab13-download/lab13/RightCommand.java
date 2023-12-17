import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
//-------------------------------------------------------------------------
/**
 *  This class implements the "right" command
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.27
 */
public class RightCommand implements Command
{
    //~ Fields ................................................................
    private Jeroo jeroo;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created RightCommand object.
     * @param jeroo the Jeroo
     */
    public RightCommand(Jeroo jeroo)
    {
        this.jeroo = jeroo;
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    
    /**
     * right turn when 
     * the "right" is called.
     */
    public void execute()
    {
        jeroo.turn(RIGHT);
    }

}
