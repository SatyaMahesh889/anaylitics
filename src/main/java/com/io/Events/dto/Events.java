package com.io.Events.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class Events {
    private String siteId;
    private String eventType;
    private String visitorId;
    private String sessionId;
    private LocalDateTime timestamp;
    private String url;
    private String referrer;
    private String platform;
    private String userAgent;
    private String country;
    private String ipAddress;
    private Map<String, Object> details;

    public Events() {
    }

    public Events(String siteId, String eventType, String visitorId, String sessionId, LocalDateTime timestamp, String url, String referrer, String platform, String userAgent, String country, String ipAddress, Map<String, Object> details) {
        this.siteId = siteId;
        this.eventType = eventType;
        this.visitorId = visitorId;
        this.sessionId = sessionId;
        this.timestamp = timestamp;
        this.url = url;
        this.referrer = referrer;
        this.platform = platform;
        this.userAgent = userAgent;
        this.country = country;
        this.ipAddress = ipAddress;
        this.details = details;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
