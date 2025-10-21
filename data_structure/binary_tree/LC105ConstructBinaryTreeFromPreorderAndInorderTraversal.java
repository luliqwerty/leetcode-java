//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// 👍 2615 👎 0

  
package data_structure.binary_tree;

import java.util.Arrays;

public class LC105ConstructBinaryTreeFromPreorderAndInorderTraversal {

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 两个序列长度相同，如果遍历序列长度为 0，那么到了空节点
        int n = preorder.length;
        if (n == 0) {
            return null;
        }

        // 左子树大小
        int leftSize = indexOf(inorder, preorder[0]);
        // 左子树前序遍历序列
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        // 右子树前序遍历序列
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        // 左子树中序遍历序列
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        // 右子树中序遍历序列
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);

        // 使用左子树前序遍历和中序遍历递归构建二叉树
        TreeNode left = buildTree(pre1, in1);
        // 使用右子树后序遍历和中序遍历递归构建二叉树
        TreeNode right = buildTree(pre2, in2);
        // 返回左子树和右子树
        return new TreeNode(preorder[0], left, right);
    }

    private int indexOf(int[] nums, int x) {
        for (int i = 0; ; ++i) {
            if (x == nums[i]) return i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
