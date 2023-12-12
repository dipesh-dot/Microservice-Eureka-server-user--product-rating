package com.ratingservices.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {

    private String productName;
    private String userName1;
    private Long rating;
    private String description;

}
