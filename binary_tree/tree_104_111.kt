package binary_tree

import TreeNode
import arrayToBinaryTree
import kotlin.math.max


fun main() {
    println(maxDepth(arrayToBinaryTree(arrayOf(3,9,20,null,null,15,7))))
    println(maxDepth(arrayToBinaryTree(arrayOf(1,null,2))))

    println(minDepth(arrayToBinaryTree(arrayOf(1,null,2))))
    println(minDepth(arrayToBinaryTree(arrayOf(2,null,3,null,4,null,5,null,6))))
}


// 104. 二叉树的最大深度
// https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/

private fun maxDepth(root: TreeNode?): Int {
    fun getDepth(node: TreeNode?): Int {
        if (node == null) return 0
        return 1 + maxOf(getDepth(node.left), getDepth(node.right))
    }
    return getDepth(root)
}


// 111. 二叉树的最小深度
// https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
// 重点: 最小深度是从根节点到最近叶子节点的最短路径上的节点数量 ！！！！
private fun minDepth(root: TreeNode?): Int {
    fun getDepth(node: TreeNode?): Int {
        if (node == null) return 0
        val left = getDepth(node.left)
        val right = getDepth(node.right)
        // 处理 无左节点或右节点的情况
        if (node.left == null && node.right != null) {
            return 1 + right
        }else if (node.left != null && node.right == null) {
            return 1 + left
        }
        return 1 + minOf(getDepth(node.left), getDepth(node.right))
    }
    return getDepth(root)
}