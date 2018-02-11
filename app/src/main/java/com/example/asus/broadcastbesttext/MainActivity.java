package com.example.asus.broadcastbesttext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.text_id);
        textView.setText(intent.getStringExtra("yhm"));
        setButton();
    }
    private void setButton(){
        Button button_force = (Button)findViewById(R.id.button_force);
        button_force.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.asus.broastbesttext.FORCE_DOWN");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }
}
