package array

import kotlin.math.min

// 209. 长度最小的子数组
// https://leetcode.cn/problems/minimum-size-subarray-sum/
// 滑动窗口, 双指针变种。 关注正整数条件
fun main() {
    println(minSubArrayLen(1, intArrayOf(2,3,1,2,4,3)))
}

private  fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var result = Int.MAX_VALUE
    var sum = 0
    var left = 0
    var subLength: Int
    nums.forEachIndexed { right, value ->
        sum += value
        while (sum >= target) {
            subLength = (right - left + 1)
            result = min(result, subLength)
            sum -= nums[left++]
        }
    }
    return if (result == Int.MAX_VALUE) 0 else result
}

