public class App {

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node result = new Node();
        Node head = result; // copy

        int carry = 0;

        while (l1 != null && l2 != null) {
            result.next = new Node((l1.value + l2.value + carry) % 10);
            carry = (l1.value + l2.value + carry) / 10;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            result.next = new Node((l1.value + carry) % 10);
            carry = (l1.value + carry) / 10;
            result = result.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            result.next = new Node((l2.value + carry) % 10);
            carry = (l2.value + carry) / 10;
            result = result.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            result.next = new Node(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.insert(9);
        l1.insert(9);
        l1.insert(9);
        l1.insert(9);

        l1.printList();

        l2.insert(9);
        l2.insert(9);
        l2.insert(9);

        l2.printList();

        LinkedList result = new LinkedList();
        result.head = addTwoNumbers(l1.head, l2.head);

        result.printList();
    }
}