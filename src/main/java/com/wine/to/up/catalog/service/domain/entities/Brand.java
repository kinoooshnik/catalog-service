package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int brandID;

    @Column(name = "name")
    private String brandName;

    @OneToMany(mappedBy = "wineBrand")
    private List<Wine> brandWines;
}
