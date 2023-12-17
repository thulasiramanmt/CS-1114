import student.media.*;
import java.awt.Color;

//-------------------------------------------------------------------------
/**
 *  A picture that supports basic color transformations for Lab 08.
 *
 *  @author thulasiramanmt  
 *  @version 2023.10.16
 *  
 *  
 *  // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- thulasiramanmt
 */
public class TransformablePicture
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created TransformablePicture object as a copy
     * of another image.
     * 
     * @param original picture
     */
    public TransformablePicture(Picture original)
    {
        super(original);
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Adds a radial shadow that gets darker the farther a pixel is from
     * the upper left corner.
     * 
     * @param rate The speed at which the shadow gets darker, where
     *             a larger number produces a more gradual shadow
     */
    public void radialShadow(int rate)
    {
        /*# Insert your imlpementation here */
        for (int x = 0; x < this.getWidth(); x++) 
        {
            for (int y = 0; y < this.getHeight(); y++) 
            {
                Pixel pixel = this.getPixel(x, y); 	
                int distance = x + y;	
                int adjustment = -distance / rate;  	
                int red = pixel.getRed() + adjustment;
                int green = pixel.getGreen() + adjustment;
                int blue = pixel.getBlue() + adjustment;

                pixel.setRed(red);
                pixel.setGreen(green);
                pixel.setBlue(blue);
            }
        }
    }
    /**
     * Adjusts the RGB color components of a pixel by 
     * adding an amount to each component.
     * 
     * @param pixel  The Pixel object to adjust.
     * @param amount The value to add to each color component.
     */
    public void adjustPixel(Pixel pixel, int amount)
    {   
        int red = pixel.getRed() + amount;
        int green = pixel.getGreen() + amount;
        int blue = pixel.getBlue() + amount;
        
        pixel.setRed(red);
        pixel.setGreen(green);
        pixel.setBlue(blue);
    }
    /**
     * Adjusts pixel colors based on their 
     * distance from the image edges.
     * 
     * 
     * @param rate The rate of color adjustment.
     */
    public void radialGlow(int rate) 
    {
        int maxWidth = this.getWidth() - 1; 
        int maxHeight = this.getHeight() - 1; 
        for (int x = 0; x <= maxWidth; x++) 
        {
            for (int y = 0; y <= maxHeight; y++) 
            {
                Pixel pixel = this.getPixel(x, y);

                int distance = (maxWidth - x) + (maxHeight - y);

                int adjustment = distance / rate;

                int red = pixel.getRed() + adjustment;
                int green = pixel.getGreen() + adjustment;
                int blue = pixel.getBlue() + adjustment;
                
                pixel.setRed(red);
                pixel.setGreen(green);
                pixel.setBlue(blue);
            }
        }
    }
    /**
     * Shifts pixel colors based 
     * on their distance from image edges.
     * 
     * @param rate The rate of color adjustment.
     * 
     */
    public void colorShift(int rate) 
    {
        int maxWidth = this.getWidth() - 1; 
        int maxHeight = this.getHeight() - 1;
        for (int x = 0; x <= maxWidth; x++) {
            for (int y = 0; y <= maxHeight; y++) {
                Pixel pixel = this.getPixel(x, y);

                int distanceFromTop = y;
                int distanceFromBottom = maxHeight - y;
                int distanceFromLeft = x;
                int distanceFromRight = maxWidth - x;

                int redAdjustment = 
                    (distanceFromBottom + distanceFromRight) / rate;
                int blueAdjustment = 
                    (distanceFromTop + distanceFromLeft) / rate;

                int red = pixel.getRed() + redAdjustment;
                int blue = pixel.getBlue() + blueAdjustment;
                int green = pixel.getGreen();

                pixel.setRed(red);
                pixel.setGreen(green);
                pixel.setBlue(blue);
            }
        }
    }
}