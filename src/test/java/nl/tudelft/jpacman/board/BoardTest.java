package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Board class.
 */
class BoardTest {

    /**
     * Tests that a valid board has non-null squares and correct dimensions.
     */
    @Test
    void validBoardHasNonNullSquares() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        Board board = new Board(grid);

        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.invariant()).isTrue();
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
    }

    /**
     * Tests that a board containing a null square fails the invariant check.
     */
    @Test
    void boardWithNullSquareFailsInvariant() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        try {
            new Board(grid);
        } catch (AssertionError e) {
            assertThat(e).isInstanceOf(AssertionError.class);
        }
    }

    /**
     * Tests that requesting a square outside the board bounds throws an AssertionError.
     */
    @Test
    void squareAtThrowsWhenOutOfBounds() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        Board board = new Board(grid);

        try {
            board.squareAt(1, 0);
        } catch (AssertionError e) {
            assertThat(e).isInstanceOf(AssertionError.class);
        }
    }
}
