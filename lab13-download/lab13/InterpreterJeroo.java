import student.micro.jeroo.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  A remotely controllable jeroo that reads commands
 *  from a scanner and uses a map to translate words
 *  into commands.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.27
 */
public class InterpreterJeroo
    extends Jeroo
{
    //~ Fields ................................................................
    private Map<String, Command> commandMap;

    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new InterpreterJeroo object.
     */
    public InterpreterJeroo()
    {
        super();
        commandMap = new HashMap<String, Command>();

        commandMap.put("forward", new ForwardCommand(this));
        commandMap.put("left", new LeftCommand(this));
        commandMap.put("right", new RightCommand(this));
        commandMap.put("Forward", new ForwardCommand(this));
        commandMap.put("Left", new LeftCommand(this));
        commandMap.put("Right", new RightCommand(this));

    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Calls interpretCommand() repeatedly until there are no more
     * words left in the given Scanner.
     * 
     * @param input The Scanner to read the command from.
     */
    public void interpretAllCommands(Scanner input)
    {
        while (input.hasNext())
        {
            interpretCommand(input);
        }
    }

    // ----------------------------------------------------------
    /**
     * Reads one word from the scanner (if there is any), and executes
     * the corresponding command.  If the scanner has no words remaining,
     * then nothing happens.
     * 
     * @param input The Scanner to read the command from.
     */
    public void interpretCommand(Scanner input)
    {

        String word = input.next();

        Command command = commandMap.get(word);

        command.execute();

    }
}
