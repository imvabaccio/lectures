public class Dequeue {
    Node front;
    Node rear;

    int size;

    public Dequeue() {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void insertFront(int val) {
        Node newNode = new Node(val);
        size++;
        if (isEmpty()) {
            front = newNode;
            rear = front;
            return;
        }

        newNode.next = front;
        front = newNode;
    }

    public void insertRear(int val) {
        Node newNode = new Node(val);
        size++;
        if (this.isEmpty()) {
            front = newNode;
            rear = front;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        size--;
        front = front.next;

        if (front == null)
            rear = null;
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        if (size == 1) {
            front = null;
            rear = null;
            size--;
            return;
        }

        size--;
        Node temp = front;

        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }

        rear = temp;
        rear.next = null;
    }

    public void printList() {
        Node temp = front;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
