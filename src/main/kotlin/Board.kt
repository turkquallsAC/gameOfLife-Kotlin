class Board {
    private val cells = mutableListOf<Cell>()

    fun addCells(vararg cells: Cell) {
        this.cells.addAll(cells)
    }

    fun getCells(): List<Cell> {
        return cells
    }

    fun getNeighbors(cell: Cell): List<Cell> {
        val filteredCells = cells.filterNot { it == cell }
        val potentialNeighbors = getPotentialNeighbors(cell)
        return filteredCells.filter { potentialNeighbors.contains(it) }
    }

    private fun getPotentialNeighbors(cell: Cell): MutableList<Cell> {
        val potentialNeighbors = mutableListOf<Cell>()

        (-1..1).forEach { x ->
            (-1..1).forEach { y ->
                potentialNeighbors.add(Cell(x + cell.x, y + cell.y))
            }
        }

        return potentialNeighbors
    }

}
