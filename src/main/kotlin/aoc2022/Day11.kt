package aoc2022

import java.math.BigInteger
import kotlin.streams.toList


class Day11 {

    class Monkey {


        private val items: MutableList<BigInteger>
        val multiply: Boolean
        val square: Boolean
        val operand: BigInteger
        val divisor: BigInteger
        val passIndex: Int
        val failIndex: Int
        var totalCount: BigInteger

        constructor(items: MutableList<BigInteger>, multiply: Boolean, operand: BigInteger, divisor: BigInteger, square: Boolean, passIndex: Int,
                    failIndex: Int) {
            this.items = items
            this.multiply = multiply
            this.operand = operand
            this.divisor = divisor
            this.passIndex = passIndex
            this.failIndex = failIndex
            this.square = square
            this.totalCount = BigInteger.ZERO
        }

        fun addItem(value: BigInteger){
            items.add(value)
        }

        fun getNextValue(): BigInteger? {
            if (items.isEmpty()) {
                return null
            }

            totalCount++
            val value = items[0]
            items.removeAt(0)

            var operationValue = this.operand
            if (square) {
                operationValue = value
            }
            return if (multiply)
                (value * operationValue) / BigInteger.valueOf(3)
            else
                (value + operationValue) / BigInteger.valueOf(3)
        }

        fun getNextValue2(): BigInteger? {
            if (items.isEmpty()) {
                return null
            }

            totalCount++
            val value = items[0]
            items.removeAt(0)

            var operationValue = this.operand
            if (square) {
                operationValue = value
            }
            return if (multiply)
                (value * operationValue)
            else
                (value + operationValue)
        }

        fun divisible(value: BigInteger): Boolean {
            return (value % divisor) == BigInteger.ZERO
        }

    }

    val monkeys: List<Monkey>


    constructor(input: String) {

        val monkeyList = mutableListOf<Monkey>()

        val monkeysInput = input.split("\n\n")
        for (monkeyInput in monkeysInput) {
            val lines = monkeyInput.split("\n")
            val items = lines[1].split(": ")[1].split(", ").stream().map { item -> item.toBigInteger() }.toList().toMutableList()
            val operationString = lines[2].split("new = old ")[1].split(" ")
            val multiply = operationString[0][0] == '*'

            var operand: BigInteger
            var square = false
            if(operationString[1] == "old"){
                operand = BigInteger.ZERO
                square = true
            } else {
                operand = operationString[1].toBigInteger()
            }
            val divisor = lines[3].split("by ")[1].toBigInteger()
            val passIndex = lines[4].split("monkey ")[1].toInt()
            val failIndex = lines[5].split("monkey ")[1].toInt()

            monkeyList.add(Monkey(items, multiply, operand, divisor, square, passIndex, failIndex))
        }

        monkeys = monkeyList

    }

    fun problem1(): BigInteger {
        for (i in 0 until 20) {
            round()
        }

        var highest = BigInteger.ZERO
        var nextHighest = BigInteger.ZERO

        monkeys.forEach {
            if( it.totalCount > highest ) {
                nextHighest = highest
                highest = it.totalCount
            } else if (it.totalCount > nextHighest) {
                nextHighest = it.totalCount
            }
        }


        return highest * nextHighest
    }

    fun round() {

        for (monkey in monkeys) {

            var nextValue = monkey.getNextValue()
            while (nextValue != null) {
                var nextMonkeyIndex = monkey.failIndex
                if (monkey.divisible(nextValue)) {
                    nextMonkeyIndex = monkey.passIndex
                }
                monkeys[nextMonkeyIndex].addItem(nextValue)


                nextValue = monkey.getNextValue()
            }

        }
    }


    fun problem2(): BigInteger {
        var superModulo = BigInteger.ONE
        monkeys.forEach {
            superModulo *= it.divisor
        }
        for (i in 0 until 10000) {
            round2(superModulo)
        }

        var highest =BigInteger.ZERO
        var nextHighest =BigInteger.ZERO

        monkeys.forEach {
            if( it.totalCount > highest ) {
                nextHighest = highest
                highest = it.totalCount
            } else if (it.totalCount > nextHighest) {
                nextHighest = it.totalCount
            }
        }


        return highest * nextHighest
    }

    fun round2(superModulo: BigInteger) {

        for (monkey in monkeys) {
            var nextValue = monkey.getNextValue2()
            while (nextValue != null) {
                var nextMonkeyIndex = monkey.failIndex
                if (monkey.divisible(nextValue)) {
                    nextMonkeyIndex = monkey.passIndex
                }
                monkeys[nextMonkeyIndex].addItem(nextValue % superModulo)


                nextValue = monkey.getNextValue2()
            }

        }
    }




}

