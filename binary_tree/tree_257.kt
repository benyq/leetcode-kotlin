package binary_tree

import TreeNode
import arrayToBinaryTree
import java.util.LinkedList


// 257. 二叉树的所有路径
// https://leetcode.cn/problems/binary-tree-paths/description/

fun main() {
    println(binaryTreePaths(arrayToBinaryTree(arrayOf(1,2,3,null,5))))
    println(binaryTreePaths(arrayToBinaryTree(arrayOf(1))))
}

private fun binaryTreePaths(root: TreeNode?): List<String> {
    val result = mutableListOf<String>()
    if (root == null) return result
    findPath(root, root.`val`.toString(), result)
    return result
}

private fun findPath(root: TreeNode, path: String, result: MutableList<String>) {
    if (root.left != null) {
        findPath(root.left!!, path + "->" + root.left!!.`val`, result)
    }
    if (root.right != null){
        findPath(root.right!!, path + "->" + root.right!!.`val`, result)
    }
    if (root.left == null && root.right == null) {
        result.add(path)
    }
}