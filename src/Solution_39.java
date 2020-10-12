import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<Integer>();
        DFS(candidates, target, tmp, 0);
        return res;
    }

    public static void DFS(int[] candidates, int target, List<Integer> tmp, int index) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }
            tmp.add(candidates[i]);
            DFS(candidates, target - candidates[i], tmp, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
