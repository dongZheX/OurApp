package com.example.asus.login;

import org.litepal.crud.DataSupport;

/**
 * Created by ASUS on 2018/2/27.
 */

public class User extends DataSupport{
    private String name;
    private String password;
    private String Email = null;
    private int ImageId = 0;
    private String phone = null;
    private String QQ = null;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean equalsName(User u) {
        return u.getName().equals(this.name);
    }
    public boolean equals(User u) {
        return u.getName().equals(this.name)&&u.getPassword().equals(this.password);
    }
}
