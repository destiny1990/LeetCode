import common.TreeNode;

import java.util.HashMap;

//337. 打家劫舍 III
public class Solution_337_2 {

    public static void main(String[] args) {
        Object[] nums_tree = {3, 4, 5, 1, 3, null, 1};
        TreeNode root = BinaryTree(nums_tree);
        System.out.println("Max Amount:" + rob(root));
    }

    //递归建立二叉树
    public static TreeNode BinaryTree(Object[] array) {
        TreeNode root = createBinaryTreeByArray(array, 0);
        return root;
    }

    //递归建立二叉树
    public static TreeNode createBinaryTreeByArray(Object[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            if (array[index] == null)
                return tn;
            int value = Integer.parseInt(String.valueOf(array[index]));
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return rob_mid(root, memo);
    }

    public static int rob_mid(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (null == root)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int money = root.getVal();
        if (root.left != null)
            money += rob_mid(root.left.left, memo) + rob_mid(root.left.right, memo);
        if (root.right != null)
            money += rob_mid(root.right.left, memo) + rob_mid(root.right.right, memo);
        int result = Math.max(money, rob_mid(root.left, memo) + rob_mid(root.right, memo));
        memo.put(root, result);
        return result;
    }
}

