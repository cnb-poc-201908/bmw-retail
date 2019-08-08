package com.bmw.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/******************************************************************
 *
 *    Java Lib, Powered By Dalian IBM.
 *
 *    Copyright (c) 2001-2018 Dalian IBM Co.,Ltd
 *    http://www.ibm.com/
 *
 *    Package:     com.ibm.dswt.utils
 *
 *    Filename:    ExceptionUtil.java
 *
 *    Description: 获取异常的堆栈信息，通常Exception信息都是打印到控制台，如果前端想要获取Exception信息，使用这个Tools
 *
 *    Copyright:   Copyright (c) 2001-2018
 *
 *    Company:     Dalian IBM Co.,Ltd
 *
 *    @author: LiuQiang
 *
 *    @version: 1.0.0
 *
 *    Create at:   12/1/2017 4:45 PM
 *
 *    Revision:
 *
 *    12/1/2017 4:45 PM
 *        - first revision
 *
 *****************************************************************/

public class ExceptionUtil {
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
