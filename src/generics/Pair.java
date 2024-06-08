package generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Pair<T> {
    private T first;
    private T second;


    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public Pair<T> swap() {
        return new Pair<T>(second, first);
    }

    public static <T> void swap(Pair<T> pair) {
        T temp = pair.first;
        pair.first = pair.second;
        pair.second = temp;
    }

    @Override
    public String toString() {
        return String.format("Pair(first=%s, second=%s)", first, second);
    }

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(3,4);
        System.out.println(pair);
        pair = pair.swap();
        System.out.println(pair);

        Pair<Integer> pair1 = new Pair<>(5,7);
        System.out.println(pair1);
        Pair.swap(pair1);
        System.out.println(pair1);
        Pair.<Integer>swap(pair1);
        System.out.println(pair1);

    }

}
