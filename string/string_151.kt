package string

// 151.翻转字符串里的单词
// https://leetcode.cn/problems/reverse-words-in-a-string/description/

fun main() {
    println(reverseWords("  hello world  "))
    println(reverseWords("a good   example"))
}

// 自己实现
private fun reverseWords1(s: String): String {
    s.reversed()
    val ss = mutableListOf<String>()
    val array = s.toCharArray()
    var left = 0
    while (left < array.size && array[left] == ' ') left++
    var right = left
    while (right < array.size) {
        right++
        if (right == array.size || array[right] == ' ') {
            ss.add(0, array.slice(left until right).joinToString(""))
            // 跳过 space
            while (right < array.size && array[right] == ' ') right++
            left = right
        }
    }
    return ss.joinToString(" ")
}

// carl 思路
// 空间复杂度 O(1)
private fun reverseWords(s: String): String {

    fun swap(a: CharArray, left: Int, right: Int) {
        var start = left
        var end = right
        var temp : Char
        while (start < end) {
            temp = a[start]
            a[start] = a[end]
            a[end] = temp
            start++
            end--
        }
    }
    val array = s.toCharArray().reversedArray()
    var index = 0
    var i = 0
    while (i < array.size) {
        if (array[i] == ' ') {
            i++
            continue
        }
        val start = i
        while (i < array.size && array[i] != ' ') i++
        // swap
        swap(array, start, i - 1)
        for (j in start until i) {
            array[index++] = array[j]
            if (j == i - 1) {
                if (i < array.size) {
                    array[index++] = ' '
                }
            }
        }
    }

    return array.slice(0 until if (array[index - 1] == ' ') index - 1 else index).joinToString("")
}