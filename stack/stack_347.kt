package stack

import java.util.Collections

// 347. 前 K 个高频元素
// https://leetcode.cn/problems/top-k-frequent-elements/description/

fun main() {
    println(topKFrequent(intArrayOf(1,1,1,2,2,3), 2).contentToString())
    println(topKFrequent(intArrayOf(1), 1).contentToString())
}

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    return map.toList().sortedByDescending { it.second }.slice(0 until k).map { it.first }.toIntArray()
}