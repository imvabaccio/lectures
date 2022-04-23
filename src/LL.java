public class LL {
    Node head;

    public void insert(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(value);
    }

    public void insertAtPos(int value, int pos) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        if (pos == 0) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        Node newNode = new Node(value);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delete(int pos) {
        if (head == null)
            return;

        if (pos == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            if (temp.next == null) {
                return;
            }
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public Node middle() {
        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void removeNthFromEnd(int n) {
        Node dummy = new Node(1);
        dummy.next = head;

        Node nth = head;

        for (int i = 0; i < n; i++)
            head = head.next;

        Node prev = dummy;

        while (head != null) {
            prev = nth;
            nth = nth.next;
            head = head.next;
        }
        prev.next = nth.next;
        head = dummy.next;
    }

    public int deleteHead() {
        int x = head.value;
        head = head.next;
        return x;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
