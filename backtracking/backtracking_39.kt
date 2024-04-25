package backtracking

import java.util.LinkedList


// 39. 组合总和
// https://leetcode.cn/problems/combination-sum/description/

fun main() {
//    println(combinationSum(intArrayOf(2,3,6,7), 7))
//    println(combinationSum(intArrayOf(2,3,5), 8))
//    println(combinationSum(intArrayOf(2,), 1))
    println(combinationSum(intArrayOf(8, 7, 4, 3), 11))
}

private val result = mutableListOf<List<Int>>()
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    backtracking(candidates, target, 0, 0, LinkedList())
    return result
}

private fun backtracking(candidates: IntArray, target: Int, startIndex: Int, sum: Int, cache: LinkedList<Int>) {
    if (sum >= target) {
        if (sum == target) {
            result.add(ArrayList(cache))
        }
        return
    }
    for (i in startIndex until candidates.size) {
        val v = candidates[i]
        cache.add(v)
        val newSum = sum + v
        backtracking(candidates, target, i, newSum, cache) // 不用i+1了，表示可以重复读取当前的数
        cache.removeLast()
    }
}