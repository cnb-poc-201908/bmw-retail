package com.bmw;

import com.bmw.service.CreateNewData;
import com.bmw.service.RetailService;
import com.bmw.utils.CommonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BMWRetailApplicationTests {
    @Autowired
    private CreateNewData createNewData;
    @Autowired
    private RetailService retailService;
    private static Logger logger = LoggerFactory.getLogger(BMWRetailApplicationTests.class);

    @Test
    public void testCreateNewData() {
        createNewData.saveDataInRedis();
    }

    @Test
    public void testGetRedisList() {
        CommonResult result = retailService.dispalyRetailList();
        logger.info("******** " + result.getData());
    }
}
