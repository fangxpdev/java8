package com.beidou.c4;

import java.util.ArrayList;
import java.util.List;

import static com.beidou.c4.Dish.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 *
 * 中间操作 返回流
 * 终端操作 返回结果  list 具体值
 *
 * @author beidou
 * @since 18/7/19
 */
public class CollectCompareTest {

    public static void main(String[] args) {

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        lowCaloricDishes.sort(comparing(Dish::getCalories));

        System.out.println(lowCaloricDishes);

        List<String> dishName = new ArrayList<>();
        for (Dish lowCaloricDish : lowCaloricDishes) {
            dishName.add(lowCaloricDish.getName());
        }

        System.out.println(dishName);

        List<String> lowDishName = menu.parallelStream()
                .filter((Dish d) -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        System.out.println(lowDishName);

        List<String> highDishName = menu.stream()
                .filter(d -> {
                    System.out.println("filtering" + d.getName());
                    return d.getCalories() > 300;})
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(highDishName);

        /*
         * filter map 两个独立操作，但它们合并到同一个遍历中（循环遍历）
         * limit 出发短路  所以只打印了3条对应记录
         */
        List<String> highDishName2 = menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;})
                .map(d->{
                    System.out.println("mapping " + d.getName());
                    return d.getName();})
                .limit(3)
                .collect(toList());
        System.out.println(highDishName2);

        menu.stream().forEach((Dish d) -> System.out.println(d.getName()));

        menu.stream().forEach(System.out::println);


    }


}
