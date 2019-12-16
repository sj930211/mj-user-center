package service;

import database.DataBaseTools;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shenjian
 * @description 标志查询服务
 * @date 2019/12/4
 */
public class SignService {

    public void firstCome(){
        File signFolder = new File("sign");
        if(!signFolder.exists()) {
            signFolder.mkdir();
        }
        // 判断是否第一次进入系统
        File firstFolder = new File("sign/first");
        if(!firstFolder.exists()) {
            DataBaseTools tools = new DataBaseTools();
            Connection conn = tools.getConn();

            try {
                Statement state = conn.createStatement();
                List<String> sqlList = this.getSqlList("sql/first.sql");
                for (String sql : sqlList) {
                    state.executeUpdate(sql);
                }
                state.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                System.out.println("初始化系统标识生成 ->"+firstFolder.mkdir());
            }
        }
    }

    private List<String> getSqlList(String path){
        List<String> sqlList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("-----------------------");
                System.out.println("语句 -> " + line);
                System.out.println("-----------------------");
                sqlList.add(line);
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlList;
    }
}
