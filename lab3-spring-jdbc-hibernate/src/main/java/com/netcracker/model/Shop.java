package com.netcracker.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Shop")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private Integer id;

    @Column(name = "name")
    @NonNull
    private String lastName;

    @Column(name = "district")
    @NonNull
    private String district;

    @Column(name="commission")
    @NonNull
    private Double commission;

}
