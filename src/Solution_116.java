import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_116 {
    public static void main(String[] args) {
        Node treeNode1 = new Node(1);
        Node treeNode2 = new Node(2);
        Node treeNode3 = new Node(3);
        Node treeNode4 = new Node(4);
        Node treeNode5 = new Node(5);
        Node treeNode6 = new Node(6);
        Node treeNode7 = new Node(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        connect(treeNode1);
        //System.out.println((int) Math.pow(2, 3));
        System.out.println((int) Math.pow(2, 2) - 1);

    }

    static List<Node> mid_res = new ArrayList<Node>();

    public static Node connect(Node root) {

        BFS(root);
        //System.out.println(mid_res);
        int layer = (int) (Math.log(mid_res.size() + 1) / Math.log(2));
        int cur_layer = 2;
        System.out.println(layer);
        for (int i = 0; i < mid_res.size(); i++) {
            //超出层数
            if (cur_layer > layer)
                break;
            if (i == 0) {
                mid_res.get(i).next = null;
                continue;
            }
            int first = (int) Math.pow(2, cur_layer - 1);
            int last = (int) Math.pow(2, cur_layer) - 1;
            //该层第一个
            if (first == (i + 1)) {
                mid_res.get(i).next = mid_res.get(i + 1);
                continue;
            }
            //该层最后一个
            if (last == (i + 1)) {
                //mid_res.get(i).next = null;
                cur_layer++;
                continue;
            }
            if (i + 1 < mid_res.size())
                mid_res.get(i).next = mid_res.get(i + 1);
        }
        return root;
    }

    public static void BFS(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            mid_res.add(tmp);
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
    }
}
