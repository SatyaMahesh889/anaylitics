package com.io.Events.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.io.Events.dao.AnalyticsDAO;
import com.io.Events.dto.Events;
import com.io.Events.service.EventInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EventService implements EventInterface.EventServiceInterface {

    @Autowired
    private AnalyticsDAO analyticsDAO;

    @Override
    public void saveEvent(Events payload) throws JsonProcessingException {
        try {
            System.out.println(payload.getEventDTO());
            analyticsDAO.insertEvent(payload.getEventDTO());
            analyticsDAO.upsertUser(payload.getUserDTO());
            analyticsDAO.upsertSession(payload.getSessionDTO());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
