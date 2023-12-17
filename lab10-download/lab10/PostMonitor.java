
//-------------------------------------------------------------------------
/**
 *  Represents a single post on a message sharing service.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.30
 */
public class PostMonitor
{
    //~ Fields ................................................................
    private int postCount;
    private int[] hourCounts;
    private int[] dayCounts;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created PostMonitor object.
     */
    public PostMonitor()
    {
        super();
        postCount = 0;
        hourCounts = new int[24];
        dayCounts = new int[7];
    }


    //~ Methods ...............................................................
    /**
     * gets the PostCounts
     * @return postCounts The value 
     */
    public int getPostCount()
    {
        return this.postCount;
    }
    /**
     *  Gets the HourCounts
     *  @return hourCounts The value
     */
    public int[] getHourCounts()
    {
        return this.hourCounts;
    }
    /**
     * Gets the DayCounts
     * @return dayCounts The Value
     */
    public int[] getDayCounts()
    {
        return this.dayCounts; 
    }
    /**
     * Record posts
     * @param post The post
     */
    public void recordPost(Post post)
    {
        int hour = post.getHour();
        int day = post.getDay();

        hourCounts[hour]++;
        dayCounts[day]++;
        postCount++;
    }
    /**
     * Gets the Index of Largest
     * @param arr An array
     * @return largestIndex The index
     */
    public int getIndexOfLargest(int[] arr)
    {
        int largestValue = 0;
        int largestIndex = 0;
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] > largestValue) {
                largestValue = arr[i];
                largestIndex = i;
            }
        }
        return largestIndex;
    }
    /**
     * Gets the bussiest Hours
     * @return the hour with the largest
     */
    public int getBusiestHour()
    {
        return getIndexOfLargest(hourCounts);
    }
    /**
     * Gest the bussiest day
     * @return The day with the largest
     */
    public int getBusiestDay()
    {
        return getIndexOfLargest(dayCounts);
    }
    /**
     * Gest the index of smallest
     * @@param arr An array
     * @return smallestIndex The index
     */
    public int getIndexOfSmallest(int [] arr)
    {
        int smallestIndex = 0;
        
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    /**
     * Gets the slowestHours
     * @return the hour that is the smallest
     * 
     */
    public int getSlowestHour()
    {
        return getIndexOfSmallest(hourCounts);
    }
    /**
     * Gets the slowest Day
     * @return the day that is the smallest
     */
    public int getSlowestDay()
    {
        return getIndexOfSmallest(dayCounts);
    }
}
