package com.userservice.controller;




import com.userservice.dto.UserDto;
import com.userservice.service.UserService;
import com.userservice.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }



    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAll());
    }


}
