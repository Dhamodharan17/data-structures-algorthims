//DFS - operations at deeper level 1st
class Solution {

     HashMap<Node,Node> map = new HashMap<>();
     
    public Node copyRandomList(Node head) {
       
        if(head==null) return null;
        Node temp = new Node(head.val);
        map.put(head,temp);
        temp.next = copyRandomList(head.next);//dfs
        temp.random = map.get(head.random);
        return temp;


    }
}
