package binary_tree

import TreeNode


// 98. 验证二叉搜索树
// https://leetcode.cn/problems/validate-binary-search-tree/description/
// 左子树所有节点小于中间节点，右子树所有节点大于中间节点 ！！！

fun main() {

}

private fun isValidBST(root: TreeNode?): Boolean {
    return isValidBST(root, null, null)
}

// 给出边界
private fun isValidBST(root: TreeNode?, min: TreeNode?, max: TreeNode?): Boolean {
    if (root == null) return true
    if (min != null && root.`val` <= min.`val`) return false
    if (max != null && root.`val` >= max.`val`) return false
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max)
}

