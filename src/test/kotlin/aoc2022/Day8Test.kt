package aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.math.BigInteger
import java.util.*

internal class Day8Test {

    val dayString = "day8"

    @Test
    fun example1() {
        val file = ClassLoader.getSystemResource(dayString + "example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day8(inputString)
        val total = example1.problem1()
        assertEquals(21, total)

    }


    @Test
    fun problem1() {
        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day8(inputString)
        val total = example1.problem1()
        println(total)

    }


    @Test
    fun example2() {
        val file = ClassLoader.getSystemResource(dayString + "example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day8(inputString)
        val total = example1.problem2()
        assertEquals(8, total)


    }


    @Test
    fun problem2() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day8(inputString)
        val total = example1.problem2()
        println(total)

    }


}