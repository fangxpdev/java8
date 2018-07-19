package com.beidou.c2;

import com.beidou.App;
import com.beidou.c1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author beidou
 * @since 18/7/19
 */
public class PredicateTest {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "yellow"),
                new Apple(120, "blue")
        );

        Predicate<Apple> p = (Apple a) -> "red".equals(a.getColor());
        Predicate<Apple> negate = p.negate();
        Predicate<Apple> and = p.and((Apple a) -> a.getWeight() > 150);

        List<Apple> list1 = filterApple(inventory, p);
        System.out.println(list1);
        List<Apple> list2 = filterApple(inventory, negate);
        System.out.println(list2);
        List<Apple> list3 = filterApple(inventory, and);
        System.out.println(list3);

    }


    public static List<Apple> filterApple(List<Apple> list, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
