package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grape")
@Data
public class Grape {
    @Id
    @Column(name = "id", nullable = false)
    private String grapeID;

    @Column(name = "name")
    private String grapeName;

    @OneToMany(mappedBy = "wineGrape")
    private List<Wine> grapeWines;
}