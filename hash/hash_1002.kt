package hash


// 1002. 查找共用字符
// https://leetcode.cn/problems/find-common-characters/solutions/2060381/yi-dao-ji-jian-dan-you-by-kind-moore2dy-msoz/
// 字符是可以重复的
// 长度固定，可以使用数组


fun main() {
    val words = arrayOf("bella","label","roller")
    println(commonChars(words).toString())
}

private fun commonChars(words: Array<String>): List<String> {
    if (words.isEmpty()) return emptyList()
    val array = IntArray(26)
    words[0].forEach {
        array[it.code - 'a'.code]++
    }
    for (i in 1 until words.size) {
        val word = words[i]
        val array2 = IntArray(26)
        word.forEach {
            array2[it.code - 'a'.code]++
        }
        for (i in 0 until 26) {
            array[i] = Math.min(array[i], array2[i])
        }
    }
    val result = mutableListOf<String>()
    for (i in 0 until 26) {
        var size = array[i]
        while (size-- > 0) {
            result.add((i + 'a'.code).toChar().toString())
        }
    }
    return result
}