package com.example.asus.broadcastbesttext;

import android.support.v7.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ASUS on 2018/2/11.
 */

public class BaseActivity extends AppCompatActivity{
    protected LocalBroadcastManager localBroadcastManager;
    protected  LocalReceive localReceive;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.activityList.remove(this);
    }
    protected  void onResume(){
        super.onResume();
      localReceive = new LocalReceive();
         localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.asus.broastbesttext.FORCE_DOWN");
        localBroadcastManager.registerReceiver(localReceive,intentFilter);
    }
    protected void onPause(){
        super.onPause();
        localBroadcastManager.unregisterReceiver(localReceive);
    }
    class LocalReceive extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {

            AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);//context无法启动窗口,书中出错
            builder.setCancelable(false);
            builder.setTitle("警告：");
            builder.setMessage("您已经被强制下线，请重新登录。！");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    Intent intent2 = new Intent(context,LoginActivity.class);
                    startActivity(intent2);
                }
            });
            builder.show();


        }
    }
}
