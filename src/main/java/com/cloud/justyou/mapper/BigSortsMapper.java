package com.cloud.justyou.mapper;

import com.cloud.justyou.model.BigSorts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author :
 * @Description :
 * @Date : 2020/5/22 15:31
 * @Version ：1.0
 */
@Mapper
@Repository
public interface BigSortsMapper {

    Collection<BigSorts> getBigSorts();

    Collection<BigSorts> getBigSortsByName(String sort_name);




}
