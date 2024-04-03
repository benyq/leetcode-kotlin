package binary_tree

import TreeNode


// 654. 最大二叉树
// https://leetcode.cn/problems/maximum-binary-tree/description/

fun main() {
    println(constructMaximumBinaryTree(intArrayOf(3,2,1,6,0,5)))
}


// 可以优化下，每次递归传入数组的 开始结束index，从而避免创建新数组
private fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {

    if (nums.isEmpty()) return null
    if (nums.size == 1) return TreeNode(nums[0])

    var maxIndex = 0
    var max = Int.MIN_VALUE
    for (i in nums.indices) {
        if (nums[i] > max) {
            max = nums[i]
            maxIndex = i
        }
    }
    val root = TreeNode(max)
    if (maxIndex > 0) {
        root.left = constructMaximumBinaryTree(nums.sliceArray(0 until maxIndex))
    }
    if (maxIndex < nums.size - 1) {
        root.right = constructMaximumBinaryTree(nums.sliceArray(maxIndex + 1 until nums.size))
    }
    return root

}