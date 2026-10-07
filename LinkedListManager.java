public class LinkedListManager {

    private Node head;

    private static class Node {
        private final int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public boolean deleteByValue(int value) {
        if (head == null) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        return true;
    }

    public SearchResult search(int target) {
        long startTime = System.nanoTime();

        Node current = head;
        int index = 0;
        int steps = 0;

        while (current != null) {
            steps++;

            if (current.data == target) {
                long endTime = System.nanoTime();
                return new SearchResult(true, index, steps, endTime - startTime);
            }

            current = current.next;
            index++;
        }

        long endTime = System.nanoTime();
        return new SearchResult(false, -1, steps, endTime - startTime);
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        System.out.print("Linked List: ");

        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println(" -> null");
    }
}
