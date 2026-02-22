
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
    }
}