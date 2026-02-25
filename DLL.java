public class DLL{
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int value;
        private Node prev;
        private Node next;

        public Node(int value){
            this.value=value;
            this.prev=null;
            this.next=null;
        }

    }

    public void insertFirst(int value){
        if(head==null){
            Node node=new Node(value);
            head=node;
            tail=node;
            size=1;
            return;
            
        }
        Node node=new Node(value);
        node.next=head;
        head.prev=node;
        head=node;
        size++;
        return;



    }

    public void insertLast(int value){
        if(head==null){
            Node node=new Node(value);
            head=node;
            tail=node;
            size=1;
            return;
            
        }
        Node node =new Node(value);
        node.prev=tail;
        tail.next=node;
        tail=node;
        size++;
        return;
    }

    public void display(){
        if(head==null){
            System.out.println("Insert into the Doubly Linked List");
        }

        Node node=head;
        while(node!=null){
            System.out.print(node.value);
            System.out.print("->");
            node=node.next;
        }
        System.out.println("End");
    }


    public void insert(int value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index");
        }

        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = new Node(value);
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        temp.next = current.next;
        temp.prev = current;

        current.next.prev = temp;
        current.next = temp;

        size++;
    }

    public int deleteFirst(){
        if(head==null){
            System.out.println("insert Elements to Doubly Linked List First");
            return -1;
        }
        if(head.next==null){
            int val=head.value;
            head=null;
            tail=null;
            size--;
            return val;
        }
        int val=head.value;
        head=head.next;
        head.prev=null;
        size--;

        return val;
    }
    public int deleteLast(){
        if(head==null){
            System.out.println("insert Elements to Doubly Linked List First");
            return -1;
        }
        if(head.next==null){
            int val=head.value;
            head=null;
            tail=null;
            size--;
            return val;
        }
        int val=tail.value;
        tail=tail.prev;
        tail.next=null;
        size--;

        return val;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }

        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        int val = current.value;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.next = null;
        current.prev = null;

        size--;

        return val;
    }
}