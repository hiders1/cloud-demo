package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

//    @Autowired
//    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.Feign的远程调用
        User user=userClient.findById(order.getUserId());

        // 3.封装user到Order
        order.setUser(user);
        System.out.println("远程调用成功");
        // 4.返回
        return order;
    }
}
//    // 2.1.url路径
//    String url = "http://userservice/user/" + order.getUserId();//服务名称userservice
//    // 2.2.发送http请求，实现远程调用
//    User user = restTemplate.getForObject(url, User.class);