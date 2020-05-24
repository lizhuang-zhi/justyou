package com.cloud.justyou.service.impl;

import com.cloud.justyou.mapper.BigSortsMapper;
import com.cloud.justyou.model.BigSorts;
import com.cloud.justyou.service.BigSortsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/22 15:30
 * @Version ：1.0
 */
@Service
public class BigSortsServiceImpl implements BigSortsService {

    @Autowired
    private BigSortsMapper bigSortsMapper;

    @Override
    public Collection<BigSorts> getBigSorts() {
        return bigSortsMapper.getBigSorts();
    }

    @Override
    public Collection<BigSorts> getBigSortsByName(String sort_name) {
        return bigSortsMapper.getBigSortsByName(sort_name);
    }
}
