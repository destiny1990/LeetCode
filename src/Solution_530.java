import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_530 {
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> pq = new ArrayList<Integer>();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(2);
        a.right = b;
        b.left = c;
        getMinimumDifference(a);
        System.out.println(min);
    }

    public static int getMinimumDifference(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return -1;
        DFS(root);
        Collections.sort(pq);
        for (int i = 1; i < pq.size(); i++) {
            int tmp = Math.abs(pq.get(i) - pq.get(i - 1));
            min = min > tmp ? tmp : min;
        }
        return min;
    }

    public static void DFS(TreeNode root) {
        if (root == null)
            return;
        else {
            pq.add(root.val);
            DFS(root.left);
            DFS(root.right);
        }
    }

}
