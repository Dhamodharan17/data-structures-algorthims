//always mark newnode's prev and next 1st
public void insertAtPosition(int data, int position) 
{ 
	Node temp = new Node(data); 
	if (position == 1) { 
		insertAtBeginning(data); 
	} 
    
	else { 
		Node current = head; 
		int currPosition = 1; 
    
		while (current != null && currPosition < position) {
			current = current.next; 
			currPosition++; 
		} 
    
		if (current == null) { 
			insertAtEnd(data); 
		} 
		else { 
			temp.next = current; //own pointer
			temp.prev = current.prev; //own pointer
			current.prev.next = temp; //inbetween pointer
			current.prev = temp; 
		} 
	} 
} 

//insert at end


    //insert at end - 3pointer
    static DNode insertAtEnd(DNode head,int x){
        // stop at lastnode (not at null)
        while(head!=null && head.next!=null){
            head = head.next;
        }
        DNode newNode = new DNode(x);
        if(head!=null){
            newNode.next = null;
            newNode.prev = head;
            head.next = newNode;
        }else{
            return newNode;
        }
        return head;
    }

