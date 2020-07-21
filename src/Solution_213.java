//213. 打家劫舍 II
public class Solution_213 {
    public static void main(String[] args) {
        //int nums[] = {2, 7, 9, 3, 1};
        //答案4173
        int[] nums = {1, 2, 3, 2};
        int amount = rob(nums);
        System.out.println("偷窃最高金额：" + amount);
    }

    public static int rob(int[] nums) {
        int[] num_a = new int[nums.length - 1];
        int[] num_b = new int[nums.length - 1];
        System.arraycopy(nums, 0, num_a, 0, nums.length - 1);
        System.arraycopy(nums, 1, num_b, 0, nums.length - 1);
        return rob_mid(num_a) > rob_mid(num_b) ? rob_mid(num_a) : rob_mid(num_b);
    }

    public static int rob_mid(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length == 1)
            return nums[0];
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int k = 2; k <= length - 1; k++) {
            dp[k] = Math.max(dp[k - 2] + nums[k], dp[k - 1]);
        }
        return dp[length - 1];
    }
}
