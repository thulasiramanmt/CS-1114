import student.tetris2.*;
//-------------------------------------------------------------------------
/**
 *  This class provides a common set of features
 *  for the Board interface
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author thulasiramanmt
 *  @version 2023.11.07
 */
public class StudentBoard 
    implements Board
{
    //~ Fields ................................................................
    private int width;
    private int height;
    private int[] columnHeights;
    private int[] blocksInAllRows;
    private boolean[][] grid;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Initializes a newly created StudentBoard object.
     * 
     * @param width The number of width
     * @param height The number of height
     */
    public StudentBoard(int width, int height)
    {
        super();
        /*# Do any work to initialize your class here. */
        this.width = width; 
        this.height = height;
        columnHeights = new int[width];
        blocksInAllRows = new int[height];
        grid = new boolean[height][width];
    }

    //~ Methods ...............................................................
    /**
     * Gets Width
     * 
     * @return width
     */
    public int getWidth()
    {
        return width;
    }
    /**
     * gets height
     * 
     * @return height
     */
    public int getHeight()
    {
        return height;
    }
    /**
     * gets column height
     * 
     * @return columnHeights
     */
    public int[] getColumnHeights() 
    {
        return columnHeights;
    }
    /**
     * get rows width
     * 
     * @return An array representing the number of blocks filled in each row.
     */
    public int[] getBlocksInAllRows() 
    {
        return blocksInAllRows;
    }
    /**
     * Attempts to add the body of a piece to the board.
     * Copies the piece blocks into the board grid.
     * Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     * for a regular placement that causes at least one row to be filled.
     * 
     * @param point The location to check.
     * @return True if there is a block at the specified (x, y) position.
     */
    public boolean hasBlockAt(Point point)
    {
        int y = point.getY();
        int x = point.getX(); 

        return grid[y][x];
    }
    /**
     * Attempts to add the body of a piece to the board.
     * Copies the piece blocks into the board grid.
     * Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     * for a regular placement that causes at least one row to be filled.
     * 
     * @param piece the peice to place
     * @param location the location to place
     * @return The result of the placement attempt. Possible return values:
     *                  - Board.PLACE_OK
     *                  - Board.PLACE_OUT_BOUNDS
     *                  - Board.PLACE_BAD
     *                  - Board.PLACE_ROW_FILLED
     */
    public int place(Piece piece, Point location)
    {
        Point[] body = piece.getBody();
        int x0 = location.getX();
        int y0 = location.getY();
        //looping through the peice's body and place each block
        for (Point block: body) 
        {
            int xi = block.getX();
            int yi = block.getY();

            // Calculate the destination for the block
            int xDs = x0 + xi;
            int yDs = y0 + yi;

            // Check if the destination is out of bounds
            if (xDs < 0 || xDs >= width || yDs < 0 || yDs >= height) 
            {
                return Board.PLACE_OUT_BOUNDS;
            }

            // Check if the destination is already occupied
            if (hasBlockAt(new Point(xDs, yDs))) 
            {
                return Board.PLACE_BAD;
            }

            grid[yDs][xDs] = true;

            // Update column height
            if (yDs + 1 > columnHeights[xDs]) 
            {
                columnHeights[xDs] = yDs + 1;
            }

            // Increment the number of blocks in the row
            blocksInAllRows[yDs]++;

            // Check if any rows have filled
        }

        for (int rowBlocks : blocksInAllRows)
        {
            if (rowBlocks == width) 
            {
                return Board.PLACE_ROW_FILLED;
            }
        }
        return PLACE_OK;
    }
    /**
     * Clear Rows
     * @return true if any rows were cleared, false otherwise.
     */
    public boolean clearRows()
    {
        boolean rowsCleared = false;
        for (int row = height - 1; row >= 0; row--)
        {
            if (blocksInAllRows[row] == width)
            {
                // this clears rows
                for (int x = 0; x < width; x++) 
                {
                    grid[row][x] = false;
                }
                // shifts all rows above; down by one
                for (int r = row; r < this.height - 1; r++) 
                {
                    for (int x = 0; x < width; x++) 
                    {
                        grid[r][x] = grid[r + 1][x];
                    }
                    blocksInAllRows[r] = blocksInAllRows[r + 1];
                }
                //cleas the top row
                for (int x = 0; x < width; x++) 
                {
                    grid[this.height - 1 ][x] = false;
                }
                blocksInAllRows[this.height - 1] = this.height - 1;

                rowsCleared = true;
            }
        }
        return rowsCleared;  
    }
    /**
     * Gets grids
     * 
     * @return grid
     */
    public boolean[][] getGrid()
    {
        return grid;
    }
}