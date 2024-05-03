package com.atguigu.tms.publisher.controller;

import com.atguigu.tms.publisher.beans.BoundSortBean;
import com.atguigu.tms.publisher.service.BoundStatsService;
import com.atguigu.tms.publisher.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Felix
 * @date 2023/6/3
 * 中转域统计Controller
 */
@RestController
public class BoundStatsController {

    @Autowired
    private BoundStatsService boundStatsService;

    @RequestMapping("/provinceSort")
    public String getProvinceSort(@RequestParam(value = "date",defaultValue = "0") Integer date){
        if(date == 0){
            date = DateFormatUtil.now();
        }
        List<BoundSortBean> provinceSortList = boundStatsService.getProvinceSort(date);
        StringBuilder jsonB = new StringBuilder("{\n" +
            "  \"status\": 0,\n" +
            "  \"data\": {\n" +
            "    \"mapData\": [");

        for (int i = 0; i < provinceSortList.size(); i++) {
            BoundSortBean bean = provinceSortList.get(i);
            jsonB.append("{\n" +
                "        \"name\": \""+bean.getProvince_name()+"\",\n" +
                "        \"value\": "+bean.getSort_count()+"\n" +
                "      }");
            if(i < provinceSortList.size() - 1){
                jsonB.append(",");
            }
        }
        jsonB.append("],\n" +
            "    \"valueName\": \"分拣数\"\n" +
            "  }\n" +
            "}");
        return jsonB.toString();
    }
}
