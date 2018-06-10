// Personal practice: Creating a doubly linked list

public class DLinkedList {

    // Fields
    private DNode head;
    private DNode tail = head;

    // Methods

    // add Method: add number to the current linked list arranged in proper order
    public void add(int number) {

        // Instantiate a new DNode object to hold the new number to be added.
        DNode newData = new DNode(number);

        // Set the current node to head, the first node in the list
        DNode current = head;

        // If the list is empty, head and tail are both set to newData
        if(head == null) {
            head = tail = newData;
        }

        // Else check if the new number being added is less than the first number in the list
        else if (head.getData() > number) {

            // temp node to hold current head data
            DNode temp = head;

            // Replace head with the new number being added
            head = newData;

            // Attached previous head node as new node to new data
            head.setNext(temp);

            // Set the second nodes previous reference to the new head data
            head.getNext().setPrevious(head);

            // Set tail to second node
            tail = head.getNext();

        }

        // else if new number is not set at head of linked list
        else {

            // Loop: While not at the end of the list, loop through the nodes
            while(current != null) {

                // If the current number is larger the new number
                if(current.getData() > number) {

                    // Set the newData's next link to the current node
                    newData.setNext(current);
                    // Set the newData's previous link, to currents previous link
                    // This now inserts it between the previous and the current node
                    newData.setPrevious(current.getPrevious());

                    // Gets the current node's previous node, and then set's it's next node to the new data
                    current.getPrevious().setNext(newData);
                    // Sets the current node previous node to the newData
                    current.setPrevious(newData);

                    break;
                }
                // Else if it reaches the end of the list
                else if (current.getNext() == null){

                // Sets the current *last* node's next node to newData
                current.setNext(newData);

                // Sets newData's previous node to the current node
                newData.setPrevious(current);

                // Sets the tail of the linked list to newData
                tail = newData;
                break;
                }

                // Loop to next node
                current = current.getNext();

            }

        }

    } // End add()

    // remove Method: Removes specified number at first instance in linked list
    // returns a boolean: True, if number is found and removed
    public boolean remove(int number) {

        // Sets current node to head of the list
        DNode current = head;

        // If head data is the number
        if(head.getData() == number) {

            // Head is set to the next node
            head = head.getNext();

            // head.previous is set to null, eliminating the original head node
            head.setPrevious(null);

            // Returns true
            return true;
        }
        // else runs if head node is not number
        else {

            // Loop: while not the end of the list
            while (current != null) {

                // If the current node is the user's number
                if(current.getData() == number) {

                    // If the current node is the last number in the list
                    if(current.getNext() == null) {

                        // tail is now set to the second from last number
                        tail = current.getPrevious();

                        // The current.previous nodes setNext is set to Null
                        // Eliminating the last node
                        current.getPrevious().setNext(null);

                        // return true
                        return true;
                    }

                    // Else the current nodes previous is set to it's next node
                    current.getPrevious().setNext(current.getNext());

                    // And the current nodes next node set it's previous node to the currents previous node
                    // Eliminating the current node
                    current.getNext().setPrevious(current.getPrevious());

                    // return true
                    return true;
                }

                // Current node is set the next node
                current = current.getNext();
            }
        }

        // Returns false if the users number is not found
        return false;
    }

    // Displays the linked list in ascending order
    public void display() {

        DNode current = head;

        while (current != null) {

            System.out.print(current.getData());

            current = current.getNext();
        }

        System.out.println();

    } // End display()

    // Displays the linked list in descending order
    public void displayReverse() {

        DNode current = tail;

        while (current != null) {

            System.out.print(current.getData());

            current = current.getPrevious();
        }

        System.out.println();

    }

    // Internal class
    private class DNode {

        // Fields
        int data;
        DNode previous;
        DNode next;

        // Constructor
        public DNode(int data) {
            this.data = data;
        } // End DNode

        // Properties
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public DNode getPrevious() {
            return previous;
        }

        public void setPrevious(DNode previous) {
            this.previous = previous;
        }

        public DNode getNext() {
            return next;
        }

        public void setNext(DNode next) {
            this.next = next;
        }
    } // End DNode

} // End DLinkedList
