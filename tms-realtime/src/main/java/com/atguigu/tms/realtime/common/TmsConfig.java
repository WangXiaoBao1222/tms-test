package com.atguigu.tms.realtime.common;

/**
 * @author Felix
 * @date 2023/5/24
 * 物流实时数仓的常量类
 */
public class TmsConfig {
    //zk的地址
    public static final String HBASE_ZOOKEEPER_QUORUM ="hadoop102,hadoop103,hadoop104";
    //hbase的namespace
    public static final String HBASE_NAMESPACE = "tms_realtime";

    // clickhouse驱动
    public static final String CLICKHOUSE_DRIVER = "ru.yandex.clickhouse.ClickHouseDriver";
    // clickhouseURL
    public static final String CLICKHOUSE_URL = "jdbc:clickhouse://hadoop102:8123/tms_realtime";

}
