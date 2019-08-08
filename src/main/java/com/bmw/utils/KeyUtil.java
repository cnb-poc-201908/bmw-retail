package com.bmw.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/******************************************************************
 *
 *    Java Lib, Powered By Dalian IBM.
 *
 *    Copyright (c) 2001-2018 Dalian IBM Co.,Ltd
 *    http://www.ibm.com/
 *
 *    Package:     com.ibm.mnf.utils
 *
 *    Filename:    KeyUtil
 *
 *    Description: 生成UUID，这个UUID是能够有时间顺序的
 *
 *    Copyright:   Copyright (c) 2001-2018
 *
 *    Company:     Dalian IBM Co.,Ltd
 *
 *    @author: LiuQiang
 *
 *    @version: 1.0.0
 *
 *    Create at:   04/20/2017 01:32 PM
 *
 *    Revision:
 *
 *    04/20/2017 01:32 PM
 *        - first revision
 *
 *****************************************************************/

public class KeyUtil {
	private static int iListCount = 10000;
	/**
	 * <B>方法名称：</B>generatorUUID<BR>
	 * <B>概要说明：</B>主键生成策略<BR>
	 * @author liuqdl
	 * @since 2017年2月21日 下午2:00:06
	 * @return UUID String
	 */
	public static String generatorUUID(){
		TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
		return StringUtils.replace(timeBasedGenerator.generate().toString(),"-","");
	}

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 产生10000个主键
	 * @return
	 */
	public static List<String> getUUIDList() {
		List<String> list = new ArrayList<>();
		for(int i=0; i<iListCount; i++){
			list.add(generatorUUID());
		}
		return list;
	}
}
