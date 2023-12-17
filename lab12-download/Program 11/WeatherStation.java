
//-------------------------------------------------------------------------
/**
 *  This class represents a weather
 *  oberservation station and collects
 *  basic statistics.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.27.14
 */
public class WeatherStation
{
    //~ Fields .................................
    //private String identifier; 
    private String stationId;
    private double[] monthlyRainTotals;
    private int[] monthlyCounts;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created WeatherDataProcessor object.
     * 
     * @param identifier The ID for
     * the weather station
     */
    public WeatherStation(String identifier)
    {
        super();
        this.monthlyCounts = new int[12];
        this.monthlyRainTotals = new double[12];
        this.stationId = identifier;

        //int m1= monthlyCounts.length;
        

        /*# Do any work to initialize your class here. */

    }

    //~ Methods ...............................................................
    /**
     * Returns the ID for the 
     * weather station
     * 
     * @return the ID for
     * the weather station
     */
    public String getId()
    {
        return stationId;

        //return "0";
    }

    /**
     * Records daily rainfall for a specific month.
     * 
     * @param month The month of rainfall recorded
     * @param rainfall The rainfall amount recorded
     */
    public void recordDailyRain(int month, double rainfall) 
    {
        //method to record daily rainfall for a specific month
        //if (month >= 1 && month <= 12)
        //{
        //monthlyRainTotals[month -1] = rainfall;
        //monthlyCounts[month -1] ++;
        monthlyRainTotals[month - 1] += rainfall;
        monthlyCounts[month - 1]++;
    }

    /**
     * Returns the count of daily rainfall of
     * specific month.
     * 
     * @param month The month of rainfall recorded
     * @return The count of daily rainfall recorded
     */
    public int getCountForMonth(int month) 
    {
        return monthlyCounts[month - 1];
    }

    /**
     *  Calculates the average daily rainfall for a specific month.
     *  
     *  @param month The month of rainfall recorded
     *  
     *  @return The average daily rainfall
     *  for specific month
     */
    public double getAvgForMonth(int month)
    {
        //method to calculate the average daily rainfall for a month
        if ( monthlyCounts[month - 1] == 0)
        {
            return -1;
        }
        return monthlyRainTotals[month - 1] / monthlyCounts[month - 1];
    }

    /**
     * Returns the number of the month that had 
     * the lowest average rainfall
     * recorded
     * 
     * @return The number of the month 
     * with the lowest average rainfall
     * 
     */
    public int getLowestMonth()
    {
        double lowestValue = Double.MAX_VALUE;
        int lowestMonth = 0; // Initialize to 0

        for (int i = 1; i <= monthlyCounts.length; i++) 
        {
            double avg = getAvgForMonth(i);

            if (avg != -1 && lowestValue > avg) 
            {
                lowestMonth = i;
                lowestValue = avg;
            }
        }

        // If no rainfall records for any month, return 1
        if (lowestMonth == 0) {
            return 1;
        }

        return lowestMonth;
    }
}