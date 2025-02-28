class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    private void add(Node node){
        if(node != null){
            Node temp = tail.prev;
            tail.prev = node;
            node.next = tail;
            node.prev = temp;
            temp.next = node;
        }

        
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        int res = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            res = node.value;
            remove(node);
            add(node);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);

        add(node);
      
        if(capacity < map.size()){
            int rem = head.next.key;
            Node nodeToBeRemoved = map.get(rem);
            map.remove(rem);
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