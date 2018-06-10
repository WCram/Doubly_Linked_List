public class LinkedList {

    private Node _head;

    public void add(int data) {

        Node newNode = new Node(data);
        Node current = _head;
        Node previous = current;

        if(_head == null) {
            _head = newNode;
        }
        else if(_head.getData() > newNode.getData()) {
            Node temp = _head;
            _head = newNode;
            _head.set_next(temp);
        }
        else {
            while (current != null) {

                if(newNode.getData() < current.getData()) {
                    newNode.set_next(previous.get_next());
                    previous.set_next(newNode);
                    break;
                }

                if(current.get_next() == null ) {
                    current.set_next(newNode);
                    break;
                }

                previous = current;
                current = current.get_next();

            }
        }

    } // End add

    public boolean remove(int num) {

        Node current = _head;
        Node previous = current;

        if(_head.getData() == num) {
            _head = _head.get_next();
        }
        else if(_head.get_next().getData() == num) {
            _head.set_next(_head.get_next().get_next());
        }
        else {

            while(current != null) {

                if(current.get_next() == null && current.getData() == num) {
                    current = null;
                    break;
                }
                else if(current.getData() == num) {
                    previous.set_next(current.get_next());
                    break;
                }


                previous = current;
                current = current.get_next();
            }

        }

        return false;
    } // End remove()

    public void display() {
        Node current = _head;

        if(current == null) {
            System.out.println("No items in the list.");
        }
        else {

            while(current != null) {

                System.out.print(current.getData() + " ");
                current = current.get_next();
            }
            System.out.println();
        }

    }


    private class Node {

        int data;
        Node _next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node get_next() {
            return _next;
        }

        public void set_next(Node _next) {
            this._next = _next;
        }
    } // End class Node
} // End class Linked List
