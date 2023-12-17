import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  this class test the Squad class methods. 
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.24
 */
public class SquadTest
    extends TestCase
{
    //~ Fields ..............................................................
    private List<Upgrade> upgrades;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new SquadTest test object.
     */
    public SquadTest()
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
        this.upgrades = new ArrayList<>();
    }   
    /**
     * Test the addUnit and getUnits methods
     */
    public void testSquadAddUnitAndGetUnits()
    {
        Squad squad = new Squad("MySquad");
        Unit unit1 = new Unit("Unit1", 100);
        Unit unit2 = new Unit("Unit2", 200);

        squad.addUnit(unit1);
        squad.addUnit(unit2);

        assertThat(squad.getUnits().size()).isEqualTo(2);
        assertThat(squad.getUnits().contains(unit1)).isTrue();
        assertThat(squad.getUnits().contains(unit2)).isTrue();

    }
    /**
     * Test the removeUnit method
     */
    public void testSquadRemoveUnit()
    {
        Squad squad = new Squad("MySquad");
        Unit unit1 = new Unit("Unit1", 100);
        Unit unit2 = new Unit("Unit2", 200);

        squad.addUnit(unit1);
        squad.addUnit(unit2);

        squad.removeUnit(unit1);

        assertThat(squad.getUnits().size()).isEqualTo(1);
        assertThat(squad.getUnits().contains(unit1)).isFalse();
        assertThat(squad.getUnits().contains(unit2)).isTrue();
    }
    /**
     * Test the getPoints method
     */
    public void testSquadGetPoints()
    {
        Squad squad = new Squad("MySquad");
        Unit unit1 = new Unit("Unit1", 100);
        Unit unit2 = new Unit("Unit2", 200);

        squad.addUnit(unit1);
        squad.addUnit(unit2);

        assertThat(squad.getPoints()).isEqualTo(300);
    }
    /**
     * Test the toString() method for Squad when there is no special rule.
     */
    public void testSquadToStringWithoutSpecialRule() 
    {
        Squad squad = new Squad("MySquad");
        Upgrade newUpgrades = new Upgrade("NUpgrade", 5);

        squad.addUnit(new Unit("UnitA", 3));
        squad.addUpgrade(newUpgrades);
        upgrades = squad.getUpgrades();
        squad.setSpecialRule("RuleA");

        String expected = "MySquad (8, 2, 2) upgrades:[NUpgrade (5)] " +
            "special rule:[RuleA] units:[UnitA (3, 2, 2)]";

        String actual = squad.toString();

        assertThat(actual).isEqualTo(expected);
    }
    /**
     * test toStringwithout Upgrades
     * 
     */
    public void testToStringWihtoutUpgrades()
    {
        Squad squad = new Squad("MySquad");

        squad.addUnit(new Unit("UnitA", 3));
        String expected = "MySquad (3, 2, 2) units:[UnitA (3, 2, 2)]";

        String actual = squad.toString();

        assertThat(actual).isEqualTo(expected);
    }
    /**
     * test with special rule
     */
    public void testToStringWithSpecialRule()
    {
        Squad squad = new Squad("MySquad");
        squad.setSpecialRule("RuleA");

        String expected = "MySquad (0, 2, 2) special rule:[RuleA] units:[]";

        String actual = squad.toString();

        assertThat(actual).isEqualTo(expected);
    }
    /**
     * tests made for the  
     * baseSquadString += " upgrades:" + upgrades;
     * statment
     * 
     * for webcat
     */
    public void testToStringWithUpgrades() {
        Squad squad = new Squad("MySquad");
        squad.addUpgrade(new Upgrade("UpgradeA", 5));
        squad.addUpgrade(new Upgrade("UpgradeB", 6));

        String expected = "MySquad (11, 2, 2) upgrades:[UpgradeA (5), " +
            "UpgradeB (6)] units:[]";

        String actual = squad.toString();

        assertThat(actual).isEqualTo(expected);
    }
    /**
     * Test all the posibilites
     * for webcat
     */
    public void testToStringWithAllPossibilities() 
    {
        // Test case 1: No upgrades, no special rule, and a unit
        Squad squad1 = new Squad("Squad1");
        squad1.addUnit(new Unit("UnitA", 3));

        String expected1 = "Squad1 (3, 2, 2) units:[UnitA (3, 2, 2)]";
        String actual1 = squad1.toString();
        assertThat(actual1).isEqualTo(expected1);

        // Test case 2: With upgrades, no special rule, and a unit
        Squad squad2 = new Squad("Squad2");
        squad2.addUnit(new Unit("UnitB", 4));
        squad2.addUpgrade(new Upgrade("UpgradeX", 5));
        squad2.addUpgrade(new Upgrade("UpgradeY", 6));

        String expected2 = "Squad2 (15, 2, 2) upgrades:[UpgradeX (5), " +
            "UpgradeY (6)] units:[UnitB (4, 2, 2)]";
        String actual2 = squad2.toString();
        assertThat(actual2).isEqualTo(expected2);

        // Test case 3: No upgrades, with a special rule, and no units
        Squad squad3 = new Squad("Squad3");
        squad3.setSpecialRule("RuleA");

        String expected3 = "Squad3 (0, 2, 2) special rule:[RuleA] units:[]";
        String actual3 = squad3.toString();
        assertThat(actual3).isEqualTo(expected3);

        // Test case 4: With upgrades, with a special rule, and multiple units
        Squad squad4 = new Squad("Squad4");
        squad4.setSpecialRule("RuleB");
        squad4.addUnit(new Unit("UnitC", 2));
        squad4.addUnit(new Unit("UnitD", 3));
        squad4.addUpgrade(new Upgrade("UpgradeZ", 7));

        String expected4 = "Squad4 (12, 2, 2) upgrades:[UpgradeZ (7)] " +
            "special rule:[RuleB] units:[UnitC (2, 2, 2), UnitD (3, 2, 2)]";
        String actual4 = squad4.toString();
        assertThat(actual4).isEqualTo(expected4);
    }
    /**
     * tests to string with upgrades and special rule
     * 
     */
    public void testToStringWithUpgradesAndSpecialRule() {
        Squad squad = new Squad("MySquad");
        squad.addUpgrade(new Upgrade("UpgradeA", 5));
        squad.setSpecialRule("RuleA");

        String expected = "MySquad (5, 2, 2) upgrades:[UpgradeA (5)] " +
            "special rule:[RuleA] units:[]";

        String actual = squad.toString();

        assertThat(actual).isEqualTo(expected);
    }
    /**
     * test with empty upgrades and special rule
     */
    public void testToStringWithEmptyUpgradesAndEmptySpecialRule() 
    {
        Squad squad = new Squad("MySquad");
        squad.setSpecialRule("");

        String expected = "MySquad (0, 2, 2) special rule:[] units:[]";

        String actual = squad.toString();

        assertThat(actual).isEqualTo(expected);
    }
    /**
     * test with null
     */
    public void testToStringWithNullUpgradesAndNullSpecialRule() 
    {
        Squad squad = new Squad("MySquad");
        squad.setSpecialRule(null);

        String expected = "MySquad (0, 2, 2) units:[]";

        String actual = squad.toString();

        assertThat(actual).isEqualTo(expected);
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
