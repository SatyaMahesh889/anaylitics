package com.io.Events.Utils;

import com.clickhouse.jdbc.ClickHouseDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class ClickHouseConfig {

//    @Value("${clickhouse.url}")
//    private String url;
//
//    @Value("${clickhouse.user}")
//    private String user;
//
//    @Value("${clickhouse.password}")
//    private String password;

    @Bean
    public DataSource clickHouseDataSource() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "default");
        properties.setProperty("password", "aBNe2.rNDmIAh"); // Replace with your actual password

        // ClickHouse URL with SSL and compression disabled
        String jdbcUrl = "jdbc:clickhouse://d7dyrjpzrh.ap-south-1.aws.clickhouse.cloud:8443"
                + "?ssl=true"
                + "&compress=0"; // Disable compression (LZ4 not supported without native libs)

        return new ClickHouseDataSource(jdbcUrl, properties);
    }
}