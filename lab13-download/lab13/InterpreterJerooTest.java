import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests for the InterpreterJeroo class.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.27
 */
public class InterpreterJerooTest
    extends TestCase
{
    //~ Fields ................................................................

    private Island island;
    private InterpreterJeroo jeroo;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new InterpreterJerooTest test object.
     */
    public InterpreterJerooTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        this.island = new Island();
        jeroo = new InterpreterJeroo();
        island.addObject(jeroo, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * Test RemoteJeroo with a scanner containing three "forward" commands.
     */
    public void testForward()
    {
        // Set the built-in scanner's contents
        setIn("forward forward forward");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(6);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    /**
     * Test the "left" command
     */
    public void testLeft()
    {
        // Set the built-in scanner's contents
        setIn("left");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(NORTH)).isTrue();
    }
    /**
     * test the "right" command
     */
    public void testRight()
    {
        // Set the built-in scanner's contents
        setIn("right");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(SOUTH)).isTrue();
    }
    /**
     * test the "Forward" command
     */
    public void testCaptialF()
    {
        // Set the built-in scanner's contents
        setIn("left");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isFalse();
    }
    /**
     * test the "Left" command
     */
    public void testCaptialL()
    {
        // Set the built-in scanner's contents
        setIn("Left");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(NORTH)).isTrue();
    }
    /**
     * test the "Right" command
     */
    public void testCaptialR()
    {
        // Set the built-in scanner's contents
        setIn("Right");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(SOUTH)).isTrue();
    }

}
