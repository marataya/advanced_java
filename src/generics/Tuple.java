package generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Tuple<T, U> {
    private T first;
    private U second;


    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("Tuple(first=%s, second=%s)", first, second);
    }

    public static void main(String[] args) {
        Tuple<Integer, String> tuple = new Tuple<>(1, "hello");
        Tuple<LocalDate, List<Integer>> tuple1 = new Tuple<>(LocalDate.now(), Arrays.asList(1, 2, 3));
        System.out.println(tuple);
        System.out.println(tuple1);
    }
}
