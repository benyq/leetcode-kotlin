package hash

// 5. 三数之和
// https://leetcode.cn/problems/3sum/description/
// 双指针

fun main() {
    println(threeSum(intArrayOf(-1,0,1,-2,1,-4)))
    println(threeSum(intArrayOf(0,1,1)))
    println(threeSum(intArrayOf(0,0,0)))
}

private fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val sortedNums = nums.sorted()
    for (i in sortedNums.indices) {
        if (sortedNums[i] > 0) return result
        //去重 a
        if (i > 0 && sortedNums[i] == sortedNums[i - 1]) continue
        var left = i + 1
        var right = sortedNums.size - 1
        while (left < right) {
            val sum = sortedNums[i] + sortedNums[left] + sortedNums[right]
            if (sum == 0) {
                result.add(listOf(sortedNums[i], sortedNums[left], sortedNums[right]))
                //去重 b, c
                while (left < right && sortedNums[left] == sortedNums[left + 1]) left++
                while (left < right && sortedNums[right] == sortedNums[right - 1]) right--
                left++
                right--
            }else if (sum < 0) {
                left++
            }else {
                right--
            }
        }
    }
    return result
}