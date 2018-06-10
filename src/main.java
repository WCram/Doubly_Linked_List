public class main {

    public static void main(String[] args) {

        // Initialize new double Linked list
        DLinkedList dl = new DLinkedList();

dl.add(1);
dl.add(7);
dl.add(5);
dl.remove(5);
dl.remove(7);
        dl.remove(5);
        dl.remove(7);
        dl.add(1);
        dl.add(7);
        dl.add(5);
        dl.add(1);
        dl.add(7);
        dl.add(5);

dl.display();
dl.displayReverse();

    }

}
