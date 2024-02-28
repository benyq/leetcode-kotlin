package array

// 704. 二分查找
// https://leetcode.cn/problems/binary-search/description/
// 二分法，左右边界 [left,right]

fun main() {
    val nums = intArrayOf(3)
    val target = 2
    println(search(nums, target))
}

private fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1
    while (start <= end) {
        val mid = (start + end) / 2
        if (target > nums[mid]) {
            start = mid + 1
        }else if (target < nums[mid]) {
            end = mid - 1
        }else {
            return mid
        }
    }
    return -1
}