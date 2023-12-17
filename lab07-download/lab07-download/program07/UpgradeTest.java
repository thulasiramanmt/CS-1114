import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 * The UpgradeTest class is a test class for the Upgrade 
 * class, focusing on testing the constructor and setter/getter methods.
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class UpgradeTest
    extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new UpgradeTest test object.
     */
    public UpgradeTest()
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
     * Tests the getter methods
     */
    public void testUpgradesGetters()
    {
        Upgrade upgrade = new Upgrade("Weapon Upgrade", 20);

        assertThat(upgrade.getName()).isEqualTo("Weapon Upgrade");
        assertThat(upgrade.getPoints()).isEqualTo(20);
    }
    /**
     * Tests the setter methods.
     */
    public void testUpgradeSetter() 
    {
        Upgrade upgrade = new Upgrade("Armor Upgrade", 30);
        upgrade.setName("Shield Upgrade");
        upgrade.setPoints(15);

        assertThat(upgrade.getName()).isEqualTo("Shield Upgrade");
        assertThat(upgrade.getPoints()).isEqualTo(15);
    }
    /**
     * 
     */
    public void testUpgradesToString()
    {
        Upgrade upgrade = new Upgrade("MyUpgrade", 20);

        String expected = "MyUpgrade (20)";
        String actual = upgrade.toString();

        assertThat(actual).isEqualTo(expected);
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
