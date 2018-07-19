package com.beidou.c1;

/**
 * @author beidou
 * @since 18/7/16
 */
public class Apple {

    private Integer weight = 0;
    private String color = "";


    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
