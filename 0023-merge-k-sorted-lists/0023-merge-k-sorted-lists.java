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
        
        if (lists.length == 0) return null;

        int k = lists.length;
        while(k > 1){
            int newK = (k + 1) / 2;

            for(int i = 0; i < k / 2; i++){
                lists[i] = mergeTwoLists(lists[i], lists[i + (k + 1)/2]);
            }
            k = newK;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        ListNode t1 = list1;
        ListNode t2 = list2;

        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        if(t1 == null){
            temp.next = t2;
        }else if(t2 == null){
            temp.next = t1;
        }

        return dummy.next;
    }
}