package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericCollectionDemo {
    public void noGenerics() {
        List nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add("adf");
        for (Object el : nums) {
            System.out.println(el);
        }
    }

    public void genericList() {
        var nums = new ArrayList<Integer>();
        nums.add(4);
        nums.add(5);
        nums.forEach(System.out::println);
    }

    public static void main(String[] args) {
        GenericCollectionDemo demo = new GenericCollectionDemo();
        demo.noGenerics();
        demo.genericList();
    }
}
