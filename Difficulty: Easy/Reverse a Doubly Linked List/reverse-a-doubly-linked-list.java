/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        if(head==null) return head;
        if(head.next==null) return head;
        
        Node prev = null;
        Node curr = head;
        
        while(curr!=null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            
            curr = curr.prev;
        }
        return prev.prev;
    }
}