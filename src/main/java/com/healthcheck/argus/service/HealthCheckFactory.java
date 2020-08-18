package com.healthcheck.argus.service;

import com.healthcheck.argus.model.General;
import com.healthcheck.argus.model.Nodes;
import com.healthcheck.argus.model.RequestType;
import com.healthcheck.argus.service.executions.HTTPService;
import com.healthcheck.argus.service.executions.HealthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckFactory {

    @Autowired
    HTTPService httpService;


    public Boolean execute(Nodes node, General general) throws HealthException {
        if (RequestType.HTTP.equals(node.getType())) {
            return httpService.executeRequest(node.getEndpoint(), general);
        } else {
            throw new HealthException("Operation " + node.getType() + " not supported");
        }
    }
}
