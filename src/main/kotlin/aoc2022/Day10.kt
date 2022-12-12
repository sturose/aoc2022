package aoc2022


class Day10 {

    val instructions: List<Int>

    constructor(input: String) {

        val inputLine = input.split("\n")
        var mutableInstructions = mutableListOf<Int>()
        for (line in inputLine) {
            if (line == "noop") {
                mutableInstructions.add(0)
            } else {
                val split = line.split(" ")
                mutableInstructions.add(split[1].toInt())
            }
        }
        mutableInstructions.add(0)
        mutableInstructions.add(0)
        instructions = mutableInstructions
    }

    val cyclesOfInterest = listOf(20, 60, 100, 140, 180, 220)

    fun problem1(): Int {
        var x = 1

        var signalStrengths = 0

        var previousInstruction = 0
        var cycle = 0
        instructions.forEach { instruction ->

            x += previousInstruction
            previousInstruction = instruction

            var signalStrength: Int
            cycle++
            if (cyclesOfInterest.contains(cycle)) {
                signalStrength = x * cycle
                signalStrengths += signalStrength
            }

            if (instruction != 0) {
                cycle++
                if (cyclesOfInterest.contains(cycle)) {
                    signalStrength = x * cycle
                    signalStrengths += signalStrength
                }
            }
        }

        return signalStrengths
    }



    fun problem2(): Int {
        var x = 1

        var signalStrengths = 0

        var previousInstruction = 0
        var cycle = 0
        instructions.forEach { instruction ->

            x += previousInstruction
            previousInstruction = instruction

            cycle++
            processCycle(x, cycle)

            if (instruction != 0) {
                cycle++
                processCycle(x, cycle)
            }
        }

        return signalStrengths
    }

    private fun processCycle(x: Int, cycle: Int) {
        val position = (cycle -1) % 40
        if (x - 1 <= position && position <= x + 1) {
            print("#")
        } else {
            print(".")
        }
        if (cycle % 40 == 0) {
            println()
        }
    }

}

