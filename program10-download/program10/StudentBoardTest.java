import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris2.*;

// -------------------------------------------------------------------------
/**
 *  Tests the board interface.
 *  Summarize what your test objectives are.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.07
 */
public class StudentBoardTest
    extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new StudentBoardTest test object.
     */
    public StudentBoardTest()
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
     * Test the placement of an L-shaped piece in the top row.
     */
    public void testLonRow0()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "#### #####"
            );
        // Rotate the L 3 times to the correct orientation
        Piece piece   = Piece.getPiece(Piece.RIGHT_L, 3);

        // Now call place()
        int result = board.place(piece, new Point(4, 0));

        // Expect place() to be successful and fill a row
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);

        // place() doesn't clear the rows, only adds the pieces        
        // row 0 should be full
        int[] blocksInRows = board.getBlocksInAllRows();
        assertThat(blocksInRows[0]).isEqualTo(board.getWidth());
        // row 1 should have the three blocks from the back of the L
        assertThat(blocksInRows[1]).isEqualTo(3);
        // Check all column heights        
        assertThat(board.getColumnHeights()).isEqualTo(new int[] {
            1, 1, 1, 1, 2, 2, 2, 1, 1, 1});
    }       
    /**
     * Test the placement of an L-shaped piece in the second row.
     */
    public void testLonRow1()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "#### #####"
            );
        // Rotate the L 3 times to the correct orientation
        Piece piece   = Piece.getPiece(Piece.RIGHT_L, 3);

        // Now call place()
        int result = board.place(piece, new Point(4, 0));

        // Expect place() to be successful and fill a row
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);

        // expected result        
        StudentBoard expected = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        assertThat(BoardUtilities.equals(board, expected)).isTrue();
    }
    /**
     * Test placing a valid piece in an empty board.
     */
    public void testPlaceValid() 
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);

        int result = board.place(piece, new Point(4, 0));

        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
    }
    /**
     * Test getting the number of blocks in all rows.
     */
    public void testGetBlocksInAllRows()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );

        int[] expected = new int[]{
            9, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThat(board.getBlocksInAllRows()).isEqualTo(expected);
    }
    /**
     * Test checking if a block exists at a specific point.
     */
    public void testHasBlockAt()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );

        Point point = new Point(3, 2);
        assertThat(board.hasBlockAt(point)).isFalse();
    }
    /**
     * Test clearing filled rows.
     */

    public void testClearRows() {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        boolean rowsCleared = board.clearRows();

        assertThat(rowsCleared).isTrue();
    }
    /**
     * Test placing a piece out of bounds.
     */
    public void testPlaceOutOfBound()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        Piece piece1 = Piece.getPiece(Piece.RIGHT_L, 3);
        int result1 = board.place(piece1, new Point(-1, -1));
        assertThat(result1).isEqualTo(Board.PLACE_OUT_BOUNDS);

        Piece piece2 = Piece.getPiece(Piece.RIGHT_L, 3);
        int result2 = board.place(piece2, new Point(4, 3));
        assertThat(result2).isNotEqualTo(Board.PLACE_OK);
    }
    /**
     * Test placing a piece within bounds.
     */
    public void testPlaceNotOutOfBounds()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);

        int result = board.place(piece, new Point(4, 0));
        assertThat(result).isNotEqualTo(Board.PLACE_OUT_BOUNDS);
    }
    /**
     * Test placing a piece where 
     * another block is already present.
     */
    public void testPlaceBadOccupied()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = board.place(piece, new Point(3, 2));
        assertThat(result).isNotEqualTo(Board.PLACE_BAD);
    }
    /**
     * Test placing a piece where no block is present.
     */
    public void testPlaceNotBadOccupied()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = board.place(piece, new Point(4, 0));

        assertThat(result).isEqualTo(Board.PLACE_BAD);
    }
    /**
     * Test the column heights after placing a piece.
     */
    public void testPlaceColumnHeight()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        board.place(piece, new Point(3, 0));

        int[] columnHeights = board.getColumnHeights();
        assertThat(columnHeights[0]).isEqualTo(1);
        assertThat(columnHeights[1]).isEqualTo(1);
    }
    /**
     *  Test placing a piece without filling a row.
     */
    public void testPlaceRowFilled()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = board.place(piece, new Point(3, 0));

        assertThat(result).isNotEqualTo(Board.PLACE_ROW_FILLED);
    }
    /**
     * Test placing a piece that results in filling a row.
     */
    public void testPlaceNotRowFilled()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "    ###   ",
                "##########"
            );

        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        board.place(piece, new Point(4, 0));

        boolean result = board.clearRows();
        assertThat(result).isEqualTo(true);
    }
    /**
     * Test clearing rows that do not meet the criteria.
     */
    public void testClearRowsNotmet()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 4,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );

        boolean rowsCleared = board.clearRows();

        assertThat(rowsCleared).isFalse();
    }
    /**
     * Test placing a piece with no issues.
     */
    public void testPlaceOk()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 4,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );

        board.clearRows();
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = board.place(piece, new Point(4, 1));

        assertThat(result).isEqualTo(Board.PLACE_OK);
    }
    /**
     * Test attempting to clear rows on an empty board.
     */
    public void testClearRowsNo()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );

        boolean result = board.clearRows();
        assertThat(result).isFalse();
    }
    /**
     * Test placing a piece with xDs >= width.
     */
    public void testPlaceOutBoundsXOverWidth() 
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);

        int result = board.place(piece, new Point(10, 0));

        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
    }
    /**
     * Test placing a piece with yDs >= height.
     */
    public void testNotPlaceOutBoundYOverHeight()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);

        int result = board.place(piece, new Point(4, 24));

        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
    }
    /**
     * Test placing a piece with xDs < 0.
     */
    public void testPlaceOutBoundsXNegative() 
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);

        int result = board.place(piece, new Point(-1, 0));

        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
    }
    /**
     * Test placing a piece with yDs < 0.
     */
    public void testPlaceOutBoundsYNegative()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
                10, 24,
                "          ",
                "          ",
                "          ",
                "#### #####"
            );
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);

        int result = board.place(piece, new Point(4, -1));

        assertThat(result).isNotEqualTo(Board.PLACE_OUT_BOUNDS);
    }
}