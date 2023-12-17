import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Test class for WeatherBureau methods
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.14
 */
public class WeatherBureauTest
    extends TestCase
{
    //~ Fields ................................................................
    private WeatherBureau bureau;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeatherBureauTest test object.
     */
    public WeatherBureauTest()
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
        bureau = new WeatherBureau();
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * Test recording a valid daily weather summary.
     * 
     */

    public void testRecordDailySummaryValidData() 
    {
        String line = 
            "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";

        bureau.recordDailySummary(line);
        WeatherStation station = bureau.getStation("KE000063612");

        assertThat(station.getCountForMonth(2)).isEqualTo(1);
    }
    /**
     * test the daily summary with invalid data
     */

    public void testRecordDailySummaryInvalidData() 
    {
        String line = 
            "KE000063820 -4.033 39.617 55 4/25/16 -1 88 101 75";
        bureau.recordDailySummary(line);

        WeatherStation station = bureau.getStation("KE000063820");

        assertThat(station).isEqualTo(null);
    }
    /**
     * Test recordDailySummary with identifier.
     */
    public void testRecordDailySummaryWithKey()
    {
        String line = 
            "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line);
        WeatherStation station = bureau.getStation("KE000063612");

        assertThat(bureau.getWeatherStations().containsKey("KE000063612"))
            .isTrue();
    }
    /**
     * Test recordDailySummary for month.
     */
    public void testRecordDailySummaryMonth()
    {
        String line = 
            "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line);

        assertThat(bureau.getWeatherStations().containsKey("KE000063612"))
            .isTrue();

    }
    /**
     * Test recordDailySummaries.
     */
    public void testRecordDailySummaries()
    {
        setIn(
            "KE000063820 -4.033 39.617 55 4/25/16 -1 88 101 75",
            "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73"
        );
        
        bureau.recordDailySummaries(in());
        
        assertThat(bureau.getWeatherStations().containsKey("KE000063612"))
            .isTrue();
        assertThat(bureau.getWeatherStations().containsKey("KE000063820"))
            .isFalse();
            
    }
    /**
     * Test getStation with valid identifier.
     */
    public void testGetStationValidExistingIdentifier()
    {
        WeatherStation retrievedStation = bureau.getStation("KE000063612");
        bureau.getWeatherStations().put("KE000063612", retrievedStation);

        assertThat(bureau.getStation("KE000063612"))
            .isEqualTo(retrievedStation);
    }
    /**
     * test the get station
     * with non exisiting indenitfier
     */
    public void testGetStationNonExistingIdentifier() 
    {
        WeatherStation retrievedStation = bureau.getStation("KE000063612");

        assertThat(retrievedStation).isEqualTo(null);

    }
    /**
     * Test lowestStation for specific month.
     */
    public void testLowestStation1()
    {
        WeatherStation station = bureau.lowestStation(6);
        
        assertThat(station).isEqualTo(null);
    }
    /**
     * Test lowestStation with multiple stations.
     */
    public void testLowestStationAllThatAreTrue()
    {
        WeatherStation station = new WeatherStation("KE000063612");
        WeatherStation station2 = new WeatherStation("KE000063820");
        
        station.recordDailyRain(3, 4.44);
        station.recordDailyRain(3, 4.45);
        station2.recordDailyRain(3, 4.46);
        station2.recordDailyRain(3, 4.41);
        
        bureau.getWeatherStations().put("KE000063612", station);
        bureau.getWeatherStations().put("KE000063820", station2);
        
        assertThat(bureau.lowestStation(3))
            .isEqualTo(station2);
    }
    /**
     * Test lowestStation for non-existing month.
     */
    public void testLowestStationNotValid()
    {
        WeatherStation station = bureau.lowestStation(1);
        assertThat(station).isEqualTo(null);
    }
    /**
     * Test lowestStation for invalid month.
     */
    public void testLowestStation3()
    {
        assertThat(bureau.lowestStation(3)).isEqualTo(null);
    }
    /**
     * Test lowestStationAvg.
     */
    public void testLowestStationAvg()
    {
        assertThat(bureau.lowestStation(2)).isEqualTo(null);
    }
    /**
     * Test lowestStationAvg with small values.
     */
    public void testLowestStationAvgSm()
    {
        WeatherStation station = new WeatherStation("KE000063612");
        WeatherStation station2 = new WeatherStation("KE000063820");
        
        station.recordDailyRain(3, 100000000);
        station2.recordDailyRain(3, 1000000000);
        
        bureau.getWeatherStations().put("KE000063612", station);
        bureau.getWeatherStations().put("KE000063820", station2);
        
        assertThat(bureau.lowestStation(1)).isEqualTo(null);
    }
    /**
     * Test lowestStation4 with no values.
     */
    public void testLowestStation4()
    {
        WeatherStation station = new WeatherStation("KE000063612");
        WeatherStation station2 = new WeatherStation("KE000063820");
        
        bureau.getWeatherStations().put("KE000063612", station);
        bureau.getWeatherStations().put("KE000063820", station2);
        
        assertThat(bureau.lowestStation(1)).isEqualTo(null);
    }
    /**
     * Test lowestStation without parameters.
     */
    public void testLowestStationWithOutParam()
    {
        WeatherStation station = bureau.lowestStation();
        
        assertThat(station).isEqualTo(null);
    }
    /**
     * Test lowestStation without average.
     */
    public void testLowestStationNoAverageParam()
    {
        WeatherStation station = new WeatherStation("KE000063612");
        WeatherStation station2 = new WeatherStation("KE000063820");
        
        station.recordDailyRain(3, 4.44);
        station.recordDailyRain(3, 4.45);
        station2.recordDailyRain(3, 4.46);
        station2.recordDailyRain(3, 4.41);
        
        bureau.getWeatherStations().put("KE000063612", station);
        bureau.getWeatherStations().put("KE000063820", station2);
        
        assertThat(bureau.lowestStation())
            .isEqualTo(station2);
    }
    /**
     * Test the recordDailySummary method where 
     * there is a null
     */
    public void testRecordDailySummaryNull()
    {
        String line = 
            "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";

        bureau.recordDailySummary(line);
        
        assertThat(bureau.getWeatherStations().size())
            .isEqualTo(1);
    }
    /**
     * Test the recordDailySummary method where 
     * there is a null
     */
    public void testRecordDailySummaryNull2()
    {
        String line = 
            "KE000063820 3.117 35.617 515 2/10/16 0.04 87 98 73";

        bureau.recordDailySummary(line);
        
        assertThat(bureau.getWeatherStations().size())
            .isEqualTo(1);
    }
    /**
     * Test the recordDailySummary method where 
     * there is a null
     */
    public void testRecordDailySummaryNull3()
    {
        WeatherStation retrievedStation = bureau.getStation("KE000063612");
            
        
        assertThat(retrievedStation).isEqualTo(null);
    }
    /**
     * Tests the recordDailySummary 
     */
    public void testRecordDailySummaryWeatherStationNotExists() {
        WeatherBureau nB = new WeatherBureau();
        String line = "KE000063612 3.117 35.617 5 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line);

        WeatherStation station = bureau.getStation("KE000063612");
        assertThat(station).isNotNull();
    }

}