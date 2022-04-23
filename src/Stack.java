// public class Stack {
// private int top = -1;
// private int[] arr;
// private int length = 5;

// Stack() {
// arr = new int[length];
// }

// boolean isEmpty() {
// return top == -1;
// }

// boolean isFull() {
// return top == (arr.length - 1);
// }

// void push(int value) {
// if (isFull()) {
// length = length * 2;
// int[] newArr = new int[length];
// for (int i = 0; i < arr.length; i++) {
// newArr[i] = arr[i];
// }
// arr = newArr;
// }
// arr[++top] = value;
// }

// int pop() {
// if (isEmpty()) {
// System.out.println("Stack Underflow!");
// return Integer.MIN_VALUE;
// }
// return arr[top--];
// }

// void peek() {
// if (isEmpty()) {
// System.out.println("Stack Underflow!");
// return;
// }
// System.out.println(arr[top]);
// }
// }
