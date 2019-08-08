package com.bmw.service;

import com.bmw.pojo.RetailPojo;
import com.bmw.utils.CommonResult;
import com.bmw.utils.JsonUtils;
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
 *    Create at:   2019-08-08 11:51
 *
 *    Revision:
 *
 *    2019-08-08 11:51
 *        - first revision
 *
 *****************************************************************/
@Service
public class CreateNewData {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * 保存基础数据到Redis
     * @return
     */
    public CommonResult saveDataInRedis() {
        String redisAllKey = "bmw-retail:list";
        String redisPerKey = "bmw-retail:list:";
        List<RetailPojo> retailPojoList = new ArrayList<>();
        retailPojoList = this.generateData();
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        for(RetailPojo temp : retailPojoList){
            String redisKey = redisPerKey + temp.getContractNum();
            String json = JsonUtils.objectToJson(temp);
            ops.set(redisKey, json);
        }
        ops.set(redisAllKey, JsonUtils.objectToJson(retailPojoList));
        return CommonResult.ok();
    }

    /**
     * 产生基础数据
     * @return
     */
    private List<RetailPojo> generateData() {
        List<RetailPojo> list = new ArrayList<>();

        RetailPojo retailPojo = new RetailPojo();
        retailPojo.setContractNum("1693");
        retailPojo.setCustNum("10174");
        retailPojo.setCustName("王怀东");
        retailPojo.setCarDescrip("318i");
        retailPojo.setCarChassis("BAOTOUYEDEBAO0011");
        retailPojo.setStatus("C");
        retailPojo.setIsNewEng("Y");
        list.add(retailPojo);

        RetailPojo retailPojo1 = new RetailPojo();
        retailPojo1.setContractNum("1692");
        retailPojo1.setCustNum("10225");
        retailPojo1.setCustName("杨宁");
        retailPojo1.setCarDescrip("318i");
        retailPojo1.setCarChassis("BAOTOUYEDEBAO0010");
        retailPojo1.setStatus("C");
        retailPojo1.setIsNewEng("Y");
        list.add(retailPojo1);

        RetailPojo retailPojo2 = new RetailPojo();
        retailPojo2.setContractNum("1707");
        retailPojo2.setCustNum("10240");
        retailPojo2.setCustName("马俊");
        retailPojo2.setCarDescrip("318i");
        retailPojo2.setCarChassis("BAOTOUYEDEBAO0026");
        retailPojo2.setStatus("C");
        retailPojo2.setIsNewEng("N");
        list.add(retailPojo2);

        RetailPojo retailPojo3 = new RetailPojo();
        retailPojo3.setContractNum("1672");
        retailPojo3.setCustNum("9091");
        retailPojo3.setCustName("杨颖");
        retailPojo3.setCarDescrip("325i Option A");
        retailPojo3.setCarChassis("WBADANICA00000001");
        retailPojo3.setStatus("Z");
        retailPojo3.setIsNewEng("Y");
        list.add(retailPojo3);

        RetailPojo retailPojo4 = new RetailPojo();
        retailPojo4.setContractNum("1639");
        retailPojo4.setCustNum("9485");
        retailPojo4.setCustName("李四");
        retailPojo4.setCarDescrip("318i");
        retailPojo4.setCarChassis("TIANJINBXH2015000");
        retailPojo4.setStatus("I");
        retailPojo4.setIsNewEng("N");
        list.add(retailPojo4);

        RetailPojo retailPojo5 = new RetailPojo();
        retailPojo5.setContractNum("1612");
        retailPojo5.setCustNum("9947");
        retailPojo5.setCustName("李想");
        retailPojo5.setCarDescrip("318i");
        retailPojo5.setCarChassis("ZHONGSHENGBAOHUIL");
        retailPojo5.setStatus("I");
        retailPojo5.setIsNewEng("Y");
        list.add(retailPojo5);

        RetailPojo retailPojo6 = new RetailPojo();
        retailPojo6.setContractNum("1610");
        retailPojo6.setCustNum("9915");
        retailPojo6.setCustName("周程");
        retailPojo6.setCarDescrip("318i");
        retailPojo6.setCarChassis("ZHONGSHENGBAOHUIG");
        retailPojo6.setStatus("Z");
        retailPojo6.setIsNewEng("Y");
        list.add(retailPojo6);

        RetailPojo retailPojo7 = new RetailPojo();
        retailPojo7.setContractNum("1590");
        retailPojo7.setCustNum("8976");
        retailPojo7.setCustName("赵四");
        retailPojo7.setCarDescrip("318i");
        retailPojo7.setCarChassis("BEIJINGCAIWU00011");
        retailPojo7.setStatus("I");
        retailPojo7.setIsNewEng("N");
        list.add(retailPojo7);

        RetailPojo retailPojo8 = new RetailPojo();
        retailPojo8.setContractNum("1585");
        retailPojo8.setCustNum("3652");
        retailPojo8.setCustName("刘能");
        retailPojo8.setCarDescrip("318i");
        retailPojo8.setCarChassis("BEIJINGCAIWU00003");
        retailPojo8.setStatus("I");
        retailPojo8.setIsNewEng("Y");
        list.add(retailPojo8);

        RetailPojo retailPojo9 = new RetailPojo();
        retailPojo9.setContractNum("1580");
        retailPojo9.setCustNum("9678");
        retailPojo9.setCustName("刘小香");
        retailPojo9.setCarDescrip("325i Option A");
        retailPojo9.setCarChassis("QDWANBAOHANG00060");
        retailPojo9.setStatus("Z");
        retailPojo9.setIsNewEng("Y");
        list.add(retailPojo9);

        RetailPojo retailPojo10 = new RetailPojo();
        retailPojo10.setContractNum("1550");
        retailPojo10.setCustNum("7460");
        retailPojo10.setCustName("赵四");
        retailPojo10.setCarDescrip("318i");
        retailPojo10.setCarChassis("QINGDAO1CAIWU0004");
        retailPojo10.setStatus("I");
        retailPojo10.setIsNewEng("Y");
        list.add(retailPojo10);

        RetailPojo retailPojo11 = new RetailPojo();
        retailPojo11.setContractNum("1548");
        retailPojo11.setCustNum("686");
        retailPojo11.setCustName("王大拿");
        retailPojo11.setCarDescrip("318i");
        retailPojo11.setCarChassis("QINGDAO1CAIWU0002");
        retailPojo11.setStatus("I");
        retailPojo11.setIsNewEng("Y");
        list.add(retailPojo11);

        RetailPojo retailPojo12 = new RetailPojo();
        retailPojo12.setContractNum("1545");
        retailPojo12.setCustNum("2716");
        retailPojo12.setCustName("张鲁");
        retailPojo12.setCarDescrip("325i Option A");
        retailPojo12.setCarChassis("QDWANBAOHANG00014");
        retailPojo12.setStatus("Z");
        retailPojo12.setIsNewEng("Y");
        list.add(retailPojo12);

        RetailPojo retailPojo13 = new RetailPojo();
        retailPojo13.setContractNum("1544");
        retailPojo13.setCustNum("9466");
        retailPojo13.setCustName("杜恒宇");
        retailPojo13.setCarDescrip("325i Option A");
        retailPojo13.setCarChassis("QDWANBAOHANG00018");
        retailPojo13.setStatus("I");
        retailPojo13.setIsNewEng("Y");
        list.add(retailPojo13);

        RetailPojo retailPojo14 = new RetailPojo();
        retailPojo14.setContractNum("1536");
        retailPojo14.setCustNum("9267");
        retailPojo14.setCustName("何腾");
        retailPojo14.setCarDescrip("325i Option A");
        retailPojo14.setCarChassis("QDWANBAOHANG00005");
        retailPojo14.setStatus("C");
        retailPojo14.setIsNewEng("Y");
        list.add(retailPojo14);

        RetailPojo retailPojo15 = new RetailPojo();
        retailPojo15.setContractNum("1499");
        retailPojo15.setCustNum("752");
        retailPojo15.setCustName("周润发");
        retailPojo15.setCarDescrip("318i");
        retailPojo15.setCarChassis("LANGFANGCAIWU0007");
        retailPojo15.setStatus("I");
        retailPojo15.setIsNewEng("Y");
        list.add(retailPojo15);

        RetailPojo retailPojo16 = new RetailPojo();
        retailPojo16.setContractNum("1497");
        retailPojo16.setCustNum("1050");
        retailPojo16.setCustName("刘德华");
        retailPojo16.setCarDescrip("318i");
        retailPojo16.setCarChassis("LANGFANGCAIWU0001");
        retailPojo16.setStatus("I");
        retailPojo16.setIsNewEng("Y");
        list.add(retailPojo16);

        RetailPojo retailPojo17 = new RetailPojo();
        retailPojo17.setContractNum("1494");
        retailPojo17.setCustNum("9071");
        retailPojo17.setCustName("王语嫣");
        retailPojo17.setCarDescrip("318i");
        retailPojo17.setCarChassis("BEIJINGYAZHIJIE01");
        retailPojo17.setStatus("I");
        retailPojo17.setIsNewEng("Y");
        list.add(retailPojo17);

        RetailPojo retailPojo18 = new RetailPojo();
        retailPojo18.setContractNum("1486");
        retailPojo18.setCustNum("9062");
        retailPojo18.setCustName("章鱼");
        retailPojo18.setCarDescrip("X1 sDrive18i Lifestyle Package");
        retailPojo18.setCarChassis("LBVUG7103EME37927");
        retailPojo18.setStatus("I");
        retailPojo18.setIsNewEng("Y");
        list.add(retailPojo18);

        RetailPojo retailPojo19 = new RetailPojo();
        retailPojo19.setContractNum("1472");
        retailPojo19.setCustNum("8957");
        retailPojo19.setCustName("陈三");
        retailPojo19.setCarDescrip("318i");
        retailPojo19.setCarChassis("LBVUG7103EME37924");
        retailPojo19.setStatus("C");
        retailPojo19.setIsNewEng("Y");
        list.add(retailPojo19);

        return list;
    }
}
