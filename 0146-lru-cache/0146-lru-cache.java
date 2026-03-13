class LRUCache {

    int capacity;

    static class DoubleLinkedList{
        int key;
        int value;
        DoubleLinkedList next;
        DoubleLinkedList prev;

        DoubleLinkedList(int key,int val){
            this.key=key;
            this.value=val;
            this.next=null;
            this.prev=null;

        }

    }

    private Map<Integer,DoubleLinkedList> cacheMap;
    DoubleLinkedList head;
    DoubleLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cacheMap= new HashMap<>();
        head= new DoubleLinkedList(0,0);
        tail = new DoubleLinkedList(0,0);
        this.head.next=tail;
        this.head.prev=tail;
    }
    
    public int get(int key) {
         //System.out.println("get ("+key+")");
        //check if exists
        DoubleLinkedList node = cacheMap.get(key);
        if(node==null)
            return -1;
        //else attach it to head as it's most recently accessed
        // detach from existing position
        removeNode(node);
        moveToFront(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {

        DoubleLinkedList node= cacheMap.get(key);
        if(node==null){
            DoubleLinkedList newNode= new DoubleLinkedList(key,value);
            System.out.println("putiing new parir with key "+key+" val "+value);
            cacheMap.put(key,newNode);
            //moveToFront
            moveToFront(newNode);
            if(cacheMap.size() > capacity){
                //evict node attached to tail(Least recently used)
                System.out.println("current capacity "+cacheMap.size() +" is greater then "+capacity);
                DoubleLinkedList lruNode =popTail();
                DoubleLinkedList removed =cacheMap.remove(lruNode.key);
                 //System.out.println("removed "+removed.key +" from cachemap");
            }
        }
        else{
            //already exists
            // remove
            //update
            //moveToFront
            removeNode(node);
            node.value=value;
            moveToFront(node);


        }
        
    }

    public void removeNode(DoubleLinkedList node){
        DoubleLinkedList prevNode= node.prev;
        DoubleLinkedList nextNode = node.next;
        prevNode.next= nextNode;
        nextNode.prev=prevNode;
        System.out.println("Removed node with key "+node.key+" and val "+node.value);
    }

    public void moveToFront(DoubleLinkedList node){
        node.prev=head;
        node.next=head.next;
         head.next.prev=node;
        head.next=node;
       
        //System.out.println("Attached node to head with key "+node.key+" and val "+node.value);
    }

    public DoubleLinkedList popTail(){
        DoubleLinkedList lruNode = tail.prev;
        removeNode(lruNode);
        //System.out.println("detached node from  tail with key "+lruNode.key+" and val "+lruNode.value);
        return lruNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */