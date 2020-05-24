package com.cloud.justyou.service;

import com.cloud.justyou.model.Users;

import java.util.Date;

public interface UserService {

    /**
     * @param user_name 用户名
     * @param user_password 密码
     * @return 用户对象
     */
    Users login(String user_name, String user_password);


    /**
     * @param user_id 用户id
     * @param user_name 用户名
     * @param user_password 用户密码
     * @param user_email 用户邮箱
     * @param user_birthday 用户生日
     * @param user_telephone_number 用户电话号码
     * @param user_nickname 用户昵称
     */
    void register(long user_id, String user_password,String user_name, String user_email, Date user_birthday, String user_telephone_number, String user_nickname);

}
