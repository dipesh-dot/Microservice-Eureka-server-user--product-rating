package com.userservice.service;

import com.userservice.converter.DtoConverter;
import com.userservice.dto.UserDto;
import com.userservice.entity.User;
import com.userservice.repository.UserRepo;
import com.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto saveUser(User user) {
        return DtoConverter.convert(userRepo.save(user));
    }




    @Override
    public UserDto updateUser(Long userId, User user) {
        // Check if the resource with the given ID exists
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            // Check and update the firstName if it's not null
            if (user.getFirstName() != null) {
                existingUser.setFirstName(user.getFirstName());
            }

            // Check and update the middleName if it's not null
            if (user.getMiddleName() != null) {
                existingUser.setMiddleName(user.getMiddleName());
            }

            // Check and update the lastName if it's not null
            if (user.getLastName() != null) {
                existingUser.setLastName(user.getLastName());
            }

            // Save the updated user
            User updatedUser = userRepo.save(existingUser);

            // Convert the updated user entity to a DTO and return it
            return DtoConverter.convert(updatedUser);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with ID: " + userId);
        }


    }


    @Override
    public UserDto getById(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
        return DtoConverter.convert(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> list = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            UserDto convert = DtoConverter.convert(user);
            list.add(convert);
        }
        return Collections.unmodifiableList(list);
    }


    @Override
    public boolean deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
        userRepo.delete(user);
        return true;
    }


}
