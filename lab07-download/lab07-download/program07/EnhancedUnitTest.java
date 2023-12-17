import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  The EnhancedUnitTest class is a test class 
 *  for the EnhancedUnit class, focusing on 
 *  testing the constructor and setter/getter methods.
 *
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class EnhancedUnitTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new EnhancedUnitTest test object.
     */
    public EnhancedUnitTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Test the constructor of EnhancedUnit.
     */
    public void testEnhancedUnitConstructor() 
    {
        EnhancedUnit enhancedUnit = new EnhancedUnit();
        assertNotNull(enhancedUnit);
    }
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
    }
    /**
     * test the getter methods
     */
    public void testEnhancedUnitGetters()
    {
        EnhancedUnit enhancedUnit = new EnhancedUnit("Mage", 120);
        
        assertThat(enhancedUnit.getName()).isEqualTo("Mage");
        assertThat(enhancedUnit.getPoints()).isEqualTo(120);
        assertThat(enhancedUnit.getQuality()).isEqualTo(2);
        assertThat(enhancedUnit.getDefense()).isEqualTo(2);
    }
    /**
     * Tests the setter and getter for 
     * the special rule of an EnhancedUnit.
     */
    public void testEnhancedUnitSetter() 
    {
        EnhancedUnit enhancedUnit = new EnhancedUnit("Mage", 120);
        enhancedUnit.setSpecialRule("Fireball Attack");

        assertThat(enhancedUnit.getSpecialRule()).isEqualTo("Fireball Attack");
    }
    /**
     * Test the toString() method
     */
    public void testEnhancedUnitToString() 
    {
        EnhancedUnit enhancedUnit = new EnhancedUnit("Mage", 120);

        String expected = "Mage (120, 2, 2)";
        String actual = enhancedUnit.toString();
        
        assertEquals(actual, expected);
    }
    /**
     * Test the toString() method with special rule. 
     */
    public void testEnhancesUnitToStringSpecialRule()
    {
        EnhancedUnit enhancedUnit = new EnhancedUnit("Mage", 120);
        enhancedUnit.setSpecialRule("Fireball Attack");

        String expected = "Mage (120, 2, 2) special rule:[Fireball Attack]";
        String actual = enhancedUnit.toString();

        assertEquals(actual, expected);
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
