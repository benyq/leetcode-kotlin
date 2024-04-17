package backtracking

import java.util.ArrayList
import java.util.LinkedList


// 77. 组合
// https://leetcode.cn/problems/combinations/description/


fun main() {
    println(combine(4, 2))
}


//dfs三部曲，先确定返回条件
//随后，循环遍历
//回溯
//参数可以根据需要，逐渐添加
//给两个整数，和k，返回范围 [1,n]中所有可能的k个数的组合
//返回参数就是 path == k

fun combine(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtracking(n, k, 1, LinkedList(), result)
    return result
}

private fun backtracking(n: Int, k: Int, startIndex: Int, stack: LinkedList<Int>, result: MutableList<List<Int>>) {
    //终止条件
    if (k == stack.size) {
        result.add(ArrayList(stack))
        return
    }
    for (i in startIndex ..  n) {
        stack.add(i)// 处理节点
        backtracking(n, k, i + 1, stack, result)//递归
        stack.removeLast() //回溯，撤销处理的节点
    }
}
