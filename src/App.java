import java.util.Scanner;

public class App {

    public static void removeCycle(Node head, Node fast) {
        Node s = fast.next;
        int count = 1;

        while (s != fast) {
            s = s.next;
            count++;
        }

        Node y = head;

        for (int i = 0; i < count; i++)
            y = y.next;

        Node x = head;

        while (y != x) {
            x = x.next;
            y = y.next;
        }

        for (int i = 0; i < count - 1; i++)
            y = y.next;

        y.next = null;
    }

    public static boolean detectAndRemove(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeCycle(head, fast);
                return true;
            }
        }

        return false;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void callsItself() {
        System.out.println("Hello");
        callsItself();
    }

    public static int fact(int x) {
        if (x == 1)
            return 1; // base case
        return x * fact(x - 1);
    }

    public static int fib(int x) {
        if (x <= 1) {
            return x;
        }
        return fib(x - 2) + fib(x - 1);
    }

    public static int fibIterative(int x) {
        if (x <= 1) {
            return x;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= x; i++) {
            int temp = b;
            b = b + a;
            a = temp;
        }
        return b;
    }

    static int hcf(int a, int b) {
        if (b == 0) {
            return a;
        }
        return hcf(b, a % b);
    }

    public static int minSteps(int n) {
        if (n == 1)
            return 0;

        int div3 = Integer.MAX_VALUE;
        int div2 = Integer.MAX_VALUE;
        int sub1 = Integer.MAX_VALUE;

        if (n % 3 == 0) {
            div3 = 1 + minSteps(n / 3);
        } else if (n % 2 == 0) {
            div2 = 1 + minSteps(n / 2);
        } else {
            sub1 = 1 + minSteps(n - 1);
        }

        return Math.min(sub1, Math.min(div3, div2));
    }

    public static void main(String[] args) {
        BST tree = new BST();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            switch (sc.nextInt()) {
                case 1:
                    tree.insert(sc.nextInt());
                    break;
                case 2:
                    tree.inOrder(tree.root);
                    break;
                case 3:
                    tree.postOrder(tree.root);
                    break;
                case 4:
                    tree.preOrder(tree.root);
                    break;
                case 5:
                    tree.root = tree.delete(tree.root, sc.nextInt());
                    break;
            }
        }
    }
}