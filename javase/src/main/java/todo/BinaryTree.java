package todo;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历二叉树
 */
public class BinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 前序遍历，根-左-右
     */
    public List<Integer> pre(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        res.addAll(pre(root.left));
        res.addAll(pre(root.right));
        return res;
    }
    // 中序遍历，左-根-右
    // 后序遍历，左-右-根
}
