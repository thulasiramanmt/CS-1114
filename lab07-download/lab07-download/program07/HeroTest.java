import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  The HeroTest class is a test class for the Hero
 *  class, focusing on testing the constructor 
 *  and inherited attributes.
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class HeroTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HeroTest test object.
     */
    public HeroTest()
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


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * Test method for the Hero class.
     */
    public void testHero()
    {
        Hero hero = new Hero("Champion", 200);
        
        assertThat(hero.getName()).isEqualTo("Champion");
        assertThat(hero.getPoints()).isEqualTo(200);
        assertThat(hero.getQuality()).isEqualTo(5);
        assertThat(hero.getDefense()).isEqualTo(5);
    }
}
