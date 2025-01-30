package com.trackingapplication.dto;

import com.trackingapplication.entity.Tagtype;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "mac_address",unique = true,nullable = false)
    private String mac_address;
    //@Column(name = "serial_no",unique = true,nullable = false)
    private String serial_no;
    private String status;
    private String assigned_status;
    private String lost_remark;
    private Tagtype tagtype;

}
