package model;

import java.util.Objects;

/**
 * @author shenjian
 * @description ��¼��
 * @date 2019/11/30
 */
public class UserEntity {

    private Integer userId;
    private String account;
    private String password;
    private String name;

    public UserEntity() {
    }

    public UserEntity(Integer userId, String account, String password, String name) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) &&
                account.equals(that.account) &&
                password.equals(that.password) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, account, password, name);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
