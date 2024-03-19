package stack

import java.util.Stack

// 1047. 删除字符串中的所有相邻重复项
// https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/


fun main() {
    println(removeDuplicates("ddd"))
    println(removeDuplicates("abbaca"))
}

private fun removeDuplicates(s: String): String {
    val stack = Stack<Char>()
    s.forEach {
        if (stack.isEmpty()) {
            stack.push(it)
        } else {
            if (stack.peek() == it) {
                stack.pop()
            }else {
                stack.push(it)
            }
        }
    }
    return stack.joinToString("")
}
