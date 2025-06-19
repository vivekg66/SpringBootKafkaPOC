package com.event_handler.event_handler_ms.controller;


import com.event_handler.event_handler_ms.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping({"/{service}", "/{service}/{type}"})
    public ResponseEntity<Void> processEvent(@PathVariable String service,@PathVariable String type,
                                             @RequestBody Map<String,Object> eventMessage) {

        eventService.processEvent(service,type,eventMessage);
        return ResponseEntity.status(HttpStatus.OK).build();


    }

}
