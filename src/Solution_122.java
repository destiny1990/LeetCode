public class Solution_122 {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int result = maxProfit(prices);
        System.out.println("Max profit is :" + result);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int[] mid = new int[prices.length - i];
            System.arraycopy(prices, i, mid, 0, prices.length - i);
            maxProfit = Math.max(maxProfit, max_mid(mid));
        }
        return maxProfit;
    }

    public static int max_mid(int[] mid) {
        int maxProfit = 0;
        int min_value = mid[0];
        for (int i = 1; i < mid.length; i++) {
            if (mid[i] > min_value) {
                if (i + 1 <= mid.length - 1)
                    if (mid[i + 1] >= mid[i])
                        continue;
                    else {
                        maxProfit += mid[i] - min_value;
                        min_value = mid[i + 1];
                    }
                else
                    maxProfit += mid[i] - min_value;
            } else {
                min_value = mid[i];
            }
        }
        return maxProfit;
    }
}
