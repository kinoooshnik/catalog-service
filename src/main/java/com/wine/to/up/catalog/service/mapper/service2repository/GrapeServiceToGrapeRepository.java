package com.wine.to.up.catalog.service.mapper.service2repository;

import com.google.common.primitives.Bytes;
import com.wine.to.up.catalog.service.domain.dto.GrapeDTO;
import com.wine.to.up.catalog.service.domain.entities.Grape;
import org.springframework.stereotype.Component;

@Component
public class GrapeServiceToGrapeRepository {
    public Grape convert(GrapeDTO grapeDTO) {
        Grape grape = new Grape();
        grape.setGrapesName(grapeDTO.getName());
        grape.setCode(grapeDTO.getCode());
        return grape;
    }

    public GrapeDTO convert(Grape wine) {
        GrapeDTO grapeDTO = new GrapeDTO();
        grapeDTO.setId(wine.getId());
        grapeDTO.setName(wine.getGrapesName());
        grapeDTO.setCode(wine.getCode());
        return grapeDTO;
    }
}
