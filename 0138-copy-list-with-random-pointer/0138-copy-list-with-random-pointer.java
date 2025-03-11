/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node ptr = head;

        while(ptr != null){
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = ptr.next.next;
        }

        ptr = head;

        while(ptr != null){
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        ptr = head;
        Node ptr2 = head.next;
        Node ans = ptr2;

        while(ptr != null){

            ptr.next = ptr2.next;
            ptr2.next = ptr.next == null ? null : ptr.next.next;

            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        return ans;
    }
}