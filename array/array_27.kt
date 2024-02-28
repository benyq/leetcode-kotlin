package array

// 27. 移除元素
// https://leetcode.cn/problems/remove-element/description/
// 双指针，数组和链表常用方法

fun main() {
    val nums = intArrayOf(2)
    val value = 2
    println(removeElement(nums, value))
    println(nums.contentToString())
}

private fun removeElement(nums: IntArray, value: Int): Int {
    var index = -1
    for (i in nums.indices) {
        if (nums[i] != value) {
            nums[++index] = nums[i]
        }
    }
    return index + 1
}