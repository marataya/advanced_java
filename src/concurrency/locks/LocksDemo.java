package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {
    private Counter counter = new Counter();
    private SyncCounter sync_counter = new SyncCounter();
    private LockedCounter locked_counter = new LockedCounter();
    private AtomicCounter atomic_counter = new AtomicCounter();

    public static void main(String[] args) throws InterruptedException {
        LocksDemo demo = new LocksDemo();
        demo.demoCounter();
        Thread.sleep(1000);
        demo.demoSyncCounter();
        Thread.sleep(1000);
        demo.demoLockedCounter();
        Thread.sleep(1000);
        demo.demoAtomicCounter();
    }

    private void demoAtomicCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(atomic_counter::increment));
        service.shutdown();
        System.out.println("AtomicCounter count=" + atomic_counter.getCount());
    }

    private void demoLockedCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(locked_counter::increment));
        service.shutdown();
        System.out.println("LockedCounter count=" + locked_counter.getCount());
    }

    private void demoSyncCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(sync_counter::increment));
        service.shutdown();
        System.out.println("SyncCounter count=" + sync_counter.getCount());
    }

    private void demoCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(counter::increment));
        service.shutdown();
        System.out.println("Counter count=" + counter.getCount());
    }
}
