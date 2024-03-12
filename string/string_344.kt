package string

// 344. 反转字符串
// https://leetcode.cn/problems/reverse-string/
fun main() {
    val s = charArrayOf('h', 'e', 'l', 'l', 'o')
    reverseString(s)
    println(s)
}

private fun reverseString(s: CharArray) {
    var left = 0
    var right = s.size - 1
    while (left < right) {
        val temp = s[left]
        s[left] = s[right]
        s[right] = temp
        left++
        right--
    }
}