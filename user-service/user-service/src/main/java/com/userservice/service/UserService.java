package com.userservice.service;



import com.userservice.dto.UserDto;
import com.userservice.entity.User;

import java.util.List;

public interface UserService {
    UserDto saveUser(User user);



     UserDto updateUser(Long userId, User user);


    UserDto getById(Long id);

    List<UserDto> getAll();


    boolean deleteUser(Long id);

}
