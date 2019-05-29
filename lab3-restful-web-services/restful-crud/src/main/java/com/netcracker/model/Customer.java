package com.netcracker.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel(value = "Describes customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    @ApiModelProperty(hidden = true)
    private Integer id;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "district")
    @NonNull
    private String district;

    @Column(name="sale")
    @NonNull
    private Double sale;

}
