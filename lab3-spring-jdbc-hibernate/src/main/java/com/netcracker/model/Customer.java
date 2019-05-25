package com.netcracker.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private Integer id;

    @Column(name = "last-name")
    @NonNull
    private String lastName;

    @Column(name = "district")
    @NonNull
    private String district;

    @Column(name="sale")
    @NonNull
    private Double sale;

}