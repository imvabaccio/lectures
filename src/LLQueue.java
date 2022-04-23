public class LLQueue {
    Node front, rear;

    void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = rear.next;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow!");
            return Integer.MIN_VALUE;
        }
        Node temp = front;
        front = front.next;
        return temp.value;
    }
}
