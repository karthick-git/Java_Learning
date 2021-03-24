package com.roughnote.ash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ScratchPad2 {

  public static void main(String[] args) {

//    Things to note
//    (1) List<?> myList = new ArrayList<?>();
//    (2) ArrayList<?> myList = new ArrayList<?>();
//    Why use option 1 instead of 2
//    Almost always List is preferred over ArrayList because, for instance, List can be translated into a LinkedList without affecting the rest of the codebase.
//    If one used ArrayList instead of List, it's hard to change the ArrayList implementation into a LinkedList one because
//    ArrayList specific methods have been used in the codebase that would also require restructuring.

    List<String> list1=new ArrayList<>();//Creating arraylist
    list1.add("Ravi");//Adding object in arraylist
    list1.add("Vijay");
    list1.add(2,"ash"); // adding an object at an index (index specified cannot exceed size value, otherwise indexoutofbound will be thrown)

//    //ways of printing objects in an arraylist
//    // Conventional way of printing arraylist
    for (String names : list1) {
      System.out.println(names);
    }

    // Lambda Expression to print arraylist - Way 1
    list1.forEach((String value) -> System.out.println(value));

    // Lambda Expression to print arraylist - Way 2
    list1.forEach(value -> System.out.println(value));

    // Lambda Expression (method reference) to print arraylist - Way 3
    list1.forEach(System.out::println);
    System.out.println();

    List<String> list2=new ArrayList<>();//Creating arraylist
    list2.add("Ravi");//Adding object in arraylist
    list2.add("Ajay");
    list2.forEach(System.out::println);
    System.out.println();

    list1.addAll(list2);//adding all elements of list 2 to list 1
    list1.forEach(System.out::println);
    System.out.println();

    list1.remove("Ravi");
    list1.remove(0);
    list1.forEach(System.out::println);
    System.out.println();

    list1.removeAll(list2);//removing all elements of list 2 from list 1
    list1.forEach(System.out::println);

    list1.clear();//clears all the elements of list 1
    list1.forEach(System.out::println);
    System.out.println();

    List<String> list1=new ArrayList<>();//Creating arraylist
    list1.add("Ravi");//Adding object in arraylist
    list1.add("Vijay");
    list1.add("Ash");

    List<String> list2=new ArrayList<>();//Creating arraylist
    list2.add("Ravi");//Adding object in arraylist
    list2.add("Vijay");

    System.out.println(list1.contains("Ash"));// check if list1 contains an object -> returns true
    System.out.println(list1.contains("ash"));// check if list1 contains an object -> returns false
    System.out.println(list1.contains(list2));// check if list1 contains list 2 -> returns false->works only for specified element, not entire list

    System.out.println(list1.containsAll(list2));// check if list1 contains list 2 -> true

    System.out.println(list1.equals(list2));// returns false since list2 contains Ash additionally
    list2.add("Ash");
    System.out.println(list1.equals(list2));// now it returns true
    System.out.println(list1.hashCode()); // hashcode of list 1 and 2 will be same since elements and order are same
    System.out.println(list2.hashCode());

    list2.remove("Ash");
    list2.add(0,"Ash");
    System.out.println(list1.equals(list2));// returns false since equals method matches both order and elements

    System.out.println(list1.hashCode());// hashcode of list 1 and 2 will be different since elements and order are not same
    System.out.println(list2.hashCode());

    list2.clear();
    System.out.println(list2.isEmpty());//returns true since list is empty

    list2.add(null);
    list2.forEach(System.out::println);
    System.out.println(list2.isEmpty());//returns true since list is not empty

    //printing the elements of a list with iterator interface
    Iterator<String> iterator = list1.iterator();
    //Returns an iterator over the elements
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    //removeIf accepts a predicate and removes elements if the condition is satisfied
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i < 21; i++) {
      list.add(i);
    }
    list.forEach(System.out::println);
    Predicate<Integer> pr = a -> (a % 2 != 0);
    list.removeIf(pr);
    list.forEach(System.out::println);

      //retainAll keeps only those elements in this queue that are present in the specified collection.
    List<Character> list1 = new ArrayList<>();
    for (char i = 'a'; i <= 'z'; i++) {
      list1.add(i);
    }
    List<Character> list2 = List.of('a', 'b'); //declaring an immutable list in java 9
    List<Character> list2 = Arrays.asList('a', 'b', 'c'); //declaring an immutable list in java 8 or before
    var list2 = List.of('a', 'b', 'c', 'd'); //declaring an immutable list in java 10 or later

    list1.retainAll(list2);
    list1.forEach(System.out::println);
  }

    System.out.println(list2.size()); //prints the size of a list

  }
}