package cn.zdh.mvpdemo.LoginUi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.zdh.mvpdemo.LoginMvp.persenter.LoginPresenter;
import cn.zdh.mvpdemo.LoginMvp.view.LoginView;
import cn.zdh.mvpdemo.R;
import cn.zdh.mvpdemo.bean.User;

/**
 * view 的实现类
 */

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private EditText et_name, et_pw;
    private Button button;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.tv_name);
        et_pw = findViewById(R.id.et_pw);
        button = findViewById(R.id.bt);
        button.setOnClickListener(this);

        //获取主持人对象，实现setLoginView
        presenter = new LoginPresenter();
        presenter.setLoginView(this);

    }

    @Override
    public void onClick(View view) {
        //用户点击登录按钮 调用主持人的登录方法处理登录时的逻辑
        presenter.login();

    }

    @Override
    public String getLoginName() {
        return et_name.getText().toString();
    }

    @Override
    public String getLoginPw() {
        return et_pw.getText().toString();
    }


    //登录成功
    @Override
    public void loginSuccess(User user) {
        startActivity(new Intent(this, TextActivity.class));
    }

    @Override
    public void loginFailed() {
        //失败
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void loginShownError() {
        //输入错区
        Toast.makeText(this, "账户或密码不能为空", Toast.LENGTH_SHORT).show();

    }


}
