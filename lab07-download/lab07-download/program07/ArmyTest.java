import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  This is a test class for the Army class.
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.24
 */
public class ArmyTest
    extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new ArmyTest test object.
     */
    public ArmyTest()
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
        /*# Insert your own setup code here */

    }
    /**
     * Tests the Army get PlayerName method.
     */
    public void testSetPlayerName() 
    {
        Army army = new Army("MyArmy", "MyFaction", "PlayerName");
        army.setPlayerName("NewPlayerName");
        assertEquals("NewPlayerName", army.getPlayerName());
    }
    /**
     * Tests the Army getFaction method. 
     */
    public void testGetFaction() 
    {
        Army army = new Army("MyArmy", "MyFaction", "PlayerName");
        assertEquals("MyFaction", army.getFaction());
    }
    /**
     * Tests the Amry SetFaction method. 
     */
    public void testSetFaction() 
    {
        Army army = new Army("MyArmy", "MyFaction", "PlayerName");
        army.setFaction("NewFaction");
        assertEquals("NewFaction", army.getFaction());
    }
    /**
     * Test the toString() method.
     */
    public void testArmyToString() 
    {
        Army army = new Army("Justice League", "Superheroes", "Batman");

        String s = "player:Batman, faction:Superheroes, " +
            "army:Justice League (0, 2, 2) units:[]";
        String actual = army.toString();

        assertEquals(s, actual);
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
