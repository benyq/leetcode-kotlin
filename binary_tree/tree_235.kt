package binary_tree

import TreeNode


// 235. 二叉搜索树的最近公共祖先
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/


// 最近公共祖先，一定是从root节点往下，第一个在p、q之间的节点（A节点）。因为如果继续走到左节点，q或者p就会比A节点大，不满足二叉搜索树的规则；走到右节点同理
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) return null
    var result: TreeNode = root
    while (true) {
        if (result.`val` > p.`val` && result.`val` > q.`val`) {
            result = result.left!!
        }
        else if (result.`val` < p.`val` && result.`val` < q.`val`) {
            result = result.right!!
        }
        else break
    }
    return result
}