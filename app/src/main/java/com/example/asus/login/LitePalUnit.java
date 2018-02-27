package com.example.asus.login;

import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by ASUS on 2018/2/27.
 * 数据库操作
 */

public class LitePalUnit {
    /**验证用户是否为注册用户或者密码是否正确
    @param  user 被验证的用户
    @return boolean 返回验证结果
     */
    public static boolean isUserInfoTrue(User user){
        List<User> mlist = DataSupport.findAll(User.class);
        if(mlist!=null)
        for(User value:mlist){
            if(value.equals(user))
                return true;
        }
        else{
            Toast.makeText(MyApplication.getContext(), "系统错误-无注册信息", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    /**向数据库中写入新用户
    @return Boolean 写入结果
     */
    public static boolean registerNewUser(User user){
        user.save();
        return true;
    }
    public static boolean isNameRepeat(String name){
        return !DataSupport.where("name = ?",name).find(User.class).isEmpty();
    }
}
