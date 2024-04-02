package binary_tree

import TreeNode


// 404. 左叶子之和
// https://leetcode.cn/problems/sum-of-left-leaves/description/

fun main() {

}

private fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    if (root.left == null && root.right == null) return 0
    val leftSum = if (root.left != null && root.left?.left == null && root.left?.right == null) {
        root.left?.`val` ?: 0
    }else {
        sumOfLeftLeaves(root.left)
    }
    val rightSum = sumOfLeftLeaves(root.right)
    return leftSum + rightSum
}