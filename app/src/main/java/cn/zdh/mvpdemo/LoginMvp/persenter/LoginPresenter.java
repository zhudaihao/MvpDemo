package cn.zdh.mvpdemo.LoginMvp.persenter;

import android.text.TextUtils;

import cn.zdh.mvpdemo.LoginMvp.model.LoginModel;
import cn.zdh.mvpdemo.LoginMvp.view.LoginView;
import cn.zdh.mvpdemo.LoginUi.activity.MainActivity;
import cn.zdh.mvpdemo.bean.User;


/**
 * 主持人
 * <p>
 * model 和view的桥梁
 */

public class LoginPresenter {

    //构造方法拿到model的引用
    private LoginModel loginModel;

    public LoginPresenter() {
        loginModel = new LoginModel();
    }


    //多态  在LoginView的子类实现下面方法，拿到子类的引用
    private LoginView loginView;

    public void setLoginView(MainActivity loginView) {
        this.loginView = loginView;
    }


    //定义个方法处理逻辑

    public void login() {
        //获取界面输入的账户 ，密码
        String loginName = loginView.getLoginName();
        String loginPw = loginView.getLoginPw();
        if (TextUtils.isEmpty(loginName) || TextUtils.isEmpty(loginPw)) {
            loginView.loginShownError();
            return;
        }

        //实现model方法,在回调方法里面实现view的方法
        loginModel.login(loginName, loginPw, new LoginModel.OnLoginResultLister() {
            @Override
            public void onLoginSuccess(User user) {
                loginView.loginSuccess(user);
            }

            @Override
            public void loginFailure() {
                loginView.loginFailed();

            }
        });


    }

}
