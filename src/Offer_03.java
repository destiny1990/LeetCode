import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Offer_03 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
//        Map<Integer, Integer> result = Collections.synchronizedMap(new HashMap<Integer, Integer>());
//        result.put(10, 20);
//        System.out.println(result.get(10));
//        boolean replace_res = result.replace(10, 20, 21);
//        System.out.println(replace_res);
//        System.out.println(result.get(10));

    }

    public static int findRepeatNumber(int[] nums) {
        int res = -1;
        //实现线程安全的HashMap,防止多线程对同一HashMap进行修改时引起的问题
        Map<Integer, Integer> result = Collections.synchronizedMap(new HashMap<Integer, Integer>());//性能与Hashtable差不多
        Map<Integer, Integer> res_1 = new ConcurrentHashMap<Integer, Integer>();//性能最好
        //遍历

        for (int i = 0; i < nums.length; i++) {
            if (!result.containsKey(nums[i]))
                result.put(nums[i], 1);
            else {
                result.replace(nums[i], result.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
        }
        return res;
    }
}
