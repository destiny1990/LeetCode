import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_141 {
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        System.out.println(hasCycle(a));
    }

    public static boolean hasCycle(ListNode head) {
        List<ListNode> mv = new ArrayList<ListNode>();
        ListNode tmp = head;
        if (tmp == null || tmp.next == null)
            return false;
        while (tmp.next != null) {
            mv.add(tmp);
            tmp = tmp.next;
            if (mv.contains(tmp))
                return true;
        }
        return false;
    }
}
