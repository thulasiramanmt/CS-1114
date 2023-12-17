import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris.*;

// -------------------------------------------------------------------------
/**
 *  This is a test class for the CleverBrain class
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.31
 */
public class CleverBrainTest
extends TestCase
{
    //~ Fields ................................................................
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new CleverBrainTest test object.
     */
    public CleverBrainTest()
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
        /*# Insert your own setup code here */
       


    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * Tests the rateBoard() method
     */
    public void testLonRow0()
    {
        CleverBrain myBrain = new CleverBrain();
        
        Board board = new Board(10, 24,
            "#### #####"
            );
        Piece piece   = Piece.getPiece(Piece.RIGHT_L, 0);

        // Now call the brain
        Move move = myBrain.bestMove(board, piece, 20);

        // Expect the lower left destination is where the hole is
        assertThat(move.getLocation()).isEqualTo(new Point(4, 0));
        // Expect the piece is rotated counter-clockwise 3 times
        assertThat(move.getPiece()).isEqualTo(
            Piece.getPiece(Piece.RIGHT_L, 3));
    }

}
