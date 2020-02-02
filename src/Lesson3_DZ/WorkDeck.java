package Lesson3_DZ;

import java.util.EmptyStackException;

public class WorkDeck<T> {

    private T[] arr;
    private int currentIndex;

    public WorkDeck(int capacity) {
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

    public void addLeft(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        for (int i = currentIndex; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        currentIndex++;
    }

    public void addRight(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        arr[currentIndex] = value;
        currentIndex++;
    }

    public T popRight() {
        T temp = readRight();
        arr[currentIndex-1] = null;
        currentIndex--;
        return temp;
    }

    public T readRight() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[currentIndex-1];
    }

    public T popLeft() {
        T temp = readleft();
        for (int i = 0; i < currentIndex -1 ; i++) {
            arr[i] = arr[i+1];
        }
        arr[currentIndex-1] = null;
        currentIndex--;
        return temp;
    }

    public T readleft() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[0];
    }
}


