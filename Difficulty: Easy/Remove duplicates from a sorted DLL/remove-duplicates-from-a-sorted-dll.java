/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // code here
        Node curr = head;
        
        if(head==null || curr.next==null) return head;
        
        while(curr!=null && curr.next != null){
            if(curr.data == curr.next.data){
                Node temp = curr.next;
                
                curr.next = temp.next;
                
                if(temp.next != null){
                    temp.next.prev = curr;
                }
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }
}