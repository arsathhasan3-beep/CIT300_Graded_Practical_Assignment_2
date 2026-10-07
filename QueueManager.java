public class QueueManager {
    private final int[] queue;
    private int front;
    private int rear;
    private int count;

    public QueueManager(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue overflow. Queue is full.");
            return false;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        count++;
        return true;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue from an empty queue.");
            return null;
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        count--;
        return value;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front value.");
            return null;
        }

        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (front -> rear): ");

        for (int i = 0; i < count; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index]);

            if (i < count - 1) {
                System.out.print(" <- ");
            }
        }

        System.out.println();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }
}
