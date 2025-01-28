package com.trackingapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tag")
public class Tag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serial_no;
    private String mac_address;

    private Tagtype tagtype;

    public long getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(long serial_no) {
        this.serial_no = serial_no;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public Tagtype getTagtype() {
        return tagtype;
    }

    public void setTagtype(Tagtype tagtype) {
        this.tagtype = tagtype;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "serial_no=" + serial_no +
                ", mac_address='" + mac_address + '\'' +
                ", tagtype=" + tagtype +
                '}';
    }
}
