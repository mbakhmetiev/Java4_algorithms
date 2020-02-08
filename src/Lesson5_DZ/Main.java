/*
1. Написать программу по возведению числа в степень с помощью рекурсии.
2. Написать программу «Задача о рюкзаке» с помощью рекурсии
 */

package Lesson5_DZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.zip.DeflaterOutputStream;

public class Main {

    public static ArrayList<ArrayList<Item>> itemsArray = new ArrayList<>();
    public static int maxCost = 0;
    public static int bestIndex = 0;
    public static final int MAX_WEIGTH = 15;

    public static void main(String[] args) {

        // Создаем предметы для загрузки в рюкзак, в который влезает MAX_WEIGTH кг

        Item item1 = new Item(3,5);
        Item item2 = new Item(6,1);
        Item item3 = new Item(1,6);
        Item item4 = new Item(7,15);
        Item item5 = new Item(2,4);

        // ArrayList из предметов
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);

        // Создание перменных для анализа макс стоимости и веса при переборе массива комбинаций
        int sumCostMax = 0;
        int index = 0;

        // Вызов рекурсии котрая создаст массив из возможных комбинаций веса и стоимости предметов

        recPermutation(items.size(), items);

        System.out.println("* * * Вывод нa печать всех возможных перестановок предметов * * * ");
        for(ArrayList<Item> i: itemsArray) {
            for(Item j : i) {
                System.out.print(j.toString() + " ");
            }
            System.out.println();
        }

        // Поиск оптимального - перебираем все комбинации, пока вес не превышает макс, суммируем стоиомсть
        // и вес, фиксируем индекс списка с макс стоимостью

        for(ArrayList<Item> i: itemsArray) {
            int sumWeight = i.get(0).getWeight();
            int sumCost = 0;
            for(int j = 0; j < i.size(); j++) {
                if(sumWeight <= MAX_WEIGTH) {
                    sumCost += i.get(j).getCost();
                    sumWeight += i.get(j+1).getWeight();
                }
            }
            if(sumCost > sumCostMax) {
                sumCostMax = sumCost;
                bestIndex = index;
            }
            index ++;
        }
        System.out.println("* * * Оптимальный вариант по стоимости * * * ");
        System.out.println("BestIndex: " + bestIndex + " BestCost: " + sumCostMax + " " + itemsArray.get(bestIndex));

        System.out.println("* * * Вывод нa печать резузльтатов рекурсивного возведения в степень * * * ");
        System.out.println("recPow(5,0) " + recPow(5,0));
        System.out.println("recPow(5,2) " + recPow(5,2));
    }

    static int recPow (int n, int m) {
        if (m == 0) {
            return 1;
        }
        return recPow(n, m-1) * n;
    }

    // Рекурсия - перебор всех возможных комбинаций заданного числа предметов

    static void recPermutation(int n, ArrayList<Item> items) {
        ArrayList<Item> tempArray = new ArrayList<>();
        if(n == 1) {
            for (int i = 0; i < items.size(); i++) {
                tempArray.add(items.get(i));
            }
            updateArray(tempArray);
        } else {
            for(int i = 0; i < n-1; i++) {
                recPermutation(n - 1, items);
                if(n % 2 == 0) {
                    swap(items, i, n-1);
                } else {
                    swap(items, 0, n-1);
                }
            }
            recPermutation(n - 1, items);
        }
    }

    // Доп метод по перестановке предметов
    static void swap(ArrayList<Item> input, int a, int b) {
        Item tmp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, tmp);
    }

    // Записываем текущую перестановку в итоговый массив
    static void updateArray (ArrayList<Item> items) {
        itemsArray.add(items);
    }
}
