package string

// 28. 实现 strStr()
// https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// KMP 算法，不是很熟

fun main() {
    println(strStrKMP("daxcdsdsd", "ds"))
    println(strStrKMP("sadbutsad", "sad"))
    println(strStrKMP("leetcode", "leeto"))
}

// 普通
private fun strStr(haystack: String, needle: String): Int {
    val max = haystack.length - needle.length
    val first = needle[0]
    var index = 0
    while (index <= max) {
        //find needle first char in haystack
        if (haystack[index] != first) {
            while (++index <= max && first != haystack[index]){}
        }
        if (index <= max) {
            var j = 1
            while (j < needle.length && needle[j] == haystack[index + j]) {
                j++
            }
            if (j == needle.length) {
                return index
            }
        }
        index++
    }
    return -1
}

// kmp
private fun strStrKMP(haystack: String, needle: String): Int {

    fun getNext(needle: String): IntArray {
        val array = IntArray(needle.length)
        array[0] = 0
        var i = 1
        var j = 0
        while(i < needle.length) {
            if (needle[i] == needle[j]) {
                j += 1
                array[i++] = j
            }else {
                if (j == 0) {
                    array[i++] = 0
                }else {
                    j = array[j - 1]
                }
            }
        }
        return array
    }
    val next = getNext(needle)
    var j = 0
    var i = 0
    while (i < haystack.length) {
        if (haystack[i] == needle[j]) {
            i++
            j++
        }else if (j > 0) {
            j = next[j - 1]
        }else {
            i++
        }
        if (j == needle.length) {
            return i - j
        }
    }

    return -1
}