package hash


// 242. 有效的字母异位词
// https://leetcode.cn/problems/valid-anagram/
// 利用asii码
// 长度固定，可以使用数组

fun main() {
    println(isAnagram("dddd", "cccv"))
}

private fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val array = IntArray(26)
    for (i in s.indices) {
        array[s[i].code - 'a'.code]++
        array[t[i].code - 'a'.code]--
    }
    return array.all { it == 0 }
}
