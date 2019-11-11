import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasSize
import org.junit.Test

class boardTest {
    @Test
    fun aSingleCellIsOnTheBoard() {
        val cell = Cell()
        val board = Board()
        board.addCell(cell)

        assertThat(board.getCells(), hasSize(1))
    }
}