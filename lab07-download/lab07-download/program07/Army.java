import java.util.*;

//-------------------------------------------------------------------------
/**
 *  The Army class represents a player's army,
 *  with information about the player, faction, and army name.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.24
 */
public class Army
    extends Squad
{
    //~ Fields ................................................................
    private String playerName;
    private String faction;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created Army object.
     * @param armyName the name of the army. 
     * @param armyFaction the name of the faction. 
     * @param playerName the name of the player. 
     */
    public Army(String armyName, String armyFaction, String playerName)
    {
        super(armyName);
        /*# Do any work to initialize your class here. */
        this.faction = armyFaction;
        this.playerName = playerName;
    }

    //~ Methods ...............................................................
    /**
     * get player name
     * @return playerName
     */
    public String getPlayerName() 
    {
        return playerName;
    }   
    /**
     * set player name
     * @param playerName name of the player
     */
    public void setPlayerName(String playerName) 
    {
        this.playerName = playerName;
    }
    /**
     * get faction
     * @return faction
     */
    public String getFaction() 
    {
        return faction;
    }
    /**
     * set faction
     * @param faction 
     */
    public void setFaction(String faction) 
    {
        this.faction = faction;
    }
    /**
     * convert to string. 
     */
    @Override
    public String toString() 
    {
        String armyString = "player:" + getPlayerName() +
            ", faction:" + getFaction() 
            + ", army:" + super.toString();
        return armyString;
    }
}