package cn.zdh.mvpdemo.LoginMvp.model;


import cn.zdh.mvpdemo.bean.User;

/**
 * 数据
 */

public class LoginModel {


    public void login(String name, String pw, OnLoginResultLister onLoginResultLister) {

        //请求网路接口 在成功方法里面实现接口 成功方法，在失败里面实现接口失败方法（这里就本地判断）

        if (name.equals("zhangsan") && pw.equals("123456")) {
            onLoginResultLister.onLoginSuccess(new User("zhangsahng", "123456"));

        } else {
            onLoginResultLister.loginFailure();
        }

    }


    public interface OnLoginResultLister {
        void onLoginSuccess(User user);

        void loginFailure();

    }


}
