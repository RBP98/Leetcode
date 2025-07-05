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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        ListNode ans = new ListNode(0);
        ListNode ptr = ans;

        int carry = 0;
        while(ptr1 != null || ptr2 != null){
            int x = ptr1 == null ? 0 : ptr1.val;
            int y = ptr2 == null ? 0 : ptr2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            ptr.next = new ListNode(sum);
            ptr = ptr.next;

            if(ptr1 != null) ptr1 = ptr1.next;
            if(ptr2 != null) ptr2 = ptr2.next;
        }

        if(carry > 0) ptr.next = new ListNode(carry);

        return ans.next;
    }
}