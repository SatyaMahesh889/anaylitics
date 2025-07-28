package com.io.Events.dto;

import java.util.Map;

public class UserDTO {
    private String siteId;                // site_id
    private String userId;                // user_id
    private long createdAt;      // first_seen (epoch seconds UTC)
    private long updatedAt;      // updated_at (epoch seconds UTC)
    private Map<String, Object> attributes;  // attributes JSON as Map
    private long version;                // version for upsert

    // Constructors, getters and setters

    public UserDTO() {}

    public String getSiteId() { return siteId; }
    public void setSiteId(String siteId) { this.siteId = siteId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public long getVersion() { return version; }
    public void setVersion(long version) { this.version = version; }

    /*
    1. UserDTO Fields Explanation
        siteId

            What: The identifier of the website or app that this user belongs to.

            Why: Supports multi-site/multi-tenant analytics, so that user data can be segregated by website.

            Example: "site_abc123".

        userId

            What: A unique string that identifies the user anonymously (often generated client-side or backend, e.g., UUID or hashed cookie).

            Why: To link user-related data across sessions and events while ensuring privacy (non-PII).

            Example: "user_98765".

        createdAt

            What: The epoch timestamp (in seconds, UTC) when this user was first observed on the platform.

            Why: Used for user lifecycle analysis, cohorting, and TTL-based data retention policies.

            Example: 1690444800 (represents a specific date/time).

        updatedAt

            What: The epoch timestamp (seconds, UTC) of the last time this user record was updated.

            Why: Helps to identify the most recent user info for upserts and synchronization.

            Example: 1692854400 (updated recently).

        attributes

            What: A map representing flexible user traits as key-value pairs (stored as JSON in the database).

            Why: Stores customizable user metadata such as subscription level, country, marketing source, device info, or feature flags. It allows schema flexibility without database changes.

            Example: {"subscription_level":"premium","utm_source":"newsletter","country":"US"}.

        version

            What: A numeric value indicating the version or update timestamp of this user record. Often this is a monotonically increasing value or a timestamp to allow upserts in ClickHouse’s ReplacingMergeTree tables.

            Why: Ensures that the latest version of the user data is kept after merges, helping to avoid stale data.

            Example: 1692854400000 (milliseconds since epoch as version).
      */

}

