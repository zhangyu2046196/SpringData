package com.youyuan;

import com.youyuan.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * @author zhangyu
 * @version 1.0
 * @description
 * @date 2019/3/6 11:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class OrderDaoImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    @Rollback(false)
    public void sendMsg(){
        orderService.orderSendMsgDetail();
    }

}
