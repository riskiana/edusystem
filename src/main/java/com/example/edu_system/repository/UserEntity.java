package com.example.edu_system.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false,name = "userid")
  private String userid;

  @Column(nullable = false,name = "full_name")
  private String fullName;

  @Column(nullable = false,name = "role")
  private String role;

  @Column(nullable = false,name = "email")
  private String email;

  @Column(name = "password")
  private String password;

}