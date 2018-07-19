package com.beidou.c2;

import com.beidou.App;
import com.beidou.c1.Apple;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author beidou
 * @since 18/7/19
 */
public class MethodReferenceTest {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "yello"),
                new Apple(120, "blue")
        );

        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(inventory);
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));

        inventory.sort(Comparator.comparing((Apple a) -> a.getWeight()));

        inventory.sort(Comparator.comparing(a -> a.getWeight()));

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort((Apple a1, Apple a2) -> a2.getWeight().compareTo(a1.getWeight()));

        System.out.println(inventory);

        List<String> str = Arrays.asList("a", "b", "c", "d", "A", "D");
        str.sort((String s1, String s2) -> s1.compareToIgnoreCase(s2));

        str.sort(String::compareToIgnoreCase);


        Supplier<Apple> s = Apple::new;
        Apple a1 = s.get();

        Supplier<Apple> s1 = () -> new Apple();


        Apple a2 = s1.get();

        Supplier<Apple> s2 = () -> {
            Apple ap = new Apple();
            ap.setColor("ye");
            ap.setWeight(150);
            return ap;
        };
        System.out.println(s2.get());

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> map = map(weights, Apple::new);
        System.out.println(map);


        BiFunction<Integer, String, Apple> b = (Integer weight, String color) -> new Apple(weight, color);
        BiFunction<Integer, String, Apple> b1 = Apple::new;
        Apple green = b1.apply(33, "green");
        System.out.println(green);



    }


    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();

        for (Integer integer : list) {
            result.add(f.apply(integer));
        }

        return result;
    }


}
