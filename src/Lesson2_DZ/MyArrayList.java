package Lesson2_DZ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MyArrayList<T extends Comparable> {
    private T[] arr;
    private T[] arr1;
    private T[] arr2;
    static Random rand = new Random();

    public MyArrayList (int _size) {
        arr = (T[]) new Comparable[_size];
        for (int i = 0; i < _size ; i++) {
            arr[i] = (T) new Integer(rand.nextInt(1000));
        }
        this.arr2 = (T[]) new Comparable[arr.length];
        System.arraycopy(arr, 0 , arr2, 0 , arr.length);
    }

    public void add(T item) {
        arr1 = (T[]) new Comparable[arr.length +1];
        for (int i = 0; i < arr.length ; i++) {
            arr1[i] = arr[i];
        }
        arr = arr1;
        arr[arr.length-1] = item;
    }

    public void remove() {
        arr1 = (T[]) new Comparable[arr.length -1];
        for (int i = 0; i < arr.length - 1 ; i++) {
            arr1[i] = arr[i];
        }
        arr = arr1;
    }

    public void remove(int index) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("Argument out of range") ;
        }
        arr1 = (T[]) new Comparable[arr.length -1];
        for (int i = 0; i < arr.length - 1 ; i++) {
            arr1[i] = arr[i];
        }
        for (int i = index; i < arr1.length  ; i++) {
            arr1[i] = arr[i + 1];
        }
        arr = arr1;
    }

    public int find(T item) {
        for (int j = 0; j < arr.length; j++) {
            if(item.equals(arr[j])) return j;
        }
        return -1;
    }

    public void swap (int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void bubbleSort() {
        for (int i = arr.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j+1].compareTo(arr[j]) < 0) {
                    swap (j + 1, j);
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i <arr.length - 1; i ++) {
            int minItem = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minItem]) < 0) {
                    minItem = j;
                }
            } swap (i, minItem);
        }
    }

    public void insertionSort() {
        T key;
        for(int i = 0; i < arr.length; i++) {
            int j = i;
            key = arr[i];
            while (j > 0 && key.compareTo(arr[j-1]) < 0) {
                arr[j] = arr [j -1];
                j--;
            }
            arr[j] = key;
        }
    }

    public void shuffle () {
        System.arraycopy(arr2, 0 , arr, 0 , arr2.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i] + ", ");
        }
        sb.append(arr[arr.length - 1] + " ]");
        return sb.toString();
    }




}
