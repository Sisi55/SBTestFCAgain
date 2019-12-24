package com.example.testFCagain.repository;

import com.example.testFCagain.TestFCagainApplicationTests;
import com.example.testFCagain.model.entity.OrderDetail;
import com.example.testFCagain.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends TestFCagainApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
//        User user = new User();
//        user.setAccount("sisi");
//        user.setCreatedBy("by sisi");
//        user.setCreatedAt(LocalDateTime.now());

        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setUser(user);
//        orderDetail.setItemId(1L);
//        orderDetail.setOrderAt(LocalDateTime.now());

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}
