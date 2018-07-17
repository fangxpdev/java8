package com.beidou.c1;

import com.beidou.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author beidou
 * @since 18/7/16
 */
public class AppleFilter {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> apples1 = filterGreenAppless(inventory);
        System.out.println(apples1);

        List<Apple> apples2 = filterHeavyAppless(inventory);
        System.out.println(apples2);

        List<Apple> apples3 = filterApples(inventory, AppleFilter::isGreenApple);
        System.out.println(apples3);

        List<Apple> apples4 = filterApples(inventory, AppleFilter::isHeavyApple);
        System.out.println(apples4);

        List<Apple> apples5 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(apples5);

        List<Apple> apples6 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(apples6);

        List<Apple> apples7 = filterApples(inventory, (a) -> a.getWeight() > 150);
        System.out.println(apples7);

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        Thread t = new Thread(() -> System.out.println("hello world"));
        t.start();


    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static List<Apple> filterGreenAppless(List<Apple> inventory) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyAppless(List<Apple> inventory) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }


}
