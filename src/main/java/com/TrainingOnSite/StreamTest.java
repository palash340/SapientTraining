package com.TrainingOnSite;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pjai60 on 10/4/2017.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(new String[]{"and", "or", "sun", "float", "boolean"});
        //stringList.stream().map(str -> str.length()).filter(length ->  length > 3).limit(2).forEach(System.out::println);
        final Map<String, Integer> hmap = new HashMap<String, Integer>();

        //Problem 1


        // Problem 6
        String[] lines = new String[]{"I am test", "I Can See", "None of Me"};
        Arrays.asList(lines).stream().flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting())).forEach((k, v) -> System.out.println("Word = " + k + ", Count = " + v));
    }
}

class Cars {
    String fualType;
    String transmissionType;

}
