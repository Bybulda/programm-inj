package org.mai;

import org.mai.config.impl.Configurator;
import org.mai.config.Configuration;
import org.mai.database.impl.DataBaseListner;
import org.mai.pattern.EventAggregator;
import org.mai.pattern.Observer;
import org.mai.pattern.impl.AggregatorImpl;
import org.mai.service.AuditService;
import org.mai.service.LoggerService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Observer logger = new LoggerService();
        Observer audit = new AuditService();
        EventAggregator eventAggregator = new AggregatorImpl();
        eventAggregator.registerObserver(logger);
        eventAggregator.registerObserver(audit);
        Configuration conf = new Configurator();
        DataBaseListner listner = new DataBaseListner(eventAggregator, conf.getConfig());
        listner.run();
    }
}