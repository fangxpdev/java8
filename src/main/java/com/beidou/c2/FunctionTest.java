package com.beidou.c2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author beidou
 * @since 18/7/18
 */
public class FunctionTest {

    public static void main(String[] args) {

        int date = 9 ;
        System.out.println(date);
        change(date);
        System.out.println(date);

        String str = "beidou";
        System.out.println(str);
        changeStr(str);
        System.out.println(str);

        Order order = new Order(1, 2);
        System.out.println(order);
        changeOrdeer(order);
        System.out.println(order);


        List<Integer> l =  map(Arrays.asList("lambdas", "in", "action"), (s) -> s.length());
        System.out.println(l);

    }

    private static void changeStr(String string) {
        string = "beidoudou";
    }

    private static void changeOrdeer(Order order) {
        order.setA(22);
        order.setB(44);
    }

    private static void change(int date) {
        date = 21;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {

        List<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;

    }

    static class Order{
        int a ;
        int b;

        public Order(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }


}
