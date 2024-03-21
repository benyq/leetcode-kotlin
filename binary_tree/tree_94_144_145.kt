package binary_tree

import TreeNode

fun main() {
}

// 144. 二叉树的前序遍历
//https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
private fun preorderTraversal(root: TreeNode?): List<Int> {
    fun traversal(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return
        list.add(node.`val`)
        traversal(node.left, list)
        traversal(node.right, list)
    }
    val list = mutableListOf<Int>()
    traversal(root, list)
    return list
}


// 94. 二叉树的中序遍历
// https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
private fun inorderTraversal(root: TreeNode?): List<Int> {
    fun traversal(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return
        traversal(node.left, list)
        list.add(node.`val`)
        traversal(node.right, list)
    }
    val list = mutableListOf<Int>()
    traversal(root, list)
    return list
}

// 145 . 二叉树的后序遍历
// https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
private fun postorderTraversal(root: TreeNode?): List<Int> {
    fun traversal(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return
        traversal(node.left, list)
        traversal(node.right, list)
        list.add(node.`val`)
    }
    val list = mutableListOf<Int>()
    traversal(root, list)
    return list
}