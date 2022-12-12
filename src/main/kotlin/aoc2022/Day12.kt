package aoc2022

class Day12 {

    val terrain: List<List<Int>>

    var start: Pair<Int, Int>? = null

    val weights: MutableList<MutableList<Int?>>k

    constructor(input: String) {


        val rows = input.split("\n")

        val tempTerrain = mutableListOf<MutableList<Int>>()
        val tempWeight = mutableListOf<MutableList<Int?>>()

        // Pad out first row
        tempTerrain.add(MutableList(rows[0].length + 2) {99})
        tempWeight.add(MutableList(rows[0].length + 2) {99})

        rows.forEachIndexed { rowIndex, row ->
            val terrainRow = mutableListOf<Int>()
            val weightRow = mutableListOf<Int?>()


            // Pad the outside
            terrainRow.add(99)
            weightRow.add(99)

            row.toCharArray().forEachIndexed { index, char ->
                when (char) {
                    'S' -> {
                        terrainRow.add(0)
                        start = Pair(rowIndex+1, index+1)
                        weightRow.add(null)
                    }
                    'E' -> {
                        terrainRow.add(25)
                        end = Pair(rowIndex+1, index+1)
                        weightRow.add(0)
                    }
                    else -> {
                        terrainRow.add(char.minus('a'))
                        weightRow.add(null)
                    }
                }
            }

            // Pad the outside
            terrainRow.add(99)
            weightRow.add(99)

            tempWeight.add(weightRow)
            tempTerrain.add(terrainRow)
        }

        // Pad out last row
        tempTerrain.add(MutableList(rows[0].length + 2) {99})
        tempWeight.add(MutableList(rows[0].length + 2) {99})

        weights = tempWeight
        terrain = tempTerrain

    }

    fun problem1(): Int {

        while( weights[start!!.first][start!!.second] == null) {
            for (x in 1 until weights.size - 1) {
                for (y in 1 until weights[0].size - 1) {
                    setWeight(x, y)
                }
            }
        }

        return weights[start!!.first][start!!.second]!!
    }

    private fun setWeight(x: Int, y: Int) {
        val height = terrain[x][y]
        var weight = weights[x][y]
        adjustWeightForIndexes(x+1, y, height, weight, x, y)
        adjustWeightForIndexes(x-1, y, height, weight, x, y)
        adjustWeightForIndexes(x, y+1, height, weight, x, y)
        adjustWeightForIndexes(x, y-1, height, weight, x, y)
    }

    private fun adjustWeightForIndexes(
        compareX: Int,
        compareY: Int,
        height: Int,
        weight: Int?,
        x: Int,
        y: Int
    ) {

        val compareWeight = weights[compareX][compareY]
        val compareHeight = terrain[compareX][compareY]
        if (compareWeight != null) {
            if (compareHeight <= height + 1) {
                if (weight == null) {
                    weights[x][y] = compareWeight + 1

                } else if (compareWeight + 1 < weight) {
                    weights[x][y] = compareWeight + 1
                }

            }
        }
    }


    fun problem2(): Int {
        // Too lazy to put a real stopping condition
        for (i in 1 until 1000){
            for (x in 1 until weights.size - 1) {
                for (y in 1 until weights[0].size - 1) {
                    setWeight(x, y)
                }
            }
        }

        var currentWinner = weights[start!!.first][start!!.second]!!
        for (x in 1 until weights.size - 1) {
            for (y in 1 until weights[0].size - 1) {
                val weight = weights[x][y]
                if(terrain[x][y] == 0 && weight != null && weight < currentWinner){
                    currentWinner = weight
                }
            }
        }

        return currentWinner
    }


}

