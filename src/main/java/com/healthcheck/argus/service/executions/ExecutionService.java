package com.healthcheck.argus.service.executions;

import com.healthcheck.argus.model.General;

public interface ExecutionService {

    Boolean executeRequest(String node, General general) throws HealthException;
}
