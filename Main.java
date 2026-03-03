
public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(6);
        list.deleteFirst(); 
        list.insert(7,3);
        list.insertLast(8);

        list.display();
        list.reverse();

        list.display();
        System.out.println(list.findMiddle());


        DLL dlist= new DLL();
        dlist.insertFirst(3);
        dlist.insertFirst(4);
        dlist.insertFirst(13);
        dlist.insertFirst(42);
        dlist.insertFirst(2);
        dlist.insertLast(8);
        dlist.insert(7,2);
        dlist.display();

        dlist.deleteLast();
        dlist.deleteFirst();
        dlist.delete(2);
        dlist.display();


        LRU lru=new LRU(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
    }
}