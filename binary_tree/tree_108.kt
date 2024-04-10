package binary_tree

import TreeNode


// 108. 将有序数组转换为二叉搜索树
// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return handle(nums, 0, nums.size - 1)
}

private fun handle(nums: IntArray, start: Int, end: Int): TreeNode? {
    if (start > end) return null
    val mid = start + ((end - start) / 2)
    val rootNode = TreeNode(nums[mid])
    rootNode.left = handle(nums, start, mid - 1)
    rootNode.right = handle(nums, mid + 1, end)
    return rootNode
}