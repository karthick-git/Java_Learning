package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

  public static void main(String[] args) {
    String words = "this is4 refence words52 try2 solve10";
    int b = 0;

    //Add digits in a string - Method 1
//    String[] arrStrings = words.split("");
//    String regex = ".*\\d.*";
//    for(String a:arrStrings){
//      if(a.matches(regex))
//        b +=Integer.parseInt(a);
//    }

    //Add digits in a string - Method 2
//    for (int i = 0; i < words.length(); i++) {
//      if (Character.isDigit(words.charAt(i))) {
//        b += Character.getNumericValue(words.charAt(i));
//      }
//    }

//    Consider consecutive digits as on number
//    String temp = "0";
//    for (int i = 0; i < words.length(); i++) {
//      if (Character.isDigit(words.charAt(i))) {
//        temp+= words.charAt(i);
//      } else {
//        b += Integer.parseInt(temp);
//        temp="0";
//      }
//    }
//    b += Integer.parseInt(temp); // to handle the scenario where the string ends with a number
//
//    Find the second highest number in a list
//    ArrayList<Integer> a = new ArrayList<>();
//    a.add(100);
//    a.add(200);
//    a.add(300);
//    a.add(400);
//    Collections.sort(a);
//    System.out.println(a.get(a.size()-2));

//Check whether two strings are palindrome
//    String a = "malayalam";
//    StringBuilder sb = new StringBuilder();
//    for (int i = a.length() - 1; i >= 0; i--) {
//      sb.append(a.charAt(i));
//    }
//    System.out.println(sb);
//    if (sb.toString().equals(a)) {
//      System.out.println("It is a palindrome");
//    } else {
//      System.out.println("It is not a palindrome");
//    }
//
//    System.out.println(b);

//Check whether the string contains only numbers
//    String a = "123";
//    IntStream intStream = a.chars();
//    System.out.println(intStream.anyMatch(Character::isDigit));

    //Reverse each word in a string
    String a = "My name is Ash!";

    //Method 1 - using stringbuilder
//    String rev = "";
//    String[] arr = a.split(" ");
//    StringBuilder stringBuilder = new StringBuilder();
//    for (String word : arr) {
//      for (int i = word.length() - 1; i >= 0; i--) {
//        rev += word.charAt(i);
//      }
//      rev+=" ";
//    }
//    stringBuilder.append(rev);
//    System.out.println(stringBuilder.toString().trim());

    //Method 2 - using stream
    Pattern pattern = Pattern.compile(" ");
    Stream<String> stream = pattern.splitAsStream(a);
    Stream<StringBuilder> stringBuilderStream = stream.map(word -> new StringBuilder(word).reverse());
    String output = stringBuilderStream.collect(Collectors.joining(" "));
    System.out.println(output);

  }
}