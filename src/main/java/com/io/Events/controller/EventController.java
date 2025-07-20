package com.io.Events.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.io.Events.dto.Events;
import com.io.Events.service.EventInterface;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventInterface.EventServiceInterface eventService;

    @PostMapping
    public void receiveEvent(@RequestBody Events payload, HttpServletRequest request) throws JsonProcessingException {

        String eventId = UUID.randomUUID().toString();
        String clientIp = getClientIp(request);
        System.out.println("Client IP: " + clientIp);

        // Optionally: Set IP in DTO if needed
        payload.setIpAddress(clientIp);
        eventService.saveEvent(eventId, payload);

    }

    private String getClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader != null && !xfHeader.isEmpty()) {
            return xfHeader.split(",")[0].trim(); // first IP is the real client
        }
        String realIp = request.getHeader("X-Real-IP");
        if (realIp != null && !realIp.isEmpty()) {
            return realIp;
        }
        return request.getRemoteAddr(); // fallback
    }

}
