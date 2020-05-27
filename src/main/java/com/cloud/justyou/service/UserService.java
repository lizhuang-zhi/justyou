package com.cloud.justyou.service;

<<<<<<< HEAD
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

=======
import com.cloud.justyou.model.User;

/**
 * @author HP
 */
public interface UserService {
    /**
     * 保存用户信息
     * @param user 更新的用户信息
     */
    boolean update(User user);

    /**
     * 根据用户id获取用户信息
     * @param userId 用户Id
     * @return 用户信息
     */
    User get(int userId);
>>>>>>> 9520ddb0b720bff4fce0c6127f076862f7cccd2b
}
