package backtracking

import java.util.LinkedList


//491. 非递减子序列
// https://leetcode.cn/problems/non-decreasing-subsequences/description/
// 与 90题不同,nums是无序的,所以需要用set去保证同一层中没有重复数字
//


fun main() {
//    println(findSubsequences(intArrayOf(4,6,7,7)))
    println(findSubsequences(intArrayOf(1,2,3,4,5,6,7,8,9,10,1,1,1,1,1)))
    println(findSubsequences2(intArrayOf(1,2,3,4,5,6,7,8,9,10,1,1,1,1,1)))

    println(findSubsequences(intArrayOf(2,3,4,5,6,7,8,9,10,1,1,1,1,1)))
    println(findSubsequences2(intArrayOf(2,3,4,5,6,7,8,9,10,1,1,1,1,1)))
}

fun findSubsequences2(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtracking2(nums, 0, LinkedList(), result)
    return result
}

// 正确答案，虽然我还是不明白测试用例 [1,2,3,4,5,6,7,8,9,10,1,1,1,1,1]结果不包括 [1,1], [1,1,1]
fun findSubsequences(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtracking(nums, 0, LinkedList(), result)
    return result
}

private fun backtracking(nums: IntArray, start: Int, cache: LinkedList<Int>, result: MutableList<List<Int>>) {
    if (cache.size >1) {
        result.add(ArrayList(cache))
    }
    val set = mutableSetOf<Int>()
    for (i in start until nums.size) {
        if ((cache.isNotEmpty() && nums[i] < cache.last) || set.contains(nums[i])) {
            continue
        }
        set.add(nums[i])
        cache.add(nums[i])
        backtracking(nums, i + 1, cache, result)
        cache.removeLast()
    }
}

private fun backtracking2(nums: IntArray, start: Int, cache: LinkedList<Int>, result: MutableList<List<Int>>) {
    if (cache.size >= 2) {
        val last = cache.last()
        if (last >= cache[cache.lastIndex -1]) {
            result.add(ArrayList(cache))
        }else {
            return
        }
    }
    val set = mutableSetOf<Int>()
    for (i in start until nums.size) {
        if (i > start && nums[i] == nums[i - 1]) continue
        set.add(nums[i])
        cache.add(nums[i])
        backtracking2(nums, i + 1, cache, result)
        cache.removeLast()
    }
}