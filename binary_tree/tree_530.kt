package binary_tree

import TreeNode
import kotlin.math.abs
import kotlin.math.min


// 530. 二叉搜索树的最小绝对差
// https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
// 中序遍历，就是一个有序数组

class Solution530 {
    private var minVal = Int.MAX_VALUE
    private var pre: TreeNode? = null

    // 中序遍历， 同时计算最小值
    fun traversal(root: TreeNode?) {
        if (root == null) return
        traversal(root.left)
        if (pre != null) {
            minVal = min(minVal, root.`val` - pre!!.`val`)
        }
        pre = root
        traversal(root.right)
    }

    fun getMinimumDifference(root: TreeNode?): Int {
        traversal(root)
        return minVal
    }
}