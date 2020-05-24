package com.cloud.justyou.service.impl;

import com.cloud.justyou.mapper.SmallSortsMapper;
import com.cloud.justyou.model.SmallSorts;
import com.cloud.justyou.service.SmallSortsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/22 15:52
 * @Version ：1.0
 */
@Service
public class SmallSortsServiceImpl implements SmallSortsService {
    @Autowired
    private SmallSortsMapper smallSortsMapper;

    @Override
    public Collection<SmallSorts> getSmallSorts() {
        return smallSortsMapper.getSmallSorts();
    }
}
