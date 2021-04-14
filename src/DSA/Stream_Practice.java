package DSA;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Practice {

  public static void main(String[] args) {
// ###########################################################################################################################################################################################
    //Java Stream Creation

    //obtain a stream from an existing array:
    String[] arrayOfEmps = {"Ash", "Shinzo", "Shishimaru"};
    ;
    Stream.of(arrayOfEmps);

    //obtain a stream from an existing list:
    List<String> empList = Arrays.asList(arrayOfEmps);
    empList.stream();

    //to create a stream from individual objects using Stream.of():
    Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);

    //Or simply using Stream.builder():
    Stream.Builder<String> empStreamBuilder = Stream.builder();

    empStreamBuilder.accept(arrayOfEmps[0]);
    empStreamBuilder.accept(arrayOfEmps[1]);
    empStreamBuilder.accept(arrayOfEmps[2]);

    Stream<String> empStream = empStreamBuilder.build();

    // ###########################################################################################################################################################################################
    //Java Stream Operations

    //forEach - forEach() is simplest and most common operation; it loops over the stream elements, calling the supplied function on each element.
    //The method is so common that is has been introduced directly in Iterable, Map etc:
    // It is a terminal operation, which means that, after the operation is performed, the stream pipeline is considered consumed, and can no longer be used.
    empList.forEach(System.out::println);
    empList.forEach(a -> System.out.println("Name : " + a));

    //map
    //map() produces a new stream after applying a function to each element of the original stream. The new stream could be of different type.
    //collect() performs mutable fold operations (repackaging elements to some data structures and applying some additional logic, concatenating them, etc.) on data elements held in the Stream instance.
    List<Integer> hash = Stream.of(arrayOfEmps)
        .map(String::length)
        .collect(Collectors.toList());
    hash.forEach(System.out::println);

    List<String> bignames = Stream.of(arrayOfEmps)
        .filter(a->a.length()>3)
        .collect(Collectors.toList());
    bignames.forEach(System.out::println);

    //findFirst() returns an Optional for the first entry in the stream; the Optional can, of course, be empty:
    //Here, the first name of length < 3 is returned. If no such name exists, then null is returned.
    String optionals = Stream.of(arrayOfEmps)
        .filter(a->a.length()<2)
        .findFirst()
        .orElse(null);
    System.out.println(optionals);

    //passing a list as input and getting an array back
    String[] arr = empList.stream().toArray(String[]::new);
    System.out.println(Arrays.toString(arr));

    //flatMap - A stream can hold complex data structures like Stream<List<String>>. In cases like this, flatMap() helps us to flatten the data structure to simplify further operations:
    List<List<String>> namesNested = Arrays.asList(
        Arrays.asList("Jeff", "Bezos"),
        Arrays.asList("Bill", "Gates"),
        Arrays.asList("Mark", "Zuckerberg"));

    List<String> namesFlatStream = namesNested.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
    namesFlatStream.forEach(System.out::println);

    //peek - forEach() earlier in this section is a terminal operation. However, sometimes we need to perform multiple operations on each element of the stream before any terminal operation is applied.
    //peek() can be useful in situations like this. Simply put, it performs the specified operation on each element of the stream and returns a new stream which can be used further.
    // peek() is an intermediate operation:
    namesFlatStream.stream()
        .filter(a->a.length()<5)
        .peek(a-> System.out.println("Name :"+a))
        .collect(Collectors.toList());

    //Method Types and Pipelines
    //A stream pipeline consists of a stream source, followed by zero or more intermediate operations, and a terminal operation.
    //short-circuiting operations - allow computations on infinite streams to complete in finite time:
    Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

    List<Integer> collect = infiniteStream
        .skip(3)
        .limit(5)
        .collect(Collectors.toList());
    collect.forEach(System.out::println);








  }


}