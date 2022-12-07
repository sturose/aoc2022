package aoc2022

import java.math.BigInteger


class Day7 {
    abstract class Socket(parent: Directory?, name: String) {
        private val parent = parent
        private val name = name
        abstract fun getSize(): BigInteger

        fun getParent(): Directory {
            return parent!!
        }

        fun getName(): String {
            return name
        }

    }

    class Directory(parent: Directory?, name: String) : Socket(parent, name) {
        private var list: MutableList<Socket> = mutableListOf()
        private var directoryMap: MutableMap<String, Directory> = mutableMapOf()


        override fun getSize(): BigInteger {
            var runningTotal: BigInteger = BigInteger.ZERO
            for (entry in list) {
                runningTotal += entry.getSize()
            }
            return runningTotal
        }

        fun add(socket: Socket) {
            list.add(socket)
            if (socket is Directory) {
                directoryMap[socket.getName()] = socket

            }
        }

        fun get(directory: String): Directory? {
            return directoryMap[directory]
        }

        fun listDirectories(): MutableCollection<Directory> {
            return directoryMap.values
        }

    }

    class File(size: BigInteger, name: String, parent: Directory) : Socket(parent, name) {
        private val size = size

        override fun getSize(): BigInteger {
            return size
        }

    }


    var root = Directory(null, "/")

    constructor(input: String) {
        var currentDirectory: Directory? = null

        val commands = input.split("\n")

        for (command in commands) {
            if (command == "$ cd /") {
                currentDirectory = root
            } else if (command == "$ cd ..") {
                currentDirectory = currentDirectory?.getParent()
            } else if (command.startsWith("$ cd ")) {

                currentDirectory = currentDirectory?.get(command.substring(5))
            } else if (command == "$ ls") {

            } else {
                val split = command.split(' ')
                val name = split[1]
                if (split[0] == "dir") {
                    currentDirectory!!.add(Directory(currentDirectory, name))
                } else {
                    val size = split[0].toBigInteger()
                    currentDirectory!!.add(File(size, name, currentDirectory!!))
                }
            }
        }
    }

    fun problem1(threshold: BigInteger): BigInteger {
        return recursiveSearch(root, threshold)
    }

    private fun recursiveSearch(currentDirectory: Directory, threshold: BigInteger): BigInteger {
        var runningTotal = BigInteger.ZERO

        for (directory in currentDirectory.listDirectories()) {
            if (directory.getSize() < threshold) {
                runningTotal += directory.getSize()
            }
            if (directory.listDirectories().isNotEmpty()) {
                runningTotal += recursiveSearch(directory, threshold)
            }
        }

        return runningTotal
    }


    fun problem2(): BigInteger {
        val currentlyFreeSpace = BigInteger.valueOf(70000000) - root.getSize()
        var minimumRequired = BigInteger.valueOf(30000000L) - currentlyFreeSpace

        return recursiveSearch2(root, minimumRequired, root.getSize())
    }

    private fun recursiveSearch2(currentDirectory: Directory, minimum: BigInteger, currentSize: BigInteger): BigInteger {

        var newSize = currentSize
        for (directory in currentDirectory.listDirectories()) {
            if (directory.getSize() < currentSize && directory.getSize() > minimum) {
                newSize = directory.getSize()
            }
            if (directory.listDirectories().isNotEmpty()) {
                newSize = recursiveSearch2(directory, minimum, newSize)
            }
        }

        return newSize
    }


}