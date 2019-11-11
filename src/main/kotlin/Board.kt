class Board {
    private val cells = mutableListOf<Cell>()

    fun addCells(vararg cells: Cell) {
        this.cells.addAll(cells)
    }

    fun getCells(): List<Cell> {
        return cells
    }

    fun getNeighbors(cell: Cell): List<Cell> {
        return cells.filterNot { it == cell }
    }

}
