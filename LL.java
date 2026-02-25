public class LL {
    private Node head;
    private Node tail;
    private int size;

    public  LL(){
        this.size=0;
    }
    public int size(){
        return size;
    }

    public void insertFirst(int value){
        Node node= new Node(value);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;
    }


    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next=node;
        tail=node;
        size+=1;
        
    }

    public void insert(int value,int index){
        if(index < 0 || index > size){
        throw new IndexOutOfBoundsException("Invalid index");
    }
        if (index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;

        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(value,temp.next);
        temp.next=node;
        size++;

    }

    public int deleteFirst(){
        if(head==null){
            System.out.println("Insert Item First");
            return -1;
        }
        int val =head.value;
        head=head.next;

        if(head==null){
            tail=null;
        }
        size--;
        return val;


    }
    public int deleteLast(){
        if(tail==null){
            throw new RuntimeException("List is empty");
        }

        if(size==1){
            int val=tail.value;
            tail=null;
            head=null;
            size--;
            return val;

        }
        
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        
        int val=tail.value;
        tail=temp;
        tail.next=null;
        size--;

        return val;
    }

    public int delete(int index){

        if(index < 0 || index >= size){
        throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index==0){
            int val=deleteFirst();
            return val;
        }
        if(index==size-1){
            int val=deleteLast();
            return val;
        }
        Node prev=head;
        
        for(int i=1;i<index;i++){
            prev=prev.next;
            

        }
        Node temp=prev.next;
        int val=temp.value;
        prev.next=temp.next;
        temp.next=null;
        size--;
        return val;

    }

    public void reverse(){
       Node prev=null;
       Node curr=head;
       Node next=null;
       tail=head;

       while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
       } 
       head=prev;
    }

    public int findMiddle(){
        Node slow=head;
        Node fast=head;
        if(head == null) {
        throw new RuntimeException("List is empty");
        }

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.value;

    }

    public boolean hasCycle(){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }

        }
        return false;
    }

    public int removeNthNodeFromEnd(int n){
        Node fast=head;
        Node slow=head;
        if(n <= 0 || n > size){
            throw new IllegalArgumentException("Invalid n");
        }
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null){
            return deleteFirst();
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        int val=slow.next.value;
        slow.next=slow.next.next;
        size--;

        return val;
    }

    public  void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value);
            System.out.print("->");
            temp=temp.next;
        }
        System.out.println("Null ");
    }

    private class Node {
        private int value;
        private Node next;
        public Node (int value){
            this.value = value;
            }
        public Node (int value,Node next){
            this.value = value;
            this.next = next;
            }


    }
    

}
