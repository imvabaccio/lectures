public class DoublyLL {
    Node head;
    Node tail;

    public void insert(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        Node newNode = new Node(value);
        temp.next = newNode;
        newNode.prev = temp;
        tail = newNode;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printListRev() {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}
