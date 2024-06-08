package computational_time_complexity;

import java.util.ArrayList;
import java.util.concurrent.locks.LockSupport;

public class Arrays {
    public static void main(String[] args) {
        System.out.println(ProcessHandle.current().pid());
        var list = new ArrayList<String>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add("Hello");

        }
        LockSupport.park();
    }
}
