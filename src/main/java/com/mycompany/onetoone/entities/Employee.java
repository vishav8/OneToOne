package com.mycompany.onetoone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Employee {

    @Id
    private int employeeNo;
    private String employeeName;
    private float employeeSal;
    private String employeeAddr;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Exclude
    private Account account;
}
