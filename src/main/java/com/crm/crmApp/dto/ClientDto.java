package com.crm.crmApp.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class ClientDto {

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String status;

    @CsvBindByName
    private String nip;

    @CsvBindByName
    private String contactFirstName;

    @CsvBindByName
    private String contactLastName;


    @CsvBindByName
    private String contactEmail;

    @CsvBindByName
    private String contactPhone;

    @CsvBindByName
    private String country;

    @CsvBindByName
    private String region;

    @CsvBindByName
    private String city;

    @CsvBindByName
    private String street;

    @CsvBindByName
    private String postCode;

    @CsvBindByName
    private String userEmail;
}
