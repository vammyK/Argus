package com.healthcheck.argus.service.executions;

public class HealthException extends Exception {
    String message;

    public HealthException(Exception e) {
        super(e);
        this.message = e.getMessage();
    }

    public HealthException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
