public class Solution_123 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        int[][] markedPrices = new int[prices.length][2];
        markedPrices = peakOrValley(prices);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]=" + markedPrices[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static int maxProfit(int[] prices) {

        return 0;
    }

    public static int[][] peakOrValley(int[] prices) {
        int i = 0;
        int[][] markedPrices = new int[prices.length][2];
        int valley = prices[0];
        int peak = prices[0];
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            markedPrices[i][0] = prices[i];
            markedPrices[i][1] = -1;
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            markedPrices[i][0] = prices[i];
            markedPrices[i][1] = 1;
        }
        return markedPrices;
    }
}
