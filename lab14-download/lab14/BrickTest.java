import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  This test class test the Brick class
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.12.04
 */
public class BrickTest
    extends TestCase
{
    //~ Fields ................................................................

    private Brick brick1;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new BrickTest test object.
     */
    public BrickTest()
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
        /*# Pick your own values instead of those used below */
        brick1 = new Brick(8, 20, 12);
    }

    // ----------------------------------------------------------
    /**
     * Test the basic accessors on a brand new Brick.
     */
    public void testBrickConstructor()
    {
        /*# Put your own assertions in here. */
        int depth = 8;
        int width = 20;
        int height = 12;

        Brick brick = new Brick(height, width, depth);

        assertThat(depth).isEqualTo(8);
        assertThat(width).isEqualTo(20);
        assertThat(height).isEqualTo(12);
    }

    /**
     * test the getSurfaceArea mehtod
     */
    public void testGetSurfaceArea()
    {
        double expectedSurfaceArea = 992.0;

        double actualSurfaceArea = brick1.getSurfaceArea();

        assertThat(actualSurfaceArea).
            isEqualTo(expectedSurfaceArea, within(0.01));

    }

    /**
     * test getWeight()
     */
    public void testGetHeight()
    {
        double expetecdHeight = 8.0;

        double actualHeight = brick1.getHeight();

        assertThat(actualHeight).
            isEqualTo(expetecdHeight, within(0.01));
    }
    /**
     * tests get volume()
     */
    public void testGetVolume()
    {
        double expectedVolume = 1920;

        double actualVolume =  brick1.getVolume();

        assertThat(actualVolume).
            isEqualTo(expectedVolume, within(0.01));
    }

    /**
     * tests getWidth();
     */
    public void getWidth()
    {
        double expectedWidth = 12.0;

        double actualWidth = brick1.getWeight();

        assertThat(actualWidth).
            isEqualTo(expectedWidth, within(0.01));
    }

}
