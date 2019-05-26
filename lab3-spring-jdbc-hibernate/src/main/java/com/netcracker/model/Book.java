package com.netcracker.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private Integer id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "price")
    @NonNull
    private Integer price;

    @Column(name="storage")
    @NonNull
    private String storage;

    @Column(name="count")
    @NonNull
    private Integer count;

}
