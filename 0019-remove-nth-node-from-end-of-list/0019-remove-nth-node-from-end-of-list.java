/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head == null || head.next == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        while(n > 0){
            fast = fast.next;

            n--;
        }

        ListNode slow = head;
        ListNode prev = dummy;

        while(fast != null){
            fast = fast.next;
            slow = slow.next; 
            prev = prev.next;
        }

        prev.next = slow.next;

        return dummy.next;
    }
}