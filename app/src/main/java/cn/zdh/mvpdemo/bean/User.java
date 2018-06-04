package cn.zdh.mvpdemo.bean;

/**
 * Created by Administrator on 2018/6/4.
 */

public class User {
    private String name;
    private String pw;

    public User(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
