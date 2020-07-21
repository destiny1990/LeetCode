import java.util.HashMap;
import java.util.Map;

public class Solution_575 {
    public static void main(String[] args) {
        //System.out.println("Hello World！");
        int[] candies = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies(candies));
    }

    public static int distributeCandies(int[] candies) {
        Map<Integer, Integer> statics = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            if (statics.isEmpty() || statics.get(candies[i]) == null)
                statics.put(candies[i], 1);
            else
                statics.replace(candies[i], statics.get(candies[i]), statics.get(candies[i]) + 1);
        }
        if (statics == null)
            return 0;
        else {
            //有多少种类的糖果
            int type = statics.keySet().size();
            //每人有多少颗糖果
            int amount = candies.length / 2;
            if (type >= amount)
                return amount;
            else
                return type;
        }
    }
}
