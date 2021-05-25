package com.kodilla.calculator.controller;

import com.kodilla.calculator.domain.InData;
import com.kodilla.calculator.domain.OutData;
import com.kodilla.calculator.event.CalculatorEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calc")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @PostMapping(path = "add")
    public OutData add(@RequestBody InData inData) {
        publisher.publishEvent(new CalculatorEvent(this, "Add"));
        return new OutData(inData.getFirstNumber()+inData.getSecondNumber(), null);
    }

    @PostMapping(path = "sub")
    public OutData substract(@RequestBody InData inData) {
        publisher.publishEvent(new CalculatorEvent(this, "Substract"));
        return new OutData(inData.getFirstNumber()-inData.getSecondNumber(), null);
    }

    @PostMapping(path = "mul")
    public OutData multiply(@RequestBody InData inData) {
        publisher.publishEvent(new CalculatorEvent(this, "Multiply"));
        return new OutData(inData.getFirstNumber()*inData.getSecondNumber(), null);
    }

    @PostMapping(path = "div")
    public OutData divide(@RequestBody InData inData) {
        publisher.publishEvent(new CalculatorEvent(this, "Divide"));
        if (inData.getSecondNumber() != 0) {
            return new OutData(inData.getFirstNumber() / inData.getSecondNumber(), null);
        }
        return new OutData(0, "Can't divide by zero!");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
