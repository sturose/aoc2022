package aoc2022


class Day3 {


    constructor(input: String) {
        rucksacks = input.split("\n")
    }

    var rucksacks = listOf<String>()

    fun problem1(): Int {
        var runningTotal = 0

        for (rucksack in rucksacks) {
            val middleIndex = rucksack.length / 2
            val firstHalf = rucksack.substring(0, middleIndex).toCharArray()
            val secondHalf = rucksack.substring(middleIndex).toCharArray()
            for( char in firstHalf){
                if(secondHalf.contains(char)) {
                    if( char.isUpperCase()){
                        runningTotal += char.code - 'A'.code + 27
                    } else {
                        runningTotal += char.code - 'a'.code + 1
                    }
                    break;
                }
            }
        }
        return runningTotal
    }


    fun problem2(): Int {
        var runningTotal = 0
        val groups = rucksacks.chunked(3)
        for (group in groups) {
            var possibilities = mutableListOf<Char>()
            possibilities.addAll(group.get(0).toCharArray().distinct())
            for (rucksack in group.subList(1, 3)) {
                val rucksackEntries = rucksack.toCharArray().distinct()
                var newPossibilties = mutableListOf<Char>()
                for (possibility in possibilities) {
                    if (rucksackEntries.contains(possibility)) {
                        newPossibilties.add(possibility)
                    }
                }
                possibilities = newPossibilties
            }
            val badge = possibilities.get(0)
            if( badge.isUpperCase()){
                runningTotal += badge.code - 'A'.code + 27
            } else {
                runningTotal += badge.code - 'a'.code + 1
            }

        }

        return runningTotal
    }



}