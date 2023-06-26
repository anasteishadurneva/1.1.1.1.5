package com.bank.history.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "transfer_audit_id")
    private Long transfer_audit_id;

    @Column(name = "profile_audit_id")
    private Long profile_audit_id;

    @Column(name = "account_audit_id")
    private Long account_audit_id;

    @Column(name = "anti_fraud_audit_id")
    private Long anti_fraud_audit_id;

    @Column(name = "public_bank_audit_id")
    private Long public_bank_audit_id;

    @Column(name = "authorization_id")
    private Long authorization_id;


}
