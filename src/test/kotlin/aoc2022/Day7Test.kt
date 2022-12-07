package aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.math.BigInteger
import java.util.*

internal class Day7Test {

    val dayString = "day7"

    @Test
    fun example1() {
        val file = ClassLoader.getSystemResource(dayString + "example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day7(inputString)
        val total = example1.problem1(BigInteger.valueOf(100000L))
        assertEquals(BigInteger.valueOf(95437L), total)

    }


    @Test
    fun problem1() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day7(inputString)
        val total = example1.problem1(BigInteger.valueOf(100000L))
        println(total)

    }


    @Test
    fun example1p2() {
        val file = ClassLoader.getSystemResource(dayString + "example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day7(inputString)
        val total = example1.problem2()
        assertEquals(BigInteger.valueOf(24933642), total)


    }


    @Test
    fun problem2() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day7(inputString)
        val total = example1.problem2()
        println(total)

    }


}