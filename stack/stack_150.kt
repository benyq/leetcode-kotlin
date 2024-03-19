package stack

import java.util.Stack

// 150. 逆波兰表达式求值
// https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/


fun main() {
    println(evalRPN(arrayOf("2","1","+","3","*")))
    println(evalRPN(arrayOf("4","13","5","/","+")))
    println(evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))
}

private fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<String>()
    tokens.forEach {
        when(it) {
            "+" -> {
                val a = stack.pop()
                val b = stack.pop()
                stack.push((b.toInt() + a.toInt()).toString())
            }
            "-" -> {
                val a = stack.pop()
                val b = stack.pop()
                stack.push((b.toInt() - a.toInt()).toString())
            }
            "*" -> {
                val a = stack.pop()
                val b = stack.pop()
                stack.push((b.toInt() * a.toInt()).toString())
            }
            "/" -> {
                val a = stack.pop()
                val b = stack.pop()
                stack.push((b.toInt() / a.toInt()).toString())
            }
            else -> stack.push(it)
        }
    }
    return stack.pop().toInt()
}