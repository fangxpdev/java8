package com.beidou.c2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author beidou
 * @since 18/7/18
 */
public class ConsumerTest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 23, 45, 63, 11, 7);

        list.forEach(System.out::println);

        list.forEach((Integer i) -> System.out.println(i));

        forEach(list, System.out::println);

        forEach(list, (Integer i) -> System.out.println(i));

        forEach(list, (i) -> System.out.println(i));

        forEach(list, i -> System.out.println(i));

    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

}
