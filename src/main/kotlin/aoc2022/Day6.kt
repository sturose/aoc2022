package aoc2022

import java.util.ArrayDeque


class Day6 {


    fun problem1(inputString: String): Int {
        var startingPosition = 4

        while (true){
            if(inputString.substring(startingPosition -4, startingPosition).toCharArray().distinct().size == 4){
                break
            }
            startingPosition++
        }
        return startingPosition
    }


    fun problem2(inputString: String): Int {
        var startingPosition = 14

        while (true){
            if(inputString.substring(startingPosition -14, startingPosition).toCharArray().distinct().size == 14){
                break
            }
            startingPosition++
        }
        return startingPosition
    }



}