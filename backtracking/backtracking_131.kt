package backtracking

import java.nio.file.Path


// 131. 分割回文串
// https://leetcode.cn/problems/palindrome-partitioning/description/

fun main() {
    println(partition("aab"))
    println(partition("a"))
}


fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    backtracking(s, 0, mutableListOf(), result)
    return result
}

private fun backtracking(s: String, start: Int, path: MutableList<String>,result: MutableList<List<String>>)  {
    if (start >= s.length) {
        result.add(ArrayList(path))
        return
    }

    for (i in start until s.length) {
        if (isPalindrome(s, start, i)) {
            path.add(s.substring(start, i + 1))
        }else {
            continue
        }
        backtracking(s, i + 1, path, result)
        path.removeLast()
    }

}

private fun isPalindrome(str: String, start: Int, end: Int): Boolean {
    var left = start
    var right = end
    while (left <= right) {
        if (str[left++] != str[right--]) return false
    }
    return true
}