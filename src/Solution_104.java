public class Solution_104 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int depth = 0;

    public int maxDepth(TreeNode root) {
        if (null == root)
            return 0;
        else if (root.left == null && root.right == null) {
            return 1;
        } else
            depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
    }
}
