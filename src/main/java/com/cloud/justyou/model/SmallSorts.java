package com.cloud.justyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/22 15:21
 * @Version ：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmallSorts {
    private long ssort_id;
    private String ssort_name;
    private String ssort_description;

    //一个小类对应一个大类
    private BigSorts bigSorts;
}
