
//-------------------------------------------------------------------------
/**
 * Represents a single post on a message sharing service.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.30
 */
public class Post
{
    //~ Fields ................................................................
    private String name;
    private String message;
    private int day;
    private int hour;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Post object.
     * @prama name String name
     * @param message String message
     * @param day Int day
     * @param hour int hour
     */
    public Post(String name, String message, int day, int hour)
    {
        super();
        /*# Do any work to initialize your class here. */
        this.name = name;
        this.message = message; 
        this.day = day;
        this.hour = hour;
    }
    /**
     * Gets name
     * @return name The name
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Gets message
     * @return message The message
     */
    public String getMessage()
    {
        return this.message;
    }
    /**
     * Gets day value
     * @return day The day value
     */
    public int getDay()
    {
        return this.day;
    }
    /**
     * Gets the hour value
     * @return hour The hour value
     */
    public int getHour()
    {
        return this.hour;
    }


    //~ Methods ...............................................................


}
