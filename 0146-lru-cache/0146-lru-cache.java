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
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node){
        if(node != null){
            Node temp = tail.prev;
            tail.prev = node;
            node.next = tail;
            node.prev = temp;
            temp.next = node;
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            Node temp = map.get(key);
            result = temp.val;

            remove(temp);
            add(temp);

        }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node temp = new Node(key, value);
        add(temp);
        map.put(key, temp);

        if(map.size() > capacity){
            int removal = head.next.key;
            remove(head.next);
            map.remove(removal);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */