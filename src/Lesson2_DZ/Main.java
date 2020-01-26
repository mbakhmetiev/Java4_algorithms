/*
1. Создать массив большого размера (миллион элементов).
2. Написать методы удаления, добавления, поиска элемента массива.
3. Заполнить массив случайными числами.
4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 */

package Lesson2_DZ;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(100000);

        long start = System.currentTimeMillis();
        arr.bubbleSort();
        System.out.println(System.currentTimeMillis() - start);
        arr.shuffle();
        start = System.currentTimeMillis();
        arr.selectionSort();
        System.out.println(System.currentTimeMillis() - start);
        arr.shuffle();
        start = System.currentTimeMillis();
        arr.insertionSort();
        System.out.println(System.currentTimeMillis() - start);
    }
}
