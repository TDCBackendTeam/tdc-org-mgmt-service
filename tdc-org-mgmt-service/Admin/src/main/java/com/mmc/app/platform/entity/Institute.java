package com.mmc.app.platform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="institute")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INST_ID")
    private int id;


    @Column(name = "INST_CODE")
    private String code;

    @Column(name = "INST_NAME")
    private String name;

    @Column(name = "ADDR")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PIN")
    private String pin;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "INS_MANAGER")
    private String manager;
}
