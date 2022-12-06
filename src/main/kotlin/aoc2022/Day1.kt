package aoc2022

class Day1 {

    fun findHighest(inputString: String): Int {
        var lines = inputString.split("\n")
        var runningTotal = 0
        var highest = 0
        for (line in lines) {
            var numbersString = line.trim()
            if (numbersString.isEmpty()) {
                if (highest < runningTotal) {
                    highest = runningTotal
                }
                runningTotal = 0;
            } else {
                var value = Integer.valueOf(numbersString)
                runningTotal += value
            }
        }
        if (highest < runningTotal) {
            highest = runningTotal
        }

        return highest

    }

    fun findTopThree(inputString: String): Int {
        var lines = inputString.split("\n")
        var runningTotal = 0
        var highest1 = 0
        var highest2 = 0
        var highest3 = 0
        for (line in lines) {
            var numbersString = line.trim()
            if (numbersString.isEmpty()) {
                if (highest1 < runningTotal) {
                    highest3 = highest2
                    highest2 = highest1
                    highest1 = runningTotal
                } else if (highest2 < runningTotal) {
                    highest3 = highest2
                    highest2 = runningTotal
                } else if (highest3 < runningTotal) {
                    highest3 = runningTotal
                }
                runningTotal = 0;
            } else {
                var value = Integer.valueOf(numbersString)
                runningTotal += value
            }
        }
        if (highest1 < runningTotal) {
            highest3 = highest2
            highest2 = highest1
            highest1 = runningTotal
        } else if (highest2 < runningTotal) {
            highest3 = highest2
            highest2 = runningTotal
        } else if (highest3 < runningTotal) {
            highest3 = runningTotal
        }

        return highest1 + highest2 + highest3

    }

}