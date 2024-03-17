package stack

import java.util.Stack

// 232.用栈实现队列
// https://leetcode.cn/problems/implement-queue-using-stacks/description/

fun main() {

}

// pop 和 peek 可以优化下
// 在push数据的时候，只要数据放进输入栈就好，但在pop的时候，操作就复杂一些，输出栈如果为空，就把进栈数据全部导入进来（注意是全部导入），
// 再从出栈弹出数据，如果输出栈不为空，则直接从出栈弹出数据就可以了。
private class MyQueue() {

    val stack = Stack<Int>()
    val stack2 = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
    }

    fun pop(): Int {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop())
        }
        val res = stack2.pop()
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop())
        }
        return res
    }

    fun peek(): Int {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop())
        }
        val res = stack2.peek()
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop())
        }
        return res
    }

    fun empty() = stack.isEmpty()

}

