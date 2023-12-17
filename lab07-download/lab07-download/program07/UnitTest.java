import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  The UnitTest class is a test class for 
 *  the Unit class, and its 
 *  objectives are to test the constructor, 
 *  setter, and getter methods.
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class UnitTest
    extends TestCase
{
    //~ Fields ................................................................
    private List<Upgrade> upgrades;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new UnitTest test object.
     */
    public UnitTest()
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
        upgrades = new ArrayList<Upgrade>();
    }
    /**
     * Tets the unite getter methods. 
     */
    public void testUnitGetter()
    {
        Unit unit = new Unit("Warrior", 100);
        int uQuality = unit.getQuality();
        int uDefense = unit.getDefense();
        upgrades = unit.getUpgrades();
        int uPoints = unit.getPoints();

        assertThat(uQuality).isEqualTo(2);
        assertThat(uDefense).isEqualTo(2);
        assertThat(upgrades.size()).isEqualTo(0);
        assertThat(unit.getPoints()).isEqualTo(100);
    }
    /**
     * Tests the setter of  the Unit class.
     */
    public void testUnitSetter()
    {
        Unit unit = new Unit("Warrior", 100);
        unit.setName("Knight");
        unit.setPoints(150);
        unit.setQuality(3);
        unit.setDefense(3);

        assertThat(unit.getName()).isEqualTo("Knight");
        assertThat(unit.getPoints()).isEqualTo(150);
        assertThat(unit.getQuality()).isEqualTo(3);
        assertThat(unit.getDefense()).isEqualTo(3);
    }
    /**
     * tests Add upgrades
     */
    public void testAddUpgrades()
    {
        Unit unit = new Unit("Warrior", 100);
        Upgrade newUpgrades = new Upgrade("Nupgrade", 5);

        unit.addUpgrade(newUpgrades);
        upgrades = unit.getUpgrades();

        assertThat(upgrades.size()).isEqualTo(1);
    }
    /**
     * test Remove Upgrades
     */
    public void testRemoveUpgrades()
    {
        Unit unit = new Unit("Warrior", 100);
        Upgrade newUpgrades = new Upgrade("Nupgrade", 5);

        unit.removeUpgrade(newUpgrades);

        upgrades = unit.getUpgrades();

        assertThat(upgrades.size()).isEqualTo(0);
    }
    /**
     * test the toString method. 
     */
    public void testUnitToString() 
    {
        Unit unit = new Unit("flash", 80);

        String toStringR = unit.toString();

        assertThat(toStringR).isEqualTo("flash (80, 2, 2)");
    }
    /**
     * test get point with upgrades
     */
    public void testGetPointsWithUpgrades() 
    {
        Unit unit = new Unit("MyUnit", 3); 
        unit.addUpgrade(new Upgrade("UpgradeA", 2)); 
        unit.addUpgrade(new Upgrade("UpgradeB", 4)); 
        int expectedTotalPoints = 3 + 2 + 4; 

        int actualTotalPoints = unit.getPoints();

        assertThat(actualTotalPoints).isEqualTo(expectedTotalPoints); 
    }
    /**
     * test get point with upgrades
     */
    public void testGetPointsWithUpgrades2() 
    {
        Unit unit = new Unit("MyUnit", 3); 
        unit.addUpgrade(new Upgrade("UpgradeA", 2)); 
        unit.addUpgrade(new Upgrade("UpgradeB", 4)); 

        int expectedTotalPoints = 3 + 2 + 4; 

        int actualTotalPoints = unit.getPoints(); 

        assertThat(actualTotalPoints).isEqualTo(expectedTotalPoints); 
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
