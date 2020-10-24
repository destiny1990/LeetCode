import common.ListNode;

public class Solution_24 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        swapPairs(a);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode newHead;
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode tmp1 = head.next;
        ListNode tmp2 = head.next.next;
        newHead = tmp1;
        tmp1.next = head;
        head.next = tmp2;
        swapPairs2(tmp2, head);
        return newHead;
    }

    public static void swapPairs2(ListNode head, ListNode pre) {
        if (head == null)
            return;
        if (head.next == null)
            return;
        ListNode tmp1 = head.next;
        ListNode tmp2 = head.next.next;
        tmp1.next = head;
        head.next = tmp2;
        pre.next = tmp1;
        swapPairs2(tmp2, head);
    }
    /*精简版*/
//    public ListNode swapPairs(ListNode head) {
//        if(head!=null && head.next!=null){
//            ListNode nextNode = head.next;
//            head.next = swapPairs(nextNode.next);
//            nextNode.next = head;
//            return nextNode;
//        }
//        return head;
//    }
}
