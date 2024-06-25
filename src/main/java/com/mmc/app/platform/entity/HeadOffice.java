package com.mmc.app.platform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="headoffice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HO_ID")
    private int id;

    @Column(name = "HO_NAME")
    private String name;

    @Column(name = "ADDR")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "DATE")
    private Date date;

    @JsonIgnore
    @OneToMany(targetEntity = Institute.class, cascade = CascadeType.ALL)
    @JoinColumn(name="HO_ID",referencedColumnName = "HO_ID")
    private List<Institute> institutes;

}
