import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17 {
    public static void main(String[] args) {
        String input = "23";
        System.out.println(letterCombinations(input));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> keyboard = new HashMap<Character, String>();
        keyboard.put('2', "abc");
        keyboard.put('3', "def");
        keyboard.put('4', "ghi");
        keyboard.put('5', "jkl");
        keyboard.put('6', "mno");
        keyboard.put('7', "pqrs");
        keyboard.put('8', "tuv");
        keyboard.put('9', "wxyz");
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backTrace(res, keyboard, digits, 0, new StringBuilder());
        return res;
    }

    public static void backTrace(List<String> res, Map<Character, String> keyboard, String digits, int index, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        Character digit = digits.charAt(index);
        String indexValue = keyboard.get(digit);
        for (int i = 0; i < indexValue.length(); i++) {
            sb.append(indexValue.charAt(i));
            backTrace(res, keyboard, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
