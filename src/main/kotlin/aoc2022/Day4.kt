package aoc2022


class Day4 {


    constructor(input: String) {
        val pairStrings = input.split("\n")
        val mutableAssignments = mutableListOf<Pair<IntRange, IntRange>>()
        for (string in pairStrings) {
            val ranges = string.split(",")

            var split = ranges[0].split("-")
            val first = IntRange(split[0].toInt(), split[1].toInt())

            split = ranges[1].split("-")
            val second = IntRange(split[0].toInt(), split[1].toInt())
            mutableAssignments.add(Pair(first, second))
        }
        assignments = mutableAssignments
    }

    var assignments = listOf<Pair<IntRange, IntRange>>()

    fun problem1(): Int {
        var runningTotal = 0
        for (assignment in assignments) {
            if (assignment.first.contains(assignment.second.first) && assignment.first.contains(assignment.second.last)) {
                runningTotal++
            } else if (assignment.second.contains(assignment.first.first) && assignment.second.contains(assignment.first.last)) {
                runningTotal++
            }
        }


        return runningTotal
    }


    fun problem2(): Int {
        var runningTotal = 0
        for (assignment in assignments) {
            if (assignment.first.contains(assignment.second.first)) {
                runningTotal++
            } else if (assignment.first.contains(assignment.second.last)) {
                runningTotal++
            } else if (assignment.second.contains(assignment.first.first)) {
                runningTotal++
            } else if (assignment.second.contains(assignment.first.last)) {
                runningTotal++
            }
        }



        return runningTotal
    }


}