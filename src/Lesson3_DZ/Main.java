/*
1. Реализовать рассмотренные структуры данных в консольных программах.
2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
3. Создать класс для реализации дека.
 */

package Lesson3_DZ;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        int capacity = 3;
        String text = "Mary had a little lamb";

        for (int i = 0; i < text.length(); i++) {
            chars.add(text.charAt(i));
        }

        for (int i = 0; i < capacity; i++) {
            items.add(new Item(i));
        }

        System.out.println("* * * ITEMS FIFO * * *");
        WorkQueue<Item> queue = new WorkQueue<>(items.size());
        for (Item item : items) {
            queue.add(item);
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println(queue.pop());
        }

        System.out.println("* * * ITEMS LIFO * * *");
        WorkStack<Item> stack = new WorkStack<>(items.size());
        for (Item item : items) {
            stack.add(item);
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println(stack.pop());
        }

        System.out.println("* * * STRING FIFO * * *");
        WorkQueue<Character> charsQueue = new WorkQueue<>(chars.size());
        for (Character character : chars) {
            charsQueue.add(character);
        }
        for (int i = 0; i < chars.size(); i++) {
            System.out.print(charsQueue.pop());
        }
        System.out.println();

        System.out.println("* * * STRING LIFO * * *");
        WorkStack<Character> charsStack = new WorkStack<>(chars.size());
        for (Character character : chars) {
            charsStack.add(character);
        }
        for (int i = 0; i < chars.size(); i++) {
            System.out.print(charsStack.pop());
        }
        System.out.println();

        System.out.println("* * * DECK INSERT LEFT * * *");
        WorkDeck<Item> deck = new WorkDeck<>(items.size());
        for (Item item : items) {
            deck.addLeft(item);
        }
        System.out.println("* * * DECK REMOVE LEFT * * *");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(deck.popLeft());
        }
        for (Item item : items) {
            deck.addLeft(item);
        }
        System.out.println("* * * DECK REMOVE RIGHT * * *");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(deck.popRight());
        }
        System.out.println("* * * DECK INSERT RIGHT * * *");
        WorkDeck<Item> deck2 = new WorkDeck<>(items.size());
        for (Item item : items) {
            deck2.addRight(item);
        }
        System.out.println("* * * DECK REMOVE LEFT * * *");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(deck2.popLeft());
        }
        for (Item item : items) {
            deck2.addRight(item);
        }
        System.out.println("* * * DECK REMOVE RIGHT * * *");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(deck2.popRight());
        }
    }
}
