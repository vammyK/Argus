package com.healthcheck.argus.model;

public class Nodes {

    String name;
    String env;
    String endpoint;
    RequestType type;
    String message;
    HealthStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getMessage() {
        return message != null ? message : "Not able to Connect";
    }

    public void setMessage(String message) {
        this.message = message != null ? message : "Not able to Connect";
    }

    public String getStatus() {
        return status != null ? status.getType() : HealthStatus.NOCONNECT.getType();
    }

    public void setStatus(HealthStatus status) {
        this.status = status;
    }
}
