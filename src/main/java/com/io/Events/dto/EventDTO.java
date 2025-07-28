package com.io.Events.dto;

import java.util.Map;
import java.util.UUID;

public class EventDTO {
    private String siteId;                  // The website or property this event belongs to
    private UUID eventId;                   // Globally unique event identifier (UUID)
    private Long eventTime;      // Time of the event (epoch milliseconds UTC)
    private String userId;                  // User associated with the event
    private String sessionId;               // Session ID associated with the event
    private String eventType;               // Type of the event (e.g., "pageview", "purchase")
    private String url;                     // Page URL for the event
    private String referrer;                // Referrer URL for the event
    private String userAgent;               // Full user agent string
    private String deviceType;              // Device category (e.g., mobile/desktop)
    private String country;                 // Country code (ISO 2-char)
    private String region;                  // Region or state/province for event location
    private String city;                    // City of event origin
    private String screenResolution;        // Screen resolution at event time
    private String language;                // Language setting or locale
    private String source;                  // Traffic source (e.g., direct, google)
    private Map<String, Object> properties; // Flexible, custom event data as JSON map
    private UUID goalId;                    // Optional goal (conversion) ID
    private Double revenueAmount;           // Revenue amount for monetized events
    private String revenueCurrency;         // Revenue currency (3-char code)

    // Additional suggested fields for richer analytics
    private String browser;                 // Browser name (e.g., "Chrome", "Firefox")
    private String browserVersion;          // Browser version (e.g., "123.0.2")
    private String os;                      // Operating system (e.g., "Windows", "MacOS")
    private String osVersion;               // OS version (e.g., "10", "Monterey")
    private String continent;               // Continent code or name (e.g., "Europe")
    private Double latitude;                // Approximate latitude (geo IP)
    private Double longitude;               // Approximate longitude (geo IP)
    private String IPAddress;
    private Long createdAt;      // first_seen (epoch seconds UTC)
    private Long updatedAt;

    public EventDTO() {
    }

    public EventDTO(String siteId, UUID eventId, Long eventTime, String userId, String sessionId, String eventType, String url, String referrer, String userAgent, String deviceType, String country, String region, String city, String screenResolution, String language, String source, Map<String, Object> properties, UUID goalId, Double revenueAmount, String revenueCurrency, String browser, String browserVersion, String os, String osVersion, String continent, Double latitude, Double longitude, String IPAddress, Long createdAt, Long updatedAt) {
        this.siteId = siteId;
        this.eventId = eventId;
        this.eventTime = eventTime;
        this.userId = userId;
        this.sessionId = sessionId;
        this.eventType = eventType;
        this.url = url;
        this.referrer = referrer;
        this.userAgent = userAgent;
        this.deviceType = deviceType;
        this.country = country;
        this.region = region;
        this.city = city;
        this.screenResolution = screenResolution;
        this.language = language;
        this.source = source;
        this.properties = properties;
        this.goalId = goalId;
        this.revenueAmount = revenueAmount;
        this.revenueCurrency = revenueCurrency;
        this.browser = browser;
        this.browserVersion = browserVersion;
        this.os = os;
        this.osVersion = osVersion;
        this.continent = continent;
        this.latitude = latitude;
        this.longitude = longitude;
        this.IPAddress = IPAddress;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public UUID getGoalId() {
        return goalId;
    }

    public void setGoalId(UUID goalId) {
        this.goalId = goalId;
    }

    public Double getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(Double revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public String getRevenueCurrency() {
        return revenueCurrency;
    }

    public void setRevenueCurrency(String revenueCurrency) {
        this.revenueCurrency = revenueCurrency;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ... rest of the existing getters and setters ...
}

    /*
    3. EventDTO Fields Explanation
        siteId

            What: Identifier of the website or property the event belongs to.

            Example: "site_abc123".

        eventId

            What: Globally unique identifier (UUID) for each event to enable precise indexing, deduplication, and referencing.

            Example: UUID.fromString("550e8400-e29b-41d4-a716-446655440000").

        eventTimeEpochMillis

            What: The exact timestamp of the event occurrence in milliseconds since the epoch UTC.

            Why: High precision timing of user interactions, used for ordering and time-series analysis.

            Example: 1690452123123.

        userId

            What: ID of the user generating the event; links the event to a particular user.

            Example: "user_98765".

        sessionId

            What: The session during which this event occurred; groups events in visits.

            Example: "sess_456789".

        eventType

            What: Name or category of the event (e.g., 'pageview', 'click', 'purchase').

            Why: For filtering and grouping event data by action type.

            Example: "purchase".

        url

            What: The page URL or resource related to the event.

            Example: "https://example.com/product/123".

        referrer

            What: The URL that referred the user to this page or event context.

            Example: "https://google.com/search?q=product".

        userAgent

            What: Browser or client user agent string at event time.

            Example: "Mozilla/5.0 (Windows NT 10.0; Win64; x64)...".

        deviceType

            What: Device classification at event time (e.g., "desktop", "mobile").

            Example: "mobile".

        country

            What: ISO country code where event originated or was detected.

            Example: "DE".

        screenResolution

            What: Screen resolution of device at event time, e.g., "1920x1080".

            Example: "1366x768".

        language

            What: Language preference or locale at event time.

            Example: "en-GB".

        source

            What: Traffic source or attribution source for the event (campaign, referrer, organic, etc.).

            Example: "facebook".

        properties

            What: JSON object containing flexible, event-specific metadata that varies per event type (e.g., purchase details, button ids, campaign tags).

            Why: Enables storing arbitrary key-value pairs for custom analytics without changing schema.

            Example:

            json
            {
              "order_id": "ORD1234",
              "cart_total": 59.99,
              "coupon_code": "SUMMER21"
            }
        goalId

            What: Optional UUID identifying a specific conversion goal tied to this event, if any.

            Example: UUID.fromString("d9b2d63d-a233-4123-847a-7e2a3c2076e0").

        revenueAmount

            What: The amount of revenue attributed to this event (nullable because not all events generate revenue).

            Example: 59.99.

        revenueCurrency

            What: The currency of the revenue amount (3-character ISO code), nullable.

            Example: "USD".

     */



