class Node {
    int key;
    int val;
    Node prev, next;
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
        this.capacity = capacity;
        map = new HashMap<>();
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
        
    }
    private void add(Node node){
        if(node != null){
            Node temp = tail.prev;
            temp.next = node;
            node.prev = temp;
            node.next = tail;
            tail.prev = node;
        }   
    }

    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }


    public int get(int key) {
        int res = -1;
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            add(temp);
            res = temp.val;
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node newNode = new Node(key,value);
        map.put(key, newNode);
        add(newNode);
        
        if(capacity < map.size()){
            Node node = head.next;
            remove(node);
            map.remove(node.key);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */