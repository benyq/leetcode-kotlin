package hash

// 349. 两个数组的交集
// https://leetcode.cn/problems/intersection-of-two-arrays/description/

fun main() {
    println(intersection(intArrayOf(1,2,2,1), intArrayOf(2,2)).contentToString())
}

private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = mutableSetOf<Int>()
    val result = mutableSetOf<Int>()
    nums1.forEach {
        set1.add(it)
    }
    nums2.forEach {
        if (set1.contains(it)) {
            result.add(it)
        }
    }
    return result.toIntArray()
}