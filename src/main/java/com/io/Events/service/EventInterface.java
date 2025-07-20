package com.io.Events.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.io.Events.dto.Events;
import org.springframework.context.annotation.Configuration;

public interface EventInterface {

    public interface EventServiceInterface {
        void saveEvent(String eventId, Events payload) throws JsonProcessingException;
    }
}
