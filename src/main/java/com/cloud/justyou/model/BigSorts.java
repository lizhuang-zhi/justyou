package com.cloud.justyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/22 15:19
 * @Version ：1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BigSorts {
    private long bsort_id;
    private String bsort_name;
    private String bsort_description;

    //一个大类可以有多个小类
    private List<SmallSorts> smallSortsList;
}
