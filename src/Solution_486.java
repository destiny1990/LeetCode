public class Solution_486 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3};
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        int res = scorediff(nums, 0, nums.length - 1, 1);
        return res >= 0;
    }

    //which player
    //1:1号选手，-1:2号选手
    public static int scorediff(int[] nums, int firstIndex, int lastIndex, int whichplayer) {
        if (firstIndex == lastIndex)
            return nums[firstIndex] * whichplayer;
        int scoreFirst = nums[firstIndex] * whichplayer + scorediff(nums, firstIndex + 1, lastIndex, -whichplayer);
        int scoreLast = nums[lastIndex] * whichplayer + scorediff(nums, firstIndex, lastIndex - 1, -whichplayer);
        return Math.max(scoreFirst * whichplayer, scoreLast * whichplayer) * whichplayer;
    }

}
