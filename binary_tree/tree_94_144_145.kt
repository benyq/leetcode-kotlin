package binary_tree

import TreeNode
import com.sun.source.tree.Tree
import java.util.LinkedList

fun main() {

    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)
    println(preorderTraversal2(root))
}

// 144. 二叉树的前序遍历
//https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
// 中左右
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

private fun preorderTraversal2(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val queue = LinkedList<TreeNode>()
    val list = mutableListOf<Int>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
        list.add(node.`val`)
    }
    return list
}


// 94. 二叉树的中序遍历
// https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
// 左中右
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

private fun inorderTraversal2(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val queue = LinkedList<TreeNode>()
    val list = mutableListOf<Int>()
    var cur: TreeNode? = root
    while (cur != null || queue.isNotEmpty()) {
        while (cur != null) {
            queue.add(cur)
            cur = cur.left
        }
        cur = queue.removeLast()
        list.add(cur.`val`) // 中节点
        cur = cur.right  // 因为这个时候cur即是整个二叉树最左侧的节点，同时它本身也是父节点，所以要移动到它的右子树
    }

    return list
}

// 145 . 二叉树的后序遍历
// https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
// 左右中
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

private fun postorderTraversal2(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val queue = LinkedList<TreeNode>()
    val list = mutableListOf<Int>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        node.right?.let { queue.add(it) }
        node.left?.let { queue.add(it) }
        list.add(node.`val`)
    }
    return list.reversed()
}