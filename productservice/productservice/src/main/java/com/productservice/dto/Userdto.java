package com.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Userdto implements Serializable {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
}
