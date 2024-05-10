package backtracking

import java.util.LinkedList


// 46. 全排列
// https://leetcode.cn/problems/permutations/description/

fun main() {
    println(permute(intArrayOf(1,2,3)))
    println(permute(intArrayOf(1)))
    println(permute(intArrayOf(0, 1)))
}

fun permute(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtracking(nums, BooleanArray(nums.size) { false }, LinkedList(), res)
    return res
}

private fun backtracking(nums: IntArray, used: BooleanArray, cache: LinkedList<Int>, res: MutableList<List<Int>>) {
    if (cache.size == nums.size) {
        res.add(ArrayList(cache))
        return
    }

    for (i in nums.indices) {
        if (used[i]) continue
        cache.add(nums[i])
        used[i] = true
        backtracking(nums, used, cache, res)
        used[i] = false
        cache.removeLast()
    }
}