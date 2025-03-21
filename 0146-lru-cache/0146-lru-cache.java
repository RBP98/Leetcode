class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    } 
}
class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(Node node){
        if(node != null){
            Node temp  = tail.prev;
            tail.prev = node;
            node.next = tail;
            node.prev = temp;
            temp.next = node;
        }
    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if(map.size() > capacity){
            Node removal = head.next;
            map.remove(removal.key);
            remove(removal);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */