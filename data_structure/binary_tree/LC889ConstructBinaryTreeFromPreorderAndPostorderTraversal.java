//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// 👍 421 👎 0


package data_structure.binary_tree;

import java.util.Arrays;

public class LC889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int n = preorder.length;
            if (n == 0) return null;
            if (n == 1) return new TreeNode(preorder[0]);
            // 认为前序遍历第二个节点是左子树的根节点
            int leftSize = 0;
            for (; leftSize < n; ++leftSize) {
                if (postorder[leftSize] == preorder[1]) break;
            }

            // 上面找到的是左子树根节点在后序遍历的下标，长度需要 + 1
            leftSize++;

            int[] pre_left = Arrays.copyOfRange(preorder, 1, leftSize + 1);
            int[] pre_right = Arrays.copyOfRange(preorder, leftSize + 1, n);
            int[] post_left = Arrays.copyOfRange(postorder, 0, leftSize);
            int[] post_right = Arrays.copyOfRange(postorder, leftSize, n - 1);

            TreeNode left = constructFromPrePost(pre_left, post_left);
            TreeNode right = constructFromPrePost(pre_right, post_right);

            return new TreeNode(preorder[0], left, right);
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
