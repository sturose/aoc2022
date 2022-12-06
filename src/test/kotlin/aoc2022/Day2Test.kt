package aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2Test {



    @Test
    fun example1() {

        val file = ClassLoader.getSystemResource("day2example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day2(inputString)
        val total = example1.problem1()
        assertEquals(15, total)

    }

    @Test
    fun problem1() {
        val file = ClassLoader.getSystemResource("day2.txt").file
        val inputString = File(file).readText().trim()
        var problem1 = Day2(inputString)
        val total = problem1.problem1()
        println(total)

    }

    @Test
    fun example2() {

        val file = ClassLoader.getSystemResource("day2example1.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day2(inputString)
        val total = example1.problem2()
        assertEquals(12, total)

    }

    @Test
    fun problem2() {

        val file = ClassLoader.getSystemResource("day2.txt").file
        val inputString = File(file).readText().trim()
        var example1 = Day2(inputString)
        val total = example1.problem2()
        println(total)

    }

}