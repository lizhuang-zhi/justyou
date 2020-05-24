package com.cloud.justyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/21 22:27
 * @Version ：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    //还有图片，和电话号码类型没确定
    private long user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private Date user_birthday;
    private String user_telephone_number;
    private String user_nickname;

    //一个用户可以有多个请求
    private List<Task> taskList;
}
