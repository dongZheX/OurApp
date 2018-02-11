package com.example.asus.broadcastbesttext;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/2/11.
 */

public class ActivityCollector {
    //全局工具类，活动处理
    public static List<Activity> activityList = new ArrayList<>();
    public static void addActivity(Activity activity){
        activityList.add(activity);
    }
    public static void removeActivity(Activity activity){
        activity.finish();
    }
    public static void finishAll(){
        for(Activity value:activityList){
           removeActivity(value);
        }
    }
}
