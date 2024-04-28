package backtracking

import java.util.LinkedList


// 93. 复原 IP 地址
// https://leetcode.cn/problems/restore-ip-addresses/description/

fun main() {
    println(Resolution93().restoreIpAddresses("25525511135"))
}

class Resolution93 {
    private val result = mutableListOf<String>()
    private var cache = mutableListOf<Char>()
    fun restoreIpAddresses(s: String): List<String> {
        s.forEach {
            cache.add(it)
        }
        backtracking(s, 0, 0)
        return result
    }

    private fun backtracking(s: String, start: Int, pointNum: Int) {
        if (pointNum == 3) {
            if (isValid(s, start, s.length - 1)) {
                result.add(cache.joinToString(""))
            }
            return
        }
        for (i in start until s.length) {
            if (isValid(s, start, i)) {
                cache.add(pointNum + i + 1, '.')
                backtracking(s, i + 1, pointNum + 1)
                cache.removeAt(pointNum + i + 1)
            }
        }

    }


    private fun isValid(s: String, start: Int, end: Int): Boolean {
        if (start > end) return false
        if (s[start] == '0' && start != end) return false

        var sum = 0
        for (i in start .. end) {
            val code = s[i].code
            if (code < '0'.code || code > '9'.code) {
                return false
            }
            sum = sum * 10 + (code - '0'.code)
            if (sum > 255) return false
        }

        return true
    }
}