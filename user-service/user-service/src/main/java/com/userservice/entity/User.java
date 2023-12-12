package com.userservice.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
        @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq",allocationSize = 1)
        private Long id;

        private String firstName;

        private String middleName;

        private String lastName;

    }
