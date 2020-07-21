public class Solution_189 {
    public static void main(String[] args) {
        //System.out.println("Hello World！");
        int[] candies = {-1, -100, 3, 99};
        rotate(candies, 2);
        for (int i = 0; i < candies.length; i++) {
            System.out.print(candies[i] + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int[] mirror = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mirror[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = mirror[i];
        }
    }
}
