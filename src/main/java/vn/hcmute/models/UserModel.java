package vn.hcmute.models;

import java.io.Serializable;

public class UserModel implements Serializable {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private int roleid;

    public UserModel() {
    }

    public UserModel(int id, String username, String password, String fullname, int roleid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.roleid = roleid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", roleid=" + roleid +
                '}';
    }
}
