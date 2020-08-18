package com.healthcheck.argus.service;

import com.healthcheck.argus.model.Groups;
import com.healthcheck.argus.model.HealthCheckConfiguration;
import com.healthcheck.argus.model.HealthStatus;
import com.healthcheck.argus.model.Nodes;
import com.healthcheck.argus.service.executions.HealthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class HealthCheckService {

    @Autowired
    HealthCheckConfiguration healthCheckConfiguration;

    @Autowired
    HealthCheckFactory healthCheckFactory;

    DateTimeFormatter formatter =
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                    .withLocale(Locale.UK)
                    .withZone(ZoneId.systemDefault());

    public HealthCheckConfiguration performHealthCheck() {
        HealthCheckConfiguration output = new HealthCheckConfiguration();
        output.setGeneral(healthCheckConfiguration.getGeneral());
        output.getGeneral().setLastRefreshTime(formatter.format(Instant.now()));

        List<Groups> groupsOutput = healthCheckConfiguration.getGroups().parallelStream().map(this::perform).collect(Collectors.toList());

        return healthCheckConfiguration;
    }

    private Groups perform(Groups groups) {
        Groups output = new Groups();
        output.setNodes(groups.getNodes());
        List<Nodes> outputNodes = groups.getNodes().parallelStream().map(this::perform).collect(Collectors.toList());
        output.setNodes(outputNodes);
        return output;
    }

    private Nodes perform(Nodes node) {

        try {
            Boolean response = healthCheckFactory.execute(node, healthCheckConfiguration.getGeneral());
            node.setStatus(HealthStatus.OK);
            node.setMessage("All Ok, For Now :P");
        } catch (HealthException e) {
            node.setStatus(HealthStatus.ERROR);
            node.setMessage(e.getMessage());
        }
        return node;
    }
}
