package computational_time_complexity;

import java.util.ArrayList;

public class ComputationalTimeComplexity {
    public static void main(String[] args) {
        var bigCollection = new ArrayList<Integer>();
        for (int i = 0; i < 20_000; i++) {
            bigCollection.add(i);
        }
        long time = System.nanoTime();
        try{
            int value = 0;
            bigCollection.containsAll(bigCollection);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms", (time / 1_000_000));
        }
    }
}
