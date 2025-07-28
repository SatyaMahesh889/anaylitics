//package com.io.Events.dao;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.io.Events.dto.Events;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.time.format.DateTimeFormatter;
//
//@Repository
//public class EventDao {
//
//    @Autowired
//    private DataSource clickHouseDataSource;
//
//    public void insertEvent(String eventId, Events payload) {
//        String sql = "INSERT INTO events (site_id, visitor_id, session_id, event_type, timestamp, url, referrer, platform, user_agent, country, ip_address, details) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection conn = clickHouseDataSource.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            String formattedTimestamp = payload.getTimestamp().format(formatter);
//
//            stmt.setString(1, payload.getSiteId());
//            stmt.setString(2, payload.getVisitorId());
//            stmt.setString(3, payload.getSessionId());
//            stmt.setString(4, payload.getEventType());
//            stmt.setString(5, formattedTimestamp);
//            stmt.setString(6, payload.getUrl());
//            stmt.setString(7, payload.getReferrer());
//            stmt.setString(8, "payload.getPlatform()");
//            stmt.setString(9, "payload.getUserAgent()");
//            stmt.setString(10, payload.getCountry());
//            stmt.setString(11, payload.getIpAddress());
//
//            ObjectMapper mapper = new ObjectMapper();
//            stmt.setString(12, mapper.writeValueAsString(payload.getDetails()));
//
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertDailyRollup(Events payload) {
//        String sql = "INSERT INTO event_daily_rollup (site_id, date, pageviews, visitors) VALUES (?, ?, ?, ?)";
//
//        try (Connection conn2 = clickHouseDataSource.getConnection();
//             PreparedStatement stmt = conn2.prepareStatement(sql)) {
//
//            stmt.setString(1, payload.getSiteId());
//            stmt.setString(2, payload.getTimestamp().toLocalDate().toString());
//            stmt.setInt(3, 1);  // assuming +1 pageview per event
//            stmt.setInt(4, 1);  // assuming +1 visitor per event (optimize later)
//
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertSiteMeta(Events payload) {
//        String sql = "INSERT INTO site_meta (site_id, country, platform, user_agent) VALUES (?, ?, ?, ?)";
//
//        try (Connection conn3 = clickHouseDataSource.getConnection();
//             PreparedStatement stmt = conn3.prepareStatement(sql)) {
//
//            stmt.setString(1, payload.getSiteId());
//            stmt.setString(2, payload.getCountry());
//            stmt.setString(3, "payload.getPlatform()");
//            stmt.setString(4, "payload.getUserAgent()");
//
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
