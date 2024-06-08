package newio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) {
        Path project = Paths.get(".");
        System.out.println(project.toAbsolutePath());
        System.out.println(project.toUri());
    }
}
