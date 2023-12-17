import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  This class test the PostMonitor Class
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.30
 */
public class PostMonitorTest
    extends TestCase
{
    //~ Fields ................................................................
    private PostMonitor monitor;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new PostMonitorTest test object.
     */
    public PostMonitorTest()
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
        monitor = new PostMonitor();

    }
    /**
     * Test the Contructor
     */
    public void testConstructor() 
    {
        int[] emptyDays = new int[7];
        int[] emptyHours = new int[24];

        assertThat(monitor.getPostCount()).isEqualTo(0);
        assertThat(monitor.getDayCounts()).isEqualTo(emptyDays);
        assertThat(monitor.getHourCounts()).isEqualTo(emptyHours);
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * Test the postCount
     */
    public void testGetPostCount()
    {
        assertThat(monitor.getPostCount()).isEqualTo(0);
    }
    /**
     * Test the GetHourCOunt
     */
    public void testGetHourCount()
    {
        int[] hourCount = new int[24];  

        assertThat(monitor.getHourCounts()).isEqualTo(hourCount);
    }
    /**
     * test the GetDay COunt
     */
    public void testGetDayCount()
    {
        int[] dayCount = new int[7];

        assertThat(monitor.getDayCounts()).isEqualTo(dayCount);
    }
    /**
     * test the RecordPost
     */
    public void testRecordPost()
    {
        Post post1 = new Post("User1", "Hi", 0, 8);

        monitor.recordPost(post1);

        int[] expectedDayCounts = {1, 0, 0, 0, 0, 0, 0};
        int[] expectedHourCounts = {
            0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };

        assertThat(monitor.getDayCounts()).isEqualTo(expectedDayCounts);
        assertThat(monitor.getHourCounts()).isEqualTo(expectedHourCounts);
        assertThat(monitor.getPostCount()).isEqualTo(1);
    }
    /**
     * test the GetIndexOfLargest
     */
    public void testGetIndexOfLargest()
    {
        Post post1 = new Post("User1", "Hi", 0, 8);
        
        int[] counts = {3, 3, 3};
        
        assertThat(monitor.getIndexOfLargest(counts)).isEqualTo(0);
    }
    /**
     * test the GetBusiestHour
     */
    public void testGetBusiestHour()
    {
        Post post1 = new Post("User1", "Hi", 0, 8);
        
        assertThat(monitor.getBusiestHour()).isEqualTo(0);
    }
    /**
     * test the GetBusiestDay
     */
    public void testGetBusiestDay()
    {
        Post post1 = new Post("User1", "Hi", 0, 8);
        
        assertThat(monitor.getBusiestDay()).isEqualTo(0);
    }
    /**
     * tests the GetIndexOfSmallest
     */
    public void testGetIndexOfSmallest()
    {
        Post post1 = new Post("User1", "Hi", 0, 8);
        
        int[] counts = {3, 3, 3};
        
        assertThat(monitor.getIndexOfSmallest(counts)).isEqualTo(0);
    }
    /**
     * test the getSlowestHour
     */
    public void testGetSlowestHour()
    {
        Post post1 = new Post("User1", "Hi", 0, 8);
        
        assertThat(monitor.getSlowestHour()).isEqualTo(0);
    }
    /**
     * test the GetSlowerDay
     */
    public void testGetSlowestDay()
    {
        Post post1 = new Post("User1", "Hi", 0, 8);
        
        assertThat(monitor.getSlowestDay()).isEqualTo(0);
    }
}
