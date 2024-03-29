class Board {
    private val aliveCells = mutableListOf<Cell>()

    fun addCells(vararg cells: Cell) {
        this.aliveCells.addAll(cells)
    }

    fun getCells(): List<Cell> {
        return aliveCells
    }

    fun getNeighbors(cell: Cell): List<Cell> {
        val potentialNeighbors = getPotentialNeighbors(cell)
        return aliveCells
            .filterNot { it == cell }
            .filter { potentialNeighbors.contains(it) }
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

    fun isAlive(cell: Cell): Boolean {
        return aliveCells.contains(cell)
    }

    fun nextRound() {
        val stillAliveCells = getCellsThatAreStillAlive()
        val rebornCells = getCellsThatAreReborn(stillAliveCells)

        updateCells(stillAliveCells, rebornCells)
    }

    private fun getCellsThatAreStillAlive(): List<Cell> {
        return aliveCells
            .filter {
                getNeighbors(it).size in 2..3
            }
    }

    private fun getCellsThatAreReborn(stillAliveCells: List<Cell>): List<Cell> {
        return stillAliveCells
            .flatMap {
                getPotentialNeighbors(it)
            }
            .distinct()
            .filter {
                !isAlive(it) && getNeighbors(it).size == 3
            }
    }

    private fun updateCells(stillAliveCells: List<Cell>, rebornCells: List<Cell>) {
        aliveCells.clear()
        aliveCells.addAll(stillAliveCells)
        aliveCells.addAll(rebornCells)
    }

}
