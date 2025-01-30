package com.trackingapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tags",uniqueConstraints = {
        @UniqueConstraint(columnNames = "mac_address"),
        @UniqueConstraint(columnNames = "serial_no")
})
public class Tag extends BaseEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lost_remark;
    @Column(name = "mac_address",unique = true,nullable = false)
    private String macAddress;
    @Column(name = "serial_no",unique = true,nullable = false)
    private String serialNo;
    private String status;
    private String assigned_status;
    private Tagtype tagtype;

//  private String bluetooth;
//  private String manufacturer_name;
//  private String model;
//  private String vendor_contact;
//  private String vendor_name;
}
