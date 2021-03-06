package com.wine.to.up.catalog.service.service;

import com.wine.to.up.catalog.service.domain.dto.GrapeDTO;
import com.wine.to.up.catalog.service.mapper.service2repository.GrapeServiceToGrapeRepository;
import com.wine.to.up.catalog.service.repository.GrapeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GrapeService implements BaseCrudService<GrapeDTO> {

    private final GrapeRepository grapeRepository;
    private final GrapeServiceToGrapeRepository converter;

    @Override
    public List<GrapeDTO> readAll() {
        return StreamSupport
                .stream(grapeRepository.findAll().spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void create(GrapeDTO grapeDTO) {
        grapeDTO.setId(UUID.randomUUID().toString());
        grapeRepository.save(converter.convert(grapeDTO));
    }

    @Override
    public GrapeDTO read(String id) {
        return converter.convert(grapeRepository.findByGrapeID(id));
    }

    @Override
    public void update(String id, GrapeDTO grapeDTO) {
        grapeDTO.setId(id);
        grapeRepository.save(converter.convert(grapeDTO));
    }

    @Override
    public void delete(String id) {
        grapeRepository.deleteById(id);
    }
}
