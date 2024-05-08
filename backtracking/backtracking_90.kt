package backtracking

import java.util.LinkedList


// 90. 子集 II
// https://leetcode.cn/problems/subsets-ii/description/


fun main() {
    println(subsetsWithDup(intArrayOf(1,2,2)))
}

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val result = ArrayList<LinkedList<Int>>()
    backtracking(nums.sortedArray(), LinkedList(),result, 0)
    return result
}
//
private fun backtracking(nums: IntArray, cache: LinkedList<Int>, result: ArrayList<LinkedList<Int>>, startIndex: Int) {
    result.add(LinkedList(cache))
    for (i in startIndex until nums.size) {
        if (i > startIndex  && nums[i] == nums[i - 1]) {
            continue
        }
        cache.addLast(nums[i])
        backtracking(nums, cache, result, i + 1)
        cache.removeLast()
    }
}

