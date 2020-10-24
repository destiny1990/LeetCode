import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1002 {
    public static void main(String[] args) {
//        String[] A = {"bella", "label", "roller"};
        String[] A = {"cool", "lock", "cook"};
        List<String> res = commonChars(A);
        System.out.println(res);

    }

    public static List<String> commonChars(String[] A) {
        int count = A.length;
        List<String> res = new ArrayList<String>();
        Map<Character, Integer>[] mid = new Map[count];
        //遍历输入数组
        for (int i = 0; i < count; i++) {
            mid[i] = new HashMap<Character, Integer>();
            //将每一个数组的char即数量放在对应的map里
            for (int j = 0; j < A[i].length(); j++) {
                char a = A[i].charAt(j);
                if (!mid[i].containsKey(a))
                    mid[i].put(a, 1);
                else
                    mid[i].put(a, mid[i].get(a) + 1);
            }

        }
        //中间结果，存储共同存在的字符及次数
        Map<Character, Integer> mid_res = new HashMap<Character, Integer>();
        char start = 'a';
        for (int i = 1; i <= 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < count; j++) {
                //如果不包含该字符，那么不会存在共同字符，并退出该循环
                if (!mid[j].containsKey(start)) {
                    min = 0;
                    break;
                } else {
                    //取最小的值才是共同存在的次数
                    min = min > mid[j].get(start) ? mid[j].get(start) : min;
                }
            }
            //共同存在次数大于0，再放进中间结果集
            if (0 != min)
                mid_res.put(start, min);
            //start++，下一个字符
            start++;
        }
        for (Character a : mid_res.keySet()) {
            for (int i = 0; i < mid_res.get(a); i++)
                res.add(a.toString());
        }
        return res;
    }
}
