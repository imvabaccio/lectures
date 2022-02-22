public class CircularLL {
    public Node head;

    public void insert(int value) {
        if (head == null) {
            head = new Node(value);
            head.next = head;
            return;
        }

        Node temp = head.next;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = new Node(value);
        temp.next.next = head;
    }

    public void delete(int pos) {
        if (head == null)
            return;

        if (pos == 0) {
            if (head.next == head) {
                head = null;
                return;
            }

            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            head = temp.next;
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            if (temp.next == head) {
                return;
            }
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void printList() {
        Node temp = head;

        System.out.print(temp.value + " ");
        temp = temp.next;
        while (temp != head) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
