package com.vancone.playground.thread.database;

import java.sql.*;

/**
 * @author Tenton Lien
 */
public class JdbcTest {

    public static void main(String[] args) throws Exception {
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
            String sql = "SELECT * FROM tb_user WHERE id=?";
            prepareStatement = connection.prepareStatement(sql);
            // 设置参数
            prepareStatement.setLong(1, 1);
            // 执行查询
            resultSet = prepareStatement.executeQuery();
            // 处理结果集
            while (resultSet.next()) {
                System.out.println("Username = " + resultSet.getString("userName"));
                System.out.println("Password = " + resultSet.getString("password"));

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
    }
}
