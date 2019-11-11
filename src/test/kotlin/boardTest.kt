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
}