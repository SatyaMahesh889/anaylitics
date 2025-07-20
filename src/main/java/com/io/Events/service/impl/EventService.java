package com.io.Events.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.io.Events.dao.EventDao;
import com.io.Events.dto.Events;
import com.io.Events.service.EventInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService implements EventInterface.EventServiceInterface {

    @Autowired
    private EventDao eventDao;

    @Override
    public void saveEvent(String eventId, Events payload) throws JsonProcessingException {
        eventDao.insertEvent(eventId, payload);

        // Save daily rollup (pageviews, visitors per site per day)
        eventDao.insertDailyRollup(payload);

        // Save metadata (device, country, browser info)
        eventDao.insertSiteMeta(payload);
    }
}
