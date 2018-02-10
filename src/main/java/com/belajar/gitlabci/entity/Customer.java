package com.belajar.gitlabci.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(length = 5, unique = true, nullable = false)
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    private String address;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

    @Column(length = 15, precision = 2)
    private BigDecimal creditLimit;
}
