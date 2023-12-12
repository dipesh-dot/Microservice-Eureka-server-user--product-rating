package com.ratingservices.usermgmtproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name ="user1")
public interface SingleUserMgmtProxy {

    @GetMapping("/user/{id}")
    public String getDataFromUserMgmt(@PathVariable("id") Long id);
}
