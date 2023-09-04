package com.vanconeplayground.thread.database;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Tenton Lien
 */
public class Consumer implements Runnable {

    @SneakyThrows
    public void run() {
        purchaseWithSynchronizedLock();
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Consumer consumer = new Consumer();
        consumer.update(1000);
        Thread.sleep(10);

        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(consumer, "Thread-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time cost: " + (endTime - startTime) + "ms");
    }

    public void purchaseWithoutLock() throws Exception {
        Consumer consumer = new Consumer();
        Thread.sleep(Math.round(Math.random() * 50));
        int amount = consumer.query();
        Thread.sleep(Math.round(Math.random() * 50));
        consumer.update(amount - 1);
        System.out.println(Thread.currentThread().getName() + ": " + amount);
    }

    public synchronized void purchaseWithSynchronizedLock() throws Exception {
        purchaseWithoutLock();
    }

    public void purchaseWithRowLock() throws Exception {
        Consumer consumer = new Consumer();
        Thread.sleep(Math.round(Math.random() * 50));
        int amount = consumer.queryForUpdate();
        Thread.sleep(Math.round(Math.random() * 50));
        consumer.update(amount - 1);
        System.out.println(Thread.currentThread().getName() + ": " + amount);
    }

    public int query() throws Exception {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql = "SELECT amount FROM tb_product WHERE id = 1";
            prepareStatement = connection.prepareStatement(sql);
            // 设置参数
            // 执行查询
            resultSet = prepareStatement.executeQuery();
            // 处理结果集
            if (resultSet.next()) {
                return resultSet.getInt("amount");
            }
        } finally {
            // 关闭连接，释放资源
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return -1;
    }

    public int queryForUpdate() throws Exception {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql = "SELECT amount FROM tb_product WHERE id = 1 FOR UPDATE";
            prepareStatement = connection.prepareStatement(sql);
            // 设置参数
            // 执行查询
            resultSet = prepareStatement.executeQuery();
            // 处理结果集
            if (resultSet.next()) {
                return resultSet.getInt("amount");
            }
        } finally {
            // 关闭连接，释放资源
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return -1;
    }

    public void update(int amount) throws Exception {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql = "UPDATE tb_product SET amount = " + amount + " WHERE id = 1";
            // 执行查询
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } finally {
            // 关闭连接，释放资源
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
