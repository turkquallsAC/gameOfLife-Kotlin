import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Test

class boardTest {
    @Test
    fun aSingleCellIsOnTheBoard() {
        val cell = Cell(0, 0)
        val board = Board()
        board.addCells(cell)

        assertThat(board.getCells(), hasSize(1))
    }

    @Test
    fun singleCellOnBoardHasNoNeighbors() {
        val cell = Cell(0, 0)
        val board = Board()
        board.addCells(cell)

        assertThat(board.getNeighbors(cell), empty())
    }
    @Test
    fun cellsOnBoardAreNeighbors() {
        val cell1 = Cell(0, 0)
        val cell2 = Cell(1, 0)
        val board = Board()
        board.addCells(cell1, cell2);

        assertThat(board.getNeighbors(cell1), contains(cell2))
    }

    @Test
    fun cellsOnBoardAreNotNeighbors() {
        val cell1 = Cell(0, 0)
        val cell2 = Cell(2, -3)
        val board = Board()
        board.addCells(cell1, cell2);

        assertThat(board.getNeighbors(cell1), empty())
    }

    @Test
    fun cellCanOnlyHaveUpToEightNeighbors() {
        val board = Board()
        addNeighborhood(board)

        assertThat(board.getCells(), hasSize(25))
        assertThat(board.getNeighbors(Cell(0,0)), hasSize(8))
    }

    @Test
    fun singleCellShouldDieNextRound() {
        val board = Board()
        val cell = Cell(0, 0)
        board.addCells(cell)

        board.nextRound();

        assertFalse(board.isAlive(cell));
    }

    @Test
    fun singleCellWithTwoNeighborsShouldBeAliveNextRound() {
        val board = Board()
        val cell1 = Cell(0, 0)
        val cell2 = Cell(1, 1)
        val cell3 = Cell(1, 0)
        board.addCells(cell1, cell2, cell3)

        board.nextRound()

        assertTrue(board.isAlive(cell2))
    }

    @Test
    fun singleCellWithThreeNeighborsShouldBeAliveNextRound() {
        val board = Board()
        val cell1 = Cell(0, 1)
        val cell2 = Cell(1, 1)
        val cell3 = Cell(1, 0)
        val cell4 = Cell(0, 0)
        board.addCells(cell1, cell2, cell3, cell4)

        board.nextRound()

        assertTrue(board.isAlive(cell2))
    }

    private fun addNeighborhood(board: Board) {
        (-2..2).forEach { x ->
            (-2..2).forEach {y ->
                board.addCells(Cell(x, y))
            }
        }
    }
}