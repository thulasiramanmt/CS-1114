import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests for the Calendar class.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.06
 */
public class CalendarTest
    extends TestCase
{
    //~ Fields ................................................................

    private Calendar calendar;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CalendarTest test object.
     */
    public CalendarTest()
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
        calendar = new Calendar();
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * javadocs
     */
    public void testAddEvent()
    {
        Event event1 = new Event(10, "Breakfast");
        Event event2 = new Event(9, "Lunch");
        
        calendar.addEvent(0, event1);
        calendar.addEvent(3, event2);
        
        Event actual1 = calendar.getEvent(0, 10);
        Event actual2 = calendar.getEvent(3,9);
        
        assertThat(event1).isEqualTo(actual1);
        assertThat(event2).isEqualTo(actual2);
    }
    /**
     * javadocs
     */
    public void testGetEvent()
    {
        Event event = new Event(13, "Test Event");
        
        calendar.addEvent(2, event);
        
        Event actual1 = calendar.getEvent(2, 13);
        
        assertThat(event).isEqualTo(actual1);
        
        //checking null
        assertThat(calendar.getEvent(-1, 13)).isNull();
        
    }

}
