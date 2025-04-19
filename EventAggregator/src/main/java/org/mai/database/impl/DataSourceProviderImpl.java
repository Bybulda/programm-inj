package org.mai.database.impl;

import com.typesafe.config.Config;
import com.zaxxer.hikari.HikariDataSource;
import org.mai.database.intrf.DataSourceProvider;

import javax.sql.DataSource;

public class DataSourceProviderImpl implements DataSourceProvider {
    @Override
    public DataSource getDataSource(Config config) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(config.getString("db.url"));
        ds.setUsername(config.getString("db.user"));
        ds.setPassword(config.getString("db.password"));
        ds.setDriverClassName(config.getString("db.driver"));
        ds.setMaximumPoolSize(config.getInt("db.pool.maxPoolSize"));
        ds.setMinimumIdle(config.getInt("db.pool.minIdle"));
        ds.setIdleTimeout(config.getInt("db.pool.idleTimeout"));
        ds.setConnectionTimeout(config.getInt("db.pool.connectionTimeout"));
        return ds;
    }
}
