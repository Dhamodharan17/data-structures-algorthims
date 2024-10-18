class LFUCache {

    final int capacity;
    int curSize;
    int minFrequency;//to remove LFU
    Map<Integer,DLLNode> cache; 
    Map<Integer,DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
       this.capacity = capacity;
       this.curSize = 0;
       this.minFrequency=0;

       this.cache = new HashMap<>();
       this.freqMap = new HashMap<>(); 
    }
    
    public int get(int key) {
        
        DLLNode curNode = cache.get(key);
        if(curNode == null) return -1;

        //update freq
        updateNode(curNode);
        return curNode.val;

    }
    
    public void put(int key, int value) {
        
        if(capacity==0) return;

        if(cache.containsKey(key)){//update
            DLLNode curNode = cache.get(key);
            curNode.val = value; //update value
            updateNode(curNode);

        }else{//new
        curSize++;
            if(curSize>capacity){
                //get minimum freq list aand remove lru
                DoublyLinkedList minFreqList = freqMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            //freq of new node - 1
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key,value);
            //create a new DLL for current freq
            DoublyLinkedList curList = freqMap.getOrDefault(1,new DoublyLinkedList());
            curList.addNode(newNode);
            freqMap.put(1,curList);
            cache.put(key,newNode);   
        }
    }//end of method

    //update freq
   public void updateNode(DLLNode curNode){

            int curFreq = curNode.freq;
            DoublyLinkedList curList = freqMap.get(curFreq);
            //remove node from frequenlinked list 
            curList.removeNode(curNode);

            //if minfreq not having any node then remove it and add new minfrequency
            if(curFreq == minFrequency && curList.size==0) minFrequency++;
            
            curNode.freq++;

            DoublyLinkedList newList = freqMap.getOrDefault(curNode.freq, new DoublyLinkedList());
            newList.addNode(curNode);
            freqMap.put(curNode.freq,newList);
        }
    
}

    //node for doubly linkedlist and map
    class DLLNode{
        int key;
        int val;
        int freq;
        DLLNode prev;
        DLLNode next;
        DLLNode(int key,int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    //DLL
    class DoublyLinkedList{
        int size;
        DLLNode head;
        DLLNode tail;
        DoublyLinkedList(){
            this.size =0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
    
    //adding node after head
    void addNode(DLLNode curNode){
    
        curNode.next = head.next;
        curNode.prev = head;

        head.next.prev = curNode;
        head.next = curNode;
        size++;

    }

    //delete  node (3 monkey)
    public void removeNode(DLLNode curNode){
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        size--;
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
