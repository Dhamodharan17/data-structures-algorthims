//print
class Solution {
	//print
    void display(Node head) {
        
       while(head != null){
           System.out.print(head.data+" ");
           head = head.next;//traverse one by one
       }
       
    }
}

//insert at end
class Solution {
    Node insertAtEnd(Node head, int x) {
        
        // insert - attach at end
        
        //edgecase
        if(head == null) return new Node(x);
        
        Node current = head;//since will lose the head
        while(current != null && current.next != null){
            current = current.next;
        }
        current.next = new Node(x);
        
        return head;
    }
}

//insert at position

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head,
     int data, int position) {
   
    SinglyLinkedListNode node=new SinglyLinkedListNode(data);
    //edge case - head
    if(position==1){
      node.next=head;
      return node;
    }
      
    //stop before posiion
    SinglyLinkedListNode temp=head;
    for(int i=1;i<position;i++)
    {
        temp=temp.next;
    }

    SinglyLinkedListNode temp1=temp.next;//hand over
      
    temp.next=node;
    node.next=temp1;//make the node which was already in that position
    return head;
    

    }
