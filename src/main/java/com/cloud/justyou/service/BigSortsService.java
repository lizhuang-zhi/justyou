package com.cloud.justyou.service;

import com.cloud.justyou.model.BigSorts;

import java.util.Collection;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/22 15:29
 * @Version ：1.0
 */
public interface BigSortsService {
    Collection<BigSorts> getBigSorts();

    Collection<BigSorts> getBigSortsByName(String sort_name);




}
