import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  test the WeatherStation methods
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.14
 */
public class WeatherStationTest
    extends TestCase
{
    //~ Fields ................................................................
    private WeatherStation station;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeatherStationTest test object.
     */
    public WeatherStationTest()
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
        station = new WeatherStation("KE000063612");
    }
    
    
    


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * test the getID method
     */
    public void testGetId() 
    {
        assertThat(station.getId()).isEqualTo("KE000063612");
    }
    /**
     * tests the recordDailyRain
     * with valid data
     */
    public void testRecordDailyRainValidData() 
    {
        station.recordDailyRain(1, 0.1);
        
        assertThat(station.getCountForMonth(1)).isEqualTo(1);
        assertThat(station.getAvgForMonth(3)).isEqualTo(-1.00, within(0.001));
    }
    /**
     * test the getCountForMonth
     * with no data
     */
    public void testGetCountForMonthNoData() 
    {
        assertThat(station.getCountForMonth(2)).isEqualTo(0);
    }
    /**
     * test the getAvgMonth
     * with no data
     */
    public void testGetAvgForMonthNoData() 
    {
        assertThat(station.getAvgForMonth(3)).isEqualTo(-1.00, within(0.001));
    }
    /**
     * test the getLowestMonth
     */
    public void testGetLowestMonth() 
    {
        station.recordDailyRain(2, 0.5);
        station.recordDailyRain(3, 0.2);
        assertThat(station.getLowestMonth()).isEqualTo(3);
    }
    /**
     * 
     */
    public void testGetLowestMonth2()
    {
        station.recordDailyRain(1, 79);
        station.recordDailyRain(2, 5);
        
        assertThat(station.getLowestMonth()).isEqualTo(2);
    }
    /**
     * 
     */
    public void testGetLowestMonth3()
    {
        station.recordDailyRain(1, 79);
        station.recordDailyRain(2, 2);
        station.recordDailyRain(3, 2);
        station.recordDailyRain(4, 2);
        station.recordDailyRain(5, 2);
        station.recordDailyRain(6, 2);
        station.recordDailyRain(7, 2);
        station.recordDailyRain(8, 2);
        station.recordDailyRain(9, 2);


        assertThat(station.getLowestMonth()).isEqualTo(2);
    }
    /**
     * 
     */
    public void testGetLowestMonth4()
    {
        assertThat(station.getLowestMonth()).isEqualTo(1);
    }
}