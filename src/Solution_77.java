import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_77 {
    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }

    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combine(int n, int k) {
        Deque<Integer> path = new ArrayDeque<Integer>();
        DFS(1, n, k, path);
        return res;
    }

    public static void DFS(int begin, int n, int k, Deque<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            DFS(i + 1, n, k, path);
            path.removeLast();
        }
    }
}
