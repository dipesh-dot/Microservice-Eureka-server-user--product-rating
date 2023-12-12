package com.productservice.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_tb_seq_gen")
    @SequenceGenerator(name = "product_tb_seq_gen",sequenceName = "product_tb_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long rating;
    private String firstName;
    private String middleName;
    private String lastName;


}
