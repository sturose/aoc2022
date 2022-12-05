package aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.util.*

internal class Day5Test {

    val dayString = "day5"

    @Test
    fun example1() {

        val startingStacks = mutableListOf<ArrayDeque<Char>>()

        startingStacks.add( ArrayDeque(listOf('N', 'Z')))
        startingStacks.add( ArrayDeque(listOf('D', 'C', 'M')))
        startingStacks.add( ArrayDeque(listOf('P')))

        val file = ClassLoader.getSystemResource(dayString +"example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day5(startingStacks)
        val total = example1.problem1(inputString)
        assertEquals("CMZ", total)

    }

    @Test
    fun problem1() {

        val startingStacks = mutableListOf<ArrayDeque<Char>>()

        startingStacks.add( ArrayDeque(listOf('B', 'V', 'W', 'T', 'Q', 'N', 'H', 'D')))
        startingStacks.add( ArrayDeque(listOf('B', 'W', 'D')))
        startingStacks.add( ArrayDeque(listOf('C', 'J', 'W', 'Q', 'S', 'T')))
        startingStacks.add( ArrayDeque(listOf('P', 'T', 'Z', 'N', 'R', 'J', 'F')))
        startingStacks.add( ArrayDeque(listOf('T', 'S', 'M', 'J', 'V', 'P', 'G')))
        startingStacks.add( ArrayDeque(listOf('N', 'T', 'F', 'W', 'B')))
        startingStacks.add( ArrayDeque(listOf('N', 'V', 'H', 'F', 'Q', 'D', 'L', 'B')))
        startingStacks.add( ArrayDeque(listOf('R', 'F', 'P', 'H')))
        startingStacks.add( ArrayDeque(listOf('H', 'P', 'N', 'L', 'B', 'M', 'S', 'Z')))


        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day5(startingStacks)
        val total = example1.problem1(inputString)
        println(total)

    }

    @Test
    fun example2() {

        val startingStacks = mutableListOf<ArrayDeque<Char>>()

        startingStacks.add( ArrayDeque(listOf('N', 'Z')))
        startingStacks.add( ArrayDeque(listOf('D', 'C', 'M')))
        startingStacks.add( ArrayDeque(listOf('P')))


        val file = ClassLoader.getSystemResource(dayString +"example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day5(startingStacks)
        val total = example1.problem2(inputString)
        assertEquals("MCD", total)

    }

    @Test
    fun problem2() {

        val startingStacks = mutableListOf<ArrayDeque<Char>>()

        startingStacks.add( ArrayDeque(listOf('B', 'V', 'W', 'T', 'Q', 'N', 'H', 'D')))
        startingStacks.add( ArrayDeque(listOf('B', 'W', 'D')))
        startingStacks.add( ArrayDeque(listOf('C', 'J', 'W', 'Q', 'S', 'T')))
        startingStacks.add( ArrayDeque(listOf('P', 'T', 'Z', 'N', 'R', 'J', 'F')))
        startingStacks.add( ArrayDeque(listOf('T', 'S', 'M', 'J', 'V', 'P', 'G')))
        startingStacks.add( ArrayDeque(listOf('N', 'T', 'F', 'W', 'B')))
        startingStacks.add( ArrayDeque(listOf('N', 'V', 'H', 'F', 'Q', 'D', 'L', 'B')))
        startingStacks.add( ArrayDeque(listOf('R', 'F', 'P', 'H')))
        startingStacks.add( ArrayDeque(listOf('H', 'P', 'N', 'L', 'B', 'M', 'S', 'Z')))



        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day5(startingStacks)
        val total = example1.problem2(inputString)
        println(total)

    }


}