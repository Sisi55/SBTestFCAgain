package com.example.testFCagain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String type;
//    private String title;
    private String account;
    private String password;
    private String status;
    private String email;
    private String phoneNumber;

    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;
    private String createdBy;

    private LocalDateTime updatedAt;
    private String updatedBy;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="user") // 연관관계되는 변수이름
    private List<OrderDetail> orderDetailList;
}
