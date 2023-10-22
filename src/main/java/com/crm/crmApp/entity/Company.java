package com.crm.crmApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    @OneToOne
    @JoinColumn(name = "main_address_id")
    private Address mainAddress;

    @Pattern(regexp = "\\d{10}")
    private String nip;
//gotta look
    @OneToMany
            (mappedBy = "company")
    private List<Office> offices;

}
