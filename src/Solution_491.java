import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_491 {

    static List<Integer> temp = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static Set<Integer> set = new HashSet<Integer>();
    static int n;

    public static void main(String[] args) {
        System.out.println("ayaya");
        int[] nums = {4, 6, 7, 7};
        findSubsequences(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<Integer>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    public static void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; ++i) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    public static int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public static boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }
}
