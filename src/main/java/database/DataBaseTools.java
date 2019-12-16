package database;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shenjian
 * @description 数据库连接类
 * @date 2019/12/3
 */
public class DataBaseTools {

    public Connection conn=null;

    /** MySQL的数据库连接地址 */
    public static final String DB_URL = "jdbc:sqlite:dbs/mj.db?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    public Connection getConn(){
        try {
            // 创建SQLite文件
            File dbFolder = new File("dbs");
            if(!dbFolder.exists()) {
                System.out.println("创建dbs文件夹："+dbFolder.mkdir());
            }

            // 新建连接
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
