package aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.util.*

internal class Day6Test {

    val dayString = "day6"

    @Test
    fun example1() {
        val inputString = "bvwbjplbgvbhsrlpgdmjqwftvncz"
        var example1 = Day6()
        val startingPoint = example1.problem1(inputString)
        assertEquals(5, startingPoint)

    }

    @Test
    fun example2() {
        val inputString = "nppdvjthqldpwncqszvftbrmjlhg"
        var example1 = Day6()
        val startingPoint = example1.problem1(inputString)
        assertEquals(6, startingPoint)

    }

    @Test
    fun example3() {
        val inputString = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
        var example1 = Day6()
        val startingPoint = example1.problem1(inputString)
        assertEquals(10, startingPoint)

    }

    @Test
    fun problem1() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()

        var example1 = Day6()
        val startingPoint = example1.problem1(inputString)
        println(startingPoint)

    }


    @Test
    fun example1p2() {
        val inputString = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
        var example1 = Day6()
        val startingPoint = example1.problem2(inputString)
        assertEquals(19, startingPoint)

    }

    @Test
    fun example2p2() {
        val inputString = "bvwbjplbgvbhsrlpgdmjqwftvncz"
        var example1 = Day6()
        val startingPoint = example1.problem2(inputString)
        assertEquals(23, startingPoint)

    }

    @Test
    fun example3p2() {
        val inputString = "nppdvjthqldpwncqszvftbrmjlhg"
        var example1 = Day6()
        val startingPoint = example1.problem2(inputString)
        assertEquals(23, startingPoint)

    }

    @Test
    fun problem2() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()

        var example1 = Day6()
        val startingPoint = example1.problem2(inputString)
        println(startingPoint)

    }


}