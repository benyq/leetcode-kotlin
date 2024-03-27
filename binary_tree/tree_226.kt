package binary_tree

import TreeNode


// 226. 翻转二叉树
// https://leetcode.cn/problems/invert-binary-tree/description/

fun main() {

}

private fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val left = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(left)
    return root
}