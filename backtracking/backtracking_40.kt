package backtracking

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


// 40. 组合总和 II
// https://leetcode.cn/problems/combination-sum-ii/

fun main() {
    println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
}

private val result = mutableListOf<List<Int>>()
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    backtracking(candidates.sortedArray(), target, 0, 0, LinkedList(), BooleanArray(candidates.size))
    return result
}

private fun backtracking(
    candidates: IntArray,
    target: Int,
    startIndex: Int,
    sum: Int,
    cache: LinkedList<Int>,
    used: BooleanArray
) {
    if (sum >= target) {
        if (sum == target) {
            result.add(ArrayList(cache))
        }
        return
    }
    for (i in startIndex until candidates.size) {
        // 进入某一层时，startIndex是一定会被第一个选中的。因为这一层中出现的其他相同数字都不能使用，又因为是数组有序的，那么只要和前一个比较就行
        if (i > startIndex && candidates[i] == candidates[i - 1]) continue
        val v = candidates[i]
        cache.add(v)
        used[i] = true
        val newSum = sum + v
        backtracking(candidates, target, i + 1, newSum, cache, used)
        used[i] = false
        cache.removeLast()
    }
}


