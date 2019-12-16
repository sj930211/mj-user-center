package service;

import database.DataBaseTools;
import model.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shenjian
 * @description 登录服务类
 * @date 2019/11/30
 */
public class LoginService {

    /**
     * 判断用户名和密码是否正确
     * @author shenjian
     * @date 2019/12/4
     * @param account
     * @param password
     * @return boolean
     */
    public Integer checkUser(String account, String password){
       Integer userId = null;
        // 获取数据库连接
        DataBaseTools tools = new DataBaseTools();
        Connection conn = tools.getConn();
        try {
            String sql = "select user_id from t_user where account = ? and password = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,account);
            st.setString(2,password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    /**
     * 判断用户名和密码是否正确
     * @author shenjian
     * @date 2019/12/4
     * @param userId
     * @return boolean
     */
    public UserEntity getUserById(Integer userId){
        boolean isLogin = false;
        UserEntity userEntity = null;
        // 获取数据库连接
        DataBaseTools tools = new DataBaseTools();
        Connection conn = tools.getConn();
        try {
            String sql = "select * from t_user where user_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                userEntity = new UserEntity();
                userEntity.setUserId(rs.getInt("user_id"));
                userEntity.setAccount(rs.getString("account"));
                userEntity.setPassword(rs.getString("password"));
                userEntity.setName(rs.getString("name"));
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntity;
    }
}
