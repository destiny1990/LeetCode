//337. 打家劫舍 III
public class Solution_337_1 {

    public static void main(String[] args) {
        Object[] nums_tree = {3, 4, 5, 1, 3, null, 1};
        TreeNode root = BinaryTree(nums_tree);
        System.out.println("Max Amount:" + rob_mid(root));
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

    public static int rob_mid(TreeNode root) {
        if (null == root)
            return 0;
        int money = root.val;
        if (root.left != null)
            money += rob_mid(root.left.left) + rob_mid(root.left.right);
        if (root.right != null)
            money += rob_mid(root.right.left) + rob_mid(root.right.right);
        return Math.max(money, rob_mid(root.left) + rob_mid(root.right));
    }
}

