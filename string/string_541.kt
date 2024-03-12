package string

import kotlin.math.min


// 541. 反转字符串II
// https://leetcode.cn/problems/reverse-string-ii/description/


fun main() {
    println(reverseStr("abcdefg", 2))
}

private fun reverseStr(s: String, k: Int): String {
    val array = s.toCharArray()
    for (i in array.indices step 2 * k) {
        var left = i
        var right = min(i + k - 1, array.size - 1)
        while (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }
    return array.joinToString("")
}