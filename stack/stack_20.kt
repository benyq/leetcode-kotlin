package stack

import java.util.LinkedList

// 20. 有效的括号
// https://leetcode.cn/problems/valid-parentheses/description/

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("(){}}{"))
}

private fun isValid(s: String): Boolean {
    val stack = LinkedList<Char>()

    s.forEach {
        if (it == '[') {
            stack.add(']')
        } else if (it == '{') {
            stack.add('}')
        } else if (it == '(') {
            stack.add(')')
        } else if (stack.isEmpty() || stack.pollLast() != it){
            return false
        }
    }
    return stack.isEmpty()
}