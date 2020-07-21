//337. 打家劫舍 III
public class Solution_337_3 {

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
        int[] result = rob_mid(root);
        return Math.max(result[0], result[1]);
    }

    public static int[] rob_mid(TreeNode root) {
        if (null == root)
            return new int[2];
        int[] result = new int[2];
        int[] left = rob_mid(root.left);
        int[] right = rob_mid(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}

