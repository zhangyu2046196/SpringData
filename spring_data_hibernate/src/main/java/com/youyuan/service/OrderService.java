package com.youyuan.service;

import cn.lover2.business.sp.SpUserOrder;
import cn.lover2.business.vippay.UseTypeList;
import cn.lover2.model.User;
import cn.lover2.service.SendMessageService;
import cn.lover2.service.cache.CacheUserService;
import com.youyuan.core.export.client.HClientPayPlus;
import com.youyuan.core.export.pay.SpUserOrderService;
import com.youyuan.core.export.pay.UseTypeListService;
import com.youyuan.dao.OrderDao;
import com.youyuan.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description
 * @date 2019/3/6 13:38
 */
@Service
public class OrderService {

    public static SpUserOrderService spUserOrderService= HClientPayPlus.getService(SpUserOrderService.class);
    public static UseTypeListService useTypeListService= HClientPayPlus.getService(UseTypeListService.class);


    private final static String SEND_MSG_CONTENT="尊敬的用户您好！您订购的USETYPE_DES会员服务升级为小沃交友会员，原来的权益服务保持不变，另外增加线下咨询，小沃红包等权益内容。详情可咨询4000114006。";

    @Autowired
    private OrderDao orderDao;

    public void orderSendMsgDetail(){
        List<Order> orders=orderDao.getOrderByState(0);
        for (Order order:orders){
            SpUserOrder spUserOrder=spUserOrderService.findByPayId(order.getOrderId());
            if (spUserOrder!=null){
               UseTypeList useTypeList= useTypeListService.findByServiceId(spUserOrder.getServiceId());
               if (useTypeList!=null){
                   String sendMsg=SEND_MSG_CONTENT.replaceAll("USETYPE_DES",useTypeList.getUsetypeDesc());
                   System.out.println("userId:"+order.getUserId()+" sendMsgConte:"+sendMsg);
                   CacheUserService userService = new CacheUserService();
                   User user = userService.find(order.getUserId());
                   SendMessageService.sendSystemMessage(user, "续订成功", sendMsg, 2);
                   orderDao.updateOrder(order);
               }
            }
        }
    }

}
