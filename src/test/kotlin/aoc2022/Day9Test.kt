package aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.math.BigInteger
import java.util.*

internal class Day9Test {

    val dayString = "day9"

    @Test
    fun example1() {
        val file = ClassLoader.getSystemResource(dayString + "example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day9(inputString)
        val total = example1.problem1(2)
        assertEquals(13, total)
    }


    @Test
    fun problem1() {
        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day9(inputString)
        val total = example1.problem1(2)
        println(total)
    }


    @Test
    fun example2() {
        val file = ClassLoader.getSystemResource(dayString + "example2.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day9(inputString)
        val total = example1.problem1(10)
        assertEquals(36, total)
    }


    @Test
    fun problem2() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day9(inputString)
        val total = example1.problem1(10)
        println(total)
    }


}