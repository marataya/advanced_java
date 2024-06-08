package newio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Files.createDirectory(Paths.get("data"));
//        Files.createDirectories(Paths.get("sub1", "sub2", "sub3"));
//        Files.createFile(Paths.get("sub1", "sub2", "sub3", "myfile.txt"));
//        boolean deleted = Files.deleteIfExists(Paths.get("sub1", "sub2", "sub3", "myfile.txt"));
//        deleted = Files.deleteIfExists(Paths.get("data"));
//        deleted = Files.deleteIfExists(Paths.get("sub1", "sub2", "sub3"));
//        deleted = Files.deleteIfExists(Paths.get("sub1", "sub2"));
//        deleted = Files.deleteIfExists(Paths.get("sub1"));

//        Path sourceDir = Paths.get("src", "newio");

        Path sourceDir = Paths.get("src", "newio");
        Path dataFile = sourceDir.resolve("data.txt");
//
        System.out.println(Files.lines(dataFile).collect(Collectors.toList()));
        //Copy file
        Path destFile = sourceDir.resolve("data_copy.txt");
        Files.deleteIfExists(destFile);
        Files.copy(dataFile, destFile);

        //Move file
        Path other = sourceDir.resolve("data_moved.txt");
        Files.deleteIfExists(other);
        Files.move(destFile, other);

        //Visit all files in dir
        Path javaDir = Paths.get(".", "src").toAbsolutePath().normalize();
        try (Stream<Path> entries = Files.walk(javaDir)){
            entries.forEach(System.out::println);
        }
    }
}
