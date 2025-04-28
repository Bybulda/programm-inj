package org.mai.database;

import com.typesafe.config.Config;

import javax.sql.DataSource;

public interface DataSourceProvider {
    DataSource getDataSource(Config config);
}
