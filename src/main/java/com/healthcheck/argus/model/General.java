package com.healthcheck.argus.model;

public class General {

    Long httpClientTimeout;
    Long refreshDashboardEvery;
    String lastRefreshTime;

    public Long getHttpClientTimeout() {
        return httpClientTimeout;
    }

    public void setHttpClientTimeout(Long httpClientTimeout) {
        this.httpClientTimeout = httpClientTimeout;
    }

    public Long getRefreshDashboardEvery() {
        return refreshDashboardEvery;
    }

    public void setRefreshDashboardEvery(Long refreshDashboardEvery) {
        this.refreshDashboardEvery = refreshDashboardEvery;
    }

    public String getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(String lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }
}
