package com.cloud.justyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/21 23:27
 * @Version ：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private long task_id;
    private long user_id;
    private String task_title;
    private String task_content;
    private long task_views;
    private Date task_date;
    private long task_like_count;

    //一个请求对应一个用户
    private Users users;
}
