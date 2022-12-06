package aoc2022


class Day2 {

    constructor(input: String) {
        val matchesStrings = input.split("\n")
        for (string in matchesStrings) {
            val split = string.split(' ')
            matches.add(Pair(split[0][0], split[1][0]))
        }
    }

    var matches = mutableListOf<Pair<Char, Char>>()

    fun problem1(): Int {
        var runningTotal = 0

        for (match in matches) {
            var won = false
            var tie = false
            when (match.second) {
                'X' -> {
                    runningTotal += 1
                    when (match.first) {
                        'A' -> {
                            tie = true
                        }
                        'B' -> {

                        }
                        'C' -> {
                            won = true
                        }
                    }
                }
                'Y' -> {
                    runningTotal += 2
                    when (match.first) {
                        'A' -> {
                            won = true
                        }
                        'B' -> {
                            tie = true

                        }
                        'C' -> {
                        }
                    }
                }
                'Z' -> {
                    runningTotal += 3
                    when (match.first) {
                        'A' -> {
                        }
                        'B' -> {
                            won = true
                        }
                        'C' -> {
                            tie = true
                        }
                    }
                }
            }
            if (won) {
                runningTotal += 6
            }
            if (tie) {
                runningTotal += 3
            }
        }

        return runningTotal
    }


    fun problem2(): Int {
        var runningTotal = 0

        for (match in matches) {
            var won = false
            var tie = false
            when (match.second) {
                'X' -> {
                    when (match.first) {
                        'A' -> {
                            runningTotal += 3
                        }
                        'B' -> {
                            runningTotal += 1
                        }
                        'C' -> {
                            runningTotal += 2
                        }
                    }
                }
                'Y' -> {
                    tie = true
                    when (match.first) {
                        'A' -> {
                            runningTotal += 1
                        }
                        'B' -> {
                            runningTotal += 2
                        }
                        'C' -> {
                            runningTotal += 3
                        }
                    }
                }
                'Z' -> {
                    won = true
                    when (match.first) {
                        'A' -> {
                            runningTotal += 2
                        }
                        'B' -> {
                            runningTotal += 3
                        }
                        'C' -> {
                            runningTotal += 1
                        }
                    }
                }
            }
            if (won) {
                runningTotal += 6
            }
            if (tie) {
                runningTotal += 3
            }
        }

        return runningTotal
    }


}