package com.healthcheck.argus.model;

import java.util.List;

public class HealthCheckConfiguration {
    private General general;
    private List<Groups> groups;

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
