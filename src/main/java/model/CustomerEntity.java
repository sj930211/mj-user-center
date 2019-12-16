package model;

import java.util.Date;
import java.util.Objects;

/**
 * @author shenjian
 * @description 客户资料实体类
 * @date 2019/12/3
 */
public class CustomerEntity {

    private String name;
    private String phone;
    private String model;
    private Date signDate;
    private Date payDate;
    private int leaseYears;
    private int payYears;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getLeaseYears() {
        return leaseYears;
    }

    public void setLeaseYears(int leaseYears) {
        this.leaseYears = leaseYears;
    }

    public int getPayYears() {
        return payYears;
    }

    public void setPayYears(int payYears) {
        this.payYears = payYears;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerEntity(String name, String phone, String model, Date signDate, Date payDate, int leaseYears, int payYears, String address) {
        this.name = name;
        this.phone = phone;
        this.model = model;
        this.signDate = signDate;
        this.payDate = payDate;
        this.leaseYears = leaseYears;
        this.payYears = payYears;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity customerEntity = (CustomerEntity) o;
        return leaseYears == customerEntity.leaseYears &&
                payYears == customerEntity.payYears &&
                Objects.equals(name, customerEntity.name) &&
                Objects.equals(phone, customerEntity.phone) &&
                Objects.equals(model, customerEntity.model) &&
                Objects.equals(signDate, customerEntity.signDate) &&
                Objects.equals(payDate, customerEntity.payDate) &&
                Objects.equals(address, customerEntity.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, model, signDate, payDate, leaseYears, payYears, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", model='" + model + '\'' +
                ", signDate=" + signDate +
                ", payDate=" + payDate +
                ", leaseYears=" + leaseYears +
                ", payYears=" + payYears +
                ", address='" + address + '\'' +
                '}';
    }
}
