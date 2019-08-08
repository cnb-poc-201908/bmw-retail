package com.bmw.controller;

/******************************************************************
 *
 *    Java Lib, Powered By Dalian IBM.
 *
 *    Copyright (c) 2001-2018 Dalian IBM Co.,Ltd
 *    http://www.ibm.com/
 *
 *    Package:     com.bmw.controller
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
 *    Create at:   2019-08-08 15:18
 *
 *    Revision:
 *
 *    2019-08-08 15:18
 *        - first revision
 *
 *****************************************************************/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SwaggerController {
    @RequestMapping("/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
