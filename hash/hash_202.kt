package hash

import kotlin.math.sqrt

// 202. 快乐数
// https://leetcode.cn/problems/happy-number/description/

fun main() {
    println(isHappy(19))
}

private fun isHappy(n: Int): Boolean {

    fun getSum(t: Int): Int {
        var n1 = t
        var s = 0
        while (n1 > 0) {
            val v = n1 % 10
            s += v * v
            n1 /= 10
        }
        return s
    }
    val hash = mutableSetOf<Int>()
    var num = n
    while (true) {
        val s = getSum(num)
        if (s == 1) {
            return true
        }else {
            if (hash.contains(s)) {
                return false
            }else {
                hash.add(s)
            }
        }
        num = s
    }
}