//198. 打家劫舍 I
public class Solution_198 {
    public static void main(String[] args) {
        //int nums[] = {2, 7, 9, 3, 1};
        //答案4173
        int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        int amount = rob2(nums);
        System.out.println("偷窃最高金额：" + amount);
    }

    /*
    递归超时
     */
    public static int rob(int[] nums) {
        if (1 == nums.length)
            return nums[0];
        else if (2 == nums.length)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        else if (3 == nums.length)
            return nums[0] + nums[2] > nums[1] ? nums[0] + nums[2] : nums[1];
        else if (4 <= nums.length) {
            int[] nums_a = new int[nums.length - 2];//取第一个
            System.arraycopy(nums, 2, nums_a, 0, nums.length - 2);
            int[] nums_b = new int[nums.length - 3];//取第二个
            System.arraycopy(nums, 3, nums_b, 0, nums.length - 3);
            //int max = nums_a > nums_b ? nums_a : nums_b;
            return nums[0] + rob(nums_a) > nums[1] + rob(nums_b) ? nums[0] + rob(nums_a) : nums[1] + rob(nums_b);
        } else
            return 0;
    }

    public static int rob2(int[] nums) {
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
