package com.example.asus.broadcastbesttext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button1 = (Button)findViewById(R.id.button_dl);
        Button button2 = (Button)findViewById(R.id.button_tc);
        final EditText edit_yhm = (EditText)findViewById(R.id.edit_yhm);
        final EditText edit_mm = (EditText)findViewById(R.id.edit_mm);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yhm = edit_yhm.getText().toString();
                String mm = edit_mm.getText().toString();
                if(yhm.equals("admin")&&mm.equals("123")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                   intent.putExtra("yhm","admin");
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"登陆信息错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
