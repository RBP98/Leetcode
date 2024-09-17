class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(){
        
    }
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void deleteFromCache(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertToCache(Node node) {
        Node currLatest = head.next;
        head.next = node;
        node.next = currLatest;
        node.prev = head;
        currLatest.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteFromCache(node);
        insertToCache(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            deleteFromCache(node);
            insertToCache(node);
        } else {
            if (map.size() == capacity) {
                Node node = tail.prev;
                map.remove(node.key);
                deleteFromCache(node);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertToCache(node);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */