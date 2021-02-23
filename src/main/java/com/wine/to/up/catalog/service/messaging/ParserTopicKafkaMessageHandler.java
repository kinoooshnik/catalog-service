package com.wine.to.up.catalog.service.messaging;

import com.wine.to.up.catalog.service.domain.entities.*;
import com.wine.to.up.catalog.service.repository.*;
import com.wine.to.up.catalog.service.service.WineSaveService;
import com.wine.to.up.commonlib.messaging.KafkaMessageHandler;
import com.wine.to.up.parser.common.api.schema.ParserApi;
import lombok.extern.slf4j.Slf4j;
import com.wine.to.up.parser.common.api.schema.ParserApi.WineParsedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class ParserTopicKafkaMessageHandler implements KafkaMessageHandler<WineParsedEvent> {

    private final WineSaveService wineSaveService;

    @Override
    public void handle(WineParsedEvent wineParsedEvent) {
        log.info("Message received from " + wineParsedEvent.getParserName() + " and site " + wineParsedEvent.getShopLink());
        log.info("Received " + wineParsedEvent.getWinesList().size() + " wines");
        //log.info("Wine parsed event: " + wineParsedEvent.toString());
        wineSaveService.save(wineParsedEvent);
    }
}

