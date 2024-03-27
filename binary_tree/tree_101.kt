package binary_tree

import TreeNode
import arrayToBinaryTree


// 101. 对称二叉树
// https://leetcode.cn/problems/symmetric-tree/description/

fun main() {
    println(isSymmetric(arrayToBinaryTree(arrayOf(1,2,2,3,4,4,3))))
    println(isSymmetric(arrayToBinaryTree(arrayOf(1,2,2,null,3,null,3))))
}

private fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return false
    return compare(root.left, root.right)
}

private fun compare(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    else if (left?.`val` != right?.`val`) return false
    else return compare(left?.left, right?.right) && compare(left?.right, right?.left)
}