package com.io.Events.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.Events.dto.EventDTO;
import com.io.Events.dto.SessionDTO;
import com.io.Events.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AnalyticsDAO {

    private final ObjectMapper objectMapper;

    @Autowired
    private DataSource clickHouseDataSource;

    // Insert SQL for Users (upsert via ReplacingMergeTree)
    private static final String INSERT_USER_SQL =
            "INSERT INTO users (site_id, user_id, first_seen, updated_at, attributes, version) VALUES (?, ?, ?, ?, ?, ?)";

    // Insert SQL for Sessions (upsert via ReplacingMergeTree)
    private static final String INSERT_SESSION_SQL =
            "INSERT INTO sessions (site_id, session_id, user_id, start_time, end_time, device, country, source, language, updated_at, version) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // Insert SQL for Events (append only)
    private static final String INSERT_EVENT_SQL =
            "INSERT INTO event (" +
                    "site_id, event_id, event_time, user_id, session_id, event_type, url, referrer, user_agent, device_type, country, region, city, " +
                    "screen_resolution, language, source, properties, goal_id, revenue_amount, revenue_currency, browser, browser_version, os, os_version, " +
                    "continent, latitude, longitude, ip_address, created_at, updated_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public AnalyticsDAO() {
        this.objectMapper = new ObjectMapper();
    }


    /** Insert or upsert a User */
    public void upsertUser(UserDTO user) throws SQLException {
        try (Connection conn = clickHouseDataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(INSERT_USER_SQL)) {
            stmt.setString(1, user.getSiteId());
            stmt.setString(2, user.getUserId());
            stmt.setLong(3, user.getCreatedAt());
            stmt.setLong(4, user.getUpdatedAt());

            if (user.getAttributes() != null) {
                stmt.setString(5, objectMapper.writeValueAsString(user.getAttributes()));
            } else {
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }

            stmt.setLong(6, user.getVersion());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("Failed to upsert user", e);
        }
    }

    /** Insert or upsert a Session */
    public void upsertSession(SessionDTO session) throws SQLException {
        try (Connection conn2 = clickHouseDataSource.getConnection();
                PreparedStatement stmt = conn2.prepareStatement(INSERT_SESSION_SQL)) {
            stmt.setString(1, session.getSiteId());
            stmt.setString(2, session.getSessionId());
            stmt.setString(3, session.getUserId());
            stmt.setLong(4, session.getStartTime());
            stmt.setLong(5, session.getEndTime());
            stmt.setString(6, session.getDevice());
            stmt.setString(7, session.getCountry());
            stmt.setString(8, session.getSource());
            stmt.setString(9, session.getLanguage());
            stmt.setLong(10, session.getUpdatedAt());
            stmt.setLong(11, session.getVersion());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("Failed to upsert session", e);
        }
    }

    /** Insert an Event */
    public void insertEvent(EventDTO event) throws SQLException {
        try (Connection conn3 = clickHouseDataSource.getConnection();
                PreparedStatement stmt = conn3.prepareStatement(INSERT_EVENT_SQL)) {
            stmt.setString(1, event.getSiteId());
            stmt.setObject(2, event.getEventId()); // UUID object, driver must support
            stmt.setLong(3, event.getEventTime());
            stmt.setString(4, event.getUserId());
            stmt.setString(5, event.getSessionId());
            stmt.setString(6, event.getEventType());
            stmt.setString(7, event.getUrl());
            stmt.setString(8, event.getReferrer());
            stmt.setString(9, event.getUserAgent());
            stmt.setString(10, event.getDeviceType());
            stmt.setString(11, event.getCountry());
            stmt.setString(12, event.getRegion());
            stmt.setString(13, event.getCity());
            stmt.setString(14, event.getScreenResolution());
            stmt.setString(15, event.getLanguage());
            stmt.setString(16, event.getSource());

            if (event.getProperties() != null) {
                stmt.setString(17, objectMapper.writeValueAsString(event.getProperties()));
            } else {
                stmt.setNull(17, java.sql.Types.VARCHAR);
            }

            if (event.getGoalId() != null) {
                stmt.setObject(18, event.getGoalId());
            } else {
                stmt.setNull(18, java.sql.Types.VARCHAR);
            }

            if (event.getRevenueAmount() != null) {
                stmt.setDouble(19, event.getRevenueAmount());
            } else {
                stmt.setNull(19, java.sql.Types.DOUBLE);
            }

            if (event.getRevenueCurrency() != null) {
                stmt.setString(20, event.getRevenueCurrency());
            } else {
                stmt.setNull(20, java.sql.Types.VARCHAR);
            }

            stmt.setString(21, event.getBrowser());
            stmt.setString(22, event.getBrowserVersion());
            stmt.setString(23, event.getOs());
            stmt.setString(24, event.getOsVersion());
            stmt.setString(25, event.getContinent());

            if (event.getLatitude() != null) {
                stmt.setDouble(26, event.getLatitude());
            } else {
                stmt.setNull(26, java.sql.Types.DOUBLE);
            }

            if (event.getLongitude() != null) {
                stmt.setDouble(27, event.getLongitude());
            } else {
                stmt.setNull(27, java.sql.Types.DOUBLE);
            }

            stmt.setString(28, event.getIPAddress());

            // For createdAt and updatedAt, if null, set current epoch seconds
            long createdAt = event.getCreatedAt() != null ? event.getCreatedAt() : System.currentTimeMillis() / 1000L;
            long updatedAt = event.getUpdatedAt() != null ? event.getUpdatedAt() : System.currentTimeMillis() / 1000L;

            stmt.setLong(29, createdAt);
            stmt.setLong(30, updatedAt);

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("Failed to insert event", e);
        }
    }
}

