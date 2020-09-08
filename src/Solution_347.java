import java.util.*;

public class Solution_347 {
    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(topKFrequent(nums, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (res.get(nums[i]) == null)
                res.put(nums[i], 1);
            else
                res.put(nums[i], res.get(nums[i]) + 1);
        }
        if (res == null || res.isEmpty()) {
            return null;
        }
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(res.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //!!不用keySet方法是因为其导出的key是乱序的
        Iterator<Map.Entry<Integer, Integer>> iter = entryList.iterator();
        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = iter.next().getKey();
        return result;
    }
}

