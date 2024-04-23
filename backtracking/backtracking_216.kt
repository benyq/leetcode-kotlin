package backtracking

import java.util.*


// 216. 组合总和 III
// https://leetcode.cn/problems/combination-sum-iii/description/


fun main() {
    println(combinationSum3(3, 7))
    println(combinationSum3(3, 9))
}

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtracking(k, n, 1, result, 0, LinkedList())
    return result
}

private fun backtracking(k: Int, n: Int, startIndex: Int, result: MutableList<List<Int>>, sum: Int, stack: LinkedList<Int>) {
    if (k == stack.size) {
        if (sum == n) {
            result.add(ArrayList(stack))
        }
        return
    }
    for (i in startIndex .. 9) {
        stack.add(i)
        val newSum = sum + i
        if (newSum > n) {
            stack.removeLast()
            return
        }
        backtracking(k, n, i + 1, result, newSum, stack)
        stack.removeLast()
    }
}