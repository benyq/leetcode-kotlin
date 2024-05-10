package backtracking

import java.util.LinkedList


// 47. 全排列 II
// https://leetcode.cn/problems/permutations-ii/description/

fun main() {
    println(permuteUnique(intArrayOf(1,1,2)))
    println(permuteUnique(intArrayOf(1,2,3)))
}

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtracking(nums.sortedArray(), BooleanArray(nums.size) { false }, LinkedList(), res)
    return res
}

private fun backtracking(nums: IntArray, used: BooleanArray, cache: LinkedList<Int>, res: MutableList<List<Int>>) {
    if (cache.size == nums.size) {
        res.add(ArrayList(cache))
        return
    }

    for (i in nums.indices) {
        // 为什么用  !used[i - 1] 判断前一个是否使用： 因为同一个层的前一个元素，向下递归完成之后，会被重置成false
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue
        if (!used[i]) {
            cache.add(nums[i])
            used[i] = true
            backtracking(nums, used, cache, res)
            used[i] = false
            cache.removeLast()
        }
    }
}