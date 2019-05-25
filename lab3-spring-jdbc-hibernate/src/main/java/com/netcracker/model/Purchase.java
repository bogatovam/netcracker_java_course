package com.netcracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Purchase")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private Integer id;

    @Column(name = "date")
    @NonNull
    private Date date;

    @ManyToOne
    @Column(name = "seller")
    @NonNull
    private Shop seller;

    @ManyToOne
    @Column(name = "customer")
    @NonNull
    private Customer customer;

    @ManyToOne
    @Column(name = "book")
    @NonNull
    private Book book;

    @Column(name="count")
    @NonNull
    private Integer count;

    @Column(name="price")
    @NonNull
    private Integer price;
}
