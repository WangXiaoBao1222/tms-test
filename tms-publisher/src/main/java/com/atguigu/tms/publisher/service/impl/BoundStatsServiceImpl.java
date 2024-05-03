package com.atguigu.tms.publisher.service.impl;

import com.atguigu.tms.publisher.beans.BoundSortBean;
import com.atguigu.tms.publisher.mapper.BoundStatsMapper;
import com.atguigu.tms.publisher.service.BoundStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Felix
 * @date 2023/6/3
 * 中转域统计Service接口实现类
 */
@Service
public class BoundStatsServiceImpl implements BoundStatsService {
    @Autowired
    private BoundStatsMapper boundStatsMapper;

    @Override
    public List<BoundSortBean> getProvinceSort(Integer date) {
        return boundStatsMapper.selectProvinceSort(date);
    }
}
