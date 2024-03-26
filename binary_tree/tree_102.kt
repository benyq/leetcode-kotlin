package binary_tree

import TreeNode
import arrayToBinaryTree
import java.util.*

// 102. 二叉树的层序遍历
// https://leetcode.cn/problems/binary-tree-level-order-traversal/description/

fun main() {
    println(levelOrder(arrayToBinaryTree(arrayOf(3,9,20,null,null,15,7))))
}

private fun levelOrder(root: TreeNode?): List<List<Int>> {

    val queue = LinkedList<TreeNode>()
    val result = mutableListOf<List<Int>>()
    if (root != null) {
        queue.add(root)
    }
    while (queue.isNotEmpty()) {
        val size = queue.size
        val data = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = queue.removeFirst()
            data.add(node.`val`)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        result.add(data)
    }

    return result
}