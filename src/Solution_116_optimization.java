import common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_116_optimization {
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

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }
}
