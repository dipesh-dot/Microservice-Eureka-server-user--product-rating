package com.ratingservices.usermgmtservicedata;

import com.ratingservices.usermgmtproxy.SingleUserMgmtProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class SingleUserManagementServiceData {




        private final SingleUserMgmtProxy singleUserMgmtProxy;

        public String getSingleUserById(Long id){
            return singleUserMgmtProxy.getDataFromUserMgmt(id);
        }
    }


