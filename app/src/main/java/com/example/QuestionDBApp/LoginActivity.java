package com.example.QuestionDBApp;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    // 定义组件
    private EditText edtAccount;
    private EditText edtPassword;
    private Button btnLogin;

    // 用于记录帐号和密码
    private String strAccount = "";
    private String strPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 设置标题
        setTitle("Login");

        // 获取sharedpreferences对象
        SharedPreferences share = getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        strAccount = share.getString("Account", "");
        strPassword = share.getString("Password", "");

        // 判断是否是之前有登录过
        if (share == null) {
            init();
        } else {
            // 判断是否刚注销
            if (share.getBoolean("LoginBool", false)) {
                // 跳转到注销页面并销毁当前activity
                Intent intent = new Intent(LoginActivity.this,
                        MainActivity.class);
                startActivity(intent);
            } else {

                init();
            }
        }

    }

    private void init() {

        // 初始化组件
        edtAccount = (EditText) findViewById(R.id.edtaccount);
        edtPassword = (EditText) findViewById(R.id.edtpassword);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        Button btnregister = findViewById(R.id.btnregister);

        edtAccount.setText(strAccount);
        edtPassword.setText(strPassword);

        // 监听按钮
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // 判断帐号和密码是输入是否为空
                if (edtAccount.getText().toString().equals("")
                        || edtPassword.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "帐号或密码不能为空",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // 创建SharedPreferences对象用于储存帐号和密码,并将其私有化
                    SharedPreferences share = getSharedPreferences("Login",
                            Context.MODE_PRIVATE);
                    // 获取编辑器来存储数据到sharedpreferences中
                    Editor editor = share.edit();
                    editor.putString("Account", edtAccount.getText().toString());
                    editor.putString("Password", edtPassword.getText()
                            .toString());
                    editor.putBoolean("LoginBool", true);
                    // 将数据提交到sharedpreferences中
                    editor.commit();

                    // 跳转到注销页面并销毁当前activity
                    Intent intent = new Intent(LoginActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                final AlertDialog dialog =builder.create();
                View dialogView = View.inflate(LoginActivity.this,R.layout.register_alert,null);

                dialog.setView(dialogView);
                final EditText reg_name = dialogView.findViewById(R.id.reg_account);
                final EditText reg_password = dialogView.findViewById(R.id.reg_password);
                final EditText regconfPassword =  dialogView.findViewById(R.id.reg_conf_password);
                Button regconf =  dialogView.findViewById(R.id.reg_conf);
                dialog.show();

                regconf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (reg_name.getText().toString().equals("")
                                || reg_password.getText().toString().equals("")||regconfPassword.getText().toString().equals("")) {
                            Toast toast = Toast.makeText(LoginActivity.this,"账号或密码不能为空",Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                        if(!reg_password.getText().toString().equals(regconfPassword.getText().toString())){
                            Toast toast = Toast.makeText(LoginActivity.this,"两次输入的密码不一致",Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                        else{
                            dialog.dismiss();
                        }

                    }
                });
            }
        });
    }

}
