package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arithmetic {
    public static void main(String[] args) {
        int x = 3;
        int y = 0;
        double z = 0;
        try {
            z = x / y;
        } catch (ArithmeticException e) {
            System.err.println(e);
        }
        System.out.printf("x = %d, y = %d, z = %s%n", x, y, z);

        try {
            Arithmetic.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Path dir = Paths.get("src", "exceptions");
        try (BufferedReader br = Files.newBufferedReader(dir.resolve("Arithmetic.java"));) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
