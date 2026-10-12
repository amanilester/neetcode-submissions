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

    private HashMap<Node, Node> copies = new HashMap<>();
    private Node getCopy(Node original) {
        if(original == null)
            return null;

        if(!copies.containsKey(original))
            copies.put(original, new Node(original.val));

        return copies.get(original);
    }
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null) {
            Node copy = getCopy(curr);
            copy.next = getCopy(curr.next);
            copy.random = getCopy(curr.random);
            curr = curr.next;
        }

        return getCopy(head);
    }
}
