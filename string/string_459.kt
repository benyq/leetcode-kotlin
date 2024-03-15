package string

// 459.重复的子字符串
// https://leetcode.cn/problems/repeated-substring-pattern/description/

fun main() {
    println(repeatedSubstringPattern("bb"))
    println(repeatedSubstringPattern("abab"))
    println(repeatedSubstringPattern("aba"))
    println(repeatedSubstringPattern("abcabcabcabc"))
}

// 字符串重复，去除头尾，依然能找到 s
private fun repeatedSubstringPattern1(s: String): Boolean {
    val content = (s + s).slice(1 until  2 * (s.length) - 1)
    return content.indexOf(s) != -1
}


/**
result string length == x
abcabcabcabc  string s
   abcabcabcabc  string t == " " * x + s
while(i in x until s.length) {
    if (s[i] == s[i - x]) { // 如果全部相等，说明存在
        continue
    }
}


**/
private fun repeatedSubstringPattern(s: String): Boolean {
    for (i in 1 .. s.length / 2) {
        if (s.length % i != 0) return false
        var match = true
        for (j in i until s.length) {
            if (s[j] != s[j - i]) {
                match = false
                break
            }
        }
        if (match) return true
    }
    return false
}