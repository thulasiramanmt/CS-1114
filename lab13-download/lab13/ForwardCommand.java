import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;

//-------------------------------------------------------------------------
/**
 *  This class implement thet "forward" command
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.27
 */
public class ForwardCommand implements Command
{
    //~ Fields ................................................................
    private Jeroo jeroo;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created ForwardCommand object.
     * 
     * @param jeroo the Jeroo
     */
    public ForwardCommand(Jeroo jeroo)
    {
        super();
        this.jeroo = jeroo;
        
        /*# Do any work to initialize your class here. */
        
    }
    


    //~ Methods ...............................................................
    
    /**
     * one hop when 
     * the "foward" is called. 
     */
    public void execute()
    {
        this.jeroo.hop();
    }

}
