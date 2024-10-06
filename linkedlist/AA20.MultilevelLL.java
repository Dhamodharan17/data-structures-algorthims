/*
go to the last children →  Node c = flatten(current.child);//recursion

connect current and child

add children’s next to itself

after adding all childrens add its next → c.next =t;//attach next after all child
*/
class Solution {
    public Node flatten(Node head) {

        //current -> child -> next
        
        Node current = head;
        while(current!=null){
            Node t = current.next;//store next to attach after all child

            if(current.child!=null){
                Node c = flatten(current.child);//recursion
                //attach current and child
                current.next=c;
                c.prev=current;

                while(c.next!=null){
                    c=c.next;
                }
                c.next =t;//attach next after all child
                if(t!=null) t.prev = c;
            }
            
            current.child = null;
            current = t; //iteration
        }
return head;
    }
}
