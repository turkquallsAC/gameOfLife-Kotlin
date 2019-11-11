class Board {
    private val cells = mutableListOf<Cell>()

    fun addCell(cell: Cell) {
        cells.add(cell)
    }

    fun getCells(): List<Cell> {
        return cells
    }

}
