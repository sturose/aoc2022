package aoc2022


class Day9 {

    val instructions: List<Pair<Char, Int>>

    constructor(input: String) {

        val inputLine = input.split("\n")
        var mutableInstructions = mutableListOf<Pair<Char, Int>>()
        for (line in inputLine) {
            val split = line.split(" ")
            mutableInstructions.add(Pair(split[0][0], split[1].toInt()))
        }
        instructions = mutableInstructions
    }

    fun problem1(length: Int): Int {

        var spacesVisited = hashSetOf<Pair<Int, Int>>()
        var ropeX = MutableList(length) { 0 }
        var ropeY = MutableList(length) { 0 }
        spacesVisited.add(Pair(ropeY[ropeY.lastIndex], ropeX[ropeX.lastIndex]))

        for (instruction in instructions) {
            for (i in 1..instruction.second) {
                var current = 0

                // Move Head
                when (instruction.first) {
                    'U' -> {
                        ropeX[current]++
                    }
                    'D' -> {
                        ropeX[current]--
                    }
                    'L' -> {
                        ropeY[current]--
                    }
                    'R' -> {
                        ropeY[current]++
                    }
                }

                // Move Tail
                for (i in 0 until length - 1) {
                    moveNext(ropeX, i, ropeY)
                }

                // Record position
                spacesVisited.add(Pair(ropeY[ropeY.lastIndex], ropeX[ropeX.lastIndex]))

            }
        }

        return spacesVisited.count()
    }

    private fun moveNext(
        ropeX: MutableList<Int>,
        current: Int,
        ropeY: MutableList<Int>
    ) {

        val next = current + 1
        if (ropeX[current] > ropeX[next] + 1) {
            ropeX[next]++
            if (ropeY[current] > ropeY[next]) {
                ropeY[next]++
            }
            if (ropeY[current] < ropeY[next]) {
                ropeY[next]--
            }
        }
        if (ropeX[current] < ropeX[next] - 1) {
            ropeX[next]--
            if (ropeY[current] > ropeY[next]) {
                ropeY[next]++
            }
            if (ropeY[current] < ropeY[next]) {
                ropeY[next]--
            }
        }

        if (ropeY[current] < ropeY[next] - 1) {
            ropeY[next]--
            if (ropeX[current] < ropeX[next]) {
                ropeX[next]--
            }
            if (ropeX[current] > ropeX[next]) {
                ropeX[next]++
            }
        }

        if (ropeY[current] > ropeY[next] + 1) {
            ropeY[next]++

            if (ropeX[current] < ropeX[next]) {
                ropeX[next]--
            }
            if (ropeX[current] > ropeX[next]) {
                ropeX[next]++
            }
        }

    }
}

