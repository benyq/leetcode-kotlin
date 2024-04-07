package binary_tree

import TreeNode


// 700. 二叉搜索树中的搜索
// https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
fun main() {

}

private fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return null
    if (root.`val` == `val`) return root
    return if (root.`val`  > `val`) searchBST(root.left, `val`)
    else searchBST(root.right, `val`)
}