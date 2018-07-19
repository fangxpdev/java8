package com.beidou.c4;

import java.util.ArrayList;
import java.util.List;

import static com.beidou.c4.Dish.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
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




    }


}
