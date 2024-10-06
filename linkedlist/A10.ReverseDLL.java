//swap next and prev
public static Node reverseDLL(Node  head)
{
    while(head != null){
        Node temp = head.prev;
        head.prev = head.next;//next pointer
        head.next = temp;
        if(head.prev == null) return head;
        head = head.prev;
    }
    
    return head;
}
