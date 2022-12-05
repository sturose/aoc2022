package aoc2022

import java.util.ArrayDeque


class Day5 {

    var stacks = mutableListOf<ArrayDeque<Char>>()

    constructor(input: MutableList<ArrayDeque<Char>>) {
        stacks = input
    }


    fun problem1(inputString: String): String {

        val movements = inputString.split("\n")
        for (movement in movements) {
            val split = movement.split("move", "from", "to")

            for (range in 0 until split[1].trim().toInt()) {
                val value = stacks[split[2].trim().toInt() -1].pop()
                stacks[split[3].trim().toInt() - 1].push(value)
            }
        }

        var outputString = ""
        for (stack in stacks) {
            outputString += stack.first
        }

        return outputString
    }


    fun problem2(inputString: String): String {
        val movements = inputString.split("\n")
        for (movement in movements) {
            val split = movement.split("move", "from", "to")

            var values = ArrayDeque<Char>()
            for (range in 0 until split[1].trim().toInt()) {
                values.push(stacks[split[2].trim().toInt() -1].pop())

            }
            for (value in values) {
                stacks[split[3].trim().toInt() - 1].push(value)
            }
        }

        var outputString = ""
        for (stack in stacks) {
            outputString += stack.first
        }

        return outputString
    }


}