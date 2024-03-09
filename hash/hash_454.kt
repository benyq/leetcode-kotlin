package hash

// 454. 四数相加 II
// https://leetcode.cn/problems/4sum-ii/description/

fun main() {
//    println(fourSumCount(intArrayOf(1,2), intArrayOf(-2,-1), intArrayOf(-1,2), intArrayOf(0,2)))
    println(fourSumCount(intArrayOf(-1,-1), intArrayOf(-1,1), intArrayOf(-1,1), intArrayOf(1,-1)))
}

private fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    nums1.forEach { i ->
        nums2.forEach { j ->
            val s = i + j
            map[s] = map.getOrElse(s) { 0 } + 1
        }
    }
    var count = 0
    nums3.forEach { i ->
        nums4.forEach { j ->
            val s = i + j
            val size = map[0 - s] ?: 0
            count += size
        }
    }
    return count
}