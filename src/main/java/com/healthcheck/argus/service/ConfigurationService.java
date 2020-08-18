package com.healthcheck.argus.service;

import com.healthcheck.argus.model.HealthCheckConfiguration;
import com.healthcheck.argus.util.FileFetch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;

@Configuration
public class ConfigurationService {

    @Bean
    public HealthCheckConfiguration getConfiguration() throws IOException {
        Yaml yaml = new Yaml();
        String data = FileFetch.getFile("healthcheck.yaml");
        HealthCheckConfiguration hc = yaml.loadAs(data, HealthCheckConfiguration.class);
        return hc;
    }

}
