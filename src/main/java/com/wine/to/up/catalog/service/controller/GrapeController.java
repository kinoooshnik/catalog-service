package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.GrapeControllerToGrapeService;
import com.wine.to.up.catalog.service.repository.GrapeRepository;
import com.wine.to.up.catalog.service.service.GrapeManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grape")
@Validated
@Slf4j
@Api(value = "WineController", description = "Grape controller")
public class GrapeController {

    private final GrapeManagerService grapeManagerService;
    private final GrapeControllerToGrapeService converter;

    @ApiOperation(value = "Get grape position by id",
            nickname = "getGrapeById", notes = "",
            tags = {"grape-controller",})
    @GetMapping("/{id}")
    public GrapeResponse getGrapeById(@Valid @PathVariable(name = "id") String grapeId) {
        return converter.convert(grapeManagerService.getGrapeById(grapeId));
    }


    @ApiOperation(value = "Get all grape positions",
            nickname = "getAllGrapes", notes = "",
            tags = {"grape-controller",})
    @GetMapping("/")
    public List<GrapeResponse> getAllGrapes() {
        return grapeManagerService.getAllGrapes()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Update grape position by id",
            nickname = "getAllGrapes", notes = "",
            tags = {"grape-controller",})
    @PutMapping("/{id}")
    public void updateGrape(@Valid @PathVariable(name = "id") String grapeId,
                            @Valid @RequestBody GrapeRequest grapeRequest) {
        grapeManagerService.updateGrape(grapeId, converter.convert(grapeRequest));
    }

    @ApiOperation(value = "Create grape position",
            nickname = "createGrape", notes = "",
            tags = {"grape-controller",})
    @PostMapping("/")
    public void createGrape(@Valid @RequestBody GrapeRequest grapeRequest) {
        grapeManagerService.createGrape(converter.convert(grapeRequest));
    }

}
