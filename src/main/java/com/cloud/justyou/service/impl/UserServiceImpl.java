package com.cloud.justyou.service.impl;

import com.cloud.justyou.mapper.UserMapper;
import com.cloud.justyou.model.Users;
import com.cloud.justyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @param user_name 用户名
     * @param user_password 密码
     * @return
     */
    @Override
    public Users login(String user_name, String user_password) {
        return userMapper.login(user_name,user_password);
    }

    /**
     * @param user_id               用户id
     * @param user_password         用户密码
     * @param user_name             用户名
     * @param user_email            用户邮箱
     * @param user_birthday         用户生日
     * @param user_telephone_number 用户电话号码
     * @param user_nickname         用户昵称
     */
    @Override
    public void register(long user_id, String user_password, String user_name, String user_email, Date user_birthday, String user_telephone_number, String user_nickname) {
        userMapper.register(user_id,user_password,user_name,user_email,user_birthday,user_telephone_number,user_nickname);
    }


}
