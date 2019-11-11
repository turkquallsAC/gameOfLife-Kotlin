import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Test

class boardTest {
    @Test
    fun aSingleCellIsOnTheBoard() {
        val cell = Cell()
        val board = Board()
        board.addCells(cell)

        assertThat(board.getCells(), hasSize(1))
    }

    @Test
    fun singleCellOnBoardHasNoNeighbors() {
        val cell = Cell()
        val board = Board()
        board.addCells(cell)

        assertThat(board.getNeighbors(cell), empty())
    }

    @Test
    fun cellsOnBoardAreNeighbors() {
        val cell1 = Cell()
        val cell2 = Cell()
        val board = Board()
        board.addCells(cell1, cell2);

        assertThat(board.getNeighbors(cell1), contains(cell2))
    }
}