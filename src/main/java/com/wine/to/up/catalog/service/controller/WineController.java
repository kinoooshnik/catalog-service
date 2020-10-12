package com.wine.to.up.catalog.service.controller;


import com.wine.to.up.catalog.service.domain.entities.Wine;
import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.WineRequest;
import com.wine.to.up.catalog.service.domain.response.WineResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.WineControllerToWineService;
import com.wine.to.up.catalog.service.service.WineService;
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
@RequestMapping("/wine")
@Validated
@Slf4j
@Api(value = "WineController", description = "Wine controller")
public class WineController {

    private final WineControllerToWineService converter;
    private final WineService wineService;

    @ApiOperation(value = "Get wine by id",
            nickname = "getWineById", notes = "",
            tags = {"wine-controller",})
    @GetMapping("/{id}")
    public WineResponse getWineById(@Valid @PathVariable(name = "id") String wineId) {
        return converter.convert(wineService.read(wineId));
    }


    @ApiOperation(value = "Get all wine",
            nickname = "getAllWines", notes = "",
            tags = {"wine-controller",})
    @GetMapping("/")
    public List<WineResponse> getAllWines() {
        return wineService.readAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Create wine",
            nickname = "createWine", notes = "",
            tags = {"wine-controller",})
    @PostMapping("/")
    public void createWine(@Valid @RequestBody WineRequest wineRequest) {
        wineService.create(converter.convert(wineRequest));
    }

    @ApiOperation(value = "Update wine",
            nickname = "updateWine", notes = "",
            tags = {"wine-controller",})
    @PutMapping("/{id}")
    public void updateWine(@Valid @PathVariable(name = "id") String wineId,
                           @Valid @RequestBody WineRequest wineRequest) {
        wineService.update(wineId, converter.convert(wineRequest));
    }

    @ApiOperation(value = "Delete wine",
            nickname = "deleteWine", notes = "",
            tags = {"wine-controller",})
    @DeleteMapping("/{id}")
    public void deleteWine(@Valid @PathVariable(name = "id") String wineId) {
        wineService.delete(wineId);
    }
}
