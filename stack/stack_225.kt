package stack

import java.util.LinkedList
import java.util.Queue

// 225. 用队列实现栈
// https://leetcode.cn/problems/implement-stack-using-queues/description/

fun main() {

}

class MyStack() {
    private val queue = ArrayDeque<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        var size = queue.size
        size--
        while (size -- > 0) {
            queue.add(queue.removeFirst())
        }
        return queue.removeFirst()
    }

    fun top(): Int {
        return queue.last()
    }

    fun empty() = queue.isEmpty()

}