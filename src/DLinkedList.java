public class DLinkedList {


    private DNode head;
    private DNode tail = head;

    public void add(int number) {

        DNode newData = new DNode(number);
        DNode current = head;

        if(head == null) {
            head = tail = newData;
        }
        else if (head.getData() > number) {

            DNode temp = head;
            head = newData;


            head.setNext(temp);
            head.getNext().setPrevious(head);

            tail = head.getNext();

        }
        else {

            while(current != null) {

                if(current.getData() > number) {

                    newData.setNext(current);
                    newData.setPrevious(current.getPrevious());

                    current.getPrevious().setNext(newData);
                    current.setPrevious(newData);

                    break;
                }
                else if (current.getNext() == null){
                current.setNext(newData);
                newData.setPrevious(current);
                tail = newData;
                break;
                }

                current = current.getNext();

            }

        }

    } // End add()

    public boolean remove(int number) {
        DNode current = head;

        if(head.getData() == number) {

            head = head.getNext();
            head.setPrevious(null);

            return true;
        }

        else {
            while (current != null) {



                if(current.getData() == number) {

                    if(current.getNext() == null) {

                        tail = current.getPrevious();
                        current.getPrevious().setNext(null);
                        return true;
                    }

//                    DNode temp = current;
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());

                    return true;
                }

                current = current.getNext();
            }
        }

        return false;
    }

    public void display() {

        DNode current = head;

        while (current != null) {

            System.out.print(current.getData());

            current = current.getNext();
        }

        System.out.println();

    } // End display()

    public void displayReverse() {

        DNode current = tail;

        while (current != null) {

            System.out.print(current.getData());

            current = current.getPrevious();
        }

        System.out.println();

    }


    private class DNode {

        int data;
        DNode previous;
        DNode next;

        public DNode(int data) {
            this.data = data;
        } // End DNode

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
