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
    public void reorderList(ListNode head) {
        if (head  == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null  && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        ListNode first = head;
        ListNode second = prev;
        while(second.next != null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }




    }
}