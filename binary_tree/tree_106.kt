package binary_tree

import TreeNode


// 106. 从中序与后序遍历序列构造二叉树
// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
// 利用前序，中序，后序构造二叉树时，必须要有中序

fun main() {
    println(buildTree(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3)))
}

private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (inorder.isEmpty() || postorder.isEmpty()) return null
    if (inorder.size == 1) return TreeNode(inorder[0])

    val rootVal = postorder.last()
    val root = TreeNode(rootVal)
    var inIndex = -1
    for (i in inorder.indices) {
        if (inorder[i] == rootVal) {
            inIndex = i
            break
        }
    }
    val leftInOrder = inorder.sliceArray(0 until inIndex)
    val rightInOrder = inorder.sliceArray(inIndex + 1 until inorder.size)
    val leftPostOrder = postorder.sliceArray(0 until leftInOrder.size)
    val rightPostOrder = postorder.sliceArray(leftInOrder.size until postorder.size - 1)
    root.left = buildTree(leftInOrder, leftPostOrder)
    root.right = buildTree(rightInOrder, rightPostOrder)
    return root
}