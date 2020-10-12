import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_142 {
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        System.out.println(detectCycle(a).val);
    }

    public static ListNode detectCycle(ListNode head) {
        List<ListNode> mv = new ArrayList<ListNode>();
        ListNode tmp = head;
        if (tmp == null || tmp.next == null)
            return null;
        while (tmp.next != null) {
            if (mv.contains(tmp))
                return tmp;
            else {
                mv.add(tmp);
                tmp = tmp.next;
            }
        }
        return null;
    }
}
