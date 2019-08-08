package com.bmw.service;

import com.bmw.pojo.RetailPojo;
import com.bmw.utils.CommonResult;
import com.bmw.utils.JsonUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/******************************************************************
 *
 *    Java Lib, Powered By Dalian IBM.
 *
 *    Copyright (c) 2001-2018 Dalian IBM Co.,Ltd
 *    http://www.ibm.com/
 *
 *    Package:     com.bmw.service
 *
 *    Filename:
 *
 *    Description: (用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2018
 *
 *    Company:     Dalian IBM Co.,Ltd
 *
 *    @author: liuqiang
 *
 *    @version: 1.0.0
 *
 *    Create at:   2019-08-08 13:07
 *
 *    Revision:
 *
 *    2019-08-08 13:07
 *        - first revision
 *
 *****************************************************************/
@Service
public class RetailService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 得到所有的Retail Infor
     * @return
     */
    public CommonResult dispalyRetailList() {
        String retailKey = "bmw-retail:list";
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String jsonRetailList = ops.get(retailKey);
        List<RetailPojo> retailPojoList = JsonUtils.jsonToList(jsonRetailList, RetailPojo.class);
        List<RetailPojo> newList = new ArrayList<>();
        for(RetailPojo temp : retailPojoList){
            String newKey = retailKey + ":" + temp.getContractNum();
            String retailPojoStr = ops.get(newKey);
            RetailPojo newPojoRetail = JsonUtils.jsonToPojo(retailPojoStr, RetailPojo.class);
            if(!StringUtils.equalsIgnoreCase(newPojoRetail.getStatus(), "F")){
                newList.add(newPojoRetail);
            }
        }
        return CommonResult.ok(newList);
    }

    /**
     * 更新信息
     * @param retailPojo
     * @return
     */
    public CommonResult updateRetailInfor(RetailPojo retailPojo) {
        String redisPerKey = "bmw-retail:list:";
        String retailKey = retailPojo.getContractNum();
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        RetailPojo needUpdatePojo = JsonUtils.jsonToPojo(ops.get(redisPerKey + retailKey), RetailPojo.class);
        //更改
        if(needUpdatePojo != null){
            needUpdatePojo.setCustNum(retailPojo.getCustNum());
            needUpdatePojo.setCustName(retailPojo.getCustName());
            needUpdatePojo.setCarChassis(retailPojo.getCarChassis());
            needUpdatePojo.setInvoiceDate(retailPojo.getInvoiceDate());
            needUpdatePojo.setDelieryCarSA(retailPojo.getDelieryCarSA());
            needUpdatePojo.setDealType(retailPojo.getDealType());
            needUpdatePojo.setCarUsing(retailPojo.getCarUsing());
            needUpdatePojo.setCertiCode(retailPojo.getCertiCode());
            needUpdatePojo.setStatus("F");

            //保存
            ops.set((redisPerKey + retailKey), JsonUtils.objectToJson(needUpdatePojo));
        }
        return CommonResult.ok();
    }

}
