package Lesson3_DZ;

import java.util.EmptyStackException;

public class WorkStack<T> {

    private T[] arr;
    private int currentIndex;

    public WorkStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        arr = (T[]) new Object[capacity];
        currentIndex = 0;
    }

    public boolean isFull() {
        return currentIndex == arr.length;
    }

    public boolean isEmpty() {
        return currentIndex == 0;
    }

    public void add(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        for (int i = currentIndex; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        currentIndex++;
    }

    public T pop() {
        T temp = read();
        for (int i = 0; i < currentIndex -1 ; i++) {
            arr[i] = arr[i+1];
        }
        arr[currentIndex-1] = null;
        currentIndex--;
        return temp;
    }

    public T read () {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[0];
    }
}
