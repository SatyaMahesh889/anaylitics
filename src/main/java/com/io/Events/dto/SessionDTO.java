package com.io.Events.dto;

public class SessionDTO {
    private String siteId;              // site_id
    private String sessionId;           // session_id
    private String userId;              // user_id
    private long startTime;    // start_time (epoch seconds UTC)
    private long endTime;      // end_time (epoch seconds UTC)
    private String device;             // device (e.g., desktop/mobile)
    private String country;            // country (2-char code)
    private String source;             // traffic source
    private String language;           // language code (e.g., en-US)
    private long updatedAt;   // updated_at (epoch seconds UTC)
    private long version;             // upsert version

    // Constructors, getters and setters

    public SessionDTO() {}

    public String getSiteId() { return siteId; }
    public void setSiteId(String siteId) { this.siteId = siteId; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public long getStartTime() { return startTime; }
    public void setStartTime(long startTime) { this.startTime = startTime; }

    public long getEndTime() { return endTime; }
    public void setEndTime(long endTime) { this.endTime = endTime; }

    public String getDevice() { return device; }
    public void setDevice(String device) { this.device = device; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }

    public long getVersion() { return version; }
    public void setVersion(long version) { this.version = version; }

    /*
    2. SessionDTO Fields Explanation
        siteId

            What: Identifier for which website or app this session belongs to (same reasoning as in UserDTO).

            Example: "site_abc123".

        sessionId

            What: Unique identifier for a user session—an individual visit instance on the site.

            Why: Groups events into sessions to analyze user visits, session duration, and behavior within sessions.

            Example: "sess_456789".

        userId

            What: The user associated with this session, linking session data to a unique user.

            Example: "user_98765".

        startTime

            What: The epoch timestamp (seconds UTC) marking when the session started.

            Why: Used for session lifecycle, calculating session length, and TTL retention rules.

            Example: 1690444800.

        endTime

            What: The epoch timestamp (seconds UTC) marking when the session ended.

            Why: Enables measuring session duration and termination events.

            Example: 1690448400.

        device

            What: Device type used during the session, e.g., "desktop", "mobile", or "tablet".

            Why: Supports segmentation and device-based behavior analysis.

            Example: "desktop".

        country

            What: ISO 3166-1 alpha-2 country code representing origin or detected location of the session.

            Why: For geographic reporting and segmentation.

            Example: "US".

        source

            What: Traffic source or campaign through which the user arrived at the site (e.g., "google", "facebook", "direct").

            Why: Attribution analysis and campaign effectiveness.

            Example: "google".

        language

            What: Language preference during the session, typically locale code like "en-US".

            Why: For regional/time zone and localization analysis.

            Example: "en-US".

        updatedAt

            What: Timestamp of last update to session data.

            Why: Used for versioning and upserts in the session table.

            Example: 1690450000.

        version

            What: Version number or timestamp for managing upserts in ClickHouse.

            Example: 1690450000000.
     */
}

