package networking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class ThreadPool<R> {
    static int id = 1;
    int threads;
    ExecutorService executor;
    List<Callable<R>> callables = new ArrayList<>();

    public ThreadPool(int threads) {
        this.threads = threads;
        this.executor = Executors.newFixedThreadPool(this.threads);
    }

    public void submit_task(Supplier<R> function) {
        this.callables.add(new Task<>(id, function));
        id++;
    }

    public ArrayList<R> run_tasks() {
        try {
            List<Future<R>> futures = this.executor.invokeAll(this.callables);
            ArrayList<R> responses = new ArrayList<>();
            for (Future<R> future : futures) {
                try {
                    responses.add(future.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return responses;
        } catch (Exception e) {
            return new ArrayList<R>();
        }

    }

    static class Task<R> implements Callable<R> {
        int task_id;
        Supplier<R> function;

        public Task(int task_id, Supplier<R> function) {
            this.task_id = task_id;
            this.function = function;
        }

        @Override
        public R call() {
            return function.get();
        }
    }
}