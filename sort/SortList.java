package learn.leetcode.sort;
    /*
    排序链表:在O(nlogn)时间复杂度和常数级空间复杂度下，对链表进行排序。
     */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

    /*
    还没做
     */
public class SortList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

//    public ListNode sortList(ListNode head) {
//        if( head == null ){
//            return head;
//        }
//        List<ListNode> list = new LinkedList<ListNode>();
//        ListNode node = head;
//        while( node!=null ){
//            list.add(node);
//            node = node.next;
//        }
//        list.sort(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val > o2.val ? 1 : (o1.val == o2.val ? 0 : -1);
//            }
//        });
//        head = new ListNode(0);
//        ListNode r = head;
//        for (ListNode n : list) {
//            System.out.print(n.val + " ");
//            r.next = n;
//            r = n;
//        }
//        r.next = null;
//        return head.next;
//    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}
