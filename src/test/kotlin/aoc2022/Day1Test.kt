package aoc2022

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class Day1Test {

    @Test
    fun example1() {
        val file = ClassLoader.getSystemResource("day1example1.txt").file
        val inputString = File(file).readText().trim()
        var day1 = Day1()
        val highest = day1.findHighest(inputString)
        Assertions.assertEquals(highest, 24000)

    }

    @Test
    fun problem1() {
        val file = ClassLoader.getSystemResource("day1.txt").file
        val inputString = File(file).readText().trim()
        var day1 = Day1()
        val highest = day1.findHighest(inputString)

        println(highest)
    }

    @Test
    fun problem2() {
        val file = ClassLoader.getSystemResource("day1.txt").file
        val inputString = File(file).readText().trim()
        var day1 = Day1()
        val highest = day1.findTopThree(inputString)

        println(highest)
    }
}