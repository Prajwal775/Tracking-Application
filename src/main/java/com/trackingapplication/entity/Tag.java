package com.trackingapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tag")

public class Tag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long serial_no;
    @GeneratedValue(strategy = GenerationType.UUID)
    private String mac_address;

    private Tagtype tagtype;





}
