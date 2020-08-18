package com.healthcheck.argus.controller;

import com.healthcheck.argus.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
public class HealthController {

    @Autowired
    HealthCheckService healthCheckService;

    @GetMapping("/dashboard")
    public ModelAndView displayDashboard(Map<String, Object> model) throws IOException {


        model.put("data", healthCheckService.performHealthCheck());

        return new ModelAndView("index", model);
    }
}
