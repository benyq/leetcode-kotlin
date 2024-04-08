package binary_tree

import TreeNode
import com.sun.source.tree.Tree
import java.util.Collections
import java.util.TreeMap
import kotlin.math.max


// 501. 二叉搜索树中的众数
// https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/
// 二叉搜索树 中序遍历是有序数组

class Solution_501 {

    val result = mutableListOf<Int>()
    var maxCount = 0
    var count = 0
    var pre: TreeNode? = null

    fun findMode(root: TreeNode?): IntArray {
        searchBST(root)
        return result.toIntArray()
    }

    fun searchBST(root: TreeNode?) {
        if (root == null) return
        searchBST(root.left)

        // 单层递归处理
        if (pre?.`val` == root.`val`) {
            count++
        }else {
            count = 1
        }
        if (count == maxCount) {
            result.add(root.`val`)
        }
        pre = root
        if (count > maxCount) {
            maxCount = count
            result.clear()
            result.add(root.`val`)
        }

        searchBST(root.right)
    }

}