package com.example.edu_system.util;

import com.example.edu_system.domain.User;
import com.example.edu_system.domain.User.Role;
import org.apache.commons.lang3.RandomStringUtils;

public class UserUtil {

  public static User mockUser(){
    return new User()
        .setUserid(RandomStringUtils.randomAlphanumeric(6))
        .setFullname(RandomStringUtils.randomAlphanumeric(10))
        .setEmail(RandomStringUtils.randomAlphanumeric(6).concat("@test.com"))
        .setRole(Role.STUDENT)
        .setPassword(RandomStringUtils.randomAlphanumeric(6));
  }

}
