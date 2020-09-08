import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(5);
        A.left = B;
        A.right = C;
        B.right = D;
        //System.out.println(binaryTreePaths(A));
        System.out.println(Integer.toString(-100).length());
    }

    static List<String> res = new ArrayList<String>();
    static StringBuilder sb = new StringBuilder();

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;
        DFS(root);
        return res;
    }

    public static void DFS(TreeNode root) {
        if (root.left != null) {
            sb.append(root.val);
            sb.append("->");
            DFS(root.left);
            for (int i = 0; i < Integer.toString(root.val).length(); i++)
                sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root.right != null) {
            sb.append(root.val);
            sb.append("->");
            DFS(root.right);
            for (int i = 0; i < Integer.toString(root.val).length(); i++)
                sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            for (int i = 0; i < Integer.toString(root.val).length(); i++)
                sb.deleteCharAt(sb.length() - 1);
        }
    }
}
