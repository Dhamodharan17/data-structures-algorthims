//Return the same node or processed / new node

//print
class Solution {
    void display(Node head) {

        if(head == null) return;//base case
        System.out.print(head.data+" ");
        display(head.next);//recursion
        
    }
}

//insert
class Solution {
    Node insertAtEnd(Node head, int x) {
        
        // insert = attach
        
        // at end return newnode
        if(head == null) return new Node(x);
        
        // if next is null we will get new node from r1 or same node from r2
        head.next = insertAtEnd(head.next,x);
        
        return head;//return same node
     
    }
}

//insert at pos
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head,
     int data, int position) {
 
     if (position == 0) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = head;
        // return the newnode with move the exisiting to after it
        return newNode;
    }
    
    // Recursive case: move to the next node and decrease the position
    head.next = insertNodeAtPosition(head.next, data, position - 1);
    return head;//return the same node

    }

}

//delete

class GfG
{
//delete = skip
Node deleteNode(Node head, int x){
	
	//when given position skip and return the next
	if(x==1) return head.next;
	
	head.next = deleteNode(head.next,--x);
	
	return head;//return the same node came in parameter
		
    }
}
