package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.WineDTO;
import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.WinePositionRequest;
import com.wine.to.up.catalog.service.domain.request.WineRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.WinePositionResponse;
import com.wine.to.up.catalog.service.domain.response.WineResponse;
import org.springframework.stereotype.Component;

@Component
public class WineControllerToWineService {
    public void convert(WineRequest wineRequest) {
    }

    public WineResponse convert() {
        return new WineResponse();
    }

}
