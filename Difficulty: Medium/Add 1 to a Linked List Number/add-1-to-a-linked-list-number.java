/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
        // code here.
        Node curr=head, prev=null, nxt=head.next;
        
        //reverse
        while(curr!=null){
            nxt = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        
        Node lastH = prev;
        
        while(prev!=null){
            if(prev.data!=9){
                prev.data+=1;
                break;
            }
            else prev.data=0;
            prev=prev.next;
        }
        if(prev==null) head.next = new Node(1);
        
        //reverse
        curr = lastH;
        prev=null;
        nxt=lastH.next;
        
        while(curr!=null){
            nxt = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        
        return prev;
    }
}