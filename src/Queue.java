public class Queue {
    int front = -1;
    int rear = -1;
    int[] arr;
    int count = 0;

    Queue(int length) {
        arr = new int[length];
    }

    void enqueue(int value) {
        if (count == arr.length) {
            System.out.println("Queue Overflow!");
            return;
        }
        if (front == -1)
            front++;
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        count++;
    }

    int dequeue() {
        if (count == 0) {
            System.out.println("Queue Underflow!");
            return Integer.MIN_VALUE;
        }
        int x = arr[front];
        front = (front + 1) % arr.length;
        count--;
        if (count == 0) {
            front = -1;
            rear = -1;
        }
        return x;
    }
}
