public class Solution_121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println("MAX profit is : " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++)
            for (int j = i + 1; j < prices.length; j++) {
                int tmp = prices[j] - prices[i];
                if (tmp > profit) profit = tmp;
            }
        return profit > 0 ? profit : 0;
    }
}
