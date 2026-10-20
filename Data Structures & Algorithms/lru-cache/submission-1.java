class Node {
    private Node prev;
    private Node next;
    private int key;
    private int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public int getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }
}

class LRUCache {
        private final int cap;
        private HashMap<Integer, Node> cache;
        private Node left;
        private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap();
        left = new Node(0, 0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;

    }

    public void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        right.prev = node;
        node.prev = prev;
        node.next = right;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            this.remove(cache.get(key));
            this.insert(cache.get(key));
            return cache.get(key).getVal();
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
            this.remove(cache.get(key));
        Node node = new Node(key, value);
        cache.put(key, node);
        this.insert(node);
        if(cache.size() > cap) {
            Node lru = left.next;
            this.remove(lru);
            cache.remove(lru.getKey());
        }
    }
}
