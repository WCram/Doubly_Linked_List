// Original linked list created for advanced programming

public class LinkedList {

    // Fields
    private Node _head;

    // Methods

    // add Method: add users new number in numerical order
    public void add(int data) {

        // Temp node to hold users data
        Node newNode = new Node(data);

        // Current node is set to first node, head
        Node current = _head;

        // previous is set the the current node
        Node previous = current;

        // If no node exists at head, set newNode to head
        if(_head == null) {
            _head = newNode;
        }

        // if the first node's number is greater than the new nodes data, replace the head with the newNode
        else if(_head.getData() > newNode.getData()) {
            Node temp = _head;
            _head = newNode;
            _head.set_next(temp);
        }

        // else if the newNode is not set at the head
        else {

            // Loop: runs while not at end of list
            while (current != null) {

                // If the new nodes data is less than the current nodes data
                if(newNode.getData() < current.getData()) {

                    // Sets the new nodes next node to the current node
                    newNode.set_next(previous.get_next());

                    // sets the previous nodes next node to the new node
                    previous.set_next(newNode);
                    break;
                }

                // If at the end of the list
                if(current.get_next() == null ) {
                    // Attach the newNode to the next of the current
                    current.set_next(newNode);
                    break;
                }

                previous = current;
                current = current.get_next();

            }
        }

    } // End add

    // remove Method: Returns true if users number is found and removed.
    public boolean remove(int num) {

        Node current = _head;
        Node previous = current;

        // If first number is users number, sets head to next.
        // Eliminating first number
        if(_head.getData() == num) {
            _head = _head.get_next();
            return true;

        }

        // Else if the second node equals users number
        else if(_head.get_next().getData() == num) {
            // Sets heads next node the the next nodes next node
            _head.set_next(_head.get_next().get_next());
            return true;

        }

        // If number is not the first or second number in the list
        else {

            // Loop: While not at the end of the list
            while(current != null) {

                // If the last number of the list is the users number, set the current node to null
                if(current.get_next() == null && current.getData() == num) {
                    current = null;
                    return true;
                }

                // If the current number is the users number
                // Set the previous numbers nextNode to the current node next node
                // Eliminating the current node
                else if(current.getData() == num) {
                    previous.set_next(current.get_next());
                    return true;

                }

                previous = current;
                current = current.get_next();
            }

        }

        return false;
    } // End remove()

    // display Method: displays Linked list in ascending order
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

    // Internal class
    private class Node {

        // Fields
        int data;
        Node _next;

        // Constructors
        public Node(int data) {
            this.data = data;
        }

        // Properties

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
