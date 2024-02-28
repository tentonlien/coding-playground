package com.vancone.playground.thread;

import java.util.concurrent.*;

/**
 * @author Tenton Lien
 */
public class FutureTaskDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<String> futureTask = new FutureTask<>(new FutureTaskDemo());
        executor.submit(futureTask);
        while (true) {
            try {
                String result = futureTask.get(1, TimeUnit.SECONDS);
                System.out.println("Get futureTask: " + result);
                break;
            } catch (InterruptedException | TimeoutException e) {
                System.out.println("Catch exception: " + e);
            }
        }
        // 如果不执行 shutdown，则程序不会退出
        executor.shutdown();
    }
}
