package binary_tree

import TreeNode


// 701. 二叉搜索树中的插入操作
// https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/


fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return TreeNode(`val`)
    inset(root, `val`)
    return root
}

private fun inset(root: TreeNode?, `val`: Int) {
    if (root == null) return
    if (root.`val` <= `val`) {
        if (root.right == null) {
            root.right = TreeNode(`val`)
        }else {
            inset(root.right, `val`)
        }
    }else {
        if (root.left == null) {
            root.left = TreeNode(`val`)
        }else {
            inset(root.left, `val`)
        }
    }
}