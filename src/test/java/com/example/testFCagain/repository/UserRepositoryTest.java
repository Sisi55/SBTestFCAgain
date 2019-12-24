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


    }

    @Test
    @Transactional
    public void  read() {


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
