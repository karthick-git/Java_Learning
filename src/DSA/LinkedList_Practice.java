package DSA;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class LinkedList_Practice {

  //Works similar to ArrayList
  public static void main(String[] args) {
    List<String> list1 = new LinkedList<>();
    list1.add("ABC");
    list1.add("DEF");

    list1.add(2, null);
    System.out.println(list1.contains(null));

    List<String> list2 = new LinkedList<>();
    list2.add("GHI");
    list2.add("JKL");
    list1.addAll(list2);
    System.out.println(list1.stream()
        .collect(Collectors.joining(",")));

    list1.removeAll(list2);
    System.out.println(list1.stream()
        .collect(Collectors.joining(",")));

    list1.addAll(1, list2);
    System.out.println(list1.stream()
        .collect(Collectors.joining(",")));

    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.addLast(3);
    linkedList.add(2);
    linkedList.addFirst(0);
    linkedList.forEach(a -> System.out.print(a + ",")); // prints 0,1,3,2

    LinkedList<Integer> dup = (LinkedList) linkedList.clone();
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    System.out.println(dup.contains(2));

    //Prints the elements in reverse order
    Iterator<Integer> itr = linkedList.descendingIterator();
    while (itr.hasNext()) {
      System.out.println(linkedList.element());//prints the first element
      System.out.println(itr.next());
    }

    System.out.println(list1.get(2));
    System.out.println(linkedList.getFirst());
    System.out.println(linkedList.getLast());
    System.out.println(list1.indexOf("ABC"));
    System.out.println(linkedList.lastIndexOf(3));

    ListIterator<Integer> listIterator = dup.listIterator();
    while (listIterator.hasPrevious()) {
      System.out.println("elements in the reverse order : " + listIterator.previous());
    }

    dup.offerFirst(5);
    dup.offerLast(7);
    dup.offer(6);// difference between add and offer is that when element can not be added to collection the add method throws an exception and offer doesn't. offer returns true or false.
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    System.out.println(dup.peek());
    System.out.println(dup.peekFirst());
    System.out.println(dup.peekLast());

    //both peek and get does the same, then why two methosd
    //Both of them get the pointer to the First element in the LinkedList without making any changes to it.
    // Then, what's the difference ? The only difference I see is that peekFirst returns null if the list is empty and getFirst throws a NoSuchElementException if the list is empty.

    dup.poll();
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    dup.pollFirst();
    dup.pollLast();
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();//poll Retrieves and removes the head (first element) of this list.

    dup.pop(); // pop removes and returns the first element of this list.
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    dup.push(9);// push - inserts the element at the front of this list.
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    dup.removeFirst();
    dup.remove();
    dup.removeLast();
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    dup.offerFirst(1);
    dup.offerLast(1);
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    dup.removeFirstOccurrence(1);
    dup.removeLastOccurrence(1);
    dup.forEach(a -> System.out.print(a + ","));
    System.out.println();

    dup.set(0, 5);
    dup.push(0);
    System.out.println(dup.size());

    Spliterator<Integer> spliterator = dup.spliterator();
    spliterator.forEachRemaining(a -> System.out.println(a));

  }


}