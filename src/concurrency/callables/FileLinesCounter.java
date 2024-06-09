package concurrency.callables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FileLinesCounter {
    private Path dir = Paths.get("src", "concurrency");

    public long computeTotalNumberOfLines() {
        long total = 0;
        try {
            total = executeCounters().stream()
                    .mapToLong(this::extractValuesFromFutures)
                    .sum();
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return total;
    }

    private <T> T extractValuesFromFutures(Future<T> future) {
        T val = null;
        try {
            val = future.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    private List<Future<Long>> executeCounters() throws InterruptedException, IOException {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<Long>> futures = service.invokeAll(getFileLineCounters());
        service.shutdown();
        return futures;
    }

    private List<Callable<Long>> getFileLineCounters() throws IOException {
        return Files.list(dir)
                .filter(Files::isRegularFile)
                .map(this::callablePrintingCounter) //change type of Callable counter here
                .collect(Collectors.toList());
    }

    private Callable<Long> callableCounter(Path path) {
        return () -> Files.lines(path).count();
    }

    private Callable<Long> callablePrintingCounter(Path path) {
        return () -> {
            long count = Files.lines(path).count();
            System.out.printf("%s had %d lines\n", path, count);
            return count;
        };
    }

    public static void main(String[] args) {
        FileLinesCounter flc = new FileLinesCounter();
        System.out.printf("Total number of lines: %d%n",
                flc.computeTotalNumberOfLines());
    }
}
