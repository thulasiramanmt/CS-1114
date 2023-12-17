import student.tetris.*;
//-------------------------------------------------------------------------
/**
 *  This class represents the Clever Brain AI,
 *  for the game
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.10.31
 */
public class CleverBrain implements Brain
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created CleverBain object.
     */
    public CleverBrain()
    {
        super();
        /*# Do any work to initialize your class here. */
    }

    //~ Methods ...............................................................
    /**
     * Reads the board
     * @param board The board
     * @return results the Value.
     */
    public double rateBoard(Board board)
    {
        double tRating = 0.0;
        for (int column = 0; column < board.getWidth(); column++)
        {
            double columnRating = rateColumn(board, column);
            tRating = columnRating + tRating;
        }

        double rFilled = 0.0;
        for (int row = 0; row < board.getHeight(); row++)
        {
            double rowRating = rateRow(board, row);
            rFilled = rowRating;
        }

        double holes = (board.getWidth() * board.getHeight()) - rFilled;
        double results = tRating * holes;
        return results;    
    }
    /**
     * makes the moves
     * @param board The board
     * @param piece The piece
     * @param heightLimit 
     * the HeightLimit
     * @return bestMove the bestMove
     */
    public Move bestMove(Board board, Piece piece, int heightLimit) 
    {  
        Move bestMove = new Move(piece);
        double leastRating = Double.MAX_VALUE;
        for (int rotation = 0; rotation < 
            piece.getRotations().length; rotation++)
        {
            Piece rotated = piece.getRotations()[rotation];
            for (int column = 0; column <= 
                board.getWidth() - rotated.getWidth(); column++)
            {

                Point pt = 
                    new Point(column, board.rowAfterDrop(rotated, column));

                int placed = board.place(rotated, pt);

                if (placed == board.PLACE_OK ||
                    placed == board.PLACE_ROW_FILLED)
                {
                    board.clearRows();
                    double rating = rateBoard(board);

                    if (rating < leastRating) 
                    {
                        leastRating = rating;
                        bestMove.setPiece(rotated);
                        bestMove.setLocation(pt);
                        bestMove.setScore(leastRating);
                    }
                    //board.undo();
                }
                board.undo();
            }
        }
        return bestMove;
    }
    /**
     * Gets the height of all the column. 
     * @param board The board
     * @param column Number of column
     * @return rating
     */
    public double rateColumn(Board board, int column)
    {
        int[] columnHeights = board.getColumnHeights();
        int heightColumn = columnHeights[column];
        double rating = heightColumn * 0.1;
        return rating;
    }
    /**
     * Gets the height of the rows
     * @param board The board
     * @param row the number of row
     * @return rating
     */
    public double rateRow(Board board, int row)
    {
        int[] blocksInRows = board.getBlocksInAllRows();
        int heightRow = blocksInRows[row];
        double rRating = heightRow * 0.1;
        return rRating;
    }
}
