package com.mycompany.onetoone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Account {

    @Id
    private String accNo;
    private String accHolderName;
    private String accType;
    private long accBalance;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private Employee employee;
}
