class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(ListNode value){
        ListNode end = tail.prev;
        end.next = value;
        value.prev = end;
        value.next = tail;
        tail.prev = value;

    }

    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key); 
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        add(node);    

        if(map.size() > capacity){
            map.remove(head.next.key);
            remove(head.next);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */