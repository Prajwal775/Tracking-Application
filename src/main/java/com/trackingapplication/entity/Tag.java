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
    private long lost_remark;
    private String bluetooth;
    @Column(name = "mac_address",unique = true,nullable = false)
    private String mac_address;
    @Column(name = "serial_no",unique = true,nullable = false)
    private String serial_no;
    private String manufacturer_name;
    private String model;
    private String status;
    private String vendor_contact;
    private String vendor_name;
    private String assigned_status;
    private Tagtype tagtype;
}
