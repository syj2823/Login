package entity;

import java.util.Date;

public class User {
    private long id;    // id

    private String username;    // 用户名

    private String password;    // 密码

    private String idNumber;    // 身份证

    private String phone;   // 手机号

    private String email;   // 邮箱

    private int gender;     // 性别：0：女 1：男

    private String address; // 籍贯

    private Date createTime;    // 创建时间

    private int status;     // 状态：0：停用 1：启用

    public User() {
    }

    public User(long id, String username, String password, String idNumber, String phone, String email, int gender,
                String address, Date createTime, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idNumber = idNumber;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.createTime = createTime;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
