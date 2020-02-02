package Lesson4_DZ;

import Lesson4.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class WorkLinkedListSingle<T> {
    private Node firstNode;
    private int size;

    public void addLast(T value) {
        if(isEmpty()) {
            this.firstNode = new Node(value);
        } else {
            Node temp = firstNode;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
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

        Node temp = firstNode;
        int currentIdx = 0;
        while (currentIdx < idx - 1) {
            temp = temp.getNext();
            currentIdx++;
        }
        Node newNode = new Node(value);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;
    }

    public T removeFirst() throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }
        Node currentFirstNode = firstNode;
        firstNode = firstNode.getNext();
        size--;
        return (T) currentFirstNode.getValue();
    }

    public T removeLast() throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        } else if (firstNode.getNext() == null) {
            T tempLast = (T) firstNode.getValue();
            firstNode = null;
            return tempLast;
        }
        else {
            Node last = firstNode;
            Node beforelast = firstNode;
            while (last.getNext() != null) {
                beforelast = last;
                last = last.getNext();
            }
            T tempLast = (T) last.getValue();
            beforelast.setNext(null);
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
            firstNode = firstNode.getNext();
            return temp;
        } else {
                Node temp = firstNode;
                while (temp.getNext() != null) {
                    if (temp.getNext().getValue().equals(value)) {
                        T popTemp = (T) temp.getNext().getValue();
                        temp.setNext(temp.getNext().getNext());
                        return popTemp;
                    }
                    temp = temp.getNext();
                }
        }
        throw new NoSuchElementException();
    }

    public T getFirst() {
        return (T) firstNode.getValue();
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

    private static class Node <T> {
        private T value;
        private Node next;

        public Node (T value) {
            this.value = value;
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
    }

}
