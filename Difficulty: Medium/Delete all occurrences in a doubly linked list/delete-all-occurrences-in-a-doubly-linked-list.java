/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node curr = head;
        
        while(curr!=null){
            if(curr.data == x){
                if(curr==head){
                    head=curr.next;
                }
                
                Node nxt = curr.next;
                Node prev = curr.prev;
                
                if(nxt!=null) nxt.prev = prev;
                if(prev != null) prev.next = nxt;
                
                curr = nxt;
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }
}