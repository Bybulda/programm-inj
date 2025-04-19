package org.mai.service;

import lombok.extern.slf4j.Slf4j;
import org.mai.pattern.Observer;

@Slf4j
public class LoggerService implements Observer {
    @Override
    public void dataChangeNotify(String data) {
        log.info("Collected info: {}", data);
    }
}
