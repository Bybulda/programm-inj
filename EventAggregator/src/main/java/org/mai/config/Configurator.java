package org.mai.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.NoArgsConstructor;
import org.mai.config.intrf.Configuration;

@NoArgsConstructor
public class Configurator implements Configuration {
    @Override
    public Config getConfig(){
        return ConfigFactory.parseResources("application.conf");
    }
}
