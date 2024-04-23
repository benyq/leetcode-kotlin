package backtracking

import java.util.ArrayList
import java.util.LinkedList


// 17. 组合
// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/


fun main() {
//    println(letterCombinations("23"))
    println(letterCombinations("").size)
//    println(letterCombinations("2"))
}

private val numberToCharMap = mapOf(
    2 to listOf('a', 'b', 'c'),
    3 to listOf('d', 'e', 'f'),
    4 to listOf('g', 'h', 'i'),
    5 to listOf('j', 'k', 'l'),
    6 to listOf('m', 'n', 'o'),
    7 to listOf('p', 'q', 'r', 's'),
    8 to listOf('t', 'u', 'v'),
    9 to listOf('w', 'x', 'y', 'z'),
)

private val result = mutableListOf<String>()

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()
    backtracking(digits.toCharArray(), 0, LinkedList())
    return result
}

private fun backtracking(chars: CharArray, index: Int, cache: LinkedList<Char>) {
    //终止条件
    if (index == chars.size) {
        result.add(cache.joinToString(""))
        return
    }
    val n = chars[index].code - '0'.code
    val letters = numberToCharMap.getOrDefault(n, emptyList())
    for (element in letters) {
        cache.add(element)// 处理节点
        backtracking(chars, index + 1, cache)
        cache.removeLast() //回溯，撤销处理的节点
    }
}
