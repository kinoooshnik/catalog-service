package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sugar")
@Data
public class Sugar {
    @Id
    @Column(name = "id", nullable = false)
    private String sugarID;

    @Column(name = "name")
    private String sugarName;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "wineSugar")
    private List<Wine> sugarWines;
}
