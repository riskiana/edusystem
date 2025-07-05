package com.example.edu_system.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

  private String userid;
  private String fullname;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  public enum Role {
    ADMIN, STUDENT, TEACHER
  }

}
