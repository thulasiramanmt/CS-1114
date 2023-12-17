import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests for the Event class.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.06
 */
public class EventTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new EventTest test object.
     */
    public EventTest()
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
        // You'll need to fix this after modifying the Event constructor
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * javadocs
     */
    public void testContructor()
    {
        Event event2 = new Event(15, "description");
        String actual = "description";
        
        assertThat(event2.getHour()).isEqualTo(15);
        assertThat(event2.getDescription()).isEqualTo(actual);
    }
    /**
     * javadocs
     */
    public void testGetDescription()
    {
        Event event3 = new Event(15, "description");
        assertThat(event3.getDescription()).isEqualTo("description");
    }
    /**
     * javadocs
     */
    public void testGetHour() 
    {
        Event event4 = new Event(15, "description");
        event4.setHour(11);
        assertThat(event4.getHour()).isEqualTo(11);
    }
    /**
     * javadocs
     */
    public void testSetDescription()
    {
        Event event5 = new Event(15, "description");
        event5.setDescription("Hello");
        assertThat(event5.getDescription()).isEqualTo("Hello");
    }
    /**
     * javadocs
     */
    public void testSetTime()
    {
        Event event6 = new Event(15, "description");
        event6.setHour(20);
        assertThat(event6.getHour()).isEqualTo(20);
    }
}