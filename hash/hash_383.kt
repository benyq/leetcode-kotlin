package hash

// https://leetcode.cn/problems/ransom-note/description/

fun main() {
    println(canConstruct("a", "b"))
    println(canConstruct("aa", "ab"))
    println(canConstruct("aa", "aab"))
}

private fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val array = IntArray(26)
    magazine.forEach {
        array[it.code - 'a'.code]++
    }
    ransomNote.forEach {
        array[it.code - 'a'.code]--
    }
    return array.all { it >= 0 }
}
