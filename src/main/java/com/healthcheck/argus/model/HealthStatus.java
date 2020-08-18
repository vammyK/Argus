package com.healthcheck.argus.model;

public enum HealthStatus {
    OK("success"), ERROR("danger"), NOCONNECT("secondary");
    String type;

    HealthStatus(String type) {
        this.type = type;
    }

    String getType() {
        return this.type;
    }
}
