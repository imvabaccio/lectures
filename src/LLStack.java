import java.util.LinkedList;

public class LLStack {
    LL list = new LL();

    boolean isEmpty() {
        return list.head == null;
    }

    void push(int value) {
        list.insertAtPos(value, 0);
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return Integer.MIN_VALUE;
        }
        return list.deleteHead();
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return Integer.MIN_VALUE;
        }
        return list.head.value;
    }
}
