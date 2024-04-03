package binary_tree

import TreeNode

// 617. 合并二叉树
// https://leetcode.cn/problems/merge-two-binary-trees/description/

fun main() {

}

private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null && root2 == null) return null
    val root = root1 ?: root2
    root?.`val` = (root1?.`val` ?: 0) + (root2?.`val` ?: 0)
    root?.left = mergeTrees(root1?.left, root2?.left)
    root?.right = mergeTrees(root1?.right, root2?.right)
    return root
}