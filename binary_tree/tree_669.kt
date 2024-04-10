package binary_tree

import TreeNode


// 669. 修剪二叉搜索树
// https://leetcode.cn/problems/trim-a-binary-search-tree/description/

private fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
    if (root == null) return root

    if (root.`val` > high) {
        return trimBST(root.left, low, high)
    }else if (root.`val` <  low) {
        return trimBST(root.right, low, high)
    }
    root.left = trimBST(root.left, low, high)
    root.right = trimBST(root.right, low, high)
    return root
}