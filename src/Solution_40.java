import java.util.*;

public class Solution_40 {
    public static void main(String[] args) {
        int[] canditates = {5};
        int target = 5;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = combinationSum2(canditates, target);
        System.out.println(res);
    }

    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<Integer>();
        DFS(candidates, target, 0, path);
        //去重
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> tmp_res : res) {
            boolean isExisted = false;
            for (List<Integer> tmp_result : result)
                if (tmp_res.toString().equals(tmp_result.toString())) {
                    isExisted = true;
                    break;
                }
            if (!isExisted)
                result.add(tmp_res);
        }
        return result;
    }


    public static void DFS(int[] candidates, int target, int index, Deque<Integer> path) {

        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (index == candidates.length)
            return;
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            DFS(candidates, target - candidates[i], i + 1, path);
            path.removeLast();
        }
        //DFS(candidates, target, index + 1, path);
    }
}
