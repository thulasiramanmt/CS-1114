//-------------------------------------------------------------------------
/**
 *  Represents a weekly event at a specified time, including a
 *  description.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.06
 */
public class Event
{
    //~ Fields ................................................................
    private int hour;
    private String description; 

    // Add a field representing the hour of this event

    // Add a field representing the description of this event

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Event object.
     * 
     * @param hour The hour (time) of this event, in military time
     *             (0-23).
     * @param description The description of this event.
     */
    public Event(int hour, String description)
    {
        /*# Do any work to initialize your class here. */
        this.hour = hour; 
        this.description = description; 
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Get the description of this event.
     * @return This event's description.
     */
    // place getDescription() here
    public String getDescription()
    {
        return description;
    }

    // ----------------------------------------------------------
    /**
     * Get the hour of this event.
     * @return This event's hour, in military time.
     */
    // place getHour() here
    public int  getHour()
    {
        return hour; 
    }

    // ----------------------------------------------------------
    /**
     * Set the description of this event.
     * @param newDescription The new description for this event.
     */
    // place setDescription() here 
    public void setDescription(String newDescription)
    {
        description = newDescription;
    }

    // ----------------------------------------------------------
    /**
     * Set the hour of this event.
     * @param newHour The new hour for this  event, in military
     *                time.
     */
    // place setHour() here
    public void setHour(int newHour)
    {
        hour = newHour;
    }

    // ----------------------------------------------------------
    /**
     * Set the hour of this event, using a more human-friendly
     * string.
     * @param newHour The new hour for this  event, using an
     *                am/pm designation such as "9am" or "5pm".
     */
    // place setTime() here
    public void setTime(String newHour)
    {
        String digitsOnly = newHour.substring(0, newHour.length() -2);
        int time = Integer.parseInt(digitsOnly);
        if(time == 12 & newHour.endsWith("am"))
        {
            hour = 0; 
        }
        if(time == 12 && newHour.endsWith("pm"))
        {
            hour = 12; 
        }
        if(time < 12 && newHour.endsWith("am"))
        {
            hour = time;
        }
        if(time > 12 && newHour.endsWith("pm"))
        {
            hour = time + 12;
        }
        
    }

    // ----------------------------------------------------------
    /**
     * Get a string representation of this event.
     * @return A human-readable representation of this event
     * that includes the time (in am/pm format) and the description,
     * such as "11am: CS 1114".
     */
    public String toString()
    {   
        String time;
        if (hour == 0) {
            time = "12am";
        } else if (hour < 12) {
            time = hour + "am";
        } else if (hour == 12) {
            time = "12pm";
        } else {
            time = (hour - 12) + "pm";
        }
        return time + ": " + description;
    }
}
