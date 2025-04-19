package org.mai.database.intrf;

import com.typesafe.config.Config;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public interface DataSourceProvider {
    DataSource getDataSource(Config config);
}
