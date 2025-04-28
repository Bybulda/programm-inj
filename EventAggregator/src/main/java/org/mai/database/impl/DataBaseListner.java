package org.mai.database.impl;

import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.mai.pattern.EventAggregator;
import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class DataBaseListner implements Runnable {

    private final DataSource dataSource;
    private final EventAggregator eventAggregator;

    public DataBaseListner(EventAggregator aggregator, Config config) {
        this.eventAggregator = aggregator;
        this.dataSource = new DataSourceProviderImpl().getDataSource(config);
    }

    @Override
    public void run() {
        try (Connection conn = dataSource.getConnection()) {
            PGConnection pgConn = conn.unwrap(PGConnection.class);
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("LISTEN data_changes");
            }

            log.info("Started listening to PostgreSQL notifications...");

            while (true) {
                PGNotification[] notifications = pgConn.getNotifications();
                if (notifications != null) {
                    for (PGNotification notification : notifications) {
                        log.debug("Received notification: {}", notification.getParameter());
                        eventAggregator.notifyObservers(notification.getParameter());
                    }
                }
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            log.error("Error while listening to database changes", e);
        }
    }
}
