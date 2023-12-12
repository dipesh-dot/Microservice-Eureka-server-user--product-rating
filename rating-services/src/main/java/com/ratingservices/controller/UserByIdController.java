package com.ratingservices.controller;



import com.ratingservices.usermgmtservicedata.SingleUserManagementServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/uc")
public class UserByIdController {



       private final SingleUserManagementServiceData singleUserManagementServiceData;

        @GetMapping("/{id}")
        public ResponseEntity<String> getUserNameById(@PathVariable Long id){

            return ResponseEntity.ok().body(singleUserManagementServiceData.getSingleUserById(id));
        }



    }

