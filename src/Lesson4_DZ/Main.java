/*
1. Реализовать все классы, рассмотренные в данном уроке.
2. В методе main LinkIteratorApp проверить все методы итератора.
3. Реализовать стек
4***. Реализовать ListIterator
 */

package Lesson4_DZ;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws ListIsEmptyException {
        WorkLinkedListSingle<String> mall = new WorkLinkedListSingle<>();
        mall.addLast("aaa");
        mall.addLast("bbb");
        mall.addLast("ccc");
        mall.addLast("ddd");
        mall.addLast("yyy");
        System.out.println("mall, Addlast -> " + mall.toString());

        WorkLinkedListSingle<String> mall2 = new WorkLinkedListSingle<>();
        mall2.addFirst("aaa");
        mall2.addFirst("bbb");
        mall2.addFirst("ccc");
        mall2.addFirst("ddd");
        System.out.println("mall2, Addfirst -> " + mall2.toString());

        System.out.println("mall.removeFirst() -> " + mall.removeFirst());
        System.out.println("mall.pop('bbb') -> " + mall.pop("bbb"));
        System.out.println("mall.toString() -> " + mall.toString());
        System.out.println("mall.removeLast() -> " + mall.removeLast());
        System.out.println("mall.removeLast() -> " + mall.removeLast());
        System.out.println("mall.toString() -> " + mall.toString());
        System.out.println("mall2.removeFirst() -> " + mall2.removeFirst());
        System.out.println("mall2.toString() -> " + mall2.toString());
        System.out.println("mall.getFirst() -> " + mall.getFirst());
        System.out.println("mall2.getFirst() -> "+ mall2.getFirst());
        System.out.println("mall.indexOf('ddd') -> " + mall.indexOf("ddd"));
        System.out.println("mall2.indexOf('aaa') -> " + mall2.indexOf("aaa"));
        System.out.println("mall2.contains('yyy') -> " + mall2.contains("yyy"));
        System.out.println("mall2.contains('aaa') -> " + mall2.contains("aaa"));
        mall.add(1,"qqq");
        System.out.println("mall.add(1,'qqq') -> " + mall.toString());
        mall.remove(1);
        System.out.println("mall.remove(1) -> " + mall.toString());
        mall.remove(0);
        System.out.println("mall.remove(0) -> " + mall.toString());

        WorkLinkedListDouble<Integer> mallD1 = new WorkLinkedListDouble<>();
        mallD1.addFirst(1);
        mallD1.addFirst(2);
        mallD1.addFirst(3);
        System.out.println(mallD1.toString());
        mallD1.addFirst(11);
        mallD1.addLast(22);
        mallD1.addLast(33);
        mallD1.addLast(44);
        System.out.println(mallD1.toString());
        mallD1.removeFirst();
        System.out.println(mallD1.toString());
        System.out.println("mallD1.removeLast() -> " + mallD1.removeLast());
        mallD1.add(2, 999);
        System.out.println(mallD1.toString());
        mallD1.add(6, 999);
        System.out.println(mallD1.toString());
        System.out.println("mallD1.pop(3) -> " + mallD1.pop(3));
        System.out.println(mallD1.toString());
        System.out.println("mallD1.pop(999) -> " + mallD1.pop(999));
        System.out.println(mallD1.toString());

        for(int i : mallD1) System.out.print(i + " ");
        System.out.println();

        Iterator<Integer> iterator = mallD1.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        WorkLinkedQueue<Integer> queue = new WorkLinkedQueue<>();
        queue.enqueue(111);
        queue.enqueue(222);
        queue.enqueue(333);
        queue.enqueue(444);
        System.out.println("queue.toString() -> " + queue.toString());
        System.out.println("queue.dequeue() ->  " + queue.dequeue());
        System.out.println("queue.peek() ->  " + queue.peek());

        WorkLinkedStack<Character> stack = new WorkLinkedStack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');;
        System.out.println("stack.toString() -> " + stack.toString());
        System.out.println("stack.remove() ->  " + stack.remove());
        System.out.println("stack.peek() ->  " + stack.peek());
    }
}
