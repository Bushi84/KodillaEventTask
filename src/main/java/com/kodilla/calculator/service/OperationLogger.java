package com.kodilla.calculator.service;

import com.kodilla.calculator.event.CalculatorEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OperationLogger implements ApplicationListener<CalculatorEvent> {

    private static final Logger logger = LogManager.getLogger(OperationLogger.class);

    @Override
    public void onApplicationEvent(CalculatorEvent event) {
        logger.info("Processing Calculator operation: " + event.getOperation());
    }
}
