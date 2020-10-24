import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_234 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        boolean res = isPalindrome(a);
        System.out.println(res);
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> tmp = new ArrayList<>();
        if (head == null)
            return true;
        while (head != null) {
            tmp.add(head.val);
            head = head.next;
        }
        int length = tmp.size();
        for (int i = 0; i <= length / 2; i++) {
            int a = tmp.get(i);
            int b = tmp.get(length - 1 - i);
            if (a != b)
                return false;
        }
        return true;
    }
}
