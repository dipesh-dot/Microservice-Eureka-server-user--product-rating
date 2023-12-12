package com.ratingservices.entity;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_tb_seq_gen")
    @SequenceGenerator(name = "rating_tb_seq_gen", sequenceName = "rating_tb_seq", allocationSize = 1)
    private Long id;
    private Long productId;
    private Long userId;
    private Long rating;
    private String feedback;
}
