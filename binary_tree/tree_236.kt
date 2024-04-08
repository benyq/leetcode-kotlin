package binary_tree

import TreeNode
import arrayToBinaryTree
import com.sun.source.tree.Tree
import java.util.LinkedList
import java.util.Stack


// 236. 二叉树的最近公共祖先
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/


fun main() {
    val treeNode = arrayToBinaryTree(arrayOf(3,5,1,6,2,0,8,null,null,7,4))
    val res = Solution_236().lowestCommonAncestor(treeNode, treeNode?.left?.left, treeNode?.right?.left?.right)
    println(res)
}
class Solution_236 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (p == null) return null
        if (q == null) return null
        getNodeMap(root)
        val visited = mutableSetOf<Int>()
        var newQ = q
        while (newQ != null) {
            visited.add(newQ.`val`)
            newQ = treeMaps[newQ.`val`]
        }
        var newP = p
        while (newP != null) {
            if (visited.contains(newP.`val`)) {
                return newP
            }
            newP = treeMaps[newP.`val`]
        }

        return null
    }


    val treeMaps = mutableMapOf<Int, TreeNode>()
    fun getNodeMap(root: TreeNode?) {
        if (root == null) return
        root.left?.let { treeMaps[it.`val`] = root }
        root.right?.let { treeMaps[it.`val`] = root }
        getNodeMap(root.left)
        getNodeMap(root.right)
    }

}