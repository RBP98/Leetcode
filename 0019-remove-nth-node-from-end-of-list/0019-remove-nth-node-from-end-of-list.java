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
        if(head == null) return null;

        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode fast = prev;
        ListNode slow = prev;
       
        while(fast.next != null && n > 0){
            fast = fast.next;
            n--;
        }

        while(fast.next != null){    
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return prev.next;
    }
}