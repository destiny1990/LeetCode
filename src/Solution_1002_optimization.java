import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1002_optimization {
    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        //String[] A = {"cool", "lock", "cook"};
        List<String> res = commonChars(A);
        System.out.println(res);
    }

    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] min_freq = new int[26];
        Arrays.fill(min_freq, Integer.MAX_VALUE);
        for (String str : A
        ) {
            int[] freq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                ++freq[tmp - 'a'];
            }
            for (int i = 0; i < 26; i++) {
                min_freq[i] = Math.min(freq[i], min_freq[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < min_freq[i]; j++)
                //res.add((char)('a'+i));
                res.add(String.valueOf((char) (i + 'a')));
        }
        return res;
    }
}
