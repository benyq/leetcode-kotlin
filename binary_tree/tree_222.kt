package binary_tree

import TreeNode
import java.util.LinkedList

// 222. 完全二叉树的节点个数
// https://leetcode.cn/problems/count-complete-tree-nodes/description/

fun main() {

}

// 递归
private fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0
    val left = countNodes(root.left)
    val right = countNodes(root.right)
    return left + right + 1
}

// 层序遍历
private fun countNodes2(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode>()
    var result = 0

    if (root != null) {
        queue.add(root)
    }
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.peekFirst()
            result++
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
            queue.removeFirst()
        }
    }

    return result
}