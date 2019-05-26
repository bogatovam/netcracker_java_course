package com.netcracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="purchase")
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
    @JoinColumn(name = "seller")
    @NonNull
    private Shop seller;

    @ManyToOne
    @JoinColumn(name = "customer")
    @NonNull
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "book")
    @NonNull
    private Book book;

    @Column(name="count")
    @NonNull
    private Integer count;

    @Column(name="price")
    @NonNull
    private Integer price;
}
