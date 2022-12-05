package aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day4Test {

    val dayString = "day4"

    @Test
    fun example1() {

        val file = ClassLoader.getSystemResource(dayString +"example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day4(inputString)
        val total = example1.problem1()
        assertEquals(2, total)

    }

    @Test
    fun problem1() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day4(inputString)
        val total = example1.problem1()
        println(total)

    }

    @Test
    fun example2() {

        val file = ClassLoader.getSystemResource(dayString +"example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day4(inputString)
        val total = example1.problem2()
        assertEquals(4, total)

    }

    @Test
    fun problem2() {

        val file = ClassLoader.getSystemResource("$dayString.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day4(inputString)
        val total = example1.problem2()
        println(total)

    }


}