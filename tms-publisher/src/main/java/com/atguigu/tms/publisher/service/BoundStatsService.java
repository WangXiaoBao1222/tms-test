package com.atguigu.tms.publisher.service;

import com.atguigu.tms.publisher.beans.BoundSortBean;

import java.util.List;

/**
 * @author Felix
 * @date 2023/6/3
 * 中转域统计service接口
 */
public interface BoundStatsService {
    List<BoundSortBean> getProvinceSort(Integer date);
}
