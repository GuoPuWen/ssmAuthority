package cn.noteblogs.domain;

import java.util.List;

public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        String staString;
        if (status==0){
            staString="关闭";
        }else if (status==1){
            staString="开启";
        }else {
            staString="查不到状态信息";
        }
        return staString;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    private List<Role> roles;

}
