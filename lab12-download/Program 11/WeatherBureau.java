import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Represents a weather service that manages
 *  and keeps track of weather
 *  station
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.14
 */
public class WeatherBureau
{
    //~ Fields ................................................................
    private Map<String, WeatherStation> weatherStations;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created WeatherBureau object.
     */
    public WeatherBureau()
    {
        super();
        /*# Do any work to initialize your class here. */
        weatherStations = new HashMap<String, WeatherStation>();
    }

    //~ Methods ...............................................................
    
    /**
     * Returns the WeatherStation map
     * @return Map WeatherStation
     */
    public Map<String, WeatherStation> getWeatherStations()
    {
        return weatherStations;
    }
    /**
     * Records a single one-line daily weatehr summary
     * for one day at one weather station
     * 
     * @param text The text representing 
     * a one-line daily weather
     * 
     */
    public void recordDailySummary(String text)
        throws NumberFormatException
    {
        //method to record daily weather summeries from an input source
        Scanner frScanner = new Scanner(text);
        String id = frScanner.next();

        frScanner.next(); // Skip next tokens if needed
        frScanner.next();
        frScanner.next();

        String date = frScanner.next();
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);     
        double rainfall = Double.parseDouble(frScanner.next());

        if (rainfall != -1) {
            WeatherStation station = weatherStations.get(id);
            if (station == null) {
                station = new WeatherStation(id);
                weatherStations.put(id, station);
            }
            station.recordDailyRain(month, rainfall);
        }
    }
    /**
     * Retrieves the WeatherStation object for a given identifier.
     * 
     * @param input The identifier of the weather station.
     */
    public void recordDailySummaries(Scanner input) 
    {
        while (input.hasNextLine()) 
        {
            recordDailySummary(input.nextLine());
        }
    }
    /**
     * Retrieves the WeatherStation object for a given
     * weather station identifier
     * 
     * @param stationID The ID
     * @return the weather station object
     * for the ID given
     */
    public WeatherStation getStation(String stationID)
    {
        //to return WeathrStation object for the given weather station ID
        //return null; //placeholder
        if (weatherStations.containsKey(stationID))
        {
            return weatherStations.get(stationID);
        }
        return null;
    }
    /**
     * Returns the weather station with the 
     * lowest average rainfall for the specified month.
     * 
     * @param month The month of rainfall recorded
     * 
     * @return The WeatherStation 
     * object with the lowest average rainfall 
     */
    public WeatherStation lowestStation(int month)
    {
        //to return the weather station with the lowest 
        //average rainfall for the specified month
        //return null; //placeholder
        WeatherStation lowest = null;
        double minAvg = Double.MAX_VALUE;

        for (WeatherStation station : weatherStations.values()) 
        {
            double avg = station.getAvgForMonth(month);
            if (avg != -1 && avg < minAvg) {
                minAvg = avg;
                lowest = station;
                //return lowest;
            }
        }
        return lowest;
    }
    /**
     * Returns the weather station with the lowest 
     * average rainfall recorded for any month (1-12).
     * 
     * @return The WeatherStation object 
     * with the lowest average rainfall overall
     */
    public  WeatherStation lowestStation()
    {
        //to return the weather station with the lowest 
        //average rainfall recorded for the specified month
        //return null; //placeholder
        WeatherStation lowest = null;
        double minAvg = Double.MAX_VALUE;
        for (WeatherStation station : weatherStations.values()) {
            for (int month = 1; month <= 12; month++) {
                double avg = station.getAvgForMonth(month);
                if (avg != -1 && avg < minAvg) {
                    minAvg = avg;
                    lowest = station;
                }
            }
        }
        return lowest;
    }
}
