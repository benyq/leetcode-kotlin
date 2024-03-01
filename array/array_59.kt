package array

import kotlin.math.sqrt

// 59. 螺旋矩阵 II
// https://leetcode.cn/problems/spiral-matrix-ii/
// 外面一圈一圈地填入数字

fun main() {
    generateMatrix2(5).forEach {
        println(it.contentToString())
    }
}


private fun generateMatrix(n: Int): Array<IntArray> {
    val result = Array(n) { IntArray(n) }
    var loop = n / 2
    val mid = n / 2
    var startX = 0
    var startY = 0
    var count = 1
    var value = 1
    while (loop-- > 0) {
        val i = startX
        val j = startY
        var offsetX = 0
        var offsetY = 0
        //总左到右
        for (v in i until  n - count) {
            result[i][v] = value++
            offsetX++
        }
        //从上到下
        for (v in j  until n - count) {
            result[v][j + offsetX] = value++
            offsetY++
        }
        //从右到左
        for (v in n - count downTo  i + 1) {
            result[i + offsetX][v] = value++
        }
        //从下到上
        for (v in n - count downTo j + 1) {
            result[v][j] = value++
        }
        startX++
        startY++
        count++
    }
    if (n % 2 != 0) {
        result[mid][mid] = n * n
    }
    return result
}


private fun generateMatrix2(n: Int): Array<IntArray> {
    val result = Array(n) { IntArray(n) }
    var loop = n / 2
    val mid = n / 2
    var cur = 1
    var i = 0
    var j = 0
    for (l in 1 .. loop) {
        while (j < n - l) {
            result[i][j++] = cur++
        }
        while (i < n - l) {
            result[i++][j] = cur++
        }
        while (j >= l) {
            result[i][j--] = cur++
        }
        while (i >= l) {
            result[i--][j] = cur++
        }
        i = l
        j = l
    }
    if (n % 2 != 0) {
        result[mid][mid] = n * n
    }
    return result
}

