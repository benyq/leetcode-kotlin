package binary_tree

import TreeNode
import java.util.LinkedList


// 513. 找树左下角的值
// https://leetcode.cn/problems/find-bottom-left-tree-value/description/

fun main() {


}

private fun findBottomLeftValue(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode>()
    var res = 0
    if (root != null) {
        queue.add(root)
    }
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            if (i == 0) {
                res = node.`val`
            }
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }
    return res

}