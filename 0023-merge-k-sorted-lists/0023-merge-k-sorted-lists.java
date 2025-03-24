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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int k = lists.length;
        while(k > 1){
            for(int i = 0; i < k/2; i++){
                lists[i] = merge2Lists(lists[i], lists[i + (k+1)/2] );
            }
            k = (k + 1)/2;        

        }
        return lists[0];
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.val < ptr2.val){
                temp.next = ptr1;
                temp = temp.next;
                ptr1 = ptr1.next;
                
            }else{
                temp.next = ptr2;
                temp = temp.next;
                ptr2 = ptr2.next;
                
            }
        }

        if(ptr1 == null){
            temp.next = ptr2;
        }else{
            temp.next = ptr1;
        }

        return dummy.next;
    }
}