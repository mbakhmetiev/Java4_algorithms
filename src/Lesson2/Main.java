package Lesson2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    static Random rand = new Random();

    public static void main(String[] args) {
//        MyArrayList<Integer> mal = new MyArrayList<>();
//
//        for (int i = 0; i < 5 ; i++) {
//            mal.add(i+5);
//        }
//
//        mal.add(1,89);
//
//        System.out.println(mal);
//        mal.remove(3);
//        System.out.println(mal);
//
//        System.out.println(mal.indexOf(6));
//
//        mal.remove(new Integer(8));
//        System.out.println(mal);


//        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
//
//        msal.add(6);
//        msal.add(9);
//        msal.add(2);
//        msal.add(1, 8);
//        System.out.println(msal);
//
//        System.out.println(msal.binaryFind(88));


//        MyArrayList<Integer> mal = new MyArrayList<>(10);
////
//        for (int i = 0; i < 10 ; i++) {
//            mal.add(rand.nextInt(100));
//        }
//
//        System.out.println(mal);
////        mal.selectionSort();
////        mal.insertionSort();


        MyArrayList<Box> boxes = new MyArrayList<>(10);

        for (int i = 0; i < 7; i++) {
            boxes.add(new Box(rand.nextInt(10), rand.nextInt(10)));
        }
        System.out.println(boxes);
//        boxes.bubbleSort(Comparator.comparingInt(a->a.getY()));
//        boxes.bubbleSort(Comparator.comparingInt(a->a.getX()*a.getY()));
//        boxes.bubbleSort((a, b) -> a.getX()- b.getX());
//        boxes.bubbleSort(Comparator.comparing(Box::getY).reversed());
        boxes.bubbleSort(Comparator.comparingInt(Box::getX)
                .thenComparingInt(Box::getY));
        System.out.println(boxes);

    }
}
