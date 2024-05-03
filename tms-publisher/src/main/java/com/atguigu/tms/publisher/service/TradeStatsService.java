package com.atguigu.tms.publisher.service;

import java.math.BigDecimal;

/**
 * @author Felix
 * @date 2023/6/3
 * 交易域统计service接口
 */
public interface TradeStatsService {

    BigDecimal getOrderAmount(Integer date);
}
