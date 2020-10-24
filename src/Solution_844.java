import java.util.Stack;

public class Solution_844 {
    public static void main(String[] args) {

    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> mid_s = new Stack<>();
        Stack<Character> mid_t = new Stack<>();
        if (S == null && T == null)
            return true;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#')
                mid_s.push(S.charAt(i));
            if (S.charAt(i) == '#' && mid_s.isEmpty())
                continue;
            if (S.charAt(i) == '#' && !mid_s.isEmpty())
                mid_s.pop();
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#')
                mid_t.push(T.charAt(i));
            if (T.charAt(i) == '#' && mid_t.isEmpty())
                continue;
            if (T.charAt(i) == '#' && !mid_t.isEmpty())
                mid_t.pop();
        }
        if (mid_s.size() != mid_t.size())
            return false;
        else {
            while (!mid_s.isEmpty()) {
                if (mid_s.pop().equals(mid_t.pop()))
                    continue;
                else
                    return false;
            }
            return true;
        }
    }
}
