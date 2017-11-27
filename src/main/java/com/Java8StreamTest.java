package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pjai60 on 11/23/2017.
 */
public class Java8StreamTest {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        l.stream().filter(s -> s > 3).map(s -> s++).sorted().collect(Collectors.toList()).forEach(System.out::println);
    }
}
