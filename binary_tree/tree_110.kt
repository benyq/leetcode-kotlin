package binary_tree

import TreeNode


// 110. 平衡二叉树
// https://leetcode.cn/problems/balanced-binary-tree/description/

fun main() {

}

private fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return false
    val left = getHeight(root.left)
    val right = getHeight(root.right)
    return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)
}

private fun getHeight(root: TreeNode?): Int {
    if (root == null) return 0
    val left = getHeight(root.left)
    val right = getHeight(root.right)
    return Math.max(left, right) + 1
}