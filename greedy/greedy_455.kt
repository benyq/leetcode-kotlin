package greedy


// 455. 分发饼干
// https://leetcode.cn/problems/assign-cookies/


fun main() {
    println(findContentChildren(intArrayOf(1,2,3), intArrayOf(1,1)))
    println(findContentChildren(intArrayOf(1,2), intArrayOf(1,2,3)))
    println(findContentChildren(intArrayOf(10,9,8,7), intArrayOf(5,6,7,8)))
}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    val newG = g.sortedArrayDescending()
    val newS = s.sortedArrayDescending()

    var result = 0
    var index = 0
    for (i in newG.indices) {
        if (index < s.size && newS[index] >= newG[i]) {
            result++
            index++
        }
    }
    return result
}