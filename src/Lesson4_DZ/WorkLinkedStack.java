package Lesson4_DZ;

public class WorkLinkedStack<T> {

    private WorkLinkedListDouble<T> stack = new WorkLinkedListDouble<>();

    public int size() {
        return stack.getSize();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T value) {
        stack.addFirst(value);
    }

    public T remove() throws ListIsEmptyException { return stack.removeFirst(); }

    public T peek() {
        return stack.getFirst();
    }

    public String toString() { return stack.toString(); }
}
