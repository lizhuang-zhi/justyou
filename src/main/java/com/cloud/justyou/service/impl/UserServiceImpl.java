package com.cloud.justyou.service.impl;

import com.cloud.justyou.mapper.UserMapper;
<<<<<<< HEAD
import com.cloud.justyou.model.Users;
=======
import com.cloud.justyou.model.User;
>>>>>>> 9520ddb0b720bff4fce0c6127f076862f7cccd2b
import com.cloud.justyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
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


=======
/**
 * @author HP
 * @noinspection ALL
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean update(User user) {
        return userMapper.updateOne(user);
    }

    @Override
    public User get(int userId) {
        return userMapper.selectOne(userId);
    }
>>>>>>> 9520ddb0b720bff4fce0c6127f076862f7cccd2b
}
