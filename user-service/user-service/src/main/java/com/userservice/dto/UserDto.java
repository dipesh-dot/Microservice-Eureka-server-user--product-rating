package com.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;


}
