import java.util.Arrays;

public class ArrayManager {
    private final int[] data;
    private int size;

    public ArrayManager(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public boolean insertAtEnd(int value) {
        if (isFull()) {
            System.out.println("Array is full. Cannot insert.");
            return false;
        }

        data[size] = value;
        size++;
        return true;
    }

    public boolean insertAtPosition(int position, int value) {
        if (isFull()) {
            System.out.println("Array is full. Cannot insert.");
            return false;
        }

        if (position < 0 || position > size) {
            System.out.println("Invalid position.");
            return false;
        }

        for (int i = size; i > position; i--) {
            data[i] = data[i - 1];
        }

        data[position] = value;
        size++;
        return true;
    }

    public boolean deleteByValue(int value) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return true;
    }

    public SearchResult search(int target) {
        return SearchAlgorithms.linearSearch(toArray(), target);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.println("Array: " + Arrays.toString(toArray()));
        System.out.println("Size : " + size + " / " + data.length);
    }

    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
