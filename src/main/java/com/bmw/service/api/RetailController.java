package com.bmw.service.api;

import com.bmw.pojo.RetailPojo;
import com.bmw.service.RetailService;
import com.bmw.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/******************************************************************
 *
 *    Java Lib, Powered By Dalian IBM.
 *
 *    Copyright (c) 2001-2018 Dalian IBM Co.,Ltd
 *    http://www.ibm.com/
 *
 *    Package:     com.bmw.service.api
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
 *    Create at:   2019-08-08 14:07
 *
 *    Revision:
 *
 *    2019-08-08 14:07
 *        - first revision
 *
 *****************************************************************/
@RestController
public class RetailController {
    private static Logger logger = LoggerFactory.getLogger(RetailController.class);
    @Autowired
    private RetailService retailService;

    /**
     * display retail list
     * @return
     */
    @RequestMapping(value = "/retail/getRetailList", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public CommonResult getRetailList() {
        return retailService.dispalyRetailList();
    }

    @RequestMapping(value = "/retail/updateRetail", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public CommonResult updateRetailInfor(@RequestBody RetailPojo retailPojo) {
        if(retailPojo == null)
            return CommonResult.build(500, "Post parameter is null");
        return retailService.updateRetailInfor(retailPojo);
    }
}
