package com.bmw.service;

import com.bmw.pojo.RetailPojo;
import com.bmw.utils.CommonResult;
import com.bmw.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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

    public CommonResult dispalyRetailList() {
        String retailKey = "bmw-retail:list:*";
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String jsonRetailList = ops.get(retailKey);
        List<RetailPojo> retailPojoList = JsonUtils.jsonToList(jsonRetailList, RetailPojo.class);
        return CommonResult.ok(retailPojoList.size());
    }
}
