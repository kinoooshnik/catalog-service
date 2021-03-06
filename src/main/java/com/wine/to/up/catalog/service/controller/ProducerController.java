package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.request.ProducerRequest;
import com.wine.to.up.catalog.service.domain.response.ProducerResponse;
import com.wine.to.up.catalog.service.mapper.controller2service.ProducerControllerToProducerService;
import com.wine.to.up.catalog.service.service.ProducerService;
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
@RequestMapping("/producer")
@Validated
@Slf4j
@Api(value = "ProducerController", description = "Producer controller")
public class ProducerController {
    private final ProducerControllerToProducerService converter;
    private final ProducerService producerService;

    @ApiOperation(value = "Get producer position by id",
            nickname = "getProducerById", notes = "",
            tags = {"producer-controller",})
    @GetMapping("/{id}")
    public ProducerResponse getProducerById(@Valid @PathVariable(name = "id") String producerId) {
        return converter.convert(producerService.read(producerId));
    }

    @ApiOperation(value = "Get all producer positions",
            nickname = "getAllProducers", notes = "",
            tags = {"producer-controller",})
    @GetMapping("/")
    public List<ProducerResponse> getAllProducers() {
        return producerService.readAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Update producer position by id",
            nickname = "updateProducer", notes = "",
            tags = {"producer-controller",})
    @PutMapping("/{id}")
    public void updateGrape(@Valid @PathVariable(name = "id") String producerId,
                            @Valid @RequestBody ProducerRequest producerRequest) {
        producerService.update(producerId, converter.convert(producerRequest));
    }

    @ApiOperation(value = "Create producer position",
            nickname = "createProducer", notes = "",
            tags = {"producer-controller",})
    @PostMapping("/")
    public void createGrape(@Valid @RequestBody ProducerRequest producerRequest) {
        producerService.create(converter.convert(producerRequest));
    }
}
