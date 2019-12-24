package com.example.testFCagain.repository;

import com.example.testFCagain.TestFCagainApplicationTests;
import com.example.testFCagain.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends TestFCagainApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void create() {
        User user = new User();
        user.setAccount("sisi");
        user.setEmail("sisi.sisi.com");
        user.setPhoneNumber("010-010");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("sisi");

        userRepository.save(user);
    }

    @Test
    @Transactional
    public void  read() {
//        Optional<User> user = userRepository.findById(1L);
        Optional<User> user = userRepository.findByAccount("sisi");

        user.ifPresent(selectUser -> {
//            System.out.println("user: " + selectUser);
//            System.out.println("email: " + selectUser.getEmail());
            selectUser.getOrderDetailList().stream().forEach(detail->{
                System.out.println(detail.getItem());
            });
        });
    }

    @Test
    @Transactional
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("update account");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update test");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(1L);
        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);
        Assert.assertFalse(deleteUser.isPresent());
    }
}
