public class Solution_75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i]);
    }

    public static void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                counts[0]++;
            else if (nums[i] == 1)
                counts[1]++;
            else
                counts[2]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < counts[0])
                nums[i] = 0;
            else if (i < counts[0] + counts[1])
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
}
