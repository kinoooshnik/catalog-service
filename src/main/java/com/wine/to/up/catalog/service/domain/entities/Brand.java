package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "brand")
@Data
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    private String brandID;

    @Column(name = "name")
    private String brandName;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "wineBrand")
    private List<Wine> brandWines;
}
