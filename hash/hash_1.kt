package hash

// 1. 两数之和
// https://leetcode.cn/problems/two-sum/description/

fun main() {
    println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    println(twoSum(intArrayOf(3,2,4), 6).contentToString())
    println(twoSum(intArrayOf(3,3), 6).contentToString())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    map[target - nums[0]] = 0
    for (i in 1 until nums.size) {
        val key = nums[i]
        if (map.containsKey(key)) {
            return intArrayOf(map[key]!!, i)
        }else {
            map[target - nums[i]] = i
        }
    }
    return intArrayOf()
}