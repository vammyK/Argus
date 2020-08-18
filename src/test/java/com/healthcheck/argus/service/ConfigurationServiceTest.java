package com.healthcheck.argus.service;

import com.healthcheck.argus.model.HealthCheckConfiguration;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigurationServiceTest {

    ConfigurationService cs = new ConfigurationService();

    @Test
    void getConfiguration() throws IOException {
        HealthCheckConfiguration healthCheckConfiguration = cs.getConfiguration();

        assertNotNull(healthCheckConfiguration);
        assertNotNull(healthCheckConfiguration.getGeneral());
        assertNotNull(healthCheckConfiguration.getGroups());

        assertEquals(2, healthCheckConfiguration.getGroups().size());


    }
}