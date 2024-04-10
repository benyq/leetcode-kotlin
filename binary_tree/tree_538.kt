package binary_tree

import TreeNode
import kotlin.math.min


// 538. 把二叉搜索树转换为累加树
// https://leetcode.cn/problems/convert-bst-to-greater-tree/description/
// 二叉搜索树 中序遍历 是 递增数组，又忘了！！！
// 并且 反向，即 右中左

class Solution_538 {

    private var pre: Int = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        pre = 0
        handle(root)
        return root
    }

    private fun handle(node: TreeNode?) {
        node ?: return
        handle(node.right)
        node.`val` += pre
        pre = node.`val`
        handle(node.left)
    }
}