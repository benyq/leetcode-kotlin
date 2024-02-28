package array

import kotlin.math.abs


// 977. 有序数组的平方
// https://leetcode.cn/problems/squares-of-a-sorted-array/description/
// 又是双指针

fun main() {
    val nums = intArrayOf(-7,-3,2,3,11, 22)
    println(sortedSquares(nums).contentToString())
}

private fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { 0 }
    var left = 0
    var right = nums.size - 1
    var index = nums.size - 1
    while (left <= right) {
        if (abs(nums[left]) >= abs(nums[right])) {
            result[index--] = nums[left] * nums[left]
            left ++
        }else {
            result[index--] = nums[right] * nums[right]
            right --
        }
    }
    return result
}