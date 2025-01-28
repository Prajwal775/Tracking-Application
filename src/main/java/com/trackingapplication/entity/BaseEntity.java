package com.trackingapplication.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseEntity
{
    private int is_deleted;
    private int is_enabled;
    private Date created_date;
    private Date last_modified_date;
    private String created_by;
    private String last_modified_by;

}
