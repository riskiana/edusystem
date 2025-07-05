package com.example.edu_system.mapper;

import com.example.edu_system.domain.User;
import com.example.edu_system.repository.UserEntity;

public class UserMapper {

  public static User map(UserEntity source){
    return new User()
        .setUserid(source.getUserid())
        .setRole(User.Role.valueOf(source.getRole()))
        .setFullname(source.getFullName())
        .setEmail(source.getEmail());

  }


  public static UserEntity map(User source){
    return new UserEntity()
        .setEmail(source.getEmail())
        .setFullName(source.getFullname())
        .setUserid(source.getUserid())
        .setRole(source.getRole().name())
        .setPassword(source.getPassword());
  }


}
