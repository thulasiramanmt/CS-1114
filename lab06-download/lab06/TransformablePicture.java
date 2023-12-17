import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A picture that supports basic color transformations for Lab 06.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.02
 */
public class TransformablePicture
    extends Picture
{
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created TransformablePicture object as a copy
     * of another image.
     * @param original picture
     */
    public TransformablePicture(Picture original)
    {
        super(original);
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Turns the red intensity of every pixel in this image up to
     * the maximum value.
     */
    public void maxRed()
    {
        /*# Start your implementation here */
        for (Pixel pix: this.getPixels())
        {
            pix.setRed(255);
        }
    }
    /**
     * Turns the green intensity of every pixel in this image up to 
     * the maximum value.
     */
    public void maxGreen()
    {
        for (Pixel pix: this.getPixels())
        {
            pix.setGreen(255);
        }
    }
    /**
     * Turns the blue intensity of every pixel in this image up to 
     * the maximum value. 
     */
    public void maxBlue()
    {
        for (Pixel pix: this.getPixels())
        {
            pix.setBlue(255);
        }
    }
    /**
     * Turns the brightness up of every pixel in this image up.
     * @param amount the int value the brightness increases. 
     */
    public void brighten(int amount)
    {
        for (Pixel pix : this.getPixels()) 
        {
            int q = pix.getRed();
            int w = pix.getGreen();
            int e = pix.getBlue();
            pix.setRed(pix.getRed() + amount);
            pix.setGreen(pix.getGreen() + amount);
            pix.setBlue(pix.getBlue() + amount);
        }
    }
}

        
