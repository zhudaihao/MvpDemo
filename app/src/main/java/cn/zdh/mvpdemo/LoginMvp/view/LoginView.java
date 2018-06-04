package cn.zdh.mvpdemo.LoginMvp.view;


import cn.zdh.mvpdemo.bean.User;

/**
 * view 定义界面接口
 * <p>
 * 1用户通过界面输入的数据
 * 2界面需要后台的数据
 */

public interface LoginView {

    String getLoginName();//获取用户输入的账户

    String getLoginPw();//获取用户输入的密码


    void loginSuccess(User user);

    void loginFailed();


    void loginShownError();

}
