package binary_tree

import TreeNode


// 112. 路径总和
// https://leetcode.cn/problems/path-sum/description/

fun main() {


}

private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) {
        return root.`val` == targetSum
    }
    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
}