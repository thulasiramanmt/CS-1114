import java.util.*;
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  This calss has methods for the jerro to 
 *  naviagte the island and pick up the flower. 
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.23
 */
public class FlowerCollector
    extends Jeroo
{
    //~ Fields ................................................................
    private List<Flower> basket;


    //~ Constructor ...........................................................
    
    // ----------------------------------------------------------
    /**
     * Initializes a newly created FlowerCollector object.
     */
    public FlowerCollector()
    {
        super();
        basket = new ArrayList<Flower>();
        
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    /**
     * This method helps the jerro collect the flowers. 
     */
    public void collectFlowers()
    {
        for (int x = 1; x < this.getWorld().getWidth() - 1; x++)
        {
            for (int y = 1; y < this.getWorld().getHeight() - 1; y++)
            {
                this.setLocation(x, y);
                
                if (this.seesFlower(HERE))
                {
                    this.pick();
                }
            }
        }

    }
    /**
     * This method gets the flowers in the basket. 
     * 
     * @return list of Flowers in the basket. 
     */
    public List<Flower> getBasket()
    {
        return basket;
    }
    /**
     * Picks a flower at a current location. 
     */
    public void pick()
    {
        Flower flower = this.getOneIntersectingObject(Flower.class);
        basket.add(flower);
        flower.remove();
    }

}
