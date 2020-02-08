package Lesson4_DZ;

import java.util.Iterator;

public class WorkLinkedQueue<T> {
    private WorkLinkedListDouble<T> queue = new WorkLinkedListDouble<>();

    public int size() { return queue.getSize(); }

    public boolean isEmpty() { return queue.isEmpty(); }

    public void enqueue(T value) { queue.addFirst(value); }

    public T dequeue() throws ListIsEmptyException { return queue.removeLast(); }

    public T peek() { return queue.getLast(); }

    public String toString() { return queue.toString(); }
}
