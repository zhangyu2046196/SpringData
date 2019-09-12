package com.youyuan;

import com.youyuan.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author zhangyu
 * @version 1.0
 * @description 主方法可执行jar包调用
 * @date 2019/3/6 17:01
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:application.xml");
        OrderService orderService= (OrderService) applicationContext.getBean("orderService");
        orderService.orderSendMsgDetail();
    }

}
