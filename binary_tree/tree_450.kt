package binary_tree

import TreeNode


// 450. 删除二叉搜索树中的节点
// https://leetcode.cn/problems/delete-node-in-a-bst/description/
// 重点：如果被删除的节点，同时存在左右节点。则需要把左节点移到右节点的最左节点的左节点位置上。
// 这是要继续满足 二叉搜索树 规则


private fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) return root

    if (root.`val` < key) {
        root.right = deleteNode(root.right, key)
    }else if (root.`val` > key) {
        root.left = deleteNode(root.left, key)
    }else {
        if (root.left == null) {
            return root.right
        }
        if (root.right == null) {
            return root.left
        }
        var cur: TreeNode? = root.right
        while (cur?.left != null) {
            cur = cur.left
        }
        cur?.left = root.left
        return root.right
    }
    return root
}