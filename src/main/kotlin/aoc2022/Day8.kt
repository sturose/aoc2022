package aoc2022

import kotlin.streams.toList


class Day8 {

    class Tree(val height: Int, var visible: Boolean) {
        var left = 0
        var right = 0
        var up = 0
        var down = 0

        fun getScore(): Int {
            return left * right * up * down
        }
    }

    val forest: List<List<Tree>>

    constructor(input: String) {

        val rows = input.split("\n")
        var creatingForest = mutableListOf<List<Tree>>()
        for (row in rows) {
            var forestRow = mutableListOf<Tree>()
            for (char in row.toCharArray()) {
                val height = char.toString().toInt()
                forestRow.add(Tree(height, false))
            }
            creatingForest.add(forestRow.toList())
        }
        forest = creatingForest.toList()

        initializeForestEdge()

        // left
        forest.forEach { row ->
            var tallest = row.first().height
            row.forEach { tree ->
                if (tree.height > tallest) {
                    tree.visible = true
                    tallest = tree.height
                }
            }
        }

        // right
        forest.forEach { row ->
            var tallest = row.last().height
            row.reversed().forEach { tree ->
                if (tree.height > tallest) {
                    tree.visible = true
                    tallest = tree.height
                }
            }
        }

        var tallest = forest.first().map(Tree::height).toMutableList()
        forest.forEach { row ->
            row.forEachIndexed { index, tree ->
                if (tree.height > tallest[index]) {
                    tree.visible = true
                    tallest[index] = tree.height
                }
            }
        }

        tallest = forest.last().map(Tree::height).toMutableList()
        forest.reversed().forEach { row ->
            row.forEachIndexed { index, tree ->
                if (tree.height > tallest[index]) {
                    tree.visible = true
                    tallest[index] = tree.height
                }
            }
        }
    }

    // Mark all outside trees as visible
    private fun initializeForestEdge() {
        forest.first().forEach { tree ->
            tree.visible = true
        }

        forest.last().forEach { tree ->
            tree.visible = true
        }

        forest.forEach { row ->
            row.first().visible = true
            row.last().visible = true
        }
    }


    // calculate visibility
    fun problem1(): Int {
        var visibleTrees = 0
        forest.forEach { row ->
            visibleTrees += row.stream().filter(Tree::visible).count().toInt()
        }
        return visibleTrees
    }


    // calculate scenic score
    fun problem2(): Int {

        forest.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { index, tree ->
                addDirectionValues(rowIndex, index, tree)
            }
        }

        var highestScore = 0
        forest.forEach { row ->
            row.forEach { tree ->
                if (tree.getScore() > highestScore) {
                    highestScore = tree.getScore()
                }
            }
        }

        return highestScore
    }

    private fun addDirectionValues(rowIndex: Int, index: Int, currentTree: Tree) {
        addRightValue(rowIndex, index, currentTree)
        addLeftValue(rowIndex, index, currentTree)
        addDownValue(rowIndex, index, currentTree)
        addUpValue(rowIndex, index, currentTree)

    }

    private fun addRightValue(rowIndex: Int, index: Int, currentTree: Tree) {
        val row = forest.get(rowIndex)
        val subList = row.subList(index + 1, row.lastIndex + 1)
        for (tree in subList) {
            currentTree.right++
            if (tree.height >= currentTree.height) {
                break;
            }
        }
    }

    private fun addLeftValue(rowIndex: Int, index: Int, currentTree: Tree) {
        val row = forest.get(rowIndex)
        val subList = row.subList(0, index).reversed()
        for (tree in subList) {
            currentTree.left++
            if (tree.height >= currentTree.height) {
                break;
            }
        }
    }

    private fun addDownValue(rowIndex: Int, index: Int, currentTree: Tree) {
        val column = forest.stream().map { row -> row[index] }.toList()
        val subList = column.subList(rowIndex + 1, column.lastIndex + 1)
        for (tree in subList) {
            currentTree.down++
            if (tree.height >= currentTree.height) {
                break;
            }
        }
    }

    private fun addUpValue(rowIndex: Int, index: Int, currentTree: Tree) {
        val column = forest.stream().map { row -> row[index] }.toList()
        val subList = column.subList( 0, rowIndex).reversed()
        for (tree in subList) {
            currentTree.up++
            if (tree.height >= currentTree.height) {
                break;
            }
        }
    }


}