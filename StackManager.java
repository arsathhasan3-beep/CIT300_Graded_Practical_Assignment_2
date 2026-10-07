public class StackManager {
    private final int[] stack;
    private int top;

    public StackManager(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow. Stack is full.");
            return false;
        }

        stack[++top] = value;
        return true;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Cannot pop from an empty stack.");
            return null;
        }

        return stack[top--];
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top value.");
            return null;
        }

        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("| " + stack[i] + " |");
        }
        System.out.println("-----");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }
}
