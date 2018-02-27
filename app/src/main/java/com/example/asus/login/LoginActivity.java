package com.example.asus.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import org.litepal.tablemanager.Connector;

public class LoginActivity extends BaseActivity {
    private EditText edit_yhm;
    private EditText edit_mm;
    private  CheckBox checkBox;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_yhm = (EditText)findViewById(R.id.edit_yhm);
        edit_mm = (EditText)findViewById(R.id.edit_mm);
        checkBox = (CheckBox)findViewById(R.id.remember_pass);
        Connector.getDatabase();
        testRememberName();
        setButton();

    }
    /**
    如果记住密码就将密码从SharedPreference中加载出来
     */
    private void testRememberName(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if(sharedPreferences.getBoolean("isRemember",false)){
            //第二个参数表示找不到返回什么
            String a1 = sharedPreferences.getString("yhm","");
            String a2 = sharedPreferences.getString("mm","");
            edit_yhm.setText(a1);
            edit_mm.setText(a2);
        }
    }

    /**
     * 加载按钮并设置点击事件
     */
    private void setButton(){
        Button login = (Button)findViewById(R.id.button_dl);
        Button register = (Button)findViewById(R.id.button_zc);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginTest();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void loginTest(){
        String name = edit_yhm.getText().toString();
        String password = edit_mm.getText().toString();
        if(LitePalUnit.isUserInfoTrue(new User(name,password))){
            //记住密码功能实现
            SharedPreferences.Editor editor = sharedPreferences.edit();
                if (checkBox.isChecked()) {

                    editor.putBoolean("isRemember", true);
                    editor.putString("yhm", name);
                    editor.putString("mm", password);
                    editor.apply();
                } else {
                    editor.clear();
                }
            //进入主用户
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("yhm",name);
            intent.putExtra("mm",password);
            startActivity(intent);
        }
        else{
            loadAlterDialog("警告：","用户验证失败！");
        }
    }

    /**
     * 注册新用户
     */
    private void register(){
        String name = edit_yhm.getText().toString();
        String password = edit_mm.getText().toString();
        if(!isValidName(name)){
            loadAlterDialog("警告：","用户名重复！");
            return;
        }
        if(!isValidPassword(password)){
            loadAlterDialog("警告","密码必须大于7位并且不能包含空格");
            return;
        }
        LitePalUnit.registerNewUser(new User(name,password));
        loadAlterDialog("通知","注册成功;");
    }

    /**
     *检验用户名的有效性
     * @param name 被验证用户名
     * @return boolean 该用户名是否有效
     */
    private boolean isValidName(String name){
        if(LitePalUnit.isNameRepeat(name)){
            return false;
        }
        return true;
    }

    /**
     * 检验密码的有效性
     * @param password
     * @return boolean 密码有效性
     */
    private boolean isValidPassword(String password){
        if(password.length()>7&&!password.contains(" "))
            return true;
        else return false;

    }


}
