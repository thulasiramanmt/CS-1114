import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  The `MonsterTest class is a test 
 *  class for the Monster 
 *  class, focusing on testing 
 *  the constructor and inherited attributes.
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.17
 */
public class MonsterTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MonsterTest test object.
     */
    public MonsterTest()
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
     * tests the Hero class. 
     */
    public void testMonster()
    {
        Monster monster = new Monster("Dragon", 500);
        
        assertThat(monster.getName()).isEqualTo("Dragon");
        assertThat(monster.getPoints()).isEqualTo(500);
        assertThat(monster.getQuality()).isEqualTo(4);
        assertThat(monster.getDefense()).isEqualTo(4);
    }

    

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
