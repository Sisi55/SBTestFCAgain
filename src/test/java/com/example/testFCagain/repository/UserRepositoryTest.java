package com.example.testFCagain.repository;

import com.example.testFCagain.TestFCagainApplicationTests;
import com.example.testFCagain.model.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends TestFCagainApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
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
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
            System.out.println("email: " + selectUser.getEmail());
        });
    }

    @Test
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
    public void delete() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        if (deleteUser.isPresent()) {
            System.out.println("데이터 존재: " + deleteUser.get());
        } else {
            System.out.println("데이터 없음");
        }
    }
}
