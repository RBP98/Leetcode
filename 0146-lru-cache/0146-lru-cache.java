class ListNode{
    int key;
    int value;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    
    Map<Integer, ListNode> map = new HashMap<>();
    int capacity;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(ListNode node){
        if(node != null){
            ListNode temp = tail.prev;
            tail.prev = node;
            node.next = tail;
            node.prev = temp;
            temp.next = node;
     
        }
    }

    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            ListNode data = map.get(key);
            result = data.value;
            remove(data);
            add(data);
        }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        ListNode node = new ListNode(key,value);
        map.put(key, node);
        add(node);

        if(map.size()> capacity){
            int removal = head.next.key;
            ListNode nodeToBeRemoved = map.get(removal);

            map.remove(removal);
            remove(nodeToBeRemoved);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */