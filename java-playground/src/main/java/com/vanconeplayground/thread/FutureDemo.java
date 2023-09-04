package com.vanconeplayground.thread;

import java.util.concurrent.*;

/**
 * @author Tenton Lien
 */
public class FutureDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(new FutureDemo());
        System.out.println("Get future: " + future.get());
        // 如果不执行 shutdown，则程序不会退出
        executor.shutdown();
    }
}
