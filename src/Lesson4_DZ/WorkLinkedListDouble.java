package Lesson4_DZ;

import Lesson4.MyLinkedList;

import java.util.*;

public class WorkLinkedListDouble<T> implements Iterable<T> {
    private Node firstNode;
    private Node lastNode;
    private int size;

    public int getSize() { return size; }

    public void addLast(T value) {
        this.lastNode = new Node(value);
        if(isEmpty()) {
            this.firstNode = new Node(value);
        } else {
            Node temp = firstNode;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(lastNode);
            lastNode.setPrev(temp);

        }
        size++;
    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            this.lastNode = newNode;
        } else {
            firstNode.setPrev(newNode);
        }
        newNode.setNext(firstNode);
        firstNode = newNode;
        size++;
    }

    public void add(int idx, T value) {
        if(idx < 0 || idx > size ) {
            throw new IndexOutOfBoundsException();
        }

        if (idx == 0) {
            addFirst(value);
            return;
        }

        if (idx == size) {
            addLast(value);
            return;
        }

        Node temp = firstNode;
        int currentIdx = 0;
        while (currentIdx < idx - 1) {
            temp = temp.getNext();
            currentIdx++;
        }
        Node newNode = new Node(value);
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        temp.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        size++;
    }

    public T removeFirst() throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }
        Node currentFirstNode = firstNode;
        firstNode = firstNode.getNext();
        if(isEmpty()) {
            this.lastNode = null;
        } else {
            firstNode.setPrev(null);
        }
        size--;
        return (T) currentFirstNode.getValue();
    }

    public T removeLast() throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        } else if (firstNode.getNext() == null) {
            T tempLast = (T) firstNode.getValue();
            firstNode = firstNode.getNext();
//            firstNode = null;
            return tempLast;
        }
        else {
            this.lastNode = firstNode;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }
            T tempLast = (T) lastNode.getValue();
            lastNode.getPrev().setNext(null);
            size--;
            return tempLast;
        }
    }

    public void remove(int index) {
        if(index == 0) {
            firstNode = firstNode.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = firstNode;

        while (temp != null) {
            if(currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public T pop (T value) throws ListIsEmptyException, NoSuchElementException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }
        if (firstNode.getValue().equals(value)) {
            T temp = (T) firstNode.getValue();
            removeFirst();
            return temp;
        } else {
            Node temp = firstNode;
            while (temp.getNext() != null) {
                if (temp.getNext().getValue().equals(value)) {
                    T popTemp = (T) temp.getNext().getValue();
                    temp.setNext(temp.getNext().getNext());
                    return popTemp;
                }
                if (temp == lastNode) {
                    removeLast();
                }
                temp = temp.getNext();
            }
        }
        throw new NoSuchElementException();
    }

    public T getFirst() {
        return (T) firstNode.getValue();
    }

    public T getLast() {
        this.lastNode = firstNode;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        return (T) lastNode.getValue();
    }

    public int indexOf(T value) {
        Node temp = firstNode;
        int idx = 0;
        while (temp != null) {
            if(temp.getValue().equals(value)) {
                return idx;
            }
            temp = temp.getNext();
            idx++;
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) > -1;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public String toString() {
        ArrayList<T> result = new ArrayList<>();
        Node temp = firstNode;
        while (temp != null) {
            result.add((T) temp.getValue());
            temp = temp.getNext();
        }
        return Arrays.toString(result.toArray());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {

        Node node = new Node(null, firstNode);

        @Override
        public boolean hasNext() {
            return node.getNext() != null;
        }

        @Override
        public T next() {
            node = node.getNext();
            return (T) node.getValue();
        }
    }

    private static class Node <T> {
        private T value;
        private Node next;
        private Node prev;

        public Node (T value) {
            this.value = value;
        }

        public Node (T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node prev, T value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() { return prev; }

        public void setPrev(Node prev) { this.prev = prev; }
    }

}
