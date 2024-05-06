package backtracking

import java.util.LinkedList


// 78. 子集
// https://leetcode.cn/problems/subsets/

fun main() {
    println(subsets(intArrayOf(1,2,3)))
}

fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtracking(nums, 0, LinkedList(), result)
    return result
}

private fun backtracking(nums: IntArray, startIndex: Int, cache: LinkedList<Int>, result: MutableList<List<Int>>) {
    result.add(ArrayList(cache))
    if (startIndex >= nums.size) {
        return
    }
    for (i in startIndex until nums.size) {
        cache.add(nums[i])
        backtracking(nums, i + 1, cache, result)
        cache.removeLast()
    }
}