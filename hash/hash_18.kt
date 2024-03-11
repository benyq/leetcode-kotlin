package hash

// 4. 两数之和
// https://leetcode.cn/problems/4sum/description/
// 与 三数之和一样

fun main() {
    println(fourSum(intArrayOf(1,0,-1,0,-2,2), 0))
    println(fourSum(intArrayOf(2,2,2,2,2), 8))
}

private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()
    for (i in nums.indices) {
        if (nums[i] > target && nums[i] >= 0) break
        if (i > 0 && nums[i] == nums[i - 1]) continue
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) break
            if (j > i + 1 && nums[j] == nums[j - 1]) continue
            var left = j + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[j] + nums[left] + nums[right]
                if (sum > target) {
                    right--
                }else if (sum < target) {
                    left++
                }else {
                    result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                    //去重 b, c
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--
                    left++
                    right--
                }
            }
        }
    }
    return result
}